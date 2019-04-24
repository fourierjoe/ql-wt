package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 16:31
 * @Description:
 */
public class RedemptionDetailForm implements ValidationForm {
    @ApiModelProperty("单据编号")
    private String guaranteePid;
    @ApiModelProperty("房产名称")
    private String estateName;
    @ApiModelProperty("客户经理姓名")
    private String managerName;
    @ApiModelProperty("部门")
    private String orgName;
    @ApiModelProperty(value = "赎楼日期")
    private Date redeemDate;
    @ApiModelProperty("赎楼员")
    private String redemOperatorName;
    @ApiModelProperty(value = "客户补差额")
    private BigDecimal personBalance;
    @ApiModelProperty(value = "实际还贷本金")
    private BigDecimal realPayBackAmount;
    @ApiModelProperty(value = "利息")
    private BigDecimal interest;
    @ApiModelProperty(value = "罚息")
    private BigDecimal penaltyInterest;
    @ApiModelProperty("出账金额")
    private BigDecimal bilingAmount;
    @ApiModelProperty("出账日期")
    private Date billingDate;
    @ApiModelProperty("赎楼总计")
    private BigDecimal redeemTotalAmount;
    @ApiModelProperty("赎楼余额")
    private BigDecimal redeemBalanceAmount;
    @ApiModelProperty(value = "公司账户")
    private String companyAccount;
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

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public String getRedemOperatorName() {
        return redemOperatorName;
    }

    public void setRedemOperatorName(String redemOperatorName) {
        this.redemOperatorName = redemOperatorName;
    }

    public BigDecimal getPersonBalance() {
        return personBalance;
    }

    public void setPersonBalance(BigDecimal personBalance) {
        this.personBalance = personBalance;
    }

    public BigDecimal getRealPayBackAmount() {
        return realPayBackAmount;
    }

    public void setRealPayBackAmount(BigDecimal realPayBackAmount) {
        this.realPayBackAmount = realPayBackAmount;
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

    public BigDecimal getBilingAmount() {
        return bilingAmount;
    }

    public void setBilingAmount(BigDecimal bilingAmount) {
        this.bilingAmount = bilingAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public BigDecimal getRedeemTotalAmount() {
        return redeemTotalAmount;
    }

    public void setRedeemTotalAmount(BigDecimal redeemTotalAmount) {
        this.redeemTotalAmount = redeemTotalAmount;
    }

    public BigDecimal getRedeemBalanceAmount() {
        return redeemBalanceAmount;
    }

    public void setRedeemBalanceAmount(BigDecimal redeemBalanceAmount) {
        this.redeemBalanceAmount = redeemBalanceAmount;
    }

    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
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
