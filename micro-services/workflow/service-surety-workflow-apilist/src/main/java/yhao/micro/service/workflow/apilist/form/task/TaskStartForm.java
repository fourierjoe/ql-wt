package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeAssignType;
import yhao.micro.service.workflow.apilist.enums.task.TaskBizCode;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;

public class TaskStartForm extends IdUnForm {
    @ApiModelProperty(value = "业务编码，与bizCodeStr之一不可为空，两者皆存在优先使用bizCode",hidden = true)
    private TaskBizCode bizCode;

    @ApiModelProperty(value = "业务编码自定义，与bizCode之一不可为空，两者皆存在优先使用bizCode")
    private String bizCodeStr;

    @ApiModelProperty(value = "流程标题")
    private String taskHead;

    @ApiModelProperty(value = "关联业务主键", required = true)
    @NotBlank(message = "关联业务主键不得为空")
    private String bizEntityId;

    @ApiModelProperty(value = "任务状态", hidden = true)
    private TaskStatus status = TaskStatus.RUNNING;

    @ApiModelProperty(value = "开始节点Id",hidden = true)
    private String nodeId;

    @ApiModelProperty(value = "流程Id",hidden = true)
    private String processId;

    @ApiModelProperty(value = "任务指派到类型",hidden = true)
    private FlowNodeAssignType assignType;

    @ApiModelProperty(value = "任务指派到Id",hidden = true)
    private String assignEntityId;

    @ApiModelProperty(value = "父任务Id",hidden = true)
    private String parentId;

    @ApiModelProperty(value = "任务变量,暂时只支持一个")
    private TaskVariableSaveForm taskVariableSaveForm;

    public TaskVariableSaveForm getTaskVariableSaveForm() {
        return taskVariableSaveForm;
    }

    public void setTaskVariableSaveForm(TaskVariableSaveForm taskVariableSaveForm) {
        this.taskVariableSaveForm = taskVariableSaveForm;
    }

    public TaskBizCode getBizCode() {
        return bizCode;
    }

    public void setBizCode(TaskBizCode bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizEntityId() {
        return bizEntityId;
    }

    public void setBizEntityId(String bizEntityId) {
        this.bizEntityId = bizEntityId;
    }

    public TaskStatus getStatus() {
        return status;
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

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getBizCodeStr() {
        return bizCodeStr;
    }

    public void setBizCodeStr(String bizCodeStr) {
        this.bizCodeStr = bizCodeStr;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTaskHead() {
        return taskHead;
    }

    public void setTaskHead(String taskHead) {
        this.taskHead = taskHead;
    }
}
