package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;

public class TaskNodeItemQueryForm extends IdUnForm {
    @ApiModelProperty(value = "任务id",required = true)
    @NotBlank(message = "任务不得为空")
    private String taskId;

    @ApiModelProperty(value = "当前节点id",required = true)
    @NotBlank(message = "节点id不得为空")
    private String nodeId;

    @ApiModelProperty(value = "是否必要条件",required = true)
    @NotNull(message = "是否必要条件不得为空")
    private YNEnum necessary;

    @ApiModelProperty(value = "是否核心条件",required = true)
    @NotNull(message = "是否核心条件不得为空")
    private YNEnum core;

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

    public YNEnum getNecessary() {
        return necessary;
    }

    public void setNecessary(YNEnum necessary) {
        this.necessary = necessary;
    }

    public YNEnum getCore() {
        return core;
    }

    public void setCore(YNEnum core) {
        this.core = core;
    }
}
