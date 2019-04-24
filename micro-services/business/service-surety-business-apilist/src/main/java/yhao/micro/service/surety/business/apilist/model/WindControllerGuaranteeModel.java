package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.apache.catalina.Manager;
import yhao.infra.common.model.Entity;

import java.util.Date;
import java.util.List;

/**
 * @Description 风控模块有关担保单列表model
 *
 * @Author leice
 * @Date 2018/12/8 14:14
 * @Version 1.0
 */
public class WindControllerGuaranteeModel extends Entity<String> {

    @ApiModelProperty("担保单id")
    private String guaranteeId;

    @ApiModelProperty("审查表id")
    private String reviewId;

    @ApiModelProperty("业务编号")
    private String guaranteeNum;

    @ApiModelProperty("任务id")
    private String taskId;

    @ApiModelProperty("节点顺序")
    private Integer nodeOrder;

    @ApiModelProperty("业务类型")
    private String businessType;

    @ApiModelProperty("卖方")
    private List<OwnerModel> sellers;

    @ApiModelProperty("买方")
    private List<BuyModel> buyers;

//    @ApiModelProperty("卖方")
//    private List<String> seller;
//
//    @ApiModelProperty("买方")
//    private List<String> buyer;

    @ApiModelProperty("客户经理")
    private String accountManager;

    private String accountManagerId;

    @ApiModelProperty("客户经理所属部门")
    private String accountManagerOrg;


    @ApiModelProperty("房产证名称")
    private List<PropertyModel> propertyCertificateNames;

//    @ApiModelProperty("房产证名称")
//    private List<String> propertyCertificateName;

    @ApiModelProperty("担保金额")
    private Double guaranteeMoney;

    @ApiModelProperty("天数")//当前时间-上一节点完成时间（风控审批时间）
    private Integer days;

    @ApiModelProperty("审查时间 yyyy-MM-dd HH:mm")
    private String examinerReviewTime;//审查员审查时间

    @ApiModelProperty("报单日期 yyyy-MM-dd")
    private String policyDate;

    @ApiModelProperty("接收日期 yyyy-MM-dd")
    private String reveiceDate;

    @ApiModelProperty("是否接收")
    private Integer isReveice;

    @ApiModelProperty("打折申请状态 1:无需打折 2：有打折申请")
    private Integer discountStstus;

    @ApiModelProperty("打折申请编号")
    private String discountId;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
    }

    public List<PropertyModel> getPropertyCertificateNames() {
        return propertyCertificateNames;
    }

    public void setPropertyCertificateNames(List<PropertyModel> propertyCertificateNames) {
        this.propertyCertificateNames = propertyCertificateNames;
    }

    public String getAccountManagerOrg() {
        return accountManagerOrg;
    }

    public void setAccountManagerOrg(String accountManagerOrg) {
        this.accountManagerOrg = accountManagerOrg;
    }

    public String getAccountManagerId() {
        return accountManagerId;
    }

    public void setAccountManagerId(String accountManagerId) {
        this.accountManagerId = accountManagerId;
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

    public String getReveiceDate() {
        return reveiceDate;
    }

    public void setReveiceDate(String reveiceDate) {
        this.reveiceDate = reveiceDate;
    }

    public Integer getIsReveice() {
        return isReveice;
    }

    public void setIsReveice(Integer isReveice) {
        this.isReveice = isReveice;
    }

    public Integer getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(Integer nodeOrder) {
        this.nodeOrder = nodeOrder;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Integer getDiscountStstus() {
        return discountStstus;
    }

    public void setDiscountStstus(Integer discountStstus) {
        this.discountStstus = discountStstus;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }


    public String getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(String accountManager) {
        this.accountManager = accountManager;
    }

//    public List<String> getSeller() {
//        return seller;
//    }
//
//    public void setSeller(List<String> seller) {
//        this.seller = seller;
//    }
//
//    public List<String> getBuyer() {
//        return buyer;
//    }
//
//    public void setBuyer(List<String> buyer) {
//        this.buyer = buyer;
//    }
//
//    public List<String> getPropertyCertificateName() {
//        return propertyCertificateName;
//    }
//
//    public void setPropertyCertificateName(List<String> propertyCertificateName) {
//        this.propertyCertificateName = propertyCertificateName;
//    }

    public Double getGuaranteeMoney() {
        return guaranteeMoney;
    }

    public void setGuaranteeMoney(Double guaranteeMoney) {
        this.guaranteeMoney = guaranteeMoney;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getExaminerReviewTime() {
        return examinerReviewTime;
    }

    public void setExaminerReviewTime(String examinerReviewTime) {
        this.examinerReviewTime = examinerReviewTime;
    }

    public String getPolicyDate() {
        return policyDate;
    }

    public void setPolicyDate(String policyDate) {
        this.policyDate = policyDate;
    }

    @Override
    public String toString() {
        return "WindControllerGuaranteeModel{" +
                "guaranteeId='" + guaranteeId + '\'' +
                ", businessType='" + businessType + '\'' +
//                ", seller='" + seller + '\'' +
//                ", buyer='" + buyer + '\'' +
                ", accountManager='" + accountManager + '\'' +
//                ", propertyCertificateName='" + propertyCertificateName + '\'' +
                ", guaranteeMoney=" + guaranteeMoney +
                ", days=" + days +
                ", examinerReviewTime=" + examinerReviewTime +
                ", policyDate=" + policyDate +
                ", discountStstus='" + discountStstus + '\'' +
                ", discountId='" + discountId + '\'' +
                '}';
    }
}
