package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeType;

/**
 * @Description:
 * @Created by ql on 2019/1/8 23:00
 * @Version: v1.0
 */
public class FlowNodeTempleteForm implements ValidationForm {
	@ApiModelProperty(value = "城市组织ID")
	@NotBlank(message = "FlowOrgIdForm:城市组织ID不得为空")
	private String orgId;

	@ApiModelProperty(value = "节点类型", hidden = true)
	private FlowNodeType nodeType;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public FlowNodeType getNodeType() {
		return nodeType;
	}

	public void setNodeType(FlowNodeType nodeType) {
		this.nodeType = nodeType;
	}
}
