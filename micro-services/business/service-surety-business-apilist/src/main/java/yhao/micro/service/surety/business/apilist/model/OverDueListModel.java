package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2019/2/15 15:40
 * @Version 1.0
 */
public class OverDueListModel extends Entity<String> {

    @ApiModelProperty("序号")
    private Integer orderNumber;

    @ApiModelProperty("担保id")
    private String guaranteeId;

    @ApiModelProperty("任务id")
    private String taskId;

    @ApiModelProperty("业务编号")
    private String guaranteeNum;

    @ApiModelProperty("业务类型")
    private String businessType;

    @ApiModelProperty("卖方")
    private List<OwnerModel> sellers;

    @ApiModelProperty("买方")
    private List<BuyModel> buyers;

    @ApiModelProperty("物业")
    private List<PropertyModel> propertys;

    @ApiModelProperty("客户经理")
    private String accountManager;

    private String accountManagerId;

    @ApiModelProperty("借款金额")
    private Double loanAmount;

    @ApiModelProperty("出账金额")
    private Double paymentAmount;

    @ApiModelProperty("累计收费")
    private Double cumulativeCharge;

    @ApiModelProperty("实际应收")
    private Double actualReceivable;

    @ApiModelProperty("逾期费")
    private Double overdueFee;

    @ApiModelProperty("剩余应交")
    private Double remainingDue;

    @ApiModelProperty("回款状态")
    private String paymentStatus;

    @ApiModelProperty("申请状态RUNNING(任务执行中)END(任务正常完成)REJECT(任务驳回) CANCEL(撤销) ''(未发起)")//SUB_TASK("子任务执行中"),
    private String applicationStatus;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
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

    public List<PropertyModel> getPropertys() {
        return propertys;
    }

    public void setPropertys(List<PropertyModel> propertys) {
        this.propertys = propertys;
    }

    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

    public String getAccountManagerId() {
        return accountManagerId;
    }

    public void setAccountManagerId(String accountManagerId) {
        this.accountManagerId = accountManagerId;
    }

    public Double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getCumulativeCharge() {
        return cumulativeCharge;
    }

    public void setCumulativeCharge(Double cumulativeCharge) {
        this.cumulativeCharge = cumulativeCharge;
    }

    public Double getActualReceivable() {
        return actualReceivable;
    }

    public void setActualReceivable(Double actualReceivable) {
        this.actualReceivable = actualReceivable;
    }

    public Double getOverdueFee() {
        return overdueFee;
    }

    public void setOverdueFee(Double overdueFee) {
        this.overdueFee = overdueFee;
    }

    public Double getRemainingDue() {
        return remainingDue;
    }

    public void setRemainingDue(Double remainingDue) {
        this.remainingDue = remainingDue;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "OverDueListModel{" +
                "orderNumber=" + orderNumber +
                ", guaranteeId='" + guaranteeId + '\'' +
                ", businessType='" + businessType + '\'' +
                ", sellers=" + sellers +
                ", buyers=" + buyers +
                ", propertys=" + propertys +
                ", accountManager='" + accountManager + '\'' +
                ", accountManagerId='" + accountManagerId + '\'' +
                ", loanAmount='" + loanAmount + '\'' +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", cumulativeCharge='" + cumulativeCharge + '\'' +
                ", actualReceivable='" + actualReceivable + '\'' +
                ", overdueFee='" + overdueFee + '\'' +
                ", remainingDue='" + remainingDue + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", applicationStatus='" + applicationStatus + '\'' +
                '}';
    }
}
