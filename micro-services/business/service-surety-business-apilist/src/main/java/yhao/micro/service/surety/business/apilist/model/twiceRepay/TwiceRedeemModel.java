package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/2/20 16:00
 * @Version: v1.0
 */
public class TwiceRedeemModel extends Entity<String> {

	@ApiModelProperty(value = "担保单编号")
	private String guaranteeNum;

	@ApiModelProperty(value = "房产名称")
	private String estateName;

	@ApiModelProperty("客户经理姓名")
	private String managerName;

	@ApiModelProperty("客户经理组织名称")
	private String orgName;

	@ApiModelProperty("赎楼人员")
	private String redeemName;

	@ApiModelProperty(value = "第二次赎楼日期")
	private Date twiceRedeemDate;

	@ApiModelProperty(value = "第二次客户补差额")
	private BigDecimal twiceCustomerReplenishment = new BigDecimal(0);

	@ApiModelProperty(value = "第二次实际还贷本金")
	private BigDecimal twiceRealRepaymentFund = new BigDecimal(0);

	@ApiModelProperty(value = "第二次利息")
	private BigDecimal twiceInterest = new BigDecimal(0);

	@ApiModelProperty(value = "第二次罚息")
	private BigDecimal twicePenaltyInterest = new BigDecimal(0);

	@ApiModelProperty(value = "出账金额")
	private BigDecimal twiceBillingAmount = new BigDecimal(0);

	@ApiModelProperty(value = "出账日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date twiceBillingDate;

	@ApiModelProperty(value = "还款合计")
	private BigDecimal totalRedeem = new BigDecimal(0);

	@ApiModelProperty(value = "还款余额")
	private BigDecimal redeemBalance = new BigDecimal(0);

	@ApiModelProperty(value = "还款凭证")
	private String certificate;

	@ApiModelProperty(value = "第二次赎楼公司账户")
	private String twiceCompanyAccount;

	@ApiModelProperty(value = "第二次退还日期")
	private Date twiceRebackDate;

	@ApiModelProperty(value = "第二次赎楼备注")
	private String twiceRemark;

	public BigDecimal getRedeemBalance() {
		return redeemBalance;
	}

	public void setRedeemBalance(BigDecimal redeemBalance) {
		this.redeemBalance = redeemBalance;
	}

	public String getGuaranteeNum() {
		return guaranteeNum;
	}

	public void setGuaranteeNum(String guaranteeNum) {
		this.guaranteeNum = guaranteeNum;
	}

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRedeemName() {
		return redeemName;
	}

	public void setRedeemName(String redeemName) {
		this.redeemName = redeemName;
	}

	public Date getTwiceRedeemDate() {
		return twiceRedeemDate;
	}

	public void setTwiceRedeemDate(Date twiceRedeemDate) {
		this.twiceRedeemDate = twiceRedeemDate;
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

	public BigDecimal getTotalRedeem() {
		return totalRedeem;
	}

	public void setTotalRedeem(BigDecimal totalRedeem) {
		this.totalRedeem = totalRedeem;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getTwiceCompanyAccount() {
		return twiceCompanyAccount;
	}

	public void setTwiceCompanyAccount(String twiceCompanyAccount) {
		this.twiceCompanyAccount = twiceCompanyAccount;
	}

	public Date getTwiceRebackDate() {
		return twiceRebackDate;
	}

	public void setTwiceRebackDate(Date twiceRebackDate) {
		this.twiceRebackDate = twiceRebackDate;
	}

	public String getTwiceRemark() {
		return twiceRemark;
	}

	public void setTwiceRemark(String twiceRemark) {
		this.twiceRemark = twiceRemark;
	}
}
