package yhao.micro.service.workflow.apilist.model.task;


import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeAssignType;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;

import java.util.Date;
import java.util.List;

public class TaskModel extends Entity<String> {
    @ApiModelProperty("当前节点ID")
    private String currentNodeId;
    @ApiModelProperty("任务状态")
    private TaskStatus status;
    @ApiModelProperty("指派类型")
    private FlowNodeAssignType assignType;
    @ApiModelProperty("指派实体ID")
    private String assignEntityId;
    @ApiModelProperty("关联业务实体ID")
    private String bizEntityId;
    @ApiModelProperty("关联流程id")
    private String processId;
    @ApiModelProperty("流转至节点的时间")
    private Date flowTime;
    @ApiModelProperty("父任务id，有且仅有当该字段有值时，表示该任务为从属于某一任务节点的子流程任务")
    private String parentId;

    @ApiModelProperty("下级节点")
    private List<FlowNodeModel> nextList;
    @ApiModelProperty("回退节点")
    private List<FlowNodeModel> previousList;
    @ApiModelProperty("事项")
    private List<TaskNodeItemModel> itemList;

    public String getCurrentNodeId() {
        return currentNodeId;
    }

    public void setCurrentNodeId(String currentNodeId) {
        this.currentNodeId = currentNodeId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public FlowNodeAssignType getAssignType() {
        return assignType;
    }

    public void setAssignType(FlowNodeAssignType assignType) {
        this.assignType = assignType;
    }

    public String getAssignEntityId() {
        return assignEntityId;
    }

    public void setAssignEntityId(String assignEntityId) {
        this.assignEntityId = assignEntityId;
    }

    public String getBizEntityId() {
        return bizEntityId;
    }

    public void setBizEntityId(String bizEntityId) {
        this.bizEntityId = bizEntityId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public Date getFlowTime() {
        return flowTime;
    }

    public void setFlowTime(Date flowTime) {
        this.flowTime = flowTime;
    }

    public List<FlowNodeModel> getNextList() {
        return nextList;
    }

    public void setNextList(List<FlowNodeModel> nextList) {
        this.nextList = nextList;
    }

    public List<FlowNodeModel> getPreviousList() {
        return previousList;
    }

    public void setPreviousList(List<FlowNodeModel> previousList) {
        this.previousList = previousList;
    }

    public List<TaskNodeItemModel> getItemList() {
        return itemList;
    }

    public void setItemList(List<TaskNodeItemModel> itemList) {
        this.itemList = itemList;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
