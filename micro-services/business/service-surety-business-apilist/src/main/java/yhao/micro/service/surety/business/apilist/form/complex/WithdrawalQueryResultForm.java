package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 14:43
 * @Description:
 */
public class WithdrawalQueryResultForm extends RedemptionBaseResultForm {
    @ApiModelProperty(value = "到账金额")
    private BigDecimal arrivalAmount;
    @ApiModelProperty(value = "赎楼金额")
    private BigDecimal redemptionAmount;
    @ApiModelProperty(value = "退余款合计")
    private BigDecimal ReBackBalanceTotal;
    @ApiModelProperty("退余款状态 SEND 已提交;NO_SEND 未提交;REBACK 已退款")
    private String status;
    @ApiModelProperty(value = "出账日期")
    private Date BilingDate;
    @ApiModelProperty("打印日期")
    private Date printDate;

    public BigDecimal getArrivalAmount() {
        return arrivalAmount;
    }

    public void setArrivalAmount(BigDecimal arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    public BigDecimal getRedemptionAmount() {
        return redemptionAmount;
    }

    public void setRedemptionAmount(BigDecimal redemptionAmount) {
        this.redemptionAmount = redemptionAmount;
    }

    public BigDecimal getReBackBalanceTotal() {
        return ReBackBalanceTotal;
    }

    public void setReBackBalanceTotal(BigDecimal reBackBalanceTotal) {
        ReBackBalanceTotal = reBackBalanceTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getBilingDate() {
        return BilingDate;
    }

    public void setBilingDate(Date bilingDate) {
        BilingDate = bilingDate;
    }

    public Date getPrintDate() {
        return printDate;
    }

    public void setPrintDate(Date printDate) {
        this.printDate = printDate;
    }
}
