package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/21 16:41
 * @Description:
 */
public class FirstBillingGeneralForm implements ValidationForm {
    @ApiModelProperty("到账合计金额")
    private BigDecimal totalArrivalAmount;
    @ApiModelProperty("赎楼合计金额")
    private BigDecimal totalRedeemAmount;
    @ApiModelProperty("退尾款金额")
    private BigDecimal refundTailAmount;

    public BigDecimal getTotalArrivalAmount() {
        return totalArrivalAmount;
    }

    public void setTotalArrivalAmount(BigDecimal totalArrivalAmount) {
        this.totalArrivalAmount = totalArrivalAmount;
    }

    public BigDecimal getTotalRedeemAmount() {
        return totalRedeemAmount;
    }

    public void setTotalRedeemAmount(BigDecimal totalRedeemAmount) {
        this.totalRedeemAmount = totalRedeemAmount;
    }

    public BigDecimal getRefundTailAmount() {
        return refundTailAmount;
    }

    public void setRefundTailAmount(BigDecimal refundTailAmount) {
        this.refundTailAmount = refundTailAmount;
    }
}
