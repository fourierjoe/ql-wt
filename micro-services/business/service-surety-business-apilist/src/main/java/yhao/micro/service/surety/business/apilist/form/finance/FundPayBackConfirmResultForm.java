package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 21:09
 * @Description:
 */
public class FundPayBackConfirmResultForm implements ValidationForm {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("借款合计金额")
    private BigDecimal loanTotalAmount;
    @ApiModelProperty("回款合计金额")
    private BigDecimal payBackTotalAmount;
    @ApiModelProperty("回款记录")
    private List<FundPayBackConfirmBizForm> payBackList;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public BigDecimal getPayBackTotalAmount() {
        return payBackTotalAmount;
    }

    public void setPayBackTotalAmount(BigDecimal payBackTotalAmount) {
        this.payBackTotalAmount = payBackTotalAmount;
    }

    public List<FundPayBackConfirmBizForm> getPayBackList() {
        return payBackList;
    }

    public void setPayBackList(List<FundPayBackConfirmBizForm> payBackList) {
        this.payBackList = payBackList;
    }
}
