package yhao.micro.service.surety.business.apilist.form.businessType;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.apilist.validate.decimalrange.DecimalRange;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.FundTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.TransactionTypeEnum;
import yhao.micro.service.workflow.apilist.form.flow.processBussiness.BizFlowProcessDefinitionForm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Description:
 * @Auther: ql
 * @Date: 2018/12/8 18:12
 */
public class BusinessTypeSaveForm extends IdUnForm {

    @ApiModelProperty(value = "城市id")
    @NotBlank(message = "城市id不得为空")
    private String orgId;

    @ApiModelProperty(value = "流程业务码", hidden = true)
    private String workflowBizCode;

    @ApiModelProperty(value = "资金分类,AMOUNT=额度/CASH=现金", required = true, example = "AMOUNT")
    @NotNull(message = "资金分类不得为空")
    private FundTypeEnum fundType;

    @ApiModelProperty(value = "交易类型,TRANSACTION=交易类/NOT_TRANSACTION=非交易类", required = true, example = "TRANSACTION")
    @NotNull(message = "交易类型不得为空")
    private TransactionTypeEnum transactionType;

    @ApiModelProperty(value = "业务类型名称", required = true)
    @NotBlank(message = "业务类型名称不得为空")
    private String businessName;

    @ApiModelProperty(value = "启用状态,ENABLED=启用，DISABLED=禁用", required = true, example = "ENABLED")
    @NotNull(message = "启用状态不得为空")
    private CommonStatusEnum state;

    @ApiModelProperty(value = "最低应收费用", required = true)
    @NotNull(message = "最低应收费用不得为空")
    private BigDecimal minCharge;

    @ApiModelProperty(value = "最低对外费率", required = true)
    @NotNull(message = "最低对外费率不得为空")
    @DecimalRange(message = "最低对外费率数据范围不通过", scale = 2, min = 0.01, max = 100)
    private BigDecimal minExternalRate;

    @ApiModelProperty(value = "最低实收费率", required = true)
    @NotNull(message = "最低实收费率不得为空")
    @DecimalRange(message = "最低实收费率数据范围不通过", scale = 2, min = 0.01, max = 100)
    private BigDecimal minRealRate;

    @ApiModelProperty(value = "最低实收费用", required = true)
    @NotNull(message = "最低实收费用不得为空")
    private BigDecimal minRealFee;

    @ApiModelProperty(value = "是否需二次还款", required = true)
    @NotNull(message = "是否需二次还款不得为空")
    private YNEnum isTwiceRepay;

    @ApiModelProperty(value = "是否自赎业务", required = true)
    @NotNull(message = "是否自赎业务不得为空")
    private YNEnum isRedeemselfBiz;

    @ApiModelProperty(value = "逾期费率JSON", required = true, example = "[{overdueDays:逾期天数，rate:费率}]")
    @NotBlank(message = "逾期费率JSON不得为空")
    private String overdueRateJson;

    @ApiModelProperty(value = "资料JSON", required = true, example = "[{materialId：资料id，name:资料名字, checked:boolean, weight:number, count：数量}]")
    @NotBlank(message = "资料JSON不得为空")
    private String materialJson;

    @ApiModelProperty(value = "是否符合监管", required = true, example = "YES")
    @NotNull(message = "是否符合监管不得为空")
    private YNEnum satisfySupervision;

    @ApiModelProperty(value = "流程配置", required = true)
    @Valid
    @NotNull(message = "流程配置不得为空")
    private BizFlowProcessDefinitionForm bizFlowProcessDefinitionForm;

    public BizFlowProcessDefinitionForm getBizFlowProcessDefinitionForm() {
        return bizFlowProcessDefinitionForm;
    }

    public void setBizFlowProcessDefinitionForm(BizFlowProcessDefinitionForm bizFlowProcessDefinitionForm) {
        this.bizFlowProcessDefinitionForm = bizFlowProcessDefinitionForm;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getWorkflowBizCode() {
        return workflowBizCode;
    }

    public void setWorkflowBizCode(String workflowBizCode) {
        this.workflowBizCode = workflowBizCode;
    }

    public FundTypeEnum getFundType() {
        return fundType;
    }

    public void setFundType(FundTypeEnum fundType) {
        this.fundType = fundType;
    }

    public TransactionTypeEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public CommonStatusEnum getState() {
        return state;
    }

    public void setState(CommonStatusEnum state) {
        this.state = state;
    }

    public BigDecimal getMinCharge() {
        return minCharge;
    }

    public void setMinCharge(BigDecimal minCharge) {
        this.minCharge = minCharge;
    }

    public BigDecimal getMinExternalRate() {
        return minExternalRate;
    }

    public void setMinExternalRate(BigDecimal minExternalRate) {
        this.minExternalRate = minExternalRate;
    }

    public BigDecimal getMinRealRate() {
        return minRealRate;
    }

    public void setMinRealRate(BigDecimal minRealRate) {
        this.minRealRate = minRealRate;
    }

    public BigDecimal getMinRealFee() {
        return minRealFee;
    }

    public void setMinRealFee(BigDecimal minRealFee) {
        this.minRealFee = minRealFee;
    }

    public YNEnum getIsTwiceRepay() {
        return isTwiceRepay;
    }

    public void setIsTwiceRepay(YNEnum isTwiceRepay) {
        this.isTwiceRepay = isTwiceRepay;
    }

    public YNEnum getIsRedeemselfBiz() {
        return isRedeemselfBiz;
    }

    public void setIsRedeemselfBiz(YNEnum isRedeemselfBiz) {
        this.isRedeemselfBiz = isRedeemselfBiz;
    }

    public String getOverdueRateJson() {
        return overdueRateJson;
    }

    public void setOverdueRateJson(String overdueRateJson) {
        this.overdueRateJson = overdueRateJson;
    }

    public String getMaterialJson() {
        return materialJson;
    }

    public void setMaterialJson(String materialJson) {
        this.materialJson = materialJson;
    }

    public YNEnum getSatisfySupervision() {
        return satisfySupervision;
    }

    public void setSatisfySupervision(YNEnum satisfySupervision) {
        this.satisfySupervision = satisfySupervision;
    }
}
