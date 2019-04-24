package yhao.micro.service.workflow.service.task;

import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.task.MainNodeBySubNodeQueryForm;
import yhao.micro.service.workflow.apilist.form.task.TaskDealPassForm;
import yhao.micro.service.workflow.apilist.form.task.TaskStatusChangeForm;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeItemModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.flow.SubProcessConditionModel;
import yhao.micro.service.workflow.apilist.model.task.ConditionVariableModel;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;
import yhao.micro.service.workflow.dao.TaskDao;
import yhao.micro.service.workflow.service.pvm.ProcessSearcher;

import java.util.*;

public class PassTaskCommand extends TaskCommand {
    private static final String YES = "YES";
    private static final String NO = "NO";
    private TaskDealPassForm form;
    public PassTaskCommand(TaskDao taskDao, ProcessSearcher processSearcher, TaskDealPassForm form) {
        super(taskDao, processSearcher);
        this.form = form;
    }

    @Override
    protected void initContext() {
        initDealTask(form);
        FlowNodeModel nextNode = null;
        FlowProcessDefinitionModel bizCodModel = processSearcher.searchProcessDefinitionById(this.context.getTask().getProcessId());
        List<FlowNodeModel> nodeList = processSearcher.findNextNodes(
                bizCodModel.getBizCode(),this.context.getTask().getCurrentNodeId());

        if(!form.isAheadFinish()&&!CommonListUtil.isEmpty(nodeList)){
            // 获取下一级节点
            FlowNodeModel flowNodeModel = processSearcher.findNextNode(bizCodModel.getBizCode(), this.context.getTask().getCurrentNodeId());
            nextNode = pickNextNode(flowNodeModel.getId(), nodeList);
        }
        this.context.setNextNode(nextNode);
    }

    @Override
    protected Boolean command() {
        TaskModel task = context.getTask();

        checkTask(task);
        // 子任务需要校验执行人
//        checkAssign(task,form);
        checkSubTask(task.getId());

        FlowNodeModel nextNode = context.getNextNode();
        task.setUpdateOperatorId(form.getTaskNodeItem().getItemFinishPerson());

        // 先查出具体任务中的变量条件
        List<ConditionVariableModel> variableModelList = taskDao.pickNodeConditionVariable(task.getBizEntityId());
        SubProcessConditionModel subProcessConditionModel = taskDao.pickNodeCondition(task.getCurrentNodeId());

        nextNode = checkNextNodeIsSubTask(task, variableModelList, subProcessConditionModel, nextNode);

        if(nextNode==null){
            task.setStatus(form.isAheadFinish()?TaskStatus.AHEAD_END:TaskStatus.END);
            taskDao.taskGoToEnd(task);
            //如果是子任务，则更改主任务状态,同时需要生成主任务下一节点事项
            if(StringUtils.isNotEmpty(task.getParentId())){
                TaskStatusChangeForm form = new TaskStatusChangeForm();
                form.setId(task.getParentId());
                form.setStatus(TaskStatus.RUNNING);
                taskDao.changeTaskStatus(form);

                //获取主任务的下一个节点
                String parentId = task.getParentId(); //主任务id
                //查出主任务
                TaskModel mainTaskModel = taskDao.pickTaskById(parentId);

                FlowProcessDefinitionModel bizCodModel = taskDao.pickProcessBizCodeByTaskId(parentId); //主流程编码

                MainNodeBySubNodeQueryForm mainNodeBySubNodeQueryForm = new MainNodeBySubNodeQueryForm();
                mainNodeBySubNodeQueryForm.setParentTaskId(parentId);
                mainNodeBySubNodeQueryForm.setSubItemId(this.context.getTask().getCurrentNodeId());
                String mainTaskCurrentNodeId = taskDao.selectMainNodeBySubNode(mainNodeBySubNodeQueryForm);

                // 主任务下一节点
                nextNode = processSearcher.findNextNode(bizCodModel.getBizCode(), mainTaskCurrentNodeId);
                // 修改主任务当前节点
                mainTaskModel.setCurrentNodeId(nextNode.getId());
                mainTaskModel.setStatus(TaskStatus.RUNNING);
                taskDao.taskGoToNext(mainTaskModel);


                // 检查下个节点是否包含子任务
                nextNode = pickSubTaskPath(nextNode, variableModelList);

                // 参数传入与子任务关联的主任务的信息taskModel
                nextNode = checkNextNodeIsSubTask(mainTaskModel, variableModelList, subProcessConditionModel, nextNode);

                // 插入下一节点事项
                initTaskNodeItem(parentId,nextNode);
            } else {
                // TODO: 2019/3/4  主任务结束发通知
            }
        }else{
            nextNode = pickSubTaskPath(nextNode, variableModelList);

            nextNode = checkNextNodeIsSubTask(task, variableModelList, subProcessConditionModel, nextNode);

            // 插入下一节点事项
            initTaskNodeItem(task.getId(),nextNode);
            //更新任务
            task.setCurrentNodeId(nextNode.getId());
            if (StringUtils.isNotEmpty(task.getParentId())) { //是子任务则赋值节点操作人
                task.setAssignType(nextNode.getAssignType());
                task.setAssignEntityId(nextNode.getAssignEntityId());
            }
            task.setStatus(TaskStatus.RUNNING);
            //初始化子任务
            if(initSubTask(task,nextNode,form)){
                task.setStatus(TaskStatus.SUB_TASK);
            }
            taskDao.taskGoToNext(task);
        }
        closeTaskNodeWarn(task.getId(),context.getCurrentNode());
        return true;
    }

    /**
     * 获取子任务路径,判断是否到达下一个节点
     * @param nextNode
     * @param variableModelList
     * @return
     */
    private FlowNodeModel pickSubTaskPath(FlowNodeModel nextNode, List<ConditionVariableModel> variableModelList) {
        if (StringUtils.isNotEmpty(nextNode.getSubProcessId())) { //下一节点是不是有子流程,有子流程,在主流程节点上也生成事项
            // 根据具体任务查出该子任务要走几个节点
            FlowProcessDefinitionModel bizCodModel = processSearcher.searchProcessDefinitionById(nextNode.getSubProcessId());
            FlowProcessDefinitionModel flowProcessDefinitionModel = processSearcher.searchNewestProcessDefinitionByCode(bizCodModel.getBizCode());
            List<FlowNodeModel> nodeList = flowProcessDefinitionModel.getNodeList();

            Collections.sort(nodeList, new Comparator<FlowNodeModel>() {
                @Override
                public int compare(FlowNodeModel o1, FlowNodeModel o2) {
                    if(StringUtils.isEmpty(o1.getNodeExpect())|| StringUtils.isEmpty(o2.getNodeExpect())){
                        return 0;
                    }
                    int expectBg = Integer.parseInt(o1.getNodeExpect());
                    int resultBg = Integer.parseInt(o2.getNodeExpect());
                    return expectBg - resultBg;
                }
            });

            List<FlowNodeModel> subNodes = Lists.newLinkedList();
            if (!CommonListUtil.isEmpty(variableModelList)) {
                for (FlowNodeModel flowNodeModel:nodeList) {
                    int count = 0;
                    for (ConditionVariableModel variableModel:variableModelList) {
                        if (variableModel.getVariableName() == (flowNodeModel.getNodeConditionName())
                                && flowNodeModel.getNodeExpectType().match(flowNodeModel.getNodeExpect(), variableModel.getVariableText())) {
                            subNodes.add(flowNodeModel);
                        }
                        if (flowNodeModel.getNodeExpectType().match(variableModel.getVariableText(), flowNodeModel.getNodeExpect())) {
                            subNodes.add(flowNodeModel);
                            count++;
                            break;
                        }
                    }
                    if (count == 1) {
                        break;
                    }
                }
            } else {
                subNodes = nodeList;
            }

            // 多个节点list整合为一个节点对象(包含多个事项)
            ArrayList<FlowNodeItemModel> list = Lists.newArrayList();
            for (FlowNodeModel model : subNodes) {
                FlowNodeItemModel flowNodeItemModel = new FlowNodeItemModel();
                flowNodeItemModel.setItemCode(nextNode.getId());
                flowNodeItemModel.setNodeId(nextNode.getId());
                flowNodeItemModel.setItemName(model.getNodeName());
                flowNodeItemModel.setItemExcept(CommonConstants.PASS);
                flowNodeItemModel.setItemExceptType(RuleItemType.EQ);
                flowNodeItemModel.setCore(YES);
                flowNodeItemModel.setNecessary(NO);
                flowNodeItemModel.setId(model.getId());
                list.add(flowNodeItemModel);
            }
            nextNode.setItems(list);
        }
        return nextNode;
    }

    /**
     * 判断下一节点是否到达
     * @param task
     * @param variableModelList
     * @param subProcessConditionModel
     * @param nextNode
     * @return
     */
    private FlowNodeModel checkNextNodeIsSubTask(TaskModel task, List<ConditionVariableModel> variableModelList,
                                SubProcessConditionModel subProcessConditionModel,FlowNodeModel nextNode) {
        if (StringUtils.isNotEmpty(task.getParentId())) { // 如果是子流程任务, 那么要判断条件分支, 判断是否符合到下一节点的条件

            if (Optional.ofNullable(variableModelList).isPresent()) {
                for (ConditionVariableModel variableModel : variableModelList) {

                    if (subProcessConditionModel != null && variableModel.getVariableName() == (subProcessConditionModel.getNodeConditionName())) {
                        // 不满足通过条件,即该节点有足够权限审批,则不到下一节点
                        if (!subProcessConditionModel.getNodeExpectType().match(subProcessConditionModel.getNodeExpect(), variableModel.getVariableText())) {
                            nextNode = null;
                            break;
                        } else { //生成子任务下一节点事项,代码中默认
                            List<FlowNodeItemModel> list = Lists.newArrayList();
                            FlowNodeItemModel model = new FlowNodeItemModel();
                            model.setItemCode(nextNode.getId());
                            model.setNodeId(nextNode.getId());
                            model.setItemExcept(CommonConstants.PASS);
                            model.setItemExceptType(RuleItemType.EQ);
                            model.setCore(YES);
                            model.setNecessary(NO);
                            model.setId(nextNode.getId());

                            list.add(model);
                            nextNode.setItems(list);
                        }
                    }
                }
            }
        }

        return nextNode;
    }

}
