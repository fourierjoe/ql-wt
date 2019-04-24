package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/11 10:46
 * @Version 1.0
 */
public class LoanDetailsInfoModel extends Entity<String> {

    @ApiModelProperty(value = "借款金额",example = "100.0")
    private BigDecimal loanAmount;

    @ApiModelProperty(value = "借款天数",example = "10")
    private Integer loanDays;

    @ApiModelProperty(value = "每日费率",example = "6.0")
    private Double marketFeeRate;

    @ApiModelProperty(value = "应收咨询费",example = "90.0")
    private Double chargeGuaranteeFee;

    @ApiModelProperty("折扣")
    private String discount;

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getLoanDays() {
        return loanDays;
    }

    public void setLoanDays(Integer loanDays) {
        this.loanDays = loanDays;
    }

    public Double getMarketFeeRate() {
        return marketFeeRate;
    }

    public void setMarketFeeRate(Double marketFeeRate) {
        this.marketFeeRate = marketFeeRate;
    }

    public Double getChargeGuaranteeFee() {
        return chargeGuaranteeFee;
    }

    public void setChargeGuaranteeFee(Double chargeGuaranteeFee) {
        this.chargeGuaranteeFee = chargeGuaranteeFee;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
