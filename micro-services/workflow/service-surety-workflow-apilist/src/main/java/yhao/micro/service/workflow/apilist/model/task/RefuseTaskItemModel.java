package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @Created by ql on 2019/2/14 11:03
 * @Version: v1.0
 */
public class RefuseTaskItemModel {
	@ApiModelProperty(value = "任务Id")
	private String taskId;

	@ApiModelProperty(value = "节点id")
	private String nodeId;

	@ApiModelProperty(value = "父任务Id")
	private String parentId;

	@ApiModelProperty(value = "流程业务码")
	private String bizCode;

	@ApiModelProperty(value = "起始节点Id")
	private String initialId;

	@ApiModelProperty(value = "事项Id")
	private String itemId;

	@ApiModelProperty(value = "事项编号")
	private String itemCode;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getInitialId() {
		return initialId;
	}

	public void setInitialId(String initialId) {
		this.initialId = initialId;
	}

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

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

}
