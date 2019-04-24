package yhao.micro.service.workflow.apilist.form.flow.processBussiness;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Description:
 * @Created by ql on 2019/1/17 19:46
 * @Version: v1.0
 */
public class ItemCodeForm extends PageForm {
	@ApiModelProperty(value = "事项名称")
	private String itemName;

	@ApiModelProperty(value = "城市组织id", required = true)
	@NotBlank(message = "城市组织id不得为空")
	private String orgId;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
}
