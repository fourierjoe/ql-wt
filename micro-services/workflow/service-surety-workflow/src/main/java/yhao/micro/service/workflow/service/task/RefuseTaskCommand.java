package yhao.micro.service.workflow.service.task;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.task.ItemResultQueryForm;
import yhao.micro.service.workflow.apilist.form.task.TaskDealRefuseForm;
import yhao.micro.service.workflow.apilist.form.task.TaskStatusChangeForm;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeItemModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.task.ItemResultModel;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeItemModel;
import yhao.micro.service.workflow.dao.TaskDao;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;

import java.util.List;
import java.util.Map;

public class RefuseTaskCommand extends TaskCommand {
    private TaskDealRefuseForm form;
    public RefuseTaskCommand(TaskDao taskDao, ProcessSearcher processSearcher, TaskDealRefuseForm form) {
        super(taskDao, processSearcher);
        this.form = form;
    }

    @Override
    protected void initContext() {
        initDealTask(form);
		TaskModel task = this.context.getTask();
		FlowNodeModel nextNode;
		if (StringUtils.isNotEmpty(task.getParentId())) { //子任务
			// 查父任务
			TaskModel parentTaskModel = taskDao.selectTask(task.getParentId());
			//子流程所在主流程节点
			FlowProcessDefinitionModel parentModel = processSearcher.searchProcessDefinitionById(parentTaskModel.getProcessId());

			if (StringUtils.isNotEmpty(form.getRefuseNodeId())) {
				FlowProcessDefinitionModel flowProcessDefinitionModel = processSearcher.searchProcessDefinitionById(task.getProcessId());
				Map<String, List<FlowNodeModel>> refuseNextNode = flowProcessDefinitionModel.getRefuseNextNode();
				if (!refuseNextNode.containsKey(form.getRefuseNodeId())) { //传入的驳回节点在主任务流程上
					//优化
					nextNode = processSearcher.findCurrentNode(parentModel.getId(), form.getRefuseNodeId());
					getNextNode(parentModel, nextNode);
				} else { //驳回节点在子任务流程上,则驳到主流程上一个节点
					String linkSubProcessNodeId = taskDao.selectNodeId(task.getProcessId());
//					FlowNodeModel currentNode = processSearcher.findCurrentNode(parentModel.getBizCode(), linkSubProcessNodeId);
					nextNode = processSearcher.findPreviousNode(parentModel.getBizCode(), linkSubProcessNodeId);

					getNextNode(parentModel, nextNode);
				}
			} else {
				String linkSubProcessNodeId = taskDao.selectNodeId(task.getProcessId());
				nextNode = processSearcher.findPreviousNode(parentModel.getBizCode(), linkSubProcessNodeId);
				getNextNode(parentModel, nextNode);
			}

		} else { //主任务
			FlowProcessDefinitionModel model = processSearcher.searchProcessDefinitionById(task.getProcessId());
			if (StringUtils.isNotEmpty(form.getRefuseNodeId())) {
				nextNode = processSearcher.findCurrentNode(model.getId(), form.getRefuseNodeId());
				getNextNode(model, nextNode);
			} else {
				nextNode = processSearcher.findPreviousNode(model.getBizCode(), task.getCurrentNodeId());
				getNextNode(model, nextNode);
			}
		}
        this.context.setNextNode(nextNode);
    }

	/**
	 * 检查节点下是否有子流程,获取上一节点
	 * @param parentModel
	 * @param nextNode
	 * @return
	 */
    private FlowNodeModel getNextNode(FlowProcessDefinitionModel parentModel, FlowNodeModel nextNode) {
		for (;;) { //上一节点有子流程继续向上驳回
			if (StringUtils.isNotEmpty(nextNode.getSubProcessId())) {
				nextNode = processSearcher.findPreviousNode(parentModel.getBizCode(), nextNode.getId());
			} else {
				break;
			}
		}
		return nextNode;
	}

    @Override
    protected Boolean command() {
        TaskModel task = context.getTask();
        ItemResultQueryForm queryForm = new ItemResultQueryForm();

        if(StringUtils.isNotEmpty(task.getParentId())) { // 子任务
            // 子流程检查操作人
            checkAssign(task,form);

			TaskStatusChangeForm subTaskStatusChangeForm = new TaskStatusChangeForm();
			subTaskStatusChangeForm.setId(task.getId());
			subTaskStatusChangeForm.setStatus(TaskStatus.END);
			taskDao.changeTaskStatus(subTaskStatusChangeForm);

			// 查父任务
			TaskModel parentTaskModel = taskDao.selectTask(task.getParentId());
			parentTaskModel.setStatus(TaskStatus.REJECT);
			parentTaskModel.setCurrentNodeId(this.context.getNextNode().getId());
			parentTaskModel.setUpdateOperatorId(form.getOperatorId());
			task = parentTaskModel;

        } else { // 驳回到主流程节点
            task.setStatus(TaskStatus.REJECT);
			task.setCurrentNodeId(this.context.getNextNode().getId());
        }
        taskDao.taskGoToNext(task);

        if(YNEnum.YES != form.getTaskNodeItem().getItemCore()) {
            throw new RuntimeException("非核心事项不能调用驳回接口");
        }

		ItemResultModel itemResultModel = taskDao.selectItemResult(form.getTaskNodeItem());

		JSONObject jsonObject;
		if (itemResultModel.getItemConfig() != null) {
			jsonObject = JSONObject.parseObject(itemResultModel.getItemConfig());
		} else {
			jsonObject = JSONObject.parseObject(CommonConstants.SUB_PROCESS_ITEM_CONFIG);
		}
		form.getTaskNodeItem().setItemResult(jsonObject.getString(form.getTaskNodeItem().getItemResultCode()));

		if (form.getTaskNodeItem().getItemResultCode().equals(itemResultModel.getItemExpect())) {
			form.getTaskNodeItem().setIsMatch(YNEnum.YES);
		} else {
			form.getTaskNodeItem().setIsMatch(YNEnum.NO);
		}
        updateTaskNodeItem(form.getTaskNodeItem());

        // 插入下一节点事项,并且原来非核心事项结果,意见内容保留,核心事项根据条件是否保留
		queryForm.setNodeId(this.context.getNextNode().getId());
		if (StringUtils.isNotEmpty(task.getParentId())) { //子任务
			queryForm.setTaskId(task.getParentId());
		} else {
			queryForm.setTaskId(task.getId());
		}

        List<TaskNodeItemModel> taskNodeItemModels = taskDao.queryItemResult(queryForm); //查询要驳回节点的信息
        for (TaskNodeItemModel taskNodeItemModel : taskNodeItemModels) {
            for (FlowNodeItemModel flowNodeItemModel : this.context.getNextNode().getItems()) {
				if (taskNodeItemModel.getItemId().equals(flowNodeItemModel.getId())) {
                    if (!taskNodeItemModel.getCore().equals(CommonConstants.YES)) {
						//非核心事项和form中条件为NO的保留
						flowNodeItemModel.setItemResult(taskNodeItemModel.getItemResult());
						flowNodeItemModel.setItemExpandResult(taskNodeItemModel.getItemExpandResult());
						flowNodeItemModel.setItemFinishTime(taskNodeItemModel.getItemFinishTime());
						flowNodeItemModel.setItemFinishPerson(taskNodeItemModel.getItemFinishPerson());
						flowNodeItemModel.setItemFinishPersonPosition(taskNodeItemModel.getItemFinishPersonPosition());
                    } else {
						if (YNEnum.YES == form.getCoreItemIsReserved()) {
							//非核心事项和form中条件为NO的保留
//                        flowNodeItemModel.setItemResult(taskNodeItemModel.getItemResult());
							flowNodeItemModel.setItemExpandResult(taskNodeItemModel.getItemExpandResult());
							flowNodeItemModel.setItemFinishTime(taskNodeItemModel.getItemFinishTime());
							flowNodeItemModel.setItemFinishPerson(taskNodeItemModel.getItemFinishPerson());
							flowNodeItemModel.setItemFinishPersonPosition(taskNodeItemModel.getItemFinishPersonPosition());
						}
					}
                }
            }
        }
        initTaskNodeItem(task.getId(),this.context.getNextNode());

		// TODO: 2019/3/4  任务驳回发通知给流程发起人
        //初始化子任务
        return true;
    }

    private void initRefuseNodeItem(List<TaskNodeItemModel> taskNodeItems) {

        if (taskNodeItems != null && !taskNodeItems.isEmpty()) {
            taskDao.insertTaskNodeItem(taskNodeItems);
        }
    }

}
