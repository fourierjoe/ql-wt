package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;

public class TaskDealPassForm extends TaskDealForm {
    @ApiModelProperty(value = "通过下一级节点Id", hidden = true)
    private String passNodeId;

    @ApiModelProperty(value = "提前完成", hidden = true)
    private boolean aheadFinish = false;

    @ApiModelProperty(value = "任务状态")
    private TaskStatus status;

    public TaskDealPassForm() {}
    public String getPassNodeId() {
        return passNodeId;
    }

    public void setPassNodeId(String passNodeId) {
        this.passNodeId = passNodeId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public boolean isAheadFinish() {
        return aheadFinish;
    }

    public void setAheadFinish(boolean aheadFinish) {
        this.aheadFinish = aheadFinish;
    }

    public static TaskDealPassForm newTaskDealPassForm() {
        return new TaskDealPassForm();
    }
}
