package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeStatusEnum;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/14 15:06
 * @Description:
 */
public class FinanceTollQueryResultForm extends GuaranteePageModel {
    @ApiModelProperty(value = "收费状态")
    private ChargeStatusEnum chargeStatus;
    @ApiModelProperty(value = "返佣金额")
    private BigDecimal rebate;
    @ApiModelProperty(value = "手续费")
    private BigDecimal charges;
    @ApiModelProperty(value = "应收合计")
    private BigDecimal planTotalCharges;
    @ApiModelProperty(value = "实收合计")
    private BigDecimal realTotalCharges;
    @ApiModelProperty(value = "展期天数/逾期交费天数")
    private Integer delayDays;
    @ApiModelProperty(value = "展期费率")
    private BigDecimal delayRate;
    @ApiModelProperty(value = "每日费率")
    private BigDecimal dayRate;
    @ApiModelProperty(value = "应收展期费/逾期费")
    private BigDecimal delayCharge;
    @ApiModelProperty(value = "展期费剩余应交")
    private BigDecimal delayBalance;
    @ApiModelProperty(value = "展后到期日")
    private Date delayEndDate;
    @ApiModelProperty(value = "展期费状态")
    private ChargeStatusEnum delayStatus;
    @ApiModelProperty(value = "展期逾期天数")
    private Integer delayOverDueDays;
    @ApiModelProperty(value = "转展申请")
    private YNEnum isToDelay;
    @ApiModelProperty("借款id")
    private String loanId;
    @ApiModelProperty("提交日期")
    private Date submitDate;
    @ApiModelProperty("展期费类型 1：现金 2：额度")
    private String delayType;
    @ApiModelProperty("回款状态 YES是 NO否 已回款")
    private YNEnum repayStatus;
    @ApiModelProperty("累计收费")
    private BigDecimal tollTatalAmount;
    @ApiModelProperty("实际应收费用")
    private BigDecimal realNomalAmount;
    @ApiModelProperty(value = "剩余应收")
    private BigDecimal balanceAmount;
    @ApiModelProperty(value = "担保费(应收合计)")
    private BigDecimal warranty;
    @ApiModelProperty("是否交齐费用 YES 是 NO 否")
    private YNEnum isPayOff;





    public ChargeStatusEnum getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(ChargeStatusEnum chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public BigDecimal getPlanTotalCharges() {
        return planTotalCharges;
    }

    public void setPlanTotalCharges(BigDecimal planTotalCharges) {
        this.planTotalCharges = planTotalCharges;
    }

    public BigDecimal getRealTotalCharges() {
        return realTotalCharges;
    }

    public void setRealTotalCharges(BigDecimal realTotalCharges) {
        this.realTotalCharges = realTotalCharges;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public BigDecimal getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(BigDecimal delayRate) {
        this.delayRate = delayRate;
    }

    public BigDecimal getDelayCharge() {
        return delayCharge;
    }

    public void setDelayCharge(BigDecimal delayCharge) {
        this.delayCharge = delayCharge;
    }

    public Date getDelayEndDate() {
        return delayEndDate;
    }

    public void setDelayEndDate(Date delayEndDate) {
        this.delayEndDate = delayEndDate;
    }

    public ChargeStatusEnum getDelayStatus() {
        return delayStatus;
    }

    public void setDelayStatus(ChargeStatusEnum delayStatus) {
        this.delayStatus = delayStatus;
    }

    public Integer getDelayOverDueDays() {
        return delayOverDueDays;
    }

    public void setDelayOverDueDays(Integer delayOverDueDays) {
        this.delayOverDueDays = delayOverDueDays;
    }

    public YNEnum getIsToDelay() {
        return isToDelay;
    }

    public void setIsToDelay(YNEnum isToDelay) {
        this.isToDelay = isToDelay;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {

        this.loanId = loanId;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getDelayType() {
        return delayType;
    }

    public void setDelayType(String delayType) {
        this.delayType = delayType;
    }

    public BigDecimal getDelayBalance() {
        return delayBalance;
    }

    public void setDelayBalance(BigDecimal delayBalance) {
        this.delayBalance = delayBalance;
    }

    public BigDecimal getDayRate() {
        return dayRate;
    }

    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

    public void setRepayStatus(YNEnum repayStatus) {
        this.repayStatus = repayStatus;
    }

    public YNEnum getRepayStatus() {
        return repayStatus;
    }

    public void setTollTatalAmount(BigDecimal tollTatalAmount) {
        this.tollTatalAmount = tollTatalAmount;
    }

    public BigDecimal getTollTatalAmount() {
        return tollTatalAmount;
    }

    public void setRealNomalAmount(BigDecimal realNomalAmount) {
        this.realNomalAmount = realNomalAmount;
    }

    public BigDecimal getRealNomalAmount() {
        return realNomalAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getWarranty() {
        return warranty;
    }

    public void setWarranty(BigDecimal warranty) {
        this.warranty = warranty;
    }

    public void setIsPayOff(YNEnum isPayOff) {
        this.isPayOff = isPayOff;
    }

    public YNEnum getIsPayOff() {
        return isPayOff;
    }
}
