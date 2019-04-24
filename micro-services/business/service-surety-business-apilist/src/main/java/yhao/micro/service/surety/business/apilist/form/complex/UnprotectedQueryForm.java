package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/28 16:24
 * @Description:
 */
public class UnprotectedQueryForm extends ComplexRedemptionBaseQueryForm {
    @ApiModelProperty("出赎楼银行")
    private String redeemBankId;
    @ApiModelProperty("出款开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billingStartDate;
    @ApiModelProperty("出款结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billingEndDate;
    @ApiModelProperty("退余款合计最小值")
    private BigDecimal refundStartAmount;
    @ApiModelProperty("退余款合计最大值")
    private BigDecimal refundEndAmount;

    public String getRedeemBankId() {
        return redeemBankId;
    }

    public void setRedeemBankId(String redeemBankId) {
        this.redeemBankId = redeemBankId;
    }

    public Date getBillingStartDate() {
        return billingStartDate;
    }

    public void setBillingStartDate(Date billingStartDate) {
        this.billingStartDate = billingStartDate;
    }

    public Date getBillingEndDate() {
        return billingEndDate;
    }

    public void setBillingEndDate(Date billingEndDate) {
        this.billingEndDate = billingEndDate;
    }

    public BigDecimal getRefundStartAmount() {
        return refundStartAmount;
    }

    public void setRefundStartAmount(BigDecimal refundStartAmount) {
        this.refundStartAmount = refundStartAmount;
    }

    public BigDecimal getRefundEndAmount() {
        return refundEndAmount;
    }

    public void setRefundEndAmount(BigDecimal refundEndAmount) {
        this.refundEndAmount = refundEndAmount;
    }
}
