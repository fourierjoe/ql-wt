package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;

/**
 * @Description:
 * @Created by ql on 2019/2/21 16:54
 * @Version: v1.0
 */
public class GuaranteeIdForm extends IdForm {
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
