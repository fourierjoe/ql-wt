package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.enums.YNEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 15:40
 * @Description:
 */
public class FinanceBillingQueryResultBizForm implements ValidationForm {

    private String id;
    @ApiModelProperty("出账金额")
    private BigDecimal billingAmount;
    @ApiModelProperty("出账日期")
    private Date billingDate;
    @ApiModelProperty("赎楼员")
    private String redeemName;
    @ApiModelProperty("赎楼日期 如果有则是已赎楼 空则为未赎楼")
    private String redeemDate;
    @ApiModelProperty("操作时间")
    private String createTime;


    public BigDecimal getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(BigDecimal billingAmount) {
        this.billingAmount = billingAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getRedeemName() {
        return redeemName;
    }

    public void setRedeemName(String redeemName) {
        this.redeemName = redeemName;
    }

    public String getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(String redeemDate) {
        this.redeemDate = redeemDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
