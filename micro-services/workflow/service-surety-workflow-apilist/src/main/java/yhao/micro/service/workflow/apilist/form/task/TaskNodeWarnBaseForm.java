package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;

public class TaskNodeWarnBaseForm extends IdUnForm {
    @ApiModelProperty(value = "任务id",required = true)
    @NotEmpty(message = "任务不得为空")
    private String taskId;

    @ApiModelProperty(value = "当前节点id",required = true)
    @NotEmpty(message = "节点id不得为空")
    private String nodeId;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
