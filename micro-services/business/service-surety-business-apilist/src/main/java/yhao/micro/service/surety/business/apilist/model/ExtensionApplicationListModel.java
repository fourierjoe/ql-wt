package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/4 14:43
 * @Version 1.0
 */
public class ExtensionApplicationListModel extends Entity<String> {

    @ApiModelProperty("序号")
    private Integer orderNumber;

    @ApiModelProperty("担保单id")
    private String guaranteeId;

    @ApiModelProperty("业务编号")
    private String guaranteeNum;

    @ApiModelProperty("展期id")
    private String extensionId;

    @ApiModelProperty("借款id")
    private String loanId;

    @ApiModelProperty("业务类型")
    private String businessType;

    @ApiModelProperty("卖方")
    private List<OwnerModel> sellers;

    @ApiModelProperty("买方")
    private List<BuyModel> buyers;

    @ApiModelProperty("客户经理")
    private String accountManager;

    private String accountManagerId;

    @ApiModelProperty("客户经理所属部门")
    private String accountManagerOrg;

    @ApiModelProperty("展期金额")
    private Double money;

    @ApiModelProperty("展期天数")
    private Integer days;

    @ApiModelProperty("费率")
    private Double rate;

    @ApiModelProperty("每日费率")
    private Double dailyRate;

    @ApiModelProperty("应收费率")
    private Double rateOfCharge;

    @ApiModelProperty("应交展期费")
    private Double shouldPay;

    @ApiModelProperty("创建时间")
    private String createDate;

    @ApiModelProperty("展期状态 1:正常 2：撤销 3：失效")
    private Integer status;

    @ApiModelProperty("展期收费状态1：未收费2：已收费未确认3：已收费已确认")
    private Integer statusFee;

    @ApiModelProperty("展期业务类型1：现金 2：额度")
    private Integer types;

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
    }

    public String getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(String extensionId) {
        this.extensionId = extensionId;
    }

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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Double getRateOfCharge() {
        return rateOfCharge;
    }

    public void setRateOfCharge(Double rateOfCharge) {
        this.rateOfCharge = rateOfCharge;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
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

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getShouldPay() {
        return shouldPay;
    }

    public void setShouldPay(Double shouldPay) {
        this.shouldPay = shouldPay;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusFee() {
        return statusFee;
    }

    public void setStatusFee(Integer statusFee) {
        this.statusFee = statusFee;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }
}
