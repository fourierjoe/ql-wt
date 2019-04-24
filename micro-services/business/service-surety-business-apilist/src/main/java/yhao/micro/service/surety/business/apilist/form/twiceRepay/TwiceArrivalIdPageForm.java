package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Description:
 * @Created by ql on 2019/3/1 14:40
 * @Version: v1.0
 */
public class TwiceArrivalIdPageForm extends PageForm {
	@ApiModelProperty(value = "担保单id")
	@NotBlank(message = "担保单id不能为空")
	private  String  guaranteeId;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}
}
