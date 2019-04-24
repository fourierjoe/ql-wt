package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/3/1 10:06
 * @Description: 费率明细
 */
public class ConsumeRecordDetailForm implements ValidationForm {
    @ApiModelProperty("使用天数")
    private String useDays;
    @ApiModelProperty("回款金额")
    private BigDecimal repayAmount;
    @ApiModelProperty("回款日期")
    private Date repayDate;
    @ApiModelProperty("消费类型")
    private ChargeType chargeType;
    @ApiModelProperty("产生费用")
    private BigDecimal fee;
    @ApiModelProperty("担保费")
    private BigDecimal warranty;
    @ApiModelProperty("展期费")
    private BigDecimal delay;
    @ApiModelProperty("逾期费")
    private BigDecimal overdue;
    @ApiModelProperty("担保费率")
    private Double warrantyRate;
    @ApiModelProperty("展期费率")
    private Double delayRate;
    @ApiModelProperty("逾期费率")
    private Double overdueRate;


    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getUseDays() {
        return useDays;
    }

    public void setUseDays(String useDays) {
        this.useDays = useDays;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public BigDecimal getWarranty() {
        return warranty;
    }

    public void setWarranty(BigDecimal warranty) {
        this.warranty = warranty;
    }

    public BigDecimal getDelay() {
        return delay;
    }

    public void setDelay(BigDecimal delay) {
        this.delay = delay;
    }

    public BigDecimal getOverdue() {
        return overdue;
    }

    public void setOverdue(BigDecimal overdue) {
        this.overdue = overdue;
    }

    public Double getWarrantyRate() {
        return warrantyRate;
    }

    public void setWarrantyRate(Double warrantyRate) {
        this.warrantyRate = warrantyRate;
    }

    public Double getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(Double delayRate) {
        this.delayRate = delayRate;
    }

    public Double getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(Double overdueRate) {
        this.overdueRate = overdueRate;
    }
}
