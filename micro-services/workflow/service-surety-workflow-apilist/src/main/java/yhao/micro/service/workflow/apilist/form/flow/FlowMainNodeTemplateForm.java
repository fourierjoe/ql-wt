package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeType;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2018/12/20 14:42
 * @Version: v1.0
 */
public class FlowMainNodeTemplateForm extends IdUnForm {
	@ApiModelProperty(value = "节点名称",required = true)
	@NotBlank(message = "节点名称不得为空")
	private String nodeName;

	@ApiModelProperty(value = "节点类型", hidden = true)
	@NotNull(message = "节点类型不得为空")
	private FlowNodeType type = FlowNodeType.MAIN;

	@ApiModelProperty(value = "城市组织ID",required = true)
	@NotBlank(message = "城市组织ID不得为空")
	private String orgId;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public FlowNodeType getType() {
		return type;
	}

	public void setType(FlowNodeType type) {
		this.type = type;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}
