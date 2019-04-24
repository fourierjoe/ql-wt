package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

/**
 * @Description:
 * @Created by ql on 2018/12/25 09:52
 * @Version: v1.0
 */
public class ItemByItemCodeQueryForm implements ValidationForm {
	@ApiModelProperty(value = "城市组织ID")
	@NotBlank(message = "城市组织ID不得为空")
	private String orgId;

	@ApiModelProperty(value = "事项编号")
	@NotBlank(message = "事项编号不得为空")
	private String itemCode;

	@ApiModelProperty(value = "事项结果")
	@NotBlank(message = "事项结果不得为空")
	private String itemResult;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemResult() {
		return itemResult;
	}

	public void setItemResult(String itemResult) {
		this.itemResult = itemResult;
	}
}
