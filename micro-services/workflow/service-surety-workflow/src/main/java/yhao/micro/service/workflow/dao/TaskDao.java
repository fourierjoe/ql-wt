package yhao.micro.service.workflow.dao;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeNotifyQueryForm;
import yhao.micro.service.workflow.apilist.form.task.*;
import yhao.micro.service.workflow.apilist.model.approve.TaskInfoModel;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.flow.SubProcessConditionModel;
import yhao.micro.service.workflow.apilist.model.task.*;

import java.util.Date;
import java.util.List;

public interface TaskDao {
    void startNewTask(TaskStartForm form);

    TaskModel pickTaskById(String id);

    void taskGoToNext(TaskModel task);

    void taskGoToEnd(TaskModel task);

    /**
     * 根据任务id+事项编码更新
     * @param item
     * @return
     */
    int updateNodeItemResult(TaskNodeItemForm item);

    /**
     * 根据任务id+事项id更新
     * @param item
     * @return
     */
    int updateMainNodeItemResult(TaskNodeItemForm item);

    void updateNodeItemResultV2(TaskNodeItemForm item);

    List<TaskNodeItemModel> queryTaskNodeItem(TaskNodeItemQueryForm queryForm);

    void insertTaskNodeItem(List<TaskNodeItemModel> taskNodeItems);

    void insertHistory(TaskHistoryForm form);

    List<TaskNodeNotifyModel> queryTaskNodeNotify(FlowNodeNotifyQueryForm form);

    TaskNodeWarnModel selectTaskNodeWarn(TaskNodeWarnBaseForm query);

    void resetTaskNodeWarn(TaskNodeWarnModel warnModel);

    void insertTaskNodeWarn(TaskNodeWarnModel warnModel);

    void closeTaskNodeWarn(TaskNodeWarnCloseForm form);

    void queryUnFlowTask(Pagination<TaskNodeWarnModel> page, Date checkTime);

    void checkTaskNodeWarn(TaskNodeWarnModel warn);

    void updateTaskNodeWarnCheckTime(TaskNodeWarnCheckTimeUpdateForm form);

    void queryTask(Pagination<TaskModel> page, TaskQueryForm form);

    List<TaskModel> queryTaskByParentId(String parentTaskId);

    void changeTaskStatus(TaskStatusChangeForm form);

    List<TaskNodeItemModel> queryCoreNecessaryItem(TaskNodeItemQueryForm form);

    /**
     * 查询子流程节点判断分支条件
     * @param
     * @return
     */
    SubProcessConditionModel pickNodeCondition(String currentNodeId);

    /**
     * 查询具体任务变量, 目前只有担保/借款金额, 申请金额
     * @param bizEntityId
     * @returns
     */
    List<ConditionVariableModel> pickNodeConditionVariable(String bizEntityId);

    FlowProcessDefinitionModel pickProcessBizCodeByTaskId(String taskId);

    TaskInfoModel querycurrentTaskNodeAllInfo(String taskId);

	TaskModel pickTaskState(String id);

	TaskNodeItemModel selectCoreItem(String itemId);

    List<TaskNodeModel> pickTaskSchedule(String taskId);

    Integer selectPreviousScheduleOrder(String taskId);

    List<TaskNodeItemModel> queryItemResult(ItemResultQueryForm form);

    /**
     * 查找当前节点Id
     * @param taskId
     */
    String findCurrentNodeId(String taskId);

    List<ItemInfoModel> pickTaskItemByItemCode(ItemByItemCodeQueryForm form);

    String selectMainNodeBySubNode(MainNodeBySubNodeQueryForm form);

    /**
     * 保存任务变量
     * @param form
     */
    void saveTaskVariable(TaskVariableSaveForm form);

    List<ConditionVariableModel> selectSubProcessNodeExpect(String subProcessId);

    int updateSubTaskBizEntityId(BizEntityIdUpdateForm form);

    TaskScheduleQueryModel findTaskVariableByTaskId(String taskId);

    List<TaskModel> selectSubTask(String taskId);

    TaskModel selectTask(String id);

    String selectNodeId(String id);

    ItemResultModel selectItemResult(TaskNodeItemForm form);

    RefuseTaskItemModel pickRefuseForm(String id);

    String selectMainTaskStartNode(String id);

    int updateTask2Cancel(String id);
}
