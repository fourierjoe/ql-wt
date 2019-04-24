package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;

public class TaskStatusChangeForm extends IdUnForm {
    @ApiModelProperty(value = "任务状态")
    private TaskStatus status = TaskStatus.RUNNING;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}