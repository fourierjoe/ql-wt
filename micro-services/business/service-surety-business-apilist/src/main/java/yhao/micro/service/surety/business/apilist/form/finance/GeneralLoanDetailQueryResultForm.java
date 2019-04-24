package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.LoanDetailsModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/9 14:30
 * @Description:
 */
public class GeneralLoanDetailQueryResultForm {
    @ApiModelProperty("借款总额")
    private BigDecimal loanTotalAmount;
    @ApiModelProperty("应收合计")
    private BigDecimal totalReceivable;
    @ApiModelProperty(value = "已收费")
    private BigDecimal realTotalCharges;
    @ApiModelProperty(value = "剩余应收")
    private BigDecimal BalanceAmount;
    @ApiModelProperty("借款明细")
    private List<LoanDetailsModel> loanDetailList;

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public BigDecimal getTotalReceivable() {
        return totalReceivable;
    }

    public void setTotalReceivable(BigDecimal totalReceivable) {
        this.totalReceivable = totalReceivable;
    }

    public BigDecimal getRealTotalCharges() {
        return realTotalCharges;
    }

    public void setRealTotalCharges(BigDecimal realTotalCharges) {
        this.realTotalCharges = realTotalCharges;
    }

    public BigDecimal getBalanceAmount() {
        return BalanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        BalanceAmount = balanceAmount;
    }

    public List<LoanDetailsModel> getLoanDetailList() {
        return loanDetailList;
    }

    public void setLoanDetailList(List<LoanDetailsModel> loanDetailList) {
        this.loanDetailList = loanDetailList;
    }
}
