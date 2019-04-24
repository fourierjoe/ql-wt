package yhao.micro.service.workflow.service.task;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.form.task.BizEntityIdUpdateForm;
import yhao.micro.service.workflow.apilist.form.task.TaskDealForm;
import yhao.micro.service.workflow.apilist.form.task.TaskNodeItemForm;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.task.ConditionVariableModel;
import yhao.micro.service.workflow.apilist.model.task.ItemResultModel;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;
import yhao.micro.service.workflow.dao.TaskDao;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;

import java.util.List;
import java.util.UUID;

public class DealTaskCommand extends TaskCommand {
    private TaskDealForm form;
    public DealTaskCommand(TaskDao taskDao, ProcessSearcher processSearcher, TaskDealForm form) {
        super(taskDao, processSearcher);
        this.form = form;
    }
    @Override
    protected void initContext() {
        initDealTask(form);
    }

    @Override
    protected Boolean command() {
        if (StringUtils.isNotEmpty(this.context.getTask().getParentId())) { // 子流程更新事项结果编码必须传R998或R999
            if (!form.getTaskNodeItem().getItemResultCode().equals(CommonConstants.REFUSED)
                    && !form.getTaskNodeItem().getItemResultCode().equals(CommonConstants.PASS)) {
                throw new RuntimeException("字段itemResultCode传入值非法,必须传(R998=通过,R999=驳回)...");
            }
        }
        // 校验子任务第一个节点是否传入条件配置
        checkSubProcessCondition(this.context.getCurrentNode(), form);

        ItemResultModel itemResultModel = taskDao.selectItemResult(form.getTaskNodeItem());

        JSONObject jsonObject;
        if (itemResultModel.getItemConfig() != null) {
            jsonObject = JSONObject.parseObject(itemResultModel.getItemConfig());
        } else {
            jsonObject = JSONObject.parseObject(CommonConstants.SUB_PROCESS_ITEM_CONFIG);
        }
        form.getTaskNodeItem().setItemResult(jsonObject.getString(form.getTaskNodeItem().getItemResultCode()));

        // 更新主任务里面的子任务事项
        if (StringUtils.isNotEmpty(this.context.getTask().getParentId())) { //是子任务要更新主任务里的事项
            //子任务开启前事项更改业务主键为子表单主键
            TaskModel task = this.context.getTask();
            if (StringUtils.isEmpty(task.getBizEntityId()) || task.getBizEntityId() == null) {
                if (StringUtils.isEmpty(form.getBizEntityId()) || form.getBizEntityId() == null) {
                    throw new RuntimeException("未传入子任务业务主键");
                }
                BizEntityIdUpdateForm bizEntityIdUpdateForm = new BizEntityIdUpdateForm();
                bizEntityIdUpdateForm.setId(task.getId());
                bizEntityIdUpdateForm.setBizEntityId(form.getBizEntityId());

                if (taskDao.updateSubTaskBizEntityId(bizEntityIdUpdateForm) < 1) {
                    throw new RuntimeException("子任务业务主键未更新成功");
                }
            }

            TaskNodeItemForm mainTaskNodeItemForm = TaskNodeItemForm.newTaskNodeItemForm();
            mainTaskNodeItemForm.setTaskId(this.context.getTask().getParentId());
            mainTaskNodeItemForm.setItemId(form.getTaskNodeItem().getNodeId());
            mainTaskNodeItemForm.setItemResultCode(form.getTaskNodeItem().getItemResultCode());

            mainTaskNodeItemForm.setItemResult(jsonObject.getString(form.getTaskNodeItem().getItemResultCode()));

            if (mainTaskNodeItemForm.getItemResultCode().equals(itemResultModel.getItemExpect())) {
                mainTaskNodeItemForm.setIsMatch(YNEnum.YES);
            } else {
                mainTaskNodeItemForm.setIsMatch(YNEnum.NO);
            }
            mainTaskNodeItemForm.setItemExpandResult(form.getTaskNodeItem().getItemExpandResult());
            mainTaskNodeItemForm.setItemFinishPerson(form.getTaskNodeItem().getItemFinishPerson());

            taskDao.updateMainNodeItemResult(mainTaskNodeItemForm);

            // 保存子流程的变量条件
            if (form.getTaskVariableSaveForm() != null) {
                form.getTaskVariableSaveForm().setBizEntityId(form.getBizEntityId());

                // 保存任务变量表
                form.getTaskVariableSaveForm().setId(UUID.randomUUID().toString());
                taskDao.saveTaskVariable(form.getTaskVariableSaveForm());
            }
        }
        if (form.getTaskNodeItem().getItemResultCode().equals(itemResultModel.getItemExpect())) {
            form.getTaskNodeItem().setIsMatch(YNEnum.YES);
        } else {
            form.getTaskNodeItem().setIsMatch(YNEnum.NO);
        }
        updateTaskNodeItem(form.getTaskNodeItem());

        return true;
    }

    /**
     * 检查当前节点是否有子任务,再判断条件配置
     * @param currentNode
     * @param startForm
     * @return
     */
    private boolean checkSubProcessCondition(FlowNodeModel currentNode, TaskDealForm startForm) {
        if (StringUtils.isNotEmpty(this.context.getTask().getParentId()) && null != currentNode.getNodeConditionName()) { //是子任务要根据子任务节点生成事项
            FlowProcessDefinitionModel flowProcessDefinitionModel = processSearcher.searchProcessDefinitionById(this.context.getTask().getProcessId());
            FlowNodeModel startNode = processSearcher.findStartNode(flowProcessDefinitionModel.getBizCode());

            if (startNode.getId().equals(currentNode.getId())) { //子任务起始节点必须传入条件配置
                if (StringUtils.isEmpty(form.getBizEntityId())) {
                    throw new RuntimeException("处理子任务第一个节点时必须传入子任务业务主键bizEntityId");
                }

                // 当前节点为子任务节点,找到是否有条件判断,如果有条件判断则校验是否传入TaskVariableSaveForm条件
                List<ConditionVariableModel> list = taskDao.selectSubProcessNodeExpect(currentNode.getProcessDefinitionId());

                if (!list.isEmpty()) {//子流程有判断条件时,校验TaskVariableSaveForm是否传入
                    if (startForm.getTaskVariableSaveForm() == null) {
                        throw new RuntimeException("启动当前节点子流程必须传入条件配置");
                    }
                    if (StringUtils.isEmpty(startForm.getTaskVariableSaveForm().getBizEntityId())
                            || startForm.getTaskVariableSaveForm().getVariableName() == null
                            || StringUtils.isEmpty(startForm.getTaskVariableSaveForm().getVariableText())) {
                        throw new RuntimeException("处理子流程第一个节点时必须传入BizEntityId/VariableName/taskVariableSaveForm");
                    }
                }
                if (list.get(0).getVariableName() != startForm.getTaskVariableSaveForm().getVariableName()) {
                    throw new RuntimeException("启动当前节点的变量类型不匹配,请检查");
                }
            }
        }
        return true;
    }
}
