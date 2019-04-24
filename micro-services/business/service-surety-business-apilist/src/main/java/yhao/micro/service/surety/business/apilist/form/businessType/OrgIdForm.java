package yhao.micro.service.surety.business.apilist.form.businessType;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.common.CommonStatusEnum;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2018/12/20 10:21
 * @Version: v1.0
 */
public class OrgIdForm implements ValidationForm {
	@ApiModelProperty(value = "城市组织ID")
	@NotBlank(message = "城市组织ID不得为空")
	private String orgId;

	@ApiModelProperty(value = "状态")
	@NotNull(message = "状态不得为空")
	private CommonStatusEnum state;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public CommonStatusEnum getState() {
		return state;
	}

	public void setState(CommonStatusEnum state) {
		this.state = state;
	}
}
