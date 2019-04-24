package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/24 11:25
 * @Description:
 */
public class CostGeneralResultForm implements ValidationForm {
    @ApiModelProperty("产生费用")
    private BigDecimal cost =new BigDecimal(0);
    @ApiModelProperty("累计交费")
    private BigDecimal totalToll =new BigDecimal(0);
    @ApiModelProperty("剩余应交")
    private BigDecimal balance =new BigDecimal(0);
    @ApiModelProperty("可退金额")
    private BigDecimal refundAmount =new BigDecimal(0);

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getTotalToll() {
        return totalToll;
    }

    public void setTotalToll(BigDecimal totalToll) {
        this.totalToll = totalToll;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }
}
