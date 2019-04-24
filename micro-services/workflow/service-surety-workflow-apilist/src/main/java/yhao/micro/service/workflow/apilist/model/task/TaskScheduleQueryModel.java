package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2018/12/28 16:20
 * @Version: v1.0
 */
public class TaskScheduleQueryModel extends Entity<String> {
	@ApiModelProperty(value = "父任务id")
	private String taskParentId;

	@ApiModelProperty(value = "当前任务流程Id")
	private String processId;

	@ApiModelProperty(value = "变量条件")
	private String variableText;

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getTaskParentId() {
		return taskParentId;
	}

	public void setTaskParentId(String taskParentId) {
		this.taskParentId = taskParentId;
	}

	public String getVariableText() {
		return variableText;
	}

	public void setVariableText(String variableText) {
		this.variableText = variableText;
	}
}
