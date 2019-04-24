package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * @Description 担保单操作历史记录model
 *
 * @Author leice
 * @Date 2018/12/10 15:20
 * @Version 1.0
 */
public class OperatingRecordListModel extends Entity<String> {

    @ApiModelProperty("修改日期")
    private Date updateDate;

    @ApiModelProperty("修改人")
    private String updatePeople;

    @ApiModelProperty("业务类别")
    private String businessType;

    @ApiModelProperty("物业")
    private String property;

    @ApiModelProperty("卖方")
    private String owner;

    @ApiModelProperty("买方")
    private String buyer;

    @ApiModelProperty("担保金额")
    private String guaranteeMoney;

    @ApiModelProperty("应收担保费")
    private String securityFeeReceivable;

    @ApiModelProperty("实收担保费")
    private String paidGuaranteeFee;

    @ApiModelProperty("处理节点")
    private String dealNode;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdatePeople() {
        return updatePeople;
    }

    public void setUpdatePeople(String updatePeople) {
        this.updatePeople = updatePeople;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getGuaranteeMoney() {
        return guaranteeMoney;
    }

    public void setGuaranteeMoney(String guaranteeMoney) {
        this.guaranteeMoney = guaranteeMoney;
    }

    public String getSecurityFeeReceivable() {
        return securityFeeReceivable;
    }

    public void setSecurityFeeReceivable(String securityFeeReceivable) {
        this.securityFeeReceivable = securityFeeReceivable;
    }

    public String getPaidGuaranteeFee() {
        return paidGuaranteeFee;
    }

    public void setPaidGuaranteeFee(String paidGuaranteeFee) {
        this.paidGuaranteeFee = paidGuaranteeFee;
    }

    public String getDealNode() {
        return dealNode;
    }

    public void setDealNode(String dealNode) {
        this.dealNode = dealNode;
    }

    @Override
    public String toString() {
        return "OperatingRecordListModel{" +
                "updateDate=" + updateDate +
                ", updatePeople='" + updatePeople + '\'' +
                ", businessType='" + businessType + '\'' +
                ", property='" + property + '\'' +
                ", owner='" + owner + '\'' +
                ", buyer='" + buyer + '\'' +
                ", guaranteeMoney='" + guaranteeMoney + '\'' +
                ", securityFeeReceivable='" + securityFeeReceivable + '\'' +
                ", paidGuaranteeFee='" + paidGuaranteeFee + '\'' +
                ", dealNode='" + dealNode + '\'' +
                '}';
    }
}
