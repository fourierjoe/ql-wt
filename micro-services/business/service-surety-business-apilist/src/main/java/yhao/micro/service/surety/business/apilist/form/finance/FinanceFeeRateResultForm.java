package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/18 11:18
 * @Description: 回款查询需要的费率结果
 */
public class FinanceFeeRateResultForm implements ValidationForm {

    @ApiModelProperty(value = "借款每日费率", example = "6.0")
    private Double loanFeeRate;
    @ApiModelProperty(value = "逾期费率json", example = "{}")
    private String overdueRateJson;
    @ApiModelProperty("第一次出账日期")
    private Date firstBillingDate;

    public Double getLoanFeeRate() {
        return loanFeeRate;
    }

    public void setLoanFeeRate(Double loanFeeRate) {
        this.loanFeeRate = loanFeeRate;
    }

    public String getOverdueRateJson() {
        return overdueRateJson;
    }

    public void setOverdueRateJson(String overdueRateJson) {
        this.overdueRateJson = overdueRateJson;
    }

    public Date getFirstBillingDate() {
        return firstBillingDate;
    }

    public void setFirstBillingDate(Date firstBillingDate) {
        this.firstBillingDate = firstBillingDate;
    }
}
