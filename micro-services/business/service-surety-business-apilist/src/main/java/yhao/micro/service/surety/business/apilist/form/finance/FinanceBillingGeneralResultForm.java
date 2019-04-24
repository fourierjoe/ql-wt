package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/14 17:48
 * @Description: 出账概况返回
 */
public class FinanceBillingGeneralResultForm implements ValidationForm {
    @ApiModelProperty("总到账金额")
    private BigDecimal arrivalTotalAmount;
    @ApiModelProperty("总出账金额")
    private BigDecimal billingTotalAmount;
    @ApiModelProperty("剩余出账金额")
    private BigDecimal billingBalance;

    public BigDecimal getArrivalTotalAmount() {
        return arrivalTotalAmount;
    }

    public void setArrivalTotalAmount(BigDecimal arrivalTotalAmount) {
        this.arrivalTotalAmount = arrivalTotalAmount;
    }

    public BigDecimal getBillingTotalAmount() {
        return billingTotalAmount;
    }

    public void setBillingTotalAmount(BigDecimal billingTotalAmount) {
        this.billingTotalAmount = billingTotalAmount;
    }

    public BigDecimal getBillingBalance() {
        return billingBalance;
    }

    public void setBillingBalance(BigDecimal billingBalance) {
        this.billingBalance = billingBalance;
    }
}
