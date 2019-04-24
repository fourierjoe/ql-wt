package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;
import yhao.micro.service.surety.business.apilist.model.redemption.BillingApplyModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 14:41
 * @Description:
 */
public class FinanceArrivalBillingQueryResultForm extends GuaranteePageModel {
    @ApiModelProperty("到账金额")
    private BigDecimal arrivalAmount;
    @ApiModelProperty("出账申请状态 START 审批中 PASS 完成 REFUSE 驳回")
    private String BillingApplyStatus;
    @ApiModelProperty("到账状态 YES 已确认到账 NO/null 未确认到账")
    private String status;
    @ApiModelProperty("累计到账")
    private BigDecimal totalArrivalAmount;
    @ApiModelProperty(value = "累计已出账")
    private BigDecimal totalBillingAmount;
    @ApiModelProperty(value = "剩余可出账")
    private BigDecimal balance;
    @ApiModelProperty("出账申请列表")
    private List<BillingApplyModel> billingApplyList;

    public BigDecimal getArrivalAmount() {
        return arrivalAmount;
    }

    public void setArrivalAmount(BigDecimal arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    public String getBillingApplyStatus() {
        return BillingApplyStatus;
    }

    public void setBillingApplyStatus(String billingApplyStatus) {
        BillingApplyStatus = billingApplyStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalArrivalAmount() {
        return totalArrivalAmount;
    }

    public void setTotalArrivalAmount(BigDecimal totalArrivalAmount) {
        this.totalArrivalAmount = totalArrivalAmount;
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

    public List<BillingApplyModel> getBillingApplyList() {
        return billingApplyList;
    }

    public void setBillingApplyList(List<BillingApplyModel> billingApplyList) {
        this.billingApplyList = billingApplyList;
    }
}
