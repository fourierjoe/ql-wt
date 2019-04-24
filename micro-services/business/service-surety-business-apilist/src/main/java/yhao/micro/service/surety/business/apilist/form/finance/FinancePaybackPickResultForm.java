package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.finance.FundPayBackDetailModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:57
 * @Description:
 */
public class FinancePaybackPickResultForm  {
    @ApiModelProperty("已回款金额")
    private BigDecimal payBackTotalAmount;
    @ApiModelProperty("剩余回款")
    private BigDecimal payBackBalanceAmount;
    @ApiModelProperty("回款记录")
    private List<FundPayBackDetailModel>payBackModelList;

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

    public List<FundPayBackDetailModel> getPayBackModelList() {
        return payBackModelList;
    }

    public void setPayBackModelList(List<FundPayBackDetailModel> payBackModelList) {
        this.payBackModelList = payBackModelList;
    }
}
