package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/11 11:30
 * @Version: v1.0
 */
public class LoanDetailsModel extends Entity<String> {
	@ApiModelProperty(value = "担保单ID", hidden = true)
	private String guaranteeId;

	@ApiModelProperty(value = "借款金额",example = "100.0")
	private BigDecimal loanAmount;

	@ApiModelProperty(value = "借款天数",example = "10")
	private Integer loanDays;

	@ApiModelProperty(value = "剩余借款",example = "50.0")
	private BigDecimal loanRemain;

	@ApiModelProperty(value = "应还款日期",example = "2019-03-03")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date arrangedRepay;

	@ApiModelProperty(value = "应收费率",example = "6.0")
	private BigDecimal marketFeeRate;

	@ApiModelProperty(value = "应收担保费",example = "20.0")
	private BigDecimal chargeGuaranteeFee;

	@ApiModelProperty(value = "实收费率",example = "3.0")
	private BigDecimal realFeeRate;

	@ApiModelProperty(value = "实收担保费",example = "90.0")
	private BigDecimal chargeRealGuaranteeFee;

	@ApiModelProperty(value = "返佣",example = "8.0")
	private BigDecimal rebate;

	@ApiModelProperty(value = "返佣账户",example = "返佣账户")
	private String rebateName;

	@ApiModelProperty(value = "返佣开户行",example = "返佣开户行")
	private String rebateBankName;
	@ApiModelProperty(value = "回款累计金额",example = "20.00")
	private BigDecimal repayTotalAmount;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getLoanDays() {
		return loanDays;
	}

	public void setLoanDays(Integer loanDays) {
		this.loanDays = loanDays;
	}

	public BigDecimal getLoanRemain() {
		return loanRemain;
	}

	public void setLoanRemain(BigDecimal loanRemain) {
		this.loanRemain = loanRemain;
	}

	public Date getArrangedRepay() {
		return arrangedRepay;
	}

	public void setArrangedRepay(Date arrangedRepay) {
		this.arrangedRepay = arrangedRepay;
	}

	public BigDecimal getMarketFeeRate() {
		return marketFeeRate;
	}

	public void setMarketFeeRate(BigDecimal marketFeeRate) {
		this.marketFeeRate = marketFeeRate;
	}

	public BigDecimal getChargeGuaranteeFee() {
		return chargeGuaranteeFee;
	}

	public void setChargeGuaranteeFee(BigDecimal chargeGuaranteeFee) {
		this.chargeGuaranteeFee = chargeGuaranteeFee;
	}

	public BigDecimal getRealFeeRate() {
		return realFeeRate;
	}

	public void setRealFeeRate(BigDecimal realFeeRate) {
		this.realFeeRate = realFeeRate;
	}

	public BigDecimal getChargeRealGuaranteeFee() {
		return chargeRealGuaranteeFee;
	}

	public void setChargeRealGuaranteeFee(BigDecimal chargeRealGuaranteeFee) {
		this.chargeRealGuaranteeFee = chargeRealGuaranteeFee;
	}

	public BigDecimal getRebate() {
		return rebate;
	}

	public void setRebate(BigDecimal rebate) {
		this.rebate = rebate;
	}

	public String getRebateName() {
		return rebateName;
	}

	public void setRebateName(String rebateName) {
		this.rebateName = rebateName;
	}

	public String getRebateBankName() {
		return rebateBankName;
	}

	public void setRebateBankName(String rebateBankName) {
		this.rebateBankName = rebateBankName;
	}

	public BigDecimal getRepayTotalAmount() {
		return repayTotalAmount;
	}

	public void setRepayTotalAmount(BigDecimal repayTotalAmount) {
		this.repayTotalAmount = repayTotalAmount;
	}
}
