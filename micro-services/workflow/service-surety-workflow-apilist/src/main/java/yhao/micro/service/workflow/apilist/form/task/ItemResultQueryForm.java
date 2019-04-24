package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

/**
 * @Description:
 * @Created by ql on 2018/12/23 22:38
 * @Version: v1.0
 */
public class ItemResultQueryForm implements ValidationForm {
	@ApiModelProperty(value = "任务Id")
	@NotBlank(message = "任务Id不得为空")
	private String taskId;

	@ApiModelProperty(value = "节点Id")
	@NotBlank(message = "节点Id不得为空")
	private String nodeId;

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
}
