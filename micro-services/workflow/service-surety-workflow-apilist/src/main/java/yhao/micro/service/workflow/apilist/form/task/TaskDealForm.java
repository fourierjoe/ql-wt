package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdForm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TaskDealForm extends IdForm {
    @ApiModelProperty(value = "处理事项")
    @NotNull(message = "处理事项不得为空")
    @Valid
    private TaskNodeItemForm taskNodeItem;

    @ApiModelProperty(value = "关联业务主键,只有下一节点发起子任务时必须传")
    private String bizEntityId;

    @ApiModelProperty(value = "任务变量,暂时只支持一个，下一节点是子流程时必须传")
    private TaskVariableSaveForm taskVariableSaveForm;

    public TaskVariableSaveForm getTaskVariableSaveForm() {
        return taskVariableSaveForm;
    }

    public String getBizEntityId() {
        return bizEntityId;
    }

    public void setBizEntityId(String bizEntityId) {
        this.bizEntityId = bizEntityId;
    }

    public void setTaskVariableSaveForm(TaskVariableSaveForm taskVariableSaveForm) {
        this.taskVariableSaveForm = taskVariableSaveForm;
    }

    public TaskNodeItemForm getTaskNodeItem() {
        return taskNodeItem;
    }

    public void setTaskNodeItem(TaskNodeItemForm taskNodeItem) {
        this.taskNodeItem = taskNodeItem;
    }
}
