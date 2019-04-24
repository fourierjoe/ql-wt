package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;

public class TaskHistoryForm extends IdForm {
    @ApiModelProperty(value = "任务id",required = true)
    @NotBlank(message = "任务id不得为空")
    private String taskId;

    @ApiModelProperty(value = "任务节点id",required = true)
    @NotBlank(message = "任务节点id不得为空")
    private String taskNodeId;

    @ApiModelProperty(value = "历史记录")
    private String history;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskNodeId() {
        return taskNodeId;
    }

    public void setTaskNodeId(String taskNodeId) {
        this.taskNodeId = taskNodeId;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}
