package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/2/25 14:05
 * @Version: v1.0
 */
public class TwiceBillingModel extends Entity<String> {
	@ApiModelProperty(value = "担保单id")
	private String guaranteeId;

	@ApiModelProperty(value = "总到账")
	private BigDecimal totalArrivalAmount;

	@ApiModelProperty(value = "总出账")
	private BigDecimal totalBillingAmount;

	@ApiModelProperty(value = "剩余可出账")
	private BigDecimal surplusBillingAmount;

	@ApiModelProperty(value = "申请金额")
	private BigDecimal applicationAmount;

	@ApiModelProperty(value = "已出账金额")
	private BigDecimal billedAmount;

	@ApiModelProperty(value = "还款日期")//还款表创建时间
	private Date redeemDate;

	@ApiModelProperty(value = "申请人")//申请表创建人
	private String applyName;


	/****************************表中字段*************************************/
	@ApiModelProperty(value = "公司账户")
	private String twiceBillingAccountId;

	@ApiModelProperty(value = "出账类型")
	private String twiceBillingType;

	@ApiModelProperty(value = "出账类型描述")
	private String twiceBillingTypeDesc;

	@ApiModelProperty(value = "出账金额")
	private BigDecimal twiceBillingAmount;

	@ApiModelProperty(value = "出账日期")
	private Date twiceBillingDate;

	@ApiModelProperty(value = "收款账户名")
	private String billingAccount;

	@ApiModelProperty(value = "收款卡号")
	private String cardNumber;

	@ApiModelProperty(value = "开户行")
	private String bank;

	@ApiModelProperty(value = "赎楼员姓名")
	private String loanName;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public String getTwiceBillingType() {
		return twiceBillingType;
	}

	public BigDecimal getTotalArrivalAmount() {
		return totalArrivalAmount;
	}

	public void setTotalArrivalAmount(BigDecimal totalArrivalAmount) {
		this.totalArrivalAmount = totalArrivalAmount;
	}

	public BigDecimal getTotalBillingAmount() {
		return totalBillingAmount;
	}

	public void setTotalBillingAmount(BigDecimal totalBillingAmount) {
		this.totalBillingAmount = totalBillingAmount;
	}

	public BigDecimal getSurplusBillingAmount() {
		return surplusBillingAmount;
	}

	public void setSurplusBillingAmount(BigDecimal surplusBillingAmount) {
		this.surplusBillingAmount = surplusBillingAmount;
	}

	public BigDecimal getApplicationAmount() {
		return applicationAmount;
	}

	public void setApplicationAmount(BigDecimal applicationAmount) {
		this.applicationAmount = applicationAmount;
	}

	public BigDecimal getBilledAmount() {
		return billedAmount;
	}

	public void setBilledAmount(BigDecimal billedAmount) {
		this.billedAmount = billedAmount;
	}

	public String getBillingAccount() {
		return billingAccount;
	}

	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public String getTwiceBillingAccountId() {
		return twiceBillingAccountId;
	}

	public void setTwiceBillingAccountId(String twiceBillingAccountId) {
		this.twiceBillingAccountId = twiceBillingAccountId;
	}

	public BigDecimal getTwiceBillingAmount() {
		return twiceBillingAmount;
	}

	public void setTwiceBillingAmount(BigDecimal twiceBillingAmount) {
		this.twiceBillingAmount = twiceBillingAmount;
	}

	public Date getTwiceBillingDate() {
		return twiceBillingDate;
	}

	public void setTwiceBillingDate(Date twiceBillingDate) {
		this.twiceBillingDate = twiceBillingDate;
	}

	public void setTwiceBillingType(String twiceBillingType) {
		this.twiceBillingType = twiceBillingType;
	}

	public String getTwiceBillingTypeDesc() {
		return twiceBillingTypeDesc;
	}

	public void setTwiceBillingTypeDesc(String twiceBillingTypeDesc) {
		this.twiceBillingTypeDesc = twiceBillingTypeDesc;
	}

	public Date getRedeemDate() {
		return redeemDate;
	}

	public void setRedeemDate(Date redeemDate) {
		this.redeemDate = redeemDate;
	}

	public String getApplyName() {
		return applyName;
	}

	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
}
