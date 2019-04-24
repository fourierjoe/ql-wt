package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Description:
 * @Created by ql on 2019/2/25 10:36
 * @Version: v1.0
 */
public class GuaranteeIdPageForm extends PageForm {
	@ApiModelProperty(value = "担保单Id")
	@NotBlank(message = "担保单Id不能为空")
	private String guaranteeId;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}
}
