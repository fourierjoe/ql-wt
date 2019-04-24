package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/11 11:22
 * @Version: v1.0
 */
public class LoanBuyerModel extends Entity<String> {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "监管银行1ID，这里关联的是资方管理里面的具体支行ID", example = "监管银行1ID")
	private String supervisionBankOneId;

	@ApiModelProperty(value = "监管金额1", example = "100")
	private BigDecimal supervisionAmountOne;

	@ApiModelProperty(value = "监管银行联系人1", example = "监管银行联系人1")
	private String supervisionContactOne;

	@ApiModelProperty(value = "监管银行联系人电话1", example = "监管银行联系人电话1")
	private String supervisionContactTeleOne;

	@ApiModelProperty(value = "监管银行2ID", example = "监管银行2ID")
	private String supervisionBankTwoId;

	@ApiModelProperty(value = "监管银行2金额", example = "100")
	private BigDecimal supervisionAmountTwo;

	@ApiModelProperty(value = "监管银行2联系人", example = "监管银行2联系人")
	private String supervisionContactTwo;

	@ApiModelProperty(value = "监管银行2电话",example = "监管银行2电话")
	private String supervisionContactTeleTwo;

	@ApiModelProperty(value = "商贷银行ID，这里关联的是资方管理里面的具体支行ID")
	private String loanMbId;

	@ApiModelProperty(value = "商贷金额")
	private BigDecimal loanMbAmount;

	@ApiModelProperty(value = "商贷银行联系人")
	private String loanMbContactName;

	@ApiModelProperty(value = "商贷银行联系人电话")
	private String loanMbContactTele;

	@ApiModelProperty(value = "退尾款账户名" ,example = "退尾款账户名")
	private String refundAccountNam;

	@ApiModelProperty(value = "退尾款账号", example = "退尾款账号")
	private String refundAccountNum;

	@ApiModelProperty(value = "退尾款账户开户行", example = "退尾款账户开户行")
	private String refundAccountBank;

	@ApiModelProperty(value = "监管账户名", example = "监管账户名")
	private String supervisionAccountNam;

	@ApiModelProperty(value = "监管账号", example = "监管账号")
	private String supervisionAccountNum;

	@ApiModelProperty(value = "监管账户开户行", example = "监管账户开户行")
	private String supervisionAccountBank;

	@ApiModelProperty(value = "借款人", example = "借款人")
	private String loanerName;

	@ApiModelProperty(value = "贷款发放方式(非交易类现金赎楼)")
	private String loanPaymentType;

	@ApiModelProperty(value = "备注")
	private String buyerLoanRemark;

	public String getLoanPaymentType() {
		return loanPaymentType;
	}

	public void setLoanPaymentType(String loanPaymentType) {
		this.loanPaymentType = loanPaymentType;
	}

	public String getBuyerLoanRemark() {
		return buyerLoanRemark;
	}

	public void setBuyerLoanRemark(String buyerLoanRemark) {
		this.buyerLoanRemark = buyerLoanRemark;
	}

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getSupervisionBankOneId() {
		return supervisionBankOneId;
	}

	public void setSupervisionBankOneId(String supervisionBankOneId) {
		this.supervisionBankOneId = supervisionBankOneId;
	}

	public BigDecimal getSupervisionAmountOne() {
		return supervisionAmountOne;
	}

	public void setSupervisionAmountOne(BigDecimal supervisionAmountOne) {
		this.supervisionAmountOne = supervisionAmountOne;
	}

	public String getSupervisionContactOne() {
		return supervisionContactOne;
	}

	public void setSupervisionContactOne(String supervisionContactOne) {
		this.supervisionContactOne = supervisionContactOne;
	}

	public String getSupervisionContactTeleOne() {
		return supervisionContactTeleOne;
	}

	public void setSupervisionContactTeleOne(String supervisionContactTeleOne) {
		this.supervisionContactTeleOne = supervisionContactTeleOne;
	}

	public String getSupervisionBankTwoId() {
		return supervisionBankTwoId;
	}

	public void setSupervisionBankTwoId(String supervisionBankTwoId) {
		this.supervisionBankTwoId = supervisionBankTwoId;
	}

	public BigDecimal getSupervisionAmountTwo() {
		return supervisionAmountTwo;
	}

	public void setSupervisionAmountTwo(BigDecimal supervisionAmountTwo) {
		this.supervisionAmountTwo = supervisionAmountTwo;
	}

	public String getSupervisionContactTwo() {
		return supervisionContactTwo;
	}

	public void setSupervisionContactTwo(String supervisionContactTwo) {
		this.supervisionContactTwo = supervisionContactTwo;
	}

	public String getSupervisionContactTeleTwo() {
		return supervisionContactTeleTwo;
	}

	public void setSupervisionContactTeleTwo(String supervisionContactTeleTwo) {
		this.supervisionContactTeleTwo = supervisionContactTeleTwo;
	}

	public String getLoanMbId() {
		return loanMbId;
	}

	public void setLoanMbId(String loanMbId) {
		this.loanMbId = loanMbId;
	}

	public BigDecimal getLoanMbAmount() {
		return loanMbAmount;
	}

	public void setLoanMbAmount(BigDecimal loanMbAmount) {
		this.loanMbAmount = loanMbAmount;
	}

	public String getLoanMbContactName() {
		return loanMbContactName;
	}

	public void setLoanMbContactName(String loanMbContactName) {
		this.loanMbContactName = loanMbContactName;
	}

	public String getLoanMbContactTele() {
		return loanMbContactTele;
	}

	public void setLoanMbContactTele(String loanMbContactTele) {
		this.loanMbContactTele = loanMbContactTele;
	}

	public String getRefundAccountNam() {
		return refundAccountNam;
	}

	public void setRefundAccountNam(String refundAccountNam) {
		this.refundAccountNam = refundAccountNam;
	}

	public String getRefundAccountNum() {
		return refundAccountNum;
	}

	public void setRefundAccountNum(String refundAccountNum) {
		this.refundAccountNum = refundAccountNum;
	}

	public String getRefundAccountBank() {
		return refundAccountBank;
	}

	public void setRefundAccountBank(String refundAccountBank) {
		this.refundAccountBank = refundAccountBank;
	}

	public String getSupervisionAccountNam() {
		return supervisionAccountNam;
	}

	public void setSupervisionAccountNam(String supervisionAccountNam) {
		this.supervisionAccountNam = supervisionAccountNam;
	}

	public String getSupervisionAccountNum() {
		return supervisionAccountNum;
	}

	public void setSupervisionAccountNum(String supervisionAccountNum) {
		this.supervisionAccountNum = supervisionAccountNum;
	}

	public String getSupervisionAccountBank() {
		return supervisionAccountBank;
	}

	public void setSupervisionAccountBank(String supervisionAccountBank) {
		this.supervisionAccountBank = supervisionAccountBank;
	}

	public String getLoanerName() {
		return loanerName;
	}

	public void setLoanerName(String loanerName) {
		this.loanerName = loanerName;
	}
}
