package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.GuaranteeStateEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.GuaranteeTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.GuaranteetSourceEnum;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @Description:    担保单信息
 *
 * @Auther: ql
 * @Date: 2018-12-8 16:20:23
 */
public class GuaranteeSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单编号", hidden = true)
    private String guaranteeNum;

    @ApiModelProperty(value = "意向单是否提交, 保存 = NO, 提交 = YES, 只用于意向单保存映射到该字段", hidden = true)
    private YNEnum isSubmit = YNEnum.YES;

    @ApiModelProperty(value = "城市组织ID", example = "orgId", required = true)
    @NotBlank(message = "城市组织ID必传")
    private String orgId;

    @ApiModelProperty(value = "交易编码(关联的交易编号【内单需要】), 保留字段", hidden = true)
    private String internalId;

    @ApiModelProperty(value = "关联担保单号")
    private String guaranteeId;

    @ApiModelProperty(value = "业务类型ID", example = "b20a5d06-6813-48aa-8599-24ffeba4c950", required = true)
    @NotBlank(message = "业务类型ID必传")
    private String bizId;

    @ApiModelProperty(value = "担保单状态", example = "")
    private GuaranteeStateEnum guaranteeState;

    @ApiModelProperty(value = "单据类型", example = "EXTERNAL")
    private GuaranteeTypeEnum guaranteeType;

    @ApiModelProperty(value = "银行主合同编号", hidden = true)
    private String bankContractNum;

    @ApiModelProperty(value = "来源：银行，中介，朋友", example = "BANK", required = true)
    @NotNull(message = "来源必传")
    private GuaranteetSourceEnum guaranteetSource;

    @ApiModelProperty(value = "中介公司名称", example = "中介公司名称")
    private String agencyName;

    @ApiModelProperty(value = "跟单员ID")
    private String followerId;

    @ApiModelProperty(value = "征信专员ID")
    private String creditClerkId;

    @ApiModelProperty(value = "报单员ID")
    private String declarerId;

    @ApiModelProperty(value = "还款申请办理人ID")
    private String redeemId;

    @ApiModelProperty(value = "资料转交赎楼员时间",example = "2018-12-25")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataTransferDate;

    @ApiModelProperty(value = "是否已报单", example = "NO")
    private YNEnum isDeclare;

    @ApiModelProperty(value = "跟单员接收状态")
    private YNEnum receiveState;

    @ApiModelProperty(value = "跟单员转单状态")
    private YNEnum transferState;

    @ApiModelProperty(value = "查询征信状态")
    private String creditState;

    @ApiModelProperty(value = "还款申请状态")
    private String repayState;

    @ApiModelProperty(value = "征信是否报送", example = "NO")
    private YNEnum isCreditReport;

    @ApiModelProperty(value = "跟单员意见", example = "跟单员意见")
    private String dealmanRemark;

    public YNEnum getReceiveState() {
        return receiveState;
    }

    public YNEnum getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(YNEnum isSubmit) {
        this.isSubmit = isSubmit;
    }

    public YNEnum getTransferState() {
        return transferState;
    }

    public void setTransferState(YNEnum transferState) {
        this.transferState = transferState;
    }

    public void setReceiveState(YNEnum receiveState) {
        this.receiveState = receiveState;
    }

    public String getGuaranteeNum() {
        return guaranteeNum;
    }

    public void setGuaranteeNum(String guaranteeNum) {
        this.guaranteeNum = guaranteeNum;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public GuaranteeStateEnum getGuaranteeState() {
        return guaranteeState;
    }

    public void setGuaranteeState(GuaranteeStateEnum guaranteeState) {
        this.guaranteeState = guaranteeState;
    }

    public GuaranteeTypeEnum getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(GuaranteeTypeEnum guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    public String getBankContractNum() {
        return bankContractNum;
    }

    public void setBankContractNum(String bankContractNum) {
        this.bankContractNum = bankContractNum;
    }

    public GuaranteetSourceEnum getGuaranteetSource() {
        return guaranteetSource;
    }

    public void setGuaranteetSource(GuaranteetSourceEnum guaranteetSource) {
        this.guaranteetSource = guaranteetSource;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getFollowerId() {
        return followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    public String getCreditClerkId() {
        return creditClerkId;
    }

    public void setCreditClerkId(String creditClerkId) {
        this.creditClerkId = creditClerkId;
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

    public Date getDataTransferDate() {
        return dataTransferDate;
    }

    public void setDataTransferDate(Date dataTransferDate) {
        this.dataTransferDate = dataTransferDate;
    }

    public YNEnum getIsDeclare() {
        return isDeclare;
    }

    public void setIsDeclare(YNEnum isDeclare) {
        this.isDeclare = isDeclare;
    }

    public String getCreditState() {
        return creditState;
    }

    public void setCreditState(String creditState) {
        this.creditState = creditState;
    }

    public String getRepayState() {
        return repayState;
    }

    public void setRepayState(String repayState) {
        this.repayState = repayState;
    }

    public YNEnum getIsCreditReport() {
        return isCreditReport;
    }

    public void setIsCreditReport(YNEnum isCreditReport) {
        this.isCreditReport = isCreditReport;
    }

    public String getDealmanRemark() {
        return dealmanRemark;
    }

    public void setDealmanRemark(String dealmanRemark) {
        this.dealmanRemark = dealmanRemark;
    }
}
