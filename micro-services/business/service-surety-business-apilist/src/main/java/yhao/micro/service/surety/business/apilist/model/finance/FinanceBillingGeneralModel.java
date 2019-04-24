package yhao.micro.service.surety.business.apilist.model.finance;


import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/14 14:40
 * @Description:
 */
public class FinanceBillingGeneralModel extends Entity<String> {
    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteeId;
    @ApiModelProperty(value = "累计出账金额", required = true)
    private BigDecimal totalBillingAmount;
    @ApiModelProperty(value = "剩余可出账金额", required = true)
    private BigDecimal balance;
    @ApiModelProperty(value = "第一次出账日期")
    private Date firstBillingDate;
    @ApiModelProperty(value = "确认出账日期")
    private Date confirmBillingDate;
    @ApiModelProperty("是否确认出账")
    private YNEnum isConfirm;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public BigDecimal getTotalBillingAmount() {
        return totalBillingAmount;
    }

    public void setTotalBillingAmount(BigDecimal totalBillingAmount) {
        this.totalBillingAmount = totalBillingAmount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getFirstBillingDate() {
        return firstBillingDate;
    }

    public void setFirstBillingDate(Date firstBillingDate) {
        this.firstBillingDate = firstBillingDate;
    }


    public Date getConfirmBillingDate() {
        return confirmBillingDate;
    }

    public void setConfirmBillingDate(Date confirmBillingDate) {
        this.confirmBillingDate = confirmBillingDate;
    }

    public YNEnum getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(YNEnum isConfirm) {
        this.isConfirm = isConfirm;
    }
}
