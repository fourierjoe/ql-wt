package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.complex.BilingCaseSituationStatus;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeStatusEnum;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.FundStateEnum;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 14:15
 * @Description:
 */
public class FinanceArrivalBillingQueryForm extends FinanceBaseQueryForm {
    @ApiModelProperty(value = "业务类别id")
    private String bizId;
    @ApiModelProperty(value = "资金状态 已到账、已出账传 YES")
    private YNEnum fundStatus;
    @ApiModelProperty(value = "收费状态")
    private ChargeStatusEnum chargeStatus;
    @ApiModelProperty(value = "已办节点")
    private String dealNodeId;
    @ApiModelProperty(value = "出赎楼款机构id")
    private String redemptionAccountId;
    @ApiModelProperty(value = "到账开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalStartDate;
    @ApiModelProperty(value = "到账结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalEndDate;
    @ApiModelProperty(value = "出账开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billingStartDate;
    @ApiModelProperty(value = "出账结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billingEndDate;
    @ApiModelProperty(value = "请求类型 arrival 到账 billing 出账", required = true)
    @NotBlank(message = "请求类型不能为空")
    private String positionType;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public YNEnum getFundStatus() {
        return fundStatus;
    }

    public void setFundStatus(YNEnum fundStatus) {
        this.fundStatus = fundStatus;
    }

    public ChargeStatusEnum getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(ChargeStatusEnum chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    public String getDealNodeId() {
        return dealNodeId;
    }

    public void setDealNodeId(String dealNodeId) {
        this.dealNodeId = dealNodeId;
    }

    public String getRedemptionAccountId() {
        return redemptionAccountId;
    }

    public void setRedemptionAccountId(String redemptionAccountId) {
        this.redemptionAccountId = redemptionAccountId;
    }

    public Date getArrivalStartDate() {
        return arrivalStartDate;
    }

    public void setArrivalStartDate(Date arrivalStartDate) {
        this.arrivalStartDate = arrivalStartDate;
    }

    public Date getArrivalEndDate() {
        return arrivalEndDate;
    }

    public void setArrivalEndDate(Date arrivalEndDate) {
        this.arrivalEndDate = arrivalEndDate;
    }

    public Date getBillingStartDate() {
        return billingStartDate;
    }

    public void setBillingStartDate(Date billingStartDate) {
        this.billingStartDate = billingStartDate;
    }

    public Date getBillingEndDate() {
        return billingEndDate;
    }

    public void setBillingEndDate(Date billingEndDate) {
        this.billingEndDate = billingEndDate;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
