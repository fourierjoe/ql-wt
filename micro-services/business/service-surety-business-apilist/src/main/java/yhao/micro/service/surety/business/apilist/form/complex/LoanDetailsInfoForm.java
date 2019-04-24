package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

import java.math.BigDecimal;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/14 10:29
 * @Version 1.0
 */
public class LoanDetailsInfoForm extends IdUnForm {

    @ApiModelProperty("借款id")
    private String loanId;

    @ApiModelProperty("每日费率")
    private Double dailyRate;

    //应收担保费
    private Double chargeGuaranteeFee;

    @ApiModelProperty(value = "借款金额",example = "100.0")
    private Double loanAmount;

    @ApiModelProperty(value = "借款天数",example = "10")
    private Integer loanDays;

    public Double getChargeGuaranteeFee() {
        return chargeGuaranteeFee;
    }

    public void setChargeGuaranteeFee(Double chargeGuaranteeFee) {
        this.chargeGuaranteeFee = chargeGuaranteeFee;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getLoanDays() {
        return loanDays;
    }

    public void setLoanDays(Integer loanDays) {
        this.loanDays = loanDays;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }
}
