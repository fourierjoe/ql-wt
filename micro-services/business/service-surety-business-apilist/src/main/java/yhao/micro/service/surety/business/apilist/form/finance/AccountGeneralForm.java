package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/3/5 10:20
 * @Description:担保单财务台账
 */
public class AccountGeneralForm implements ValidationForm {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("出账日期")
    private Date billingDate;
    @ApiModelProperty("借款人")
    private String loanerName;
    @ApiModelProperty("借款时长")
    private String loanDays;
    @ApiModelProperty("出账金额")
    private BigDecimal billingTotalAmount;
    @ApiModelProperty("已回款金额")
    private BigDecimal repayTotalAmount;
    @ApiModelProperty("确认收费日期")
    private Date tollConfirmDate;
    @ApiModelProperty("确认回款日期")
    private Date repayConfirmDate;
    @ApiModelProperty("剩余借款")
    private BigDecimal loanBalanceAmount;
    @ApiModelProperty("产品类型")
    private String productType;
    @ApiModelProperty("资金平台")
    private String fundName;
    @ApiModelProperty("实际用款天数")
    private Integer useDays;
    @ApiModelProperty("应收担保费")
    private BigDecimal chargeTotal;
    @ApiModelProperty("手续费")
    private BigDecimal charges;
    @ApiModelProperty("展期天数")
    private String delayDays;
    @ApiModelProperty("展期费用")
    private BigDecimal delayAmount;
    @ApiModelProperty("逾期费用")
    private BigDecimal overdueAmount;
    @ApiModelProperty("可退费用")
    private BigDecimal refundTotalAmount;
    @ApiModelProperty(value = "担保费累计收取金额",hidden = true)
    private BigDecimal warrantyTotalAmount;
    @ApiModelProperty(value = "展期费累计收取金额",hidden = true)
    private BigDecimal delayTotalAmount;
    @ApiModelProperty(value = "逾期费累计收取金额",hidden = true)
    private BigDecimal overdueTotalAmount;



    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getLoanerName() {
        return loanerName;
    }

    public void setLoanerName(String loanerName) {
        this.loanerName = loanerName;
    }

    public String getLoanDays() {
        return loanDays;
    }

    public void setLoanDays(String loanDays) {
        this.loanDays = loanDays;
    }

    public BigDecimal getBillingTotalAmount() {
        return billingTotalAmount;
    }

    public void setBillingTotalAmount(BigDecimal billingTotalAmount) {
        this.billingTotalAmount = billingTotalAmount;
    }

    public BigDecimal getRepayTotalAmount() {
        return repayTotalAmount;
    }

    public void setRepayTotalAmount(BigDecimal repayTotalAmount) {
        this.repayTotalAmount = repayTotalAmount;
    }

    public Date getTollConfirmDate() {
        return tollConfirmDate;
    }

    public void setTollConfirmDate(Date tollConfirmDate) {
        this.tollConfirmDate = tollConfirmDate;
    }

    public Date getRepayConfirmDate() {
        return repayConfirmDate;
    }

    public void setRepayConfirmDate(Date repayConfirmDate) {
        this.repayConfirmDate = repayConfirmDate;
    }

    public BigDecimal getLoanBalanceAmount() {
        return loanBalanceAmount;
    }

    public void setLoanBalanceAmount(BigDecimal loanBalanceAmount) {
        this.loanBalanceAmount = loanBalanceAmount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Integer getUseDays() {
        return useDays;
    }

    public void setUseDays(Integer useDays) {
        this.useDays = useDays;
    }

    public BigDecimal getChargeTotal() {
        return chargeTotal;
    }

    public void setChargeTotal(BigDecimal chargeTotal) {
        this.chargeTotal = chargeTotal;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public String getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(String delayDays) {
        this.delayDays = delayDays;
    }

    public BigDecimal getDelayTotalAmount() {
        return delayTotalAmount;
    }

    public void setDelayTotalAmount(BigDecimal delayTotalAmount) {
        this.delayTotalAmount = delayTotalAmount;
    }

    public BigDecimal getOverdueTotalAmount() {
        return overdueTotalAmount;
    }

    public void setOverdueTotalAmount(BigDecimal overdueTotalAmount) {
        this.overdueTotalAmount = overdueTotalAmount;
    }

    public BigDecimal getRefundTotalAmount() {
        return refundTotalAmount;
    }

    public void setRefundTotalAmount(BigDecimal refundTotalAmount) {
        this.refundTotalAmount = refundTotalAmount;
    }


    public BigDecimal getDelayAmount() {
        return delayAmount;
    }

    public void setDelayAmount(BigDecimal delayAmount) {
        this.delayAmount = delayAmount;
    }

    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public BigDecimal getWarrantyTotalAmount() {
        return warrantyTotalAmount;
    }

    public void setWarrantyTotalAmount(BigDecimal warrantyTotalAmount) {
        this.warrantyTotalAmount = warrantyTotalAmount;
    }
}
