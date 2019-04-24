package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.form.guarantee.LoanDetailsSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.LoanGeneralSaveForm;

import java.util.Date;
import java.util.List;

/**
 * @Description 打折申请详情查看model
 *
 * @Author leice
 * @Date 2018/12/10 10:56
 * @Version 1.0
 */
public class DiscountApplicationInfoModel extends Entity<String> {

    @ApiModelProperty("业务编号")
    private String businessNumber;

    @ApiModelProperty("客户经理")
    private String accountManager;

    @ApiModelProperty("客户经理id")
    private String accountManagerId;

    @ApiModelProperty("客户经理所属部门")
    private String accountManagerOrg;

    @ApiModelProperty("公正日期")
    private String fairDate;

    @ApiModelProperty("卖方")
    private List<OwnerModel> sellers;

    @ApiModelProperty("买方")
    private List<BuyModel> buyers;

    @ApiModelProperty("物业")
    private List<PropertyModel> propertys;

    @ApiModelProperty("业务类型")
    private String businessType;

    @ApiModelProperty("担保金额")
    private Double guaranteeMoney;

    @ApiModelProperty("赎楼金额")
    private Double redemptionMoney;

    @ApiModelProperty("担保天数")
    private Integer guaranteeDays;

    @ApiModelProperty("手续费")
    private Double handlingFee;

    @ApiModelProperty("对外费率")
    private Double externalRate;

    @ApiModelProperty("应收担保费")
    private Double securityFeeReceivable;

    @ApiModelProperty("应收合计")
    private Double totalReceivable;

    @ApiModelProperty("实收费率")
    private Double actualRate;

    @ApiModelProperty("实收担保费")
    private Double paidGuaranteeFee;

    @ApiModelProperty("实收合计")
    private Double totalHarvest;

    @ApiModelProperty("返佣")
    private Double rebate;

    @ApiModelProperty("折扣")
    private String discount;

    @ApiModelProperty("打折记录id")
    private String discountId;

    @ApiModelProperty("打折原因")
    private String discountReason;

    @ApiModelProperty("最低实收费率")
    private Double lowestActualRate;

    @ApiModelProperty("业务类型 额度=AMOUNT,现金=CASH")
    private String types;

    @ApiModelProperty(value = "借款概况信息")
    private LoanGeneralSaveForm loanGeneralSaveForm;

    @ApiModelProperty(value = "借款明细信息")
    private List<LoanDetailsInfoModel> LoanDetailsInfoList;

    public String getAccountManagerId() {
        return accountManagerId;
    }

    public void setAccountManagerId(String accountManagerId) {
        this.accountManagerId = accountManagerId;
    }

    public String getAccountManagerOrg() {
        return accountManagerOrg;
    }

    public void setAccountManagerOrg(String accountManagerOrg) {
        this.accountManagerOrg = accountManagerOrg;
    }

    public Double getRedemptionMoney() {
        return redemptionMoney;
    }

    public void setRedemptionMoney(Double redemptionMoney) {
        this.redemptionMoney = redemptionMoney;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public String getFairDate() {
        return fairDate;
    }

    public void setFairDate(String fairDate) {
        this.fairDate = fairDate;
    }

    public List<OwnerModel> getSellers() {
        return sellers;
    }

    public void setSellers(List<OwnerModel> sellers) {
        this.sellers = sellers;
    }

    public List<BuyModel> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<BuyModel> buyers) {
        this.buyers = buyers;
    }

    public List<PropertyModel> getPropertys() {
        return propertys;
    }

    public void setPropertys(List<PropertyModel> propertys) {
        this.propertys = propertys;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Double getGuaranteeMoney() {
        return guaranteeMoney;
    }

    public void setGuaranteeMoney(Double guaranteeMoney) {
        this.guaranteeMoney = guaranteeMoney;
    }

    public Integer getGuaranteeDays() {
        return guaranteeDays;
    }

    public void setGuaranteeDays(Integer guaranteeDays) {
        this.guaranteeDays = guaranteeDays;
    }

    public Double getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(Double handlingFee) {
        this.handlingFee = handlingFee;
    }

    public Double getExternalRate() {
        return externalRate;
    }

    public void setExternalRate(Double externalRate) {
        this.externalRate = externalRate;
    }

    public Double getSecurityFeeReceivable() {
        return securityFeeReceivable;
    }

    public void setSecurityFeeReceivable(Double securityFeeReceivable) {
        this.securityFeeReceivable = securityFeeReceivable;
    }

    public Double getTotalReceivable() {
        return totalReceivable;
    }

    public void setTotalReceivable(Double totalReceivable) {
        this.totalReceivable = totalReceivable;
    }

    public Double getActualRate() {
        return actualRate;
    }

    public void setActualRate(Double actualRate) {
        this.actualRate = actualRate;
    }

    public Double getPaidGuaranteeFee() {
        return paidGuaranteeFee;
    }

    public void setPaidGuaranteeFee(Double paidGuaranteeFee) {
        this.paidGuaranteeFee = paidGuaranteeFee;
    }

    public Double getTotalHarvest() {
        return totalHarvest;
    }

    public void setTotalHarvest(Double totalHarvest) {
        this.totalHarvest = totalHarvest;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }

    public Double getLowestActualRate() {
        return lowestActualRate;
    }

    public void setLowestActualRate(Double lowestActualRate) {
        this.lowestActualRate = lowestActualRate;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public LoanGeneralSaveForm getLoanGeneralSaveForm() {
        return loanGeneralSaveForm;
    }

    public void setLoanGeneralSaveForm(LoanGeneralSaveForm loanGeneralSaveForm) {
        this.loanGeneralSaveForm = loanGeneralSaveForm;
    }

    public List<LoanDetailsInfoModel> getLoanDetailsInfoList() {
        return LoanDetailsInfoList;
    }

    public void setLoanDetailsInfoList(List<LoanDetailsInfoModel> loanDetailsInfoList) {
        LoanDetailsInfoList = loanDetailsInfoList;
    }
}
