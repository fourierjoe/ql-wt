package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeStatusEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/9 10:54
 * @Version: v1.0
 */
public class GuaranteeQueryPageForm extends PageForm {

    @ApiModelProperty(value = "组织ID",required = true)
    @NotBlank(message = "组织ID不得为空")
    private String orgId;

    @ApiModelProperty(value = "人员ERPID")
    private String managerId;

    @ApiModelProperty(value = "业务类型ID")
    private List<String> bizIdList;

    @ApiModelProperty(value = "已办理节点")
    private String dealedNode;

    @ApiModelProperty(value = "未办理节点")
    private String noDealNode;

    // T_SURETY_TOLL_GENERAL表
    @ApiModelProperty(value = "收费情况")
    private ChargeStatusEnum warrantyStatus;

    @ApiModelProperty(value = "单据类型",example = "内单/外单")
    private GuaranteeTypeEnum guaranteeType;

    //T_SURETY_G_ESTATE_SELLER
    @ApiModelProperty(value = "建模状态")
    private ModelEnum isModeling;

    @ApiModelProperty(value = "资金状态")
    private BundTypeEnum fundType;

    @ApiModelProperty(value = "日期类型", example = "赎楼日期/放款日期/注销日期..")
    private GuaranteeDateTypeEnum dateType;

    @ApiModelProperty(value = "日期类型所在表", hidden = true)
    private String dateTypeTable;

    @ApiModelProperty(value = "日期类型对应字段", hidden = true)
    private String dateTypeColumn;

    @ApiModelProperty(value = "开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    // 单据号,物业,买卖双方,房产证号
    @ApiModelProperty(value = "单据号,物业,买卖双方,房产证号")
    private String mix;

    @ApiModelProperty(value = "来源")
    private GuaranteetSourceEnum guaranteetSource;

    //T_SURETY_G_GUARANTEE_SITUATION
    @ApiModelProperty(value = "担保最小金额")
    private BigDecimal guaranteeAmountMin;

    @ApiModelProperty(value = "担保最大金额")
    private BigDecimal guaranteeAmountMax;

    @ApiModelProperty(value = "银行类型", example = "原按揭银行/出赎楼款银行..")
    private GuaranteeBankTypeEnum bankType;

    @ApiModelProperty(value = "银行类型所在表", hidden = true)
    private String bankTypeTable;

    @ApiModelProperty(value = "银行类型对应字段", hidden = true)
    private String bankTypeColumn;

    @ApiModelProperty(value = "银行id")
    private String bankId;

    @ApiModelProperty(value = "驻点员id")
    private String zhuDianId;

    @ApiModelProperty(value = "审查员id")
    private String examinerId;

    @ApiModelProperty(value = "跟单员id")
    private String followerId;

    @ApiModelProperty(value = "报单员id")
    private String declarerId;

    @ApiModelProperty(value = "赎楼员id")
    private String redeemId;

    @ApiModelProperty(value = "审查开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkStartDate;

    @ApiModelProperty(value = "审查结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkEndDate;

    @ApiModelProperty(value = "征信数据是否报送", example = "YES/NO")
    private YNEnum isCreditReport;

    public String getZhuDianId() {
        return zhuDianId;
    }

    public void setZhuDianId(String zhuDianId) {
        this.zhuDianId = zhuDianId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public List<String> getBizIdList() {
        return bizIdList;
    }

    public void setBizIdList(List<String> bizIdList) {
        this.bizIdList = bizIdList;
    }

    public String getDealedNode() {
        return dealedNode;
    }

    public void setDealedNode(String dealedNode) {
        this.dealedNode = dealedNode;
    }

    public String getNoDealNode() {
        return noDealNode;
    }

    public void setNoDealNode(String noDealNode) {
        this.noDealNode = noDealNode;
    }

    public ChargeStatusEnum getWarrantyStatus() {
        return warrantyStatus;
    }

    public void setWarrantyStatus(ChargeStatusEnum warrantyStatus) {
        this.warrantyStatus = warrantyStatus;
    }

    public GuaranteeTypeEnum getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(GuaranteeTypeEnum guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public ModelEnum getIsModeling() {
        return isModeling;
    }

    public void setIsModeling(ModelEnum isModeling) {
        this.isModeling = isModeling;
    }

    public GuaranteeDateTypeEnum getDateType() {
        return dateType;
    }

    public void setDateType(GuaranteeDateTypeEnum dateType) {
        this.dateType = dateType;
    }

    public String getDateTypeTable() {
        return dateTypeTable;
    }

    public void setDateTypeTable(String dateTypeTable) {
        if (dateType != null) {
            this.dateTypeTable = dateType.toString().split("999")[0];
        }
    }

    public String getDateTypeColumn() {
        return dateTypeColumn;
    }

    public void setDateTypeColumn(String dateTypeColumn) {
        if (dateType != null) {
            this.dateTypeColumn = dateType.toString().split("999")[1];
        }
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMix() {
        return mix;
    }

    public void setMix(String mix) {
        this.mix = mix;
    }

    public GuaranteetSourceEnum getGuaranteetSource() {
        return guaranteetSource;
    }

    public void setGuaranteetSource(GuaranteetSourceEnum guaranteetSource) {
        this.guaranteetSource = guaranteetSource;
    }

    public BigDecimal getGuaranteeAmountMin() {
        return guaranteeAmountMin;
    }

    public void setGuaranteeAmountMin(BigDecimal guaranteeAmountMin) {
        this.guaranteeAmountMin = guaranteeAmountMin;
    }

    public BigDecimal getGuaranteeAmountMax() {
        return guaranteeAmountMax;
    }

    public void setGuaranteeAmountMax(BigDecimal guaranteeAmountMax) {
        this.guaranteeAmountMax = guaranteeAmountMax;
    }

    public GuaranteeBankTypeEnum getBankType() {
        return bankType;
    }

    public void setBankType(GuaranteeBankTypeEnum bankType) {
        this.bankType = bankType;
    }

    public String getBankTypeTable() {
        return bankTypeTable;
    }

    public void setBankTypeTable(String bankTypeTable) {
        if (bankType != null) {
            this.bankTypeTable = bankType.toString().split("999")[0];
        }
    }

    public String getBankTypeColumn() {
        return bankTypeColumn;
    }

    public void setBankTypeColumn(String bankTypeColumn) {
        if (bankType != null) {
            this.bankTypeColumn = bankType.toString().split("999")[1];
        }
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getExaminerId() {
        return examinerId;
    }

    public void setExaminerId(String examinerId) {
        this.examinerId = examinerId;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    public String getDeclarerId() {
        return declarerId;
    }

    public void setDeclarerId(String declarerId) {
        this.declarerId = declarerId;
    }

    public String getRedeemId() {
        return redeemId;
    }

    public void setRedeemId(String redeemId) {
        this.redeemId = redeemId;
    }

    public Date getCheckStartDate() {
        return checkStartDate;
    }

    public void setCheckStartDate(Date checkStartDate) {
        this.checkStartDate = checkStartDate;
    }

    public Date getCheckEndDate() {
        return checkEndDate;
    }

    public void setCheckEndDate(Date checkEndDate) {
        this.checkEndDate = checkEndDate;
    }

    public YNEnum getIsCreditReport() {
        return isCreditReport;
    }

    public void setIsCreditReport(YNEnum isCreditReport) {
        this.isCreditReport = isCreditReport;
    }

    public BundTypeEnum getFundType() {
        return fundType;
    }

    public void setFundType(BundTypeEnum fundType) {
        this.fundType = fundType;
    }
}
