package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.ReceipterTypeEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * @Description:
 * @Created by ql on 2019/3/2 15:52
 * @Version: v1.0
 */
public class TwiceRepayRedeemInnerPageModel extends Entity<String> {
	@ApiModelProperty(value = "第二次赎楼公司账户")
	private String twiceCompanyAccount;

	@ApiModelProperty("出账金额,单笔")
	private BigDecimal twiceBillingAmount = new BigDecimal(0);

	@ApiModelProperty("(单笔)还款合计")
	private BigDecimal perRedeem = new BigDecimal(0);

	@ApiModelProperty("(单笔)余款合计")
	private BigDecimal perBalance = new BigDecimal(0);

	@ApiModelProperty("单笔还款状态")
	private String perRedeemStateDesc;

	@ApiModelProperty("单笔余款状态")
	private String perBalanceRedeemStateDesc;

	@ApiModelProperty("确认时间")
	private Date balanceConfirmDate;

	@ApiModelProperty("确认人Id")
	private String balanceConfirmOperatorId;

	@ApiModelProperty("确认人姓名")
	private String balanceConfirmOperator;

	@ApiModelProperty("出账申请收款人类型")//用于判断余款是否确认
	private String receipterType;

	/*******************还款********************/
	@ApiModelProperty(value = "每笔还款状态", hidden = true)
	private String perRedeemState;

	@ApiModelProperty(value = "每笔余款状态", hidden = true)
	private String perBalanceRedeemState;

	@ApiModelProperty(value = "第二次客户补差额", hidden = true)
	private BigDecimal twiceCustomerReplenishment = new BigDecimal(0);

	@ApiModelProperty(value = "第二次实际还贷本金", hidden = true)
	private BigDecimal twiceRealRepaymentFund = new BigDecimal(0);

	@ApiModelProperty(value = "第二次利息", hidden = true)
	private BigDecimal twiceInterest = new BigDecimal(0);

	@ApiModelProperty(value = "第二次罚息", hidden = true)
	private BigDecimal twicePenaltyInterest = new BigDecimal(0);

	public BigDecimal getPerRedeem() {
		// 还款合计 = 实际还贷本金+利息+罚息
		BigDecimal perRedeem = new BigDecimal(0);
		perRedeem = perRedeem.add(getTwiceRealRepaymentFund()).add(getTwiceInterest()).add(getTwicePenaltyInterest());
		return perRedeem;
	}

	public void setPerRedeem(BigDecimal perRedeem) {
		this.perRedeem = perRedeem;
	}

	public BigDecimal getPerBalance() {
		// 还款余额 = 出账金额+客户补差额-还款合计
		BigDecimal redeemBalance = new BigDecimal(0);
		redeemBalance = redeemBalance.add(getTwiceBillingAmount()).add(getTwiceCustomerReplenishment()).subtract(getPerRedeem());
		return redeemBalance;
	}

	public void setPerBalance(BigDecimal perBalance) {
		this.perBalance = perBalance;
	}

	public BigDecimal getTwiceBillingAmount() {
		return twiceBillingAmount;
	}

	public void setTwiceBillingAmount(BigDecimal twiceBillingAmount) {
		this.twiceBillingAmount = twiceBillingAmount;
	}

	public BigDecimal getTwiceCustomerReplenishment() {
		return twiceCustomerReplenishment;
	}

	public void setTwiceCustomerReplenishment(BigDecimal twiceCustomerReplenishment) {
		this.twiceCustomerReplenishment = twiceCustomerReplenishment;
	}

	public BigDecimal getTwiceRealRepaymentFund() {
		return twiceRealRepaymentFund;
	}

	public void setTwiceRealRepaymentFund(BigDecimal twiceRealRepaymentFund) {
		this.twiceRealRepaymentFund = twiceRealRepaymentFund;
	}

	public BigDecimal getTwiceInterest() {
		return twiceInterest;
	}

	public void setTwiceInterest(BigDecimal twiceInterest) {
		this.twiceInterest = twiceInterest;
	}

	public BigDecimal getTwicePenaltyInterest() {
		return twicePenaltyInterest;
	}

	public void setTwicePenaltyInterest(BigDecimal twicePenaltyInterest) {
		this.twicePenaltyInterest = twicePenaltyInterest;
	}

	public String getPerRedeemStateDesc() {
		if (Optional.ofNullable(this.perRedeemState).orElse("").equals(CommonConstants.YES)) {
			return perRedeemStateDesc = "已还款";
		} else {
			return perRedeemStateDesc = "未还款";
		}
	}

	public void setPerRedeemStateDesc(String perRedeemStateDesc) {
		this.perRedeemStateDesc = perRedeemStateDesc;
	}

	public String getPerRedeemState() {
		return perRedeemState;
	}

	public void setPerRedeemState(String perRedeemState) {
		this.perRedeemState = perRedeemState;
	}

	public String getPerBalanceRedeemStateDesc() {
		if (Optional.ofNullable(this.perBalanceRedeemState).orElse("").equals(CommonConstants.YES)) {
			return perBalanceRedeemStateDesc = "已经确认余款";
		} else if (Optional.ofNullable(receipterType).orElse("").equals(ReceipterTypeEnum.SELLER.toString())
				|| (!Optional.ofNullable(receipterType).orElse("").equals(ReceipterTypeEnum.SELLER.toString()) && getPerRedeem().compareTo(new BigDecimal(0)) == 0)) { //业主 或者 非业主且余款为0 则无需确认余款
			return perBalanceRedeemStateDesc = "无需确认";
		} else {
			return perBalanceRedeemStateDesc = "未确认余款";
		}
	}

	public void setPerBalanceRedeemStateDesc(String perBalanceRedeemStateDesc) {
		this.perBalanceRedeemStateDesc = perBalanceRedeemStateDesc;
	}

	public String getPerBalanceRedeemState() {
		return perBalanceRedeemState;
	}

	public void setPerBalanceRedeemState(String perBalanceRedeemState) {
		this.perBalanceRedeemState = perBalanceRedeemState;
	}

	public String getTwiceCompanyAccount() {
		return twiceCompanyAccount;
	}

	public void setTwiceCompanyAccount(String twiceCompanyAccount) {
		this.twiceCompanyAccount = twiceCompanyAccount;
	}

	public Date getBalanceConfirmDate() {
		return balanceConfirmDate;
	}

	public void setBalanceConfirmDate(Date balanceConfirmDate) {
		this.balanceConfirmDate = balanceConfirmDate;
	}

	public String getBalanceConfirmOperator() {
		return balanceConfirmOperator;
	}

	public void setBalanceConfirmOperator(String balanceConfirmOperator) {
		this.balanceConfirmOperator = balanceConfirmOperator;
	}

	public String getBalanceConfirmOperatorId() {
		return balanceConfirmOperatorId;
	}

	public void setBalanceConfirmOperatorId(String balanceConfirmOperatorId) {
		this.balanceConfirmOperatorId = balanceConfirmOperatorId;
	}
}
