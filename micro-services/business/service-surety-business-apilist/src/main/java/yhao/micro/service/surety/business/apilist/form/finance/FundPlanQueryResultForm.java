package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PlanStatusEnum;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.EstatePageModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 19:33
 * @Description:
 */
public class FundPlanQueryResultForm   {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("经办人")
    private String managerName;
    @ApiModelProperty("业主")
    private String sellerName;
    @ApiModelProperty("借款金额")
    private BigDecimal loanTotalAmount;
    @ApiModelProperty("预计用款时间")
    private Date planUseDate;
    @ApiModelProperty("借款天数")
    private String loanDays;
    @ApiModelProperty("进度")
    private PlanStatusEnum status;
    @ApiModelProperty("原按揭银行")
    private  String bankName;
    @ApiModelProperty("报单时间")
    private Date declarationDate;
    @ApiModelProperty("担保单编号")
    private String guaranteeNum;
    @ApiModelProperty("业务类型名称")
    private String businessName;
    @ApiModelProperty("房产名称")
    private List<EstatePageModel> estatePageModelList;
    @ApiModelProperty("业务编码")
    private String workflowBizCode;
    @ApiModelProperty("手续费")
    private BigDecimal charges;
    @ApiModelProperty("咨询费")
    private BigDecimal chargeLittle;
    @ApiModelProperty("应收合计")
    private BigDecimal chargeTotal;
    @ApiModelProperty("申请人")
    private  String guaranteeApplicantIds;
    @ApiModelProperty("审查员意见")
    private String review;



    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public BigDecimal getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(BigDecimal loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public Date getPlanUseDate() {
        return planUseDate;
    }

    public void setPlanUseDate(Date planUseDate) {
        this.planUseDate = planUseDate;
    }

    public String getLoanDays() {
        return loanDays;
    }

    public void setLoanDays(String loanDays) {
        this.loanDays = loanDays;
    }

    public PlanStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PlanStatusEnum status) {
        this.status = status;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Date getDeclarationDate() {
        return declarationDate;
    }

    public void setDeclarationDate(Date declarationDate) {
        this.declarationDate = declarationDate;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
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

    public String getWorkflowBizCode() {
        return workflowBizCode;
    }

    public void setWorkflowBizCode(String workflowBizCode) {
        this.workflowBizCode = workflowBizCode;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public BigDecimal getChargeLittle() {
        return chargeLittle;
    }

    public void setChargeLittle(BigDecimal chargeLittle) {
        this.chargeLittle = chargeLittle;
    }

    public BigDecimal getChargeTotal() {
        return chargeTotal;
    }

    public void setChargeTotal(BigDecimal chargeTotal) {
        this.chargeTotal = chargeTotal;
    }


    public String getGuaranteeApplicantIds() {
        return guaranteeApplicantIds;
    }

    public void setGuaranteeApplicantIds(String guaranteeApplicantIds) {
        this.guaranteeApplicantIds = guaranteeApplicantIds;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getReview() {
        return review;
    }
}
