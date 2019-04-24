package yhao.micro.service.surety.business.apilist.model.redemption;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/3 18:11
 * @Description:
 */
public class RedeemModel extends Entity<String> {
    @ApiModelProperty(value = "出账id")
    private String financeBillingId;
    @ApiModelProperty(value = "担保单id")
    private String guaranteePid;
    @ApiModelProperty(value = "出账金额")
    private BigDecimal billingAmount;
   @ApiModelProperty("实际还贷本金")
    private BigDecimal realRepaymentFund;
    @ApiModelProperty("赎楼合计")
    private BigDecimal redeemTotalAmount;
    @ApiModelProperty("赎楼余额")
    private BigDecimal redeemBalance;
    @ApiModelProperty("赎楼人id")
    private String redeemOperatorId;
    @ApiModelProperty(value = "赎楼日期")
    private Date redeemDate;
    @ApiModelProperty(value = "客户补差额")
    private BigDecimal personReplenishment;
    @ApiModelProperty(value = "实际还贷本金")
    private BigDecimal realRepayAmount;
    @ApiModelProperty(value = "利息")
    private BigDecimal interest;
    @ApiModelProperty(value = "罚息")
    private BigDecimal penaltyInterest;
    @ApiModelProperty(value = "公司账户")
    @NotBlank(message = "公司账户不得为空")
    private String companyAccountId;
    @ApiModelProperty(value = "退还日期")
    private Date rebackDate;
    @ApiModelProperty(value = "备注")
    private String remark;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public String getFinanceBillingId() {
        return financeBillingId;
    }

    public void setFinanceBillingId(String financeBillingId) {
        this.financeBillingId = financeBillingId;
    }

    public BigDecimal getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(BigDecimal billingAmount) {
        this.billingAmount = billingAmount;
    }



    public BigDecimal getRealRepaymentFund() {
        return realRepaymentFund;
    }

    public void setRealRepaymentFund(BigDecimal realRepaymentFund) {
        this.realRepaymentFund = realRepaymentFund;
    }

    public BigDecimal getRedeemTotalAmount() {
        return redeemTotalAmount;
    }

    public void setRedeemTotalAmount(BigDecimal redeemTotalAmount) {
        this.redeemTotalAmount = redeemTotalAmount;
    }

    public BigDecimal getRedeemBalance() {
        return redeemBalance;
    }

    public void setRedeemBalance(BigDecimal redeemBalance) {
        this.redeemBalance = redeemBalance;
    }

    public String getRedeemOperatorId() {
        return redeemOperatorId;
    }

    public void setRedeemOperatorId(String redeemOperatorId) {
        this.redeemOperatorId = redeemOperatorId;
    }

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public BigDecimal getPersonReplenishment() {
        return personReplenishment;
    }

    public void setPersonReplenishment(BigDecimal personReplenishment) {
        this.personReplenishment = personReplenishment;
    }

    public String getCompanyAccountId() {
        return companyAccountId;
    }

    public void setCompanyAccountId(String companyAccountId) {
        this.companyAccountId = companyAccountId;
    }

    public BigDecimal getRealRepayAmount() {
        return realRepayAmount;
    }

    public void setRealRepayAmount(BigDecimal realRepayAmount) {
        this.realRepayAmount = realRepayAmount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getPenaltyInterest() {
        return penaltyInterest;
    }

    public void setPenaltyInterest(BigDecimal penaltyInterest) {
        this.penaltyInterest = penaltyInterest;
    }


    public Date getRebackDate() {
        return rebackDate;
    }

    public void setRebackDate(Date rebackDate) {
        this.rebackDate = rebackDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
