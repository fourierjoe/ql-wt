package yhao.micro.service.surety.business.apilist.model.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeStatusEnum;

import java.math.BigDecimal;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/8 20:10
 * @Description:
 */
public class FinanceTollGeneralModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("担保费状态")
    private ChargeStatusEnum warrantyStatus;
    @ApiModelProperty("展期费状态")
    private ChargeStatusEnum delayStatus;
    @ApiModelProperty("逾期费状态")
    private ChargeStatusEnum overdueStatus;
    @ApiModelProperty("担保费累计收取金额")
    private BigDecimal warrantyTotalAmount;
    @ApiModelProperty("展期费累计收取金额")
    private BigDecimal delayTotalAmount;
    @ApiModelProperty("逾期费累计收取金额")
    private BigDecimal overdueTotalAmount;
    @ApiModelProperty("是否交齐费用 YES 是 NO 否")
    private YNEnum isPayOff;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public ChargeStatusEnum getWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(ChargeStatusEnum warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
    }

    public ChargeStatusEnum getDelayStatus() {
        return delayStatus;
    }

    public void setDelayStatus(ChargeStatusEnum delayStatus) {
        this.delayStatus = delayStatus;
    }

    public ChargeStatusEnum getOverdueStatus() {
        return overdueStatus;
    }

    public void setOverdueStatus(ChargeStatusEnum overdueStatus) {
        this.overdueStatus = overdueStatus;
    }

    public BigDecimal getWarrantyTotalAmount() {
        return warrantyTotalAmount;
    }

    public void setWarrantyTotalAmount(BigDecimal warrantyTotalAmount) {
        this.warrantyTotalAmount = warrantyTotalAmount;
    }

    public BigDecimal getDelayTotalAmount() {
        return delayTotalAmount;
    }

    public void setDelayTotalAmount(BigDecimal delayTotalAmount) {
        this.delayTotalAmount = delayTotalAmount;
    }

    public BigDecimal getOverdueTotalAmount() {
        return overdueTotalAmount;
    }

    public void setOverdueTotalAmount(BigDecimal overdueTotalAmount) {
        this.overdueTotalAmount = overdueTotalAmount;
    }

    public YNEnum getIsPayOff() {
        return isPayOff;
    }

    public void setIsPayOff(YNEnum isPayOff) {
        this.isPayOff = isPayOff;
    }


}
