package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/23 11:50
 * @Description:
 */
public class FinanceLoanGeneralResultForm implements ValidationForm {
    @ApiModelProperty("赎楼金额/剩余借款")
    private BigDecimal amount;
    @ApiModelProperty("到期日/应还款日")
    private Date arrivalDate;
    @ApiModelProperty("应收费率")
    private BigDecimal rate;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
