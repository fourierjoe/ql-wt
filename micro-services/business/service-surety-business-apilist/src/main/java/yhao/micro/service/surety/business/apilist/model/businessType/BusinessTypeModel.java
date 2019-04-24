package yhao.micro.service.surety.business.apilist.model.businessType;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.FundTypeEnum;
import yhao.micro.service.surety.business.apilist.model.enums.businessType.TransactionTypeEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 *
 * @Created by ql on 2018/12/8 19:09
 * @Version: v1.0
 */
public class BusinessTypeModel extends Entity<String> {

    @ApiModelProperty(value = "城市id")
    private String orgId;

    @ApiModelProperty(value = "流程业务码")
    private String workflowBizCode;

    @ApiModelProperty(value = "资金分类,AMOUNT=额度/CASH=现金")
    private FundTypeEnum fundType;

    @ApiModelProperty(value = "交易类型,TRANSACTION=交易类/NOT_TRANSACTION=非交易类")
    private TransactionTypeEnum transactionType;

    @ApiModelProperty(value = "业务类型名称")
    private String businessName;

    @ApiModelProperty(value = "启用状态,ENABLE=启用，DISABLE=禁用")
    private CommonStatusEnum state;

    @ApiModelProperty(value = "最低应收费用")
    private BigDecimal minCharge;

    @ApiModelProperty(value = "最低对外费率")
    private BigDecimal minExternalRate;

    @ApiModelProperty(value = "最低实收费率")
    private BigDecimal minRealRate;

    @ApiModelProperty(value = "最低实收费用")
    private BigDecimal minRealFee;

    @ApiModelProperty(value = "是否需二次还款")
    private YNEnum isTwiceRepay;

    @ApiModelProperty(value = "是否自赎业务")
    private YNEnum isRedeemselfBiz;

    @ApiModelProperty(value = "逾期费率JSON", example = "[{min:起止天数，max:终止天数，rate:费率}]")
    private String overdueRateJson;

    @ApiModelProperty(value = "资料JSON", example = "[{materialId：资料id，count：数量，order：顺序}]")
    private String materialJson;

    @ApiModelProperty(value = "是否符合监管", example = "YES")
    private YNEnum satisfySupervision;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
