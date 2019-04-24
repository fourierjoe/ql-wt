package yhao.micro.service.surety.business.apilist.model.finance;


import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 15:29
 * @Description:出账model
 */
public class FinanceBillingModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("公司账户id")
    private String companyAccountId;
    @ApiModelProperty("出账类型")
    private String billingType;
    @ApiModelProperty("出账金额")
    private BigDecimal bilingAmount;
    @ApiModelProperty("出账日期")
    private Date billingDate;
    @ApiModelProperty("赎楼员id")
    private String redemOperatorId;
    @ApiModelProperty("赎楼员账户id")
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

    public BigDecimal getBilingAmount() {
        return bilingAmount;
    }

    public void setBilingAmount(BigDecimal bilingAmount) {
        this.bilingAmount = bilingAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getRedemOperatorId() {
        return redemOperatorId;
    }

    public void setRedemOperatorId(String redemOperatorId) {
        this.redemOperatorId = redemOperatorId;
    }

    public String getRedeemAccountId() {
        return redeemAccountId;
    }

    public void setRedeemAccountId(String redeemAccountId) {
        this.redeemAccountId = redeemAccountId;
    }
}
