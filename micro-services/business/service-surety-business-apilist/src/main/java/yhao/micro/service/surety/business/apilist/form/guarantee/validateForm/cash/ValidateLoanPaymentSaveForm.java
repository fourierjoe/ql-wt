package yhao.micro.service.surety.business.apilist.form.guarantee.validateForm.cash;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.enums.YNEnum;

/**
 * @Description:
 * @Created by ql on 2019/1/21 16:21
 * @Version: v1.0
 */
public class ValidateLoanPaymentSaveForm implements ValidationForm {
	@ApiModelProperty(value = "贷款发放账户")
	@NotBlank(message = "贷款发放账户不得为空")
	private String loanPaymentAccountNam;

	@ApiModelProperty(value = "开户行")
	@NotBlank(message = "开户行不得为空")
	private String loanPaymentAccountBank;

	@ApiModelProperty(value = "贷款发放账号")
	@NotBlank(message = "贷款发放账号不得为空")
	private String loanPaymentAccountNum;

	@ApiModelProperty(value = "是否回款账户")
	@NotBlank(message = "是否回款账户不得为空")
	private YNEnum isReceivePayment;

	public String getLoanPaymentAccountNam() {
		return loanPaymentAccountNam;
	}

	public void setLoanPaymentAccountNam(String loanPaymentAccountNam) {
		this.loanPaymentAccountNam = loanPaymentAccountNam;
	}

	public String getLoanPaymentAccountBank() {
		return loanPaymentAccountBank;
	}

	public void setLoanPaymentAccountBank(String loanPaymentAccountBank) {
		this.loanPaymentAccountBank = loanPaymentAccountBank;
	}

	public String getLoanPaymentAccountNum() {
		return loanPaymentAccountNum;
	}

	public void setLoanPaymentAccountNum(String loanPaymentAccountNum) {
		this.loanPaymentAccountNum = loanPaymentAccountNum;
	}

	public YNEnum getIsReceivePayment() {
		return isReceivePayment;
	}

	public void setIsReceivePayment(YNEnum isReceivePayment) {
		this.isReceivePayment = isReceivePayment;
	}
}
