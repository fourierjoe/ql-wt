package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.LoanDetailsModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:41
 * @Description:
 */
public class FundPayBackQueryResultForm extends GuaranteePageModel {

    @ApiModelProperty("确认出账日期")
    private Date billingConfirmDate;
    @ApiModelProperty("赎楼金额")
    private BigDecimal redemptionAmount;
    @ApiModelProperty("赎楼余款")
    private BigDecimal redemptionBalance;
    @ApiModelProperty("借款总金额")
    private BigDecimal loanTotalAmount;
    @ApiModelProperty("借款明细")
    private List<LoanDetailsModel>loanDetails;
    @ApiModelProperty("回款总金额")
    private BigDecimal payBackTotalAmount;
    @ApiModelProperty("剩余回款")
    private BigDecimal payBackBalanceAmount;
    @ApiModelProperty("可退金额")
    private BigDecimal refundAmount;
    @ApiModelProperty("是否确认回款")
    private YNEnum isConfirm;


    public BigDecimal getRedemptionAmount() {
        return redemptionAmount;
    }

    public void setRedemptionAmount(BigDecimal redemptionAmount) {
        this.redemptionAmount = redemptionAmount;
    }

    public BigDecimal getRedemptionBalance() {
        return redemptionBalance;
    }

    public void setRedemptionBalance(BigDecimal redemptionBalance) {
        this.redemptionBalance = redemptionBalance;
    }

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public Date getBillingConfirmDate() {
        return billingConfirmDate;
    }

    public void setBillingConfirmDate(Date billingConfirmDate) {
        this.billingConfirmDate = billingConfirmDate;
    }

    public List<LoanDetailsModel> getLoanDetails() {
        return loanDetails;
    }

    public void setLoanDetails(List<LoanDetailsModel> loanDetails) {
        this.loanDetails = loanDetails;
    }

    public BigDecimal getPayBackTotalAmount() {
        return payBackTotalAmount;
    }

    public void setPayBackTotalAmount(BigDecimal payBackTotalAmount) {
        this.payBackTotalAmount = payBackTotalAmount;
    }

    public BigDecimal getPayBackBalanceAmount() {
        return payBackBalanceAmount;
    }

    public void setPayBackBalanceAmount(BigDecimal payBackBalanceAmount) {
        this.payBackBalanceAmount = payBackBalanceAmount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public YNEnum getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(YNEnum isConfirm) {
        this.isConfirm = isConfirm;
    }
}
