package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;

import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2018/12/25 10:02
 * @Version: v1.0
 */
public class ItemInfoModel extends Entity<String> {
	@ApiModelProperty(value = "任务ID")
	private String taskId;

	@ApiModelProperty(value = "任务节点ID")
	private String taskNodeId;

	@ApiModelProperty(value = "任务状态")
	private TaskStatus status;

	@ApiModelProperty(value = "业务数据表主键ID")
	private String bizEntityId;

	@ApiModelProperty(value = "事项完成时间")
	private Date itemFinishTime;

	@ApiModelProperty(value = "事项处理人ID")
	private String itemFinishPerson;

	@ApiModelProperty(value = "事项结果")
	private String itemResult;

	@ApiModelProperty(value = "事项结果拓展")
	private String itemExpandResult;

	public String getItemResult() {
		return itemResult;
	}

	public void setItemResult(String itemResult) {
		this.itemResult = itemResult;
	}

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

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public String getBizEntityId() {
		return bizEntityId;
	}

	public void setBizEntityId(String bizEntityId) {
		this.bizEntityId = bizEntityId;
	}

	public Date getItemFinishTime() {
		return itemFinishTime;
	}

	public void setItemFinishTime(Date itemFinishTime) {
		this.itemFinishTime = itemFinishTime;
	}

	public String getItemFinishPerson() {
		return itemFinishPerson;
	}

	public void setItemFinishPerson(String itemFinishPerson) {
		this.itemFinishPerson = itemFinishPerson;
	}

	public String getItemExpandResult() {
		return itemExpandResult;
	}

	public void setItemExpandResult(String itemExpandResult) {
		this.itemExpandResult = itemExpandResult;
	}
}
