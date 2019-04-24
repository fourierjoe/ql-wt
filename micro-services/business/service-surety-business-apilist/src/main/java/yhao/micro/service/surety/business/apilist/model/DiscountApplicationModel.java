package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.List;

/**
 * @Description 打折申请model
 *
 * @Author leice
 * @Date 2018/12/6 19:13
 * @Version 1.0
 */
public class DiscountApplicationModel extends Entity<String>{

    @ApiModelProperty("序号")
    private Integer orderNumber;

    @ApiModelProperty("申请单号")
    private String singleNumber;

    @ApiModelProperty("业务编号")
    private String guaranteeId;

    @ApiModelProperty("担保金额")
    private String guaranteeMoney;

    @ApiModelProperty("审批进度")
    private String approvalProgress;

    @ApiModelProperty("实收费率")
    private Double guaranteeRate;

    @ApiModelProperty("折扣")
    private String discount;

    @ApiModelProperty("应收担保费")
    private String receivableguaranteeMoney;

    @ApiModelProperty("卖方")
    private List<OwnerModel> sellers;

    @ApiModelProperty("买方")
    private List<BuyModel> buyers;

    @ApiModelProperty("客户经理")
    private String accountManager;

    private String accountManagerId;

    @ApiModelProperty("客户经理所属部门")
    private String accountManagerOrg;

    @ApiModelProperty("任务id")
    private String taskId;

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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Double getGuaranteeRate() {
        return guaranteeRate;
    }

    public void setGuaranteeRate(Double guaranteeRate) {
        this.guaranteeRate = guaranteeRate;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getGuaranteeMoney() {
        return guaranteeMoney;
    }

    public void setGuaranteeMoney(String guaranteeMoney) {
        this.guaranteeMoney = guaranteeMoney;
    }

    public String getApprovalProgress() {
        return approvalProgress;
    }

    public void setApprovalProgress(String approvalProgress) {
        this.approvalProgress = approvalProgress;
    }


    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getReceivableguaranteeMoney() {
        return receivableguaranteeMoney;
    }

    public void setReceivableguaranteeMoney(String receivableguaranteeMoney) {
        this.receivableguaranteeMoney = receivableguaranteeMoney;
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

    @Override
    public String toString() {
        return "DiscountApplicationModel{" +
                "orderNumber=" + orderNumber +
                ", singleNumber='" + singleNumber + '\'' +
                ", guaranteeId='" + guaranteeId + '\'' +
                ", guaranteeMoney='" + guaranteeMoney + '\'' +
                ", approvalProgress='" + approvalProgress + '\'' +
                ", guaranteeRate=" + guaranteeRate +
                ", discount='" + discount + '\'' +
                ", receivableguaranteeMoney='" + receivableguaranteeMoney + '\'' +
                ", sellers=" + sellers +
                ", buyers=" + buyers +
                ", accountManager='" + accountManager + '\'' +
                ", taskId='" + taskId + '\'' +
                '}';
    }
}
