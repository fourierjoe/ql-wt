package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 18:53
 * @Description:
 */
public class RedemptionQueryResultForm extends GuaranteePageModel {

    @ApiModelProperty("原按揭银行")
    private  String bankName;
    @ApiModelProperty("借款金额")
    private  BigDecimal loanAmount;
    @ApiModelProperty("到账日期")
    private Date arrivalDate;
    @ApiModelProperty("出账日期")
    private Date billingDate;
    @ApiModelProperty("赎楼日期")
    private Date redeemDate;
    @ApiModelProperty("赎楼余额")
    private  BigDecimal redemptionBalance;


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public BigDecimal getRedemptionBalance() {
        return redemptionBalance;
    }

    public void setRedemptionBalance(BigDecimal redemptionBalance) {
        this.redemptionBalance = redemptionBalance;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }
}
