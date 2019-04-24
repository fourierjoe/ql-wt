package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/25 09:35
 * @Description:
 */
public class LoanPayBackTotalQueryForm  {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("借款明细id")
    private String loanId;
    @ApiModelProperty("借款回款总额")
    private BigDecimal payBackTotalAmount;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public BigDecimal getPayBackTotalAmount() {
        return payBackTotalAmount;
    }

    public void setPayBackTotalAmount(BigDecimal payBackTotalAmount) {
        this.payBackTotalAmount = payBackTotalAmount;
    }
}
