package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2019/3/6 15:16
 * @Version: v1.0
 */
public class LoanPaymentModel extends Entity<String> {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "贷款发放账户")
	private String loanPaymentAccountNam;

	@ApiModelProperty(value = "开户行")
	private String loanPaymentAccountBank;

	@ApiModelProperty(value = "贷款发放账号")
	private String loanPaymentAccountNum;

	@ApiModelProperty(value = "是否回款账户")
	private String isReceivePayment;

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

	public String getIsReceivePayment() {
		return isReceivePayment;
	}

	public void setIsReceivePayment(String isReceivePayment) {
		this.isReceivePayment = isReceivePayment;
	}
}
