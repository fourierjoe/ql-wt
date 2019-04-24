package yhao.micro.service.workflow.service;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.form.flow.BizCodeForm;
import yhao.micro.service.workflow.apilist.form.task.*;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.task.*;
import yhao.micro.service.workflow.dao.TaskDao;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;
import yhao.micro.service.workflow.service.task.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TaskService  {
    @Resource
    private ProcessSearcher processSearcher;
    @Resource
    private TaskDao taskDao;

    /**
     * 启动任务
     *
     * @param form
     * @return
     */
    @Transactional
    public TaskStartForm startNewTask(TaskStartForm form) {
        StartTaskCommand command = new StartTaskCommand(taskDao, processSearcher, form);
        form = (TaskStartForm)command.doCommand();
        return form;
    }

    /**
     * 终止任务
     *
     * @param form
     * @return
     */
    @Transactional
    public IdForm stopTask(IdForm form) {
        StopTaskCommand command = new StopTaskCommand(taskDao, processSearcher, form);
        command.doCommand();
        return form;
    }

    /**
     * 查询任务
     *
     * @param form
     * @return
     */
    public TaskModel pickTask(IdForm form) {
        TaskModel task = taskDao.pickTaskById(form.getId());
//        /findNextNodes
        List<FlowNodeModel> nextList = processSearcher.findNextNodes(task.getProcessId(), task.getCurrentNodeId());
        List<FlowNodeModel> previousList = processSearcher.findPreviousNodes(task.getProcessId(), task.getCurrentNodeId());
        task.setNextList(nextList);
        task.setPreviousList(previousList);
        TaskNodeItemQueryForm queryForm = new TaskNodeItemQueryForm();
        queryForm.setTaskId(task.getId());
        queryForm.setNodeId(task.getCurrentNodeId());
        task.setItemList(taskDao.queryTaskNodeItem(queryForm));
        return task;
    }

    /**
     * 执行任务，仅更新事项
     *
     * @param form
     * @return
     */
    @Transactional
    public boolean dealTask(TaskDealForm form) {
        DealTaskCommand command = new DealTaskCommand(taskDao, processSearcher, form);
        command.doCommand();
        return true;
    }

    /**
     * 审核通过任务
     *
     * @param form
     * @return
     */
    @Transactional
    public boolean passTask(TaskDealPassForm form) {
        PassTaskCommand command = new PassTaskCommand(taskDao, processSearcher, form);
        command.doCommand();
        return true;
    }

    /**
     * 查询任务中的所有核心事项和必要事项
     * @param form
     * @return
     */
    public List<TaskNodeItemModel> queryCoreNecessaryItem(TaskDealPassForm form) {
        TaskModel task = taskDao.pickTaskById(form.getId());

        TaskNodeItemQueryForm queryForm = new TaskNodeItemQueryForm();
        queryForm.setTaskId(task.getId());
        queryForm.setNodeId(task.getCurrentNodeId());
        queryForm.setNecessary(YNEnum.YES);
        queryForm.setCore(YNEnum.YES);

        List<TaskNodeItemModel> itemList = taskDao.queryCoreNecessaryItem(queryForm);

        return itemList;
    }


    /**
     * 节点自动审核通过任务
     *
     * @param form
     * @return
     */
    @Transactional
    public boolean passTaskAuto(TaskDealPassForm form) {
        dealTask(form);
        List<TaskNodeItemModel> itemList = queryCoreNecessaryItem(form);

        String currentNodeId = taskDao.findCurrentNodeId(form.getTaskNodeItem().getTaskId());
        // 要处理的事项所在节点id 不等于 当前任务节点id,则不通过
        if (CommonListUtil.isEmpty(itemList) || !itemList.get(0).getTaskNodeId().equals(currentNodeId)) {

            return true;
        }

        boolean pass = checkNodeItem(itemList,form.getTaskNodeItem());
        if (pass) {
            return passTask(form);
        }
        return true;
    }

    /**
     * 审核拒绝任务
     *
     * @param form
     * @return
     */
    @Transactional
    public boolean refuseTask(TaskDealRefuseForm form) {
        RefuseTaskCommand command = new RefuseTaskCommand(taskDao, processSearcher, form);
        command.doCommand();
        return true;
    }

    /**
     * 查询任务列表
     *
     * @param form
     * @return
     */
    public Pagination<TaskModel> queryTask(TaskQueryForm form) {
        Pagination<TaskModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        taskDao.queryTask(page, form);
        return page;
    }


    private boolean checkNodeItem(List<TaskNodeItemModel> itemList, TaskNodeItemForm form) {
        if(form != null){
            for(TaskNodeItemModel model:itemList){
                if(form.getItemId().equals(model.getId())){ //未持久化的数据保存
                    model.setItemResultCode(form.getItemResultCode());
                    break;
                }
            }
        }

        for(TaskNodeItemModel model:itemList){
            // 是核心事项且 事项结果 不等于 期望值
            if (CommonConstants.YES.equals(model.getCore())) {
                if (!model.getItemExcept().equals(model.getItemResultCode())) {
                    return false;
                }
            } else {
                if(!model.getItemExceptType().match(model.getItemExcept(),model.getItemResultCode())){
                    return false;
//                    throw new RuntimeException("节点事项结果未通过。");
                }
            }
        }
        return true;
    }

    /**
     * 根据任务id查询该流程定义信息
     * @param form
     * @return
     */
    public FlowProcessDefinitionModel pickProcessBizCodeByTaskId(IdForm form) {
        return taskDao.pickProcessBizCodeByTaskId(form.getId());
    }

    public TaskModel pickTaskState(IdForm form) {
        return taskDao.pickTaskState(form.getId());
    }

    /**
     * 检测当前事项是否核心事项
     * @param itemId
     * @return
     */
    public Boolean validCoreItem(String itemId) {

        // TODO: 2018/12/22  
        taskDao.selectCoreItem(itemId);

        return true;
    }

    public Map<Integer, TaskNodeModel> pickTaskSchedule(IdForm form) {

        List<TaskNodeModel> dBList = taskDao.pickTaskSchedule(form.getId());
        Map<Integer, TaskNodeModel> map = Maps.newLinkedHashMap();
        for (TaskNodeModel model: dBList) {
            if(map.containsKey(model.getNodeScheduleOrder())) {
                map.get(model.getNodeScheduleOrder()).getItems().add(model.getItems().get(0));
            } else {
                map.put(model.getNodeScheduleOrder(), model);
            }
        }
        joinBackNode(map, form);

        return map;
    }

    private boolean joinBackNode(Map<Integer, TaskNodeModel> map, IdForm form) {
        if (!map.isEmpty()) { //拼接后续未完成流程
            String currentNodeId = map.get(map.size()).getItems().get(0).getTaskNodeId();
            TaskScheduleQueryModel taskScheduleQueryModel = taskDao.findTaskVariableByTaskId(form.getId());
            FlowNodeModel currentNode = processSearcher.findCurrentNode(taskScheduleQueryModel.getProcessId(), currentNodeId);
            if (Optional.ofNullable(taskScheduleQueryModel.getVariableText()).isPresent()
                    && Optional.ofNullable(currentNode.getNodeExpect()).isPresent()
                    && taskScheduleQueryModel.getVariableText().compareTo(currentNode.getNodeExpect()) < 0) {//子任务变量大于当前节点配置条件,则拼接下一节点(仅支持数字)
                return true; //条件流程才判断
            }
            List<FlowNodeModel> nextNodes = processSearcher.findNextNodes(map.get(1).getBizCode(), currentNodeId);
            DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
            for(FlowNodeModel model : nextNodes) {
                int size = map.size();
                map.put(++size, dozerBeanMapper.map(model, TaskNodeModel.class));
            }
        }
        return true;
    }

    public List<ItemInfoModel> pickTaskItemByItemCode (ItemByItemCodeQueryForm form){
        return taskDao.pickTaskItemByItemCode(form);
    }

    public RefuseTaskItemModel pickRefuseForm (IdForm form){
        RefuseTaskItemModel refuseTaskItemModel = taskDao.pickRefuseForm(form.getId());
        String bizCode;
        if (StringUtils.isNotEmpty(refuseTaskItemModel.getParentId())) { // 子流程
            bizCode = taskDao.selectMainTaskStartNode(refuseTaskItemModel.getParentId());
        } else { // 主流程
            bizCode = refuseTaskItemModel.getBizCode();
        }
        FlowNodeModel startNode = processSearcher.findStartNode(bizCode);

        refuseTaskItemModel.setInitialId(startNode.getId());
        return refuseTaskItemModel;
    }

    @Transactional
    public boolean cancelTask(IdForm form) {
        return taskDao.updateTask2Cancel(form.getId()) > 0;
    }
}
