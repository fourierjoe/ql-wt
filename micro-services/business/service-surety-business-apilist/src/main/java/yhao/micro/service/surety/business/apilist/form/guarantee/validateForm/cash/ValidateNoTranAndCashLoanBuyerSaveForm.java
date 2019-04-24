package yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.cash;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

/**
 * @Description:
 * @Created by ql on 2019/1/21 15:40
 * @Version: v1.0
 */
public class ValidateNoTranAndCashLoanBuyerSaveForm implements ValidationForm {
	@ApiModelProperty(value = "借款人", example = "借款人")
	@NotBlank(message = "借款人不得为空")
	private String loanerName;

	@ApiModelProperty(value = "贷款发放方式", example = "贷款发放方式")
	@NotBlank(message = "贷款发放方式不得为空")
	private String loanPaymentType;

	public String getLoanerName() {
		return loanerName;
	}

	public void setLoanerName(String loanerName) {
		this.loanerName = loanerName;
	}

	public String getLoanPaymentType() {
		return loanPaymentType;
	}

	public void setLoanPaymentType(String loanPaymentType) {
		this.loanPaymentType = loanPaymentType;
	}
}
