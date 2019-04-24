package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargePayType;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/14 16:11
 * @Description:
 */
public class FinanceTollSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteeId;
    @ApiModelProperty("借款id 展期费 逾期费必填")
    private String loanId;
    @ApiModelProperty("展期申请id 展期费必填")
    private String delayApplyId;
    @ApiModelProperty("WARRANTY 担保费, OVERDUE 逾期费, DELAY 逾期费")
    private ChargeType chargeType;
    @ApiModelProperty(value = "公司账户id", required = true)
    private String companyAccountId;
    @ApiModelProperty(value = "收费日期", required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date chargeDate;
    @ApiModelProperty(value = "支付类型 CASH现金 BANK银行 MONTHLY月结", required = true)
    private ChargePayType payType;
    @ApiModelProperty(value = "应收金额",required = true)
    private BigDecimal tollAmount;
    @ApiModelProperty("手续费")
    private BigDecimal handlingFee;
    @ApiModelProperty("是否开票")
    private YNEnum isInvoice;
    @ApiModelProperty("开票名称")
    private String invoiceName;


    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
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

    public ChargePayType getPayType() {
        return payType;
    }

    public void setPayType(ChargePayType payType) {
        this.payType = payType;
    }

    public BigDecimal getTollAmount() {
        return tollAmount;
    }

    public void setTollAmount(BigDecimal tollAmount) {
        this.tollAmount = tollAmount;
    }

    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(BigDecimal handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getDelayApplyId() {
        return delayApplyId;
    }

    public void setDelayApplyId(String delayApplyId) {
        this.delayApplyId = delayApplyId;
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
}
