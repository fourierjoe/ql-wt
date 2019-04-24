package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/9 19:30
 * @Version 1.0
 */
public class LoanDailyRateModel extends Entity<String> {

    @ApiModelProperty("每日费率")
    private Double loanDailyRate;

    public Double getLoanDailyRate() {
        return loanDailyRate;
    }

    public void setLoanDailyRate(Double loanDailyRate) {
        this.loanDailyRate = loanDailyRate;
    }

    @Override
    public String toString() {
        return "LoanDailyRateModel{" +
                "loanDailyRate=" + loanDailyRate +
                '}';
    }
}
