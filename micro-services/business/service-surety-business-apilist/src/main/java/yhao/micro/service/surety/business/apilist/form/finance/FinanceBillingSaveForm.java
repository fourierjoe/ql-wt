package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.IdUnForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 15:39
 * @Description:
 */
public class FinanceBillingSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;
    @ApiModelProperty(value = "公司账户id",required = true)
    private String companyAccountId;
    @ApiModelProperty(value = "出账类型 CASH ",required = true)
    private String billingType;
    @ApiModelProperty(value = "出账金额",required = true)
    private BigDecimal bilLingAmount;
    @ApiModelProperty(value = "出账日期",required = true)
    private Date billingDate;
    @ApiModelProperty(value = "赎楼员id",required = true)
    private String redeemOperatorId;
    @ApiModelProperty(value = "赎楼员账户id",required = true)
    private String redeemAccountId;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getCompanyAccountId() {
        return companyAccountId;
    }

    public void setCompanyAccountId(String companyAccountId) {
        this.companyAccountId = companyAccountId;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public BigDecimal getBilLingAmount() {
        return bilLingAmount;
    }

    public void setBilLingAmount(BigDecimal bilLingAmount) {
        this.bilLingAmount = bilLingAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getRedeemOperatorId() {
        return redeemOperatorId;
    }

    public void setRedeemOperatorId(String redeemOperatorId) {
        this.redeemOperatorId = redeemOperatorId;
    }

    public String getRedeemAccountId() {
        return redeemAccountId;
    }

    public void setRedeemAccountId(String redeemAccountId) {
        this.redeemAccountId = redeemAccountId;
    }
}
