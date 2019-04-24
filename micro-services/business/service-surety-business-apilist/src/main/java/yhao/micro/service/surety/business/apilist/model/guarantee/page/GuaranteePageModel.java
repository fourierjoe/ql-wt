package yhao.micro.service.surety.business.apilist.model.guarantee.page;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/8 20:14
 * @Version: v1.0
 */
public class GuaranteePageModel extends Entity<String> {

    @ApiModelProperty("担保单编号")
    private String guaranteeNum;

    @ApiModelProperty("担保单关联单ID")
    private String kguaranteeId;

    @ApiModelProperty(value = "单据类型")
    private String guaranteeType;

    @ApiModelProperty("业务类型名称")
    private String businessName;

    @ApiModelProperty("房产名称")
    private List<EstatePageModel> estatePageModelList;

    @ApiModelProperty(value = "买卖方姓名")
    private List<ApplicationPersonModel> applicationPersonModelList;

    @ApiModelProperty(value = "担保金额")
    private BigDecimal guaranteeAmount;

    @ApiModelProperty(value = "借款金额")
    private BigDecimal loanTotalAmount;

    @ApiModelProperty(value = "实收担保费")
    private BigDecimal chargeRealGuaranteeFee;

    @ApiModelProperty(value = "当前节点名称")
    private String currentNodeName;

    @ApiModelProperty(value = "上一节点名称")
    private String previousNodeName;

    @ApiModelProperty(value = "收费情况")
    private String warrantyStatus;

    @ApiModelProperty("出赎楼款银行支行")
    private String redeemBankName;

    @ApiModelProperty("客户经理姓名")
    private String managerName;

    @ApiModelProperty("客户经理所属组织名称")
    private String orgName;

    @ApiModelProperty("房产证号")
    private String deedNum;

    @ApiModelProperty("来源")
    private String guaranteetSource;

    @ApiModelProperty("中介公司名称")
    private String agencyName;

    @ApiModelProperty("接受日期")
    private Date declarationDate;

    @ApiModelProperty(value = "是否已赎楼状态,用于判断页面是否显示 (撤单/驳回) 按钮")
    private String isRedeem;

    public String getKguaranteeId() {
        return kguaranteeId;
    }

    public void setKguaranteeId(String kguaranteeId) {
        this.kguaranteeId = kguaranteeId;
    }

    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getIsRedeem() {
        return isRedeem;
    }

    public void setIsRedeem(String isRedeem) {
        this.isRedeem = isRedeem;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public List<EstatePageModel> getEstatePageModelList() {
        return estatePageModelList;
    }

    public void setEstatePageModelList(List<EstatePageModel> estatePageModelList) {
        this.estatePageModelList = estatePageModelList;
    }

    public List<ApplicationPersonModel> getApplicationPersonModelList() {
        return applicationPersonModelList;
    }

    public void setApplicationPersonModelList(List<ApplicationPersonModel> applicationPersonModelList) {
        this.applicationPersonModelList = applicationPersonModelList;
    }

    public BigDecimal getGuaranteeAmount() {
        return guaranteeAmount;
    }

    public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public BigDecimal getChargeRealGuaranteeFee() {
        return chargeRealGuaranteeFee;
    }

    public void setChargeRealGuaranteeFee(BigDecimal chargeRealGuaranteeFee) {
        this.chargeRealGuaranteeFee = chargeRealGuaranteeFee;
    }

    public String getCurrentNodeName() {
        return currentNodeName;
    }

    public void setCurrentNodeName(String currentNodeName) {
        this.currentNodeName = currentNodeName;
    }

    public String getPreviousNodeName() {
        return previousNodeName;
    }

    public void setPreviousNodeName(String previousNodeName) {
        this.previousNodeName = previousNodeName;
    }

    public String getWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(String warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
    }

    public String getRedeemBankName() {
        return redeemBankName;
    }

    public void setRedeemBankName(String redeemBankName) {
        this.redeemBankName = redeemBankName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDeedNum() {
        return deedNum;
    }

    public void setDeedNum(String deedNum) {
        this.deedNum = deedNum;
    }

    public String getGuaranteetSource() {
        return guaranteetSource;
    }

    public void setGuaranteetSource(String guaranteetSource) {
        this.guaranteetSource = guaranteetSource;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public Date getDeclarationDate() {
        return declarationDate;
    }

    public void setDeclarationDate(Date declarationDate) {
        this.declarationDate = declarationDate;
    }
}
