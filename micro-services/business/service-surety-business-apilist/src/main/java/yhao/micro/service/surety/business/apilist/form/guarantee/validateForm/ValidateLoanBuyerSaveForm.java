package yhao.micro.service.surety.business.apilist.form.guarantee.validateForm;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

/**
 * @Description:
 * @Created by ql on 2019/1/21 10:23
 * @Version: v1.0
 */
public class ValidateLoanBuyerSaveForm implements ValidationForm {
	@ApiModelProperty(value = "借款人", example = "借款人")
	@NotBlank(message = "借款人不得为空")
	private String loanerName;

	public String getLoanerName() {
		return loanerName;
	}

	public void setLoanerName(String loanerName) {
		this.loanerName = loanerName;
	}
}
