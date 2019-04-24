package yhao.micro.service.workflow.service.task;

import org.apache.commons.lang.StringUtils;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.util.CommonDateUtil;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeAssignType;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeItemQueryForm;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeNotifyQueryForm;
import yhao.micro.service.workflow.apilist.form.task.*;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeItemModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.task.*;
import yhao.micro.service.workflow.dao.TaskDao;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;
import yhao.micro.service.workflow.service.task.chain.EndPoint;
import yhao.micro.service.workflow.utils.SerialNumberUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 任务执行器
 */
public abstract class TaskCommand{
    protected TaskDao taskDao;
    protected ProcessSearcher processSearcher;
    protected TaskContext context;
    private List<EndPoint> pointList;
    public TaskCommand(TaskDao taskDao, ProcessSearcher processSearcher) {
        this.taskDao = taskDao;
        this.processSearcher = processSearcher;
        this.context =  new TaskContext();
        initChain();
    }

    private void doChain(TaskContext context) {
        if(pointList.size()>0){
            for(EndPoint point:pointList){
                point.doPoint(context);
            }
        }
    }

    protected abstract void initContext();

    protected abstract Object command();

    private void initChain(){
        pointList = new ArrayList<>();
        //执行历史记录录入
        pointList.add(ctx -> {
            if(ctx.getTask()!=null && ctx.getCurrentNode()!=null){
                TaskHistoryForm form = new TaskHistoryForm();
                form.setTaskId(ctx.getTask().getId());
                form.setTaskNodeId(ctx.getCurrentNode().getId());
                form.setHistory(ctx.getHistory().toString());
                taskDao.insertHistory(form);
            }
        });
        //通知节点
        pointList.add(ctx -> {
            if(ctx.getNextNode()!=null){
                FlowNodeNotifyQueryForm form = new FlowNodeNotifyQueryForm();
                form.setNodeId(ctx.getNextNode().getId());
                List<TaskNodeNotifyModel> personList = taskDao.queryTaskNodeNotify(form);
                //taskDao.notify(); TODO 做具体的通知动作
            }
        });
    }

    /**
     * 执行任务
     * @return
     */
    public Object doCommand(){
        initContext();
        Object result = command();
        doChain(this.context);
        return result;
    }

    /**
     * 初始化任务的上下文通用数据
     * @param form
     */
    protected void initDealTask(IdForm form){
        TaskModel task = taskDao.pickTaskById(form.getId());
        if(task==null){
            throw new RuntimeException("任务Id有误，请确认数据");
        }
        FlowNodeModel currentNode = processSearcher.findCurrentNode(task.getProcessId(),task.getCurrentNodeId());
        if(currentNode==null){
            throw new RuntimeException("任务关联流程定义有误，请确认数据");
        }
        this.context.setTask(task);
        this.context.setCurrentNode(currentNode);
    }

    /**
     * 操作更新任务的节点事项
     * @param item
     */
    protected void updateTaskNodeItem(TaskNodeItemForm item) {
        if(item != null){
//            addHistory(1,"[更新事项]","");
            taskDao.updateNodeItemResult(item);
        }
    }

    /**
     * 根据子任务事项更新主任务事项,只适用于子任务
     * @param item
     */
    protected void updateTaskNodeItemV2(TaskNodeItemForm item) {
        if(item != null){
            taskDao.updateNodeItemResultV2(item);
        }
    }



    /**判断是否启动子流程任务
     * **/
    protected boolean initSubTask(TaskModel task,FlowNodeModel node, TaskDealForm taskDealForm){
        if(StringUtils.isNotEmpty(node.getSubProcessId())){
            FlowProcessDefinitionModel subDef = processSearcher.searchProcessDefinitionById(node.getSubProcessId());
            TaskStartForm form = new TaskStartForm();
            form.setBizCodeStr(subDef.getBizCode());

            if (StringUtils.isEmpty(taskDealForm.getBizEntityId())) {
                throw new RuntimeException("下一节点包含子流程,开启子任务必须传关联业务表主键");
            }

            form.setParentId(task.getId());
            form.setOperatorId(task.getUpdateOperatorId());
            FlowNodeModel subStartNode = processSearcher.findStartNode(subDef.getBizCode());
            startTask(form,subStartNode);

            return true;
        }
        return false;
    }

    /**
     * 开启任务
     * @param form
     * @param nextNode
     */
    protected void startTask(TaskStartForm form,FlowNodeModel nextNode) {
        String taskId = SerialNumberUtil.generateSerialNumber();
        form.setId(taskId);
        //查找下一节点执行人
        form.setNodeId(nextNode.getId());
        form.setProcessId(nextNode.getProcessDefinitionId());
        form.setAssignType(nextNode.getAssignType());
        form.setAssignEntityId(nextNode.getAssignEntityId());
        TaskModel task = new TaskModel();
        task.setId(form.getId());
        task.setBizEntityId(form.getBizEntityId());
        task.setCreateOperatorId(form.getOperatorId());
        task.setUpdateOperatorId(form.getOperatorId());
        if(initSubTask(task,nextNode, TaskDealPassForm.newTaskDealPassForm())){
            form.setStatus(TaskStatus.SUB_TASK);
        }
        //保存任务
        taskDao.startNewTask(form);

        checkNextNodeIsSubProcess(nextNode, form);

        // 保存子流程的变量条件
        if (form.getTaskVariableSaveForm() != null) {
            form.getTaskVariableSaveForm().setBizEntityId(form.getBizEntityId());
            saveTaskVariable(nextNode, form);
        }

        initTaskNodeItem(form.getId(),nextNode);
        //如果是主业务流程则生成节点预警
        if(StringUtils.isEmpty(form.getParentId())) {

            resetTaskNodeWarn(form.getId(),nextNode);
        }
    }

    /**
     * 初始化任务的节点事项
     * @param taskId
     * @param node
     */
    protected void initTaskNodeItem(String taskId, FlowNodeModel node) {
        FlowNodeItemQueryForm form = new FlowNodeItemQueryForm();
        form.setNodeId(node.getId());
        if(!CommonListUtil.isEmpty(node.getItems())){
            List<TaskNodeItemModel> taskNodeItems = new ArrayList<>();
            // 根据pass的下一个节点查出上一节点的 节点进度展示顺序
            Integer passNodeScheduleOrder = taskDao.selectPreviousScheduleOrder(taskId) + 1;

            for(FlowNodeItemModel flowNodeItem :node.getItems()){
                TaskNodeItemModel taskNodeItem = new TaskNodeItemModel();
                taskNodeItem.setTaskId(taskId);
                taskNodeItem.setTaskNodeId(node.getId());

                taskNodeItem.setItemFinishPerson(flowNodeItem.getItemFinishPerson());
                taskNodeItem.setItemFinishTime(flowNodeItem.getItemFinishTime());
                taskNodeItem.setItemResult(flowNodeItem.getItemResult());
                taskNodeItem.setItemExpandResult(flowNodeItem.getItemExpandResult());
                taskNodeItem.setItemCode(flowNodeItem.getItemCode());
                taskNodeItem.setNecessary(flowNodeItem.getNecessary());

                taskNodeItem.setItemExcept(flowNodeItem.getItemExcept());
                taskNodeItem.setItemExceptType(flowNodeItem.getItemExceptType());
                taskNodeItem.setItemId(flowNodeItem.getId());
                taskNodeItem.setNecessary(flowNodeItem.getNecessary());
                taskNodeItem.setCore(flowNodeItem.getCore());
                taskNodeItem.setNodeScheduleOrder(passNodeScheduleOrder);

                taskNodeItem.setId(UUID.randomUUID().toString());
                taskNodeItems.add(taskNodeItem);
            }
            taskDao.insertTaskNodeItem(taskNodeItems);
        }
    }

    /**
     * 从节点列表中获得指定id的节点信息
     * @param nextNodeId
     * @param nodeList
     * @return
     */
    protected FlowNodeModel pickNextNode(String nextNodeId, List<FlowNodeModel> nodeList) {
        if(StringUtils.isEmpty(nextNodeId)){
            throw new RuntimeException("非终结节点必须选择下一节点id");
        }
        FlowNodeModel nextNode = null;
        for(FlowNodeModel node:nodeList){
            if(node.getId().equals(nextNodeId)){
                nextNode = node;
            }
        }
        if(nextNode==null){
            throw new RuntimeException("下一节点id设置有误");
        }
        return nextNode;
    }

    /**
     * 添加操作历史记录
     * @param level
     * @param title
     * @param info
     */
    protected void addHistory(int level,String title,String info){
        context.getHistory().append("├─");
        while(level>1){
            context.getHistory().append("├─");
            level--;
        }
        context.getHistory().append(title)
                .append(":").append(info).append("\r\n");
    }

    /**
     * 关闭节点预警
     * @param taskId
     * @param currentNode
     */
    protected void closeTaskNodeWarn(String taskId, FlowNodeModel currentNode){
        TaskNodeWarnCloseForm form = new TaskNodeWarnCloseForm();
        form.setTaskId(taskId);
        form.setNodeId(currentNode.getId());
        form.setEndTime(new Date());
        taskDao.closeTaskNodeWarn(form);
    }

    /**
     * 重置预警节点
     * @param taskId
     * @param nextNode
     */

    protected void resetTaskNodeWarn(String taskId, FlowNodeModel nextNode) {
        if(CommonConstants.YES.equals(nextNode.getWarn())){
            TaskNodeWarnBaseForm query = new TaskNodeWarnBaseForm();
            query.setTaskId(taskId);
            query.setNodeId(nextNode.getId());
            TaskNodeWarnModel warnModel = taskDao.selectTaskNodeWarn(query);
            Date now = new Date();
            if(warnModel==null){
                warnModel = new TaskNodeWarnModel();
                warnModel.setId(UUID.randomUUID().toString());
                warnModel.setTaskId(taskId);
                warnModel.setNodeId(nextNode.getId());
                warnModel.setStartTime(now);
                warnModel.setUpdateTime(now);
                if(CommonConstants.YES.equals(nextNode.getWarn())){
                    if(nextNode.getNodeWarn().getLimit()!=null){
                        warnModel.setLimitEndTime(CommonDateUtil.addHour(now,nextNode.getNodeWarn().getLimit()));
                        if(nextNode.getNodeWarn().getLimitWarn()!=null &&
                                nextNode.getNodeWarn().getLimit()>nextNode.getNodeWarn().getLimitWarn()){
                            warnModel.setLimitWarnTime(CommonDateUtil.addHour(now,
                                    nextNode.getNodeWarn().getLimit()-nextNode.getNodeWarn().getLimitWarn()));
                        }

                        if(nextNode.getNodeWarn().getLevelOneWarn()!=null){
                            warnModel.setLevelOneTime(CommonDateUtil.addHour(now,
                                    nextNode.getNodeWarn().getLimit()+nextNode.getNodeWarn().getLevelOneWarn()));
                        }
                        if(nextNode.getNodeWarn().getLevelTwoWarn()!=null){
                            warnModel.setLevelTwoTime(CommonDateUtil.addHour(now,
                                    nextNode.getNodeWarn().getLimit()+nextNode.getNodeWarn().getLevelTwoWarn()));
                        }
                        if(nextNode.getNodeWarn().getLevelThreeWarn()!=null){
                            warnModel.setLevelThreeTime(CommonDateUtil.addHour(now,
                                    nextNode.getNodeWarn().getLimit()+nextNode.getNodeWarn().getLevelThreeWarn()));
                        }
                    }
                }
                taskDao.insertTaskNodeWarn(warnModel);
            }else{
                warnModel.setUpdateTime(now);
                taskDao.resetTaskNodeWarn(warnModel);
            }
        }
    }

    /**
     * 检查是否存在未完成的子任务
     * @param parentTaskId
     */
    protected void checkSubTask(String parentTaskId) {
        List<TaskModel> taskList = taskDao.queryTaskByParentId(parentTaskId);
        for(TaskModel subTask:taskList){
            if(subTask.getStatus()==TaskStatus.RUNNING||
                    subTask.getStatus()==TaskStatus.SUB_TASK){
                throw new RuntimeException("子任务未完成，不能执行通过/驳回操作。");
            }
        }
    }

    /**
     * 检查操作人权限
     * @param task
     * @param form
     * @return
     */
    protected void checkAssign(TaskModel task, TaskDealForm form) {
        boolean result;
        if(task.getAssignType()== FlowNodeAssignType.PERSON){
            result = task.getAssignEntityId().equals(form.getTaskNodeItem().getItemFinishPerson());
        }else{
            result = task.getAssignEntityId().equals(form.getTaskNodeItem().getItemFinishPersonOrgId());
        }
        if(!result){
            throw new RuntimeException("操作人权限不足。");
        }
    }

    /**
     * 检查任务有效性
     * @param task
     */
    protected void checkTask(TaskModel task) {
        if(!TaskStatus.RUNNING.equals(task.getStatus()) && !TaskStatus.REJECT.equals(task.getStatus())){
            throw new RuntimeException("任务当前状态不可操作："+task.getStatus());
        }
    }

    /**
     * 新增自定义处理
     * @param point
     */
    public void addEndPoint(EndPoint point){
        this.pointList.add(point);
    }

    protected void saveTaskVariable(FlowNodeModel nextNode, TaskStartForm form) {
        if (nextNode.getNodeConditionName()!=null && form.getTaskVariableSaveForm() == null) {
            throw new RuntimeException("开启有条件配置的子流程,未传入业务配置信息");
        }

        // 保存任务变量表
        form.getTaskVariableSaveForm().setId(UUID.randomUUID().toString());
        taskDao.saveTaskVariable(form.getTaskVariableSaveForm());
    }

    /**
     * 检查下一个节点是否有子任务,再判断条件配置
     * @param nextNode
     * @param startForm
     * @return
     */
    private boolean checkNextNodeIsSubProcess(FlowNodeModel nextNode, TaskStartForm startForm) {
        if (StringUtils.isNotEmpty(nextNode.getSubProcessId())) { //是子任务要根据子任务节点生成事项
            // 找主流程下一个节点上是否有子任务,有子任务找到是否有条件判断,如果有条件判断则校验是否传入TaskVariableSaveForm条件
            List<ConditionVariableModel> list = taskDao.selectSubProcessNodeExpect(nextNode.getSubProcessId());
            if (!list.isEmpty() && startForm.getTaskVariableSaveForm() == null) {//子流程有判断条件时,校验TaskVariableSaveForm是否传入
                throw new RuntimeException("下一节点包含子流程必须传入条件配置");
            }
            if (list.get(0).getVariableName() != startForm.getTaskVariableSaveForm().getVariableName()) {
                throw new RuntimeException("传入下一节点的变量类型不匹配,请检查");
            }
        }
        return true;
    }

}
