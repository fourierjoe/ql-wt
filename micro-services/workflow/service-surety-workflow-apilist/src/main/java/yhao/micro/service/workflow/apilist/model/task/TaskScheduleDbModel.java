package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2018/12/22 11:57
 * @Version: v1.0
 */
public class TaskScheduleDbModel extends Entity<String> {

	@ApiModelProperty("节点名称")
	private String nodeName;
	@ApiModelProperty(value = "节点进度展示顺序")
	private Integer nodeScheduleOrder;
	@ApiModelProperty("事项名称")
	private String itemName;
	@ApiModelProperty("事项结果")
	private String itemResult;
	@ApiModelProperty("是否必要条件")
	private String necessary;
	@ApiModelProperty(value = "事项处理意见")
	private String itemExpandResult;
	@ApiModelProperty(value = "是否核心条件")
	private String core;
	@ApiModelProperty(value = "事项完成时间")
	private Date itemFinishTime;
	@ApiModelProperty(value = "事项处理人岗位")
	private String itemFinishPersonPosition;
	@ApiModelProperty(value = "事项处理人名称")
	private String itemFinishPersonName;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Integer getNodeScheduleOrder() {
		return nodeScheduleOrder;
	}

	public void setNodeScheduleOrder(Integer nodeScheduleOrder) {
		this.nodeScheduleOrder = nodeScheduleOrder;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemResult() {
		return itemResult;
	}

	public void setItemResult(String itemResult) {
		this.itemResult = itemResult;
	}

	public String getNecessary() {
		return necessary;
	}

	public void setNecessary(String necessary) {
		this.necessary = necessary;
	}

	public String getItemExpandResult() {
		return itemExpandResult;
	}

	public void setItemExpandResult(String itemExpandResult) {
		this.itemExpandResult = itemExpandResult;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public Date getItemFinishTime() {
		return itemFinishTime;
	}

	public void setItemFinishTime(Date itemFinishTime) {
		this.itemFinishTime = itemFinishTime;
	}

	public String getItemFinishPersonPosition() {
		return itemFinishPersonPosition;
	}

	public void setItemFinishPersonPosition(String itemFinishPersonPosition) {
		this.itemFinishPersonPosition = itemFinishPersonPosition;
	}

	public String getItemFinishPersonName() {
		return itemFinishPersonName;
	}

	public void setItemFinishPersonName(String itemFinishPersonName) {
		this.itemFinishPersonName = itemFinishPersonName;
	}
}
