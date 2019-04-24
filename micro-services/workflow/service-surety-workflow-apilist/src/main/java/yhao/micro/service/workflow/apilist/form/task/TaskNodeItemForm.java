package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.form.task.validatedGroup.RefuseTask;

import javax.validation.constraints.NotNull;

public class TaskNodeItemForm implements ValidationForm {
    @ApiModelProperty(value = "任务id", required = true)
    @NotBlank(message = "任务id不得为空")
    private String taskId;

    @ApiModelProperty(value = "事项关联节点id", required = true)
    @NotBlank(message = "事项关联节点id不得为空")
    private String nodeId;

    // 事项id通过pick任务获取,子任务事项id为子流程节点ID
    @ApiModelProperty(value = "事项Id", required = true)
    @NotBlank(message = "事项Id不得为空")
    private String itemId;

    @ApiModelProperty(value = "事项编号", required = true)
    @NotBlank(message = "事项编号不得为空")
    private String itemCode;

    @ApiModelProperty(value = "处理事项结果编码", required = true)
    @NotBlank(message = "处理事项结果编码不得为空")
    private String itemResultCode;

    @ApiModelProperty(value = "处理事项结果", hidden = true)
    private String itemResult;

    @ApiModelProperty(value = "是否匹配通过 YES/NO(展示页面对勾)", hidden = true)
    private YNEnum isMatch;

    @ApiModelProperty(value = "事项拓展字段, 可填审批意见")
    private String itemExpandResult;

    @ApiModelProperty(value = "事项处理人ID,其他服务调用必传", required = true)
    @NotBlank(message = "(其他服务)事项处理人ID不得为空")
    private String itemFinishPerson;

    @ApiModelProperty(value = "事项处理人组织ID,其他服务调用必传", required = true)
    @NotBlank(message = "(其他服务)事项处理人组织ID不得为空")
    private String itemFinishPersonOrgId;

    @ApiModelProperty(value = "是否必要条件, YES/NO")
    @NotNull(message = "是否必要条件不得为空", groups = {RefuseTask.class})
    private YNEnum itemNecessary;

    @ApiModelProperty(value = "是否核心条件, YES/NO")
    @NotNull(message = "是否核心条件不得为空", groups = {RefuseTask.class})
    private YNEnum itemCore;

    public String getItemFinishPersonOrgId() {
        return itemFinishPersonOrgId;
    }

    public void setItemFinishPersonOrgId(String itemFinishPersonOrgId) {
        this.itemFinishPersonOrgId = itemFinishPersonOrgId;
    }

    public YNEnum getIsMatch() {
        return isMatch;
    }

    public void setIsMatch(YNEnum isMatch) {
        this.isMatch = isMatch;
    }

    public String getItemResult() {
        return itemResult;
    }

    public void setItemResult(String itemResult) {
        this.itemResult = itemResult;
    }

    public YNEnum getItemNecessary() {
        return itemNecessary;
    }

    public void setItemNecessary(YNEnum itemNecessary) {
        this.itemNecessary = itemNecessary;
    }

    public YNEnum getItemCore() {
        return itemCore;
    }

    public void setItemCore(YNEnum itemCore) {
        this.itemCore = itemCore;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemResultCode() {
        return itemResultCode;
    }

    public void setItemResultCode(String itemResultCode) {
        this.itemResultCode = itemResultCode;
    }

    public String getItemExpandResult() {
        return itemExpandResult;
    }

    public void setItemExpandResult(String itemExpandResult) {
        this.itemExpandResult = itemExpandResult;
    }

    public String getItemFinishPerson() {
        return itemFinishPerson;
    }

    public void setItemFinishPerson(String itemFinishPerson) {
        this.itemFinishPerson = itemFinishPerson;
    }
    public static TaskNodeItemForm newTaskNodeItemForm() {
        return new TaskNodeItemForm();
    }
    public TaskNodeItemForm() {}
}
