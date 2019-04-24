package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.ReceivePaymentSourceEnum;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/2 19:53
 * @Version: v1.0
 */
public class TransactionTypeReceivePaymentPlanSaveForm extends IdUnForm {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "借款明细ID")
	private String loanDetailId;

	@ApiModelProperty(value = "回款来源",example = "SUPERVISION")
	private ReceivePaymentSourceEnum receivePaymentSource;

	@ApiModelProperty(value = "回款预计金额",example = "50.0")
	private BigDecimal receivePaymentExpectAmount;

	@ApiModelProperty(value = "回款客户账户名",example = "回款客户账户名")
	private String receivePaymentAccount;

	@ApiModelProperty(value = "回款客户账号",example = "回款客户账号")
	private String receivePaymentAccountNum;

	@ApiModelProperty(value = "回款客户开户行",example = "回款客户开户行")
	private String receivePaymentBank;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getLoanDetailId() {
		return loanDetailId;
	}

	public void setLoanDetailId(String loanDetailId) {
		this.loanDetailId = loanDetailId;
	}

	public ReceivePaymentSourceEnum getReceivePaymentSource() {
		return receivePaymentSource;
	}

	public void setReceivePaymentSource(ReceivePaymentSourceEnum receivePaymentSource) {
		this.receivePaymentSource = receivePaymentSource;
	}

	public BigDecimal getReceivePaymentExpectAmount() {
		return receivePaymentExpectAmount;
	}

	public void setReceivePaymentExpectAmount(BigDecimal receivePaymentExpectAmount) {
		this.receivePaymentExpectAmount = receivePaymentExpectAmount;
	}

	public String getReceivePaymentAccount() {
		return receivePaymentAccount;
	}

	public void setReceivePaymentAccount(String receivePaymentAccount) {
		this.receivePaymentAccount = receivePaymentAccount;
	}

	public String getReceivePaymentAccountNum() {
		return receivePaymentAccountNum;
	}

	public void setReceivePaymentAccountNum(String receivePaymentAccountNum) {
		this.receivePaymentAccountNum = receivePaymentAccountNum;
	}

	public String getReceivePaymentBank() {
		return receivePaymentBank;
	}

	public void setReceivePaymentBank(String receivePaymentBank) {
		this.receivePaymentBank = receivePaymentBank;
	}

}
