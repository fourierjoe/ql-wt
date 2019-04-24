package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @auther: yuanxy
 * @date: 2018/12/10 11:42
 * @description:综合管理列表返回基类
 */
public class RedemptionBaseResultForm {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("业务类型名称")
    private String bizName;

    @ApiModelProperty("房产名称")
    private String estateName;
    @ApiModelProperty("客户经理姓名")
    private String managerName;

    @ApiModelProperty("房产证号")
    private String deedNum;
    @ApiModelProperty("买方")
    private String buyerName;
    @ApiModelProperty("卖方")
    private String sellerName;
    @ApiModelProperty(value = "担保金额")
    private BigDecimal guaranteeAmount;
    @ApiModelProperty(value = "二次归档")
    private String secondArchive;
    @ApiModelProperty(value = "三次归档")
    private String thirdArchive;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public String getBizName() {
        return bizName;
    }

    public void setBizName(String bizName) {
        this.bizName = bizName;
    }

    public String getEstateName() {
        return estateName;
    }

    public void setEstateName(String estateName) {
        this.estateName = estateName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getDeedNum() {
        return deedNum;
    }

    public void setDeedNum(String deedNum) {
        this.deedNum = deedNum;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public BigDecimal getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    public String getSecondArchive() {
        return secondArchive;
    }

    public void setSecondArchive(String secondArchive) {
        this.secondArchive = secondArchive;
    }

    public String getThirdArchive() {
        return thirdArchive;
    }

    public void setThirdArchive(String thirdArchive) {
        this.thirdArchive = thirdArchive;
    }
}
