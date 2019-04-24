package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author leice
 * @Date 2019/2/28 11:14
 * @Version 1.0
 */
public class ExtensionSomeFiledModel extends Entity<String> {

    @ApiModelProperty("赎楼金额/剩余借款")
    private Double amount;

    @ApiModelProperty("到期日/应还款日")
    private String arrivalDate;

    @ApiModelProperty("应收费率")
    private Double rate;

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
