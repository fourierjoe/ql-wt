package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

/**
 * @Description:
 * @Created by ql on 2019/1/21 16:17
 * @Version: v1.0
 */
public class LoanPaymentSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "贷款发放账户")
	private String loanPaymentAccountNam;

	@ApiModelProperty(value = "开户行")
	private String loanPaymentAccountBank;

	@ApiModelProperty(value = "贷款发放账号")
	private String loanPaymentAccountNum;

	@ApiModelProperty(value = "是否回款账户")
	private YNEnum isReceivePayment;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

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
