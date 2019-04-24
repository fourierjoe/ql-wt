package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

/**
 * @Description:
 * @Created by ql on 2018/12/23 19:57
 * @Version: v1.0
 */
public class PreviousScheduleOrderQueryForm implements ValidationForm {
	@ApiModelProperty(value = "当前任务Id")
	@NotEmpty(message = "当前任务Id不得为空")
	private String taskId;

	@ApiModelProperty(value = "下一个节点Id")
	@NotEmpty(message = "下一个节点Id不得为空")
	private String nextNodeId;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getNextNodeId() {
		return nextNodeId;
	}

	public void setNextNodeId(String nextNodeId) {
		this.nextNodeId = nextNodeId;
	}
}
