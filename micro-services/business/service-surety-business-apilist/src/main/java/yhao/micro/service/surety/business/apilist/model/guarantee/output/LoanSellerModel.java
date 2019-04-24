package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.GuaranteePayTypeEnum;

import java.math.BigDecimal;

/**
 * @Description:
 * @Created by ql on 2019/1/11 11:20
 * @Version: v1.0
 */
public class LoanSellerModel extends Entity<String> {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "原贷款类型:按揭贷款，组合贷款，公积金贷款", example = "MORTGAGE_LOAN")
	private GuaranteePayTypeEnum loanType;

	@ApiModelProperty(value = "原贷款金额", example = "13000000")
	private BigDecimal loanAmount;

	@ApiModelProperty(value = "原贷款余额", example = "3000")
	private BigDecimal loanBalance;

	@ApiModelProperty(value = "原商贷银行ID，这里关联的是资方管理里面的具体支行ID")
	private String loanMbId;

	@ApiModelProperty(value = "商贷金额", example = "100000")
	private BigDecimal loanMbAmount;

	@ApiModelProperty(value = "银行联系人", example = "银行联系人")
	private String loanMbContactName;

	@ApiModelProperty(value = "商贷银行联系电话", example = "131")
	private String loanMbContactTele;

	@ApiModelProperty(value = "公贷银行ID，这里关联的是资方管理里面的具体支行ID")
	private String loanPbId;

	@ApiModelProperty(value = "公贷金额")
	private BigDecimal loanPbAmount;

	@ApiModelProperty(value = "公贷银行联系人")
	private String loanPbContactName;

	@ApiModelProperty(value = "公贷银行联系电话")
	private String loanPbContactTele;

	@ApiModelProperty(value = "主借款人", example = "主借款人")
	private String loanMajorPerson;

	@ApiModelProperty(value = "共借人", example = "共借人")
	private String loanOtherPerson;

	@ApiModelProperty(value = "备注", example = "备注")
	private String loanRemark;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public GuaranteePayTypeEnum getLoanType() {
		return loanType;
	}

	public void setLoanType(GuaranteePayTypeEnum loanType) {
		this.loanType = loanType;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(BigDecimal loanBalance) {
		this.loanBalance = loanBalance;
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

	public String getLoanPbId() {
		return loanPbId;
	}

	public void setLoanPbId(String loanPbId) {
		this.loanPbId = loanPbId;
	}

	public BigDecimal getLoanPbAmount() {
		return loanPbAmount;
	}

	public void setLoanPbAmount(BigDecimal loanPbAmount) {
		this.loanPbAmount = loanPbAmount;
	}

	public String getLoanPbContactName() {
		return loanPbContactName;
	}

	public void setLoanPbContactName(String loanPbContactName) {
		this.loanPbContactName = loanPbContactName;
	}

	public String getLoanPbContactTele() {
		return loanPbContactTele;
	}

	public void setLoanPbContactTele(String loanPbContactTele) {
		this.loanPbContactTele = loanPbContactTele;
	}

	public String getLoanMajorPerson() {
		return loanMajorPerson;
	}

	public void setLoanMajorPerson(String loanMajorPerson) {
		this.loanMajorPerson = loanMajorPerson;
	}

	public String getLoanOtherPerson() {
		return loanOtherPerson;
	}

	public void setLoanOtherPerson(String loanOtherPerson) {
		this.loanOtherPerson = loanOtherPerson;
	}

	public String getLoanRemark() {
		return loanRemark;
	}

	public void setLoanRemark(String loanRemark) {
		this.loanRemark = loanRemark;
	}
}
