package yhao.micro.service.surety.business.apilist.model.finance;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargePayType;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/8 20:14
 * @Description:
 */
public class FinanceTollDetailModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("展期申请id")
    private String delayApplyId;
    @ApiModelProperty("收费金额")
    private BigDecimal tollAmount;
    @ApiModelProperty("收费类型")
    private ChargeType chargeType;
    @ApiModelProperty("支付方式")
    private ChargePayType payType;
    @ApiModelProperty("手续费")
    private BigDecimal handlingFee;
    @ApiModelProperty("公司id")
    private String companyAccountId;
    @ApiModelProperty("收费日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chargeDate;
    @ApiModelProperty("是否开票")
    private YNEnum isInvoice;
    @ApiModelProperty("开票名称")
    private String invoiceName;
    @ApiModelProperty("公司名称")
    private String companyName;
    @ApiModelProperty("操作人")
    private String operateName;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getDelayApplyId() {
        return delayApplyId;
    }

    public void setDelayApplyId(String delayApplyId) {
        this.delayApplyId = delayApplyId;
    }

    public BigDecimal getTollAmount() {
        return tollAmount;
    }

    public void setTollAmount(BigDecimal tollAmount) {
        this.tollAmount = tollAmount;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public ChargePayType getPayType() {
        return payType;
    }

    public void setPayType(ChargePayType payType) {
        this.payType = payType;
    }

    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(BigDecimal handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getCompanyAccountId() {
        return companyAccountId;
    }

    public void setCompanyAccountId(String companyAccountId) {
        this.companyAccountId = companyAccountId;
    }

    public Date getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(Date chargeDate) {
        this.chargeDate = chargeDate;
    }

    public YNEnum getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(YNEnum isInvoice) {
        this.isInvoice = isInvoice;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getOperateName() {
        return operateName;
    }

    public void setOperateName(String operateName) {
        this.operateName = operateName;
    }
}
