package yhao.micro.service.surety.business.apilist.model.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/14 14:41
 * @Description:
 */
public class FinanceBillingDetailModel extends Entity<String> {
    @ApiModelProperty(value = "担保单id")
    private String guaranteeId;
    @ApiModelProperty(value = "公司账户id")
    private String companyAccountId;
    @ApiModelProperty(value = "出账类型 CASH ")
    private String billingType;
    @ApiModelProperty(value = "出账金额")
    private BigDecimal bilLingAmount;
    @ApiModelProperty(value = "出账日期")
    private Date billingDate;
    @ApiModelProperty(value = "赎楼员id")
    private String redeemOperatorId;
    @ApiModelProperty(value = "赎楼员账户id")
    private String redeemAccountId;
    @ApiModelProperty(value = "是否删除")
    private String isDelete;

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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
