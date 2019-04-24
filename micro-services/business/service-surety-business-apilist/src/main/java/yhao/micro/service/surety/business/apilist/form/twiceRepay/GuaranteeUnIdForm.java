package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Description:
 * @Created by ql on 2019/3/1 16:34
 * @Version: v1.0
 */
public class GuaranteeUnIdForm {
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
