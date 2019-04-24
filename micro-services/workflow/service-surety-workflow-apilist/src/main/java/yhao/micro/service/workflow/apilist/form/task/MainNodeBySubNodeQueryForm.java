package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * @Description:
 * @Created by ql on 2018/12/26 11:37
 * @Version: v1.0
 */
public class MainNodeBySubNodeQueryForm implements ValidationForm {

	@ApiModelProperty(value = "父任务ID")
	private String parentTaskId;

	@ApiModelProperty(value = "子任务节点ID = 子任务事项ID")
	private String subItemId;

	public String getParentTaskId() {
		return parentTaskId;
	}

	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	public String getSubItemId() {
		return subItemId;
	}

	public void setSubItemId(String subItemId) {
		this.subItemId = subItemId;
	}
}
