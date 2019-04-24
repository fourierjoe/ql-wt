package yhao.micro.service.surety.baseconfig.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.baseconfig.apilist.enums.InsuranceTypeEnum;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleSaveForm;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:资金方案管理模型 Model
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 20:45
 */
public class FundRuleModel extends Entity<String> {
    private Mapper mapper = new DozerBeanMapper();

    @ApiModelProperty(value = "资金方案名称",example = "资金方案")
    private String ruleName;
    @ApiModelProperty(value = "资金方id",example = "string")
    private String fundProviderId;
    @ApiModelProperty(value = "生效日期",example = "2018-11-29")
    private Date effectiveDate;
    @ApiModelProperty(value = "失效日期",example = "2018-11-29")
    private Date expirationDate;
    @ApiModelProperty(value = "利率",example = "3.20")
    private Double rate;
    @ApiModelProperty(value = "通道费率",example = "4.3")
    private Double channelRate;
    @ApiModelProperty(value = "保险费类型",example = "FIXD")
    private InsuranceTypeEnum insuranceType;
    @ApiModelProperty(value = "保险费固定费率",example = "4.3")
    private Double fixInsuranceRate;
    @ApiModelProperty(value = "保险费分段费率json串",example = "[{min:起止天数，max:终止天数，rate:费率}]")
    private String sectionInsuranceRateJson;
    @ApiModelProperty(value = "备注",example = "备注")
    private String remark;
    @ApiModelProperty(value = "状态",example = "ENABLED")
    private CommonStatusEnum status;

    /*以下是非数据库字段，是关联表的冗余字段，查询时可关联带出值*/
    @ApiModelProperty(value = "资金方名称",example = "中国人民银行")
    private String fundProviderName;

    @ApiModelProperty(value = "保险费类型中文描述", example = "固定费率")
    public String getInsuranceTypeDesc(){
        return insuranceType != null ? insuranceType.getDesc() : "";
    }

    @ApiModelProperty(value = "状态中文描述", example = "启用")
    public String getStatusDesc(){
        if(status==null){
            return "";
        }
        if(status==CommonStatusEnum.ENABLED){
            return "启用";
        }
        if(status==CommonStatusEnum.DISABLED){
            return "禁用";
        }
        return "";
    }

    public FundRuleSaveForm toSaveForm() {
        return mapper.map(this, FundRuleSaveForm.class);
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getFundProviderId() {
        return fundProviderId;
    }

    public void setFundProviderId(String fundProviderId) {
        this.fundProviderId = fundProviderId;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getChannelRate() {
        return channelRate;
    }

    public void setChannelRate(Double channelRate) {
        this.channelRate = channelRate;
    }

    public InsuranceTypeEnum getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceTypeEnum insuranceType) {
        this.insuranceType = insuranceType;
    }

    public Double getFixInsuranceRate() {
        return fixInsuranceRate;
    }

    public void setFixInsuranceRate(Double fixInsuranceRate) {
        this.fixInsuranceRate = fixInsuranceRate;
    }

    public String getSectionInsuranceRateJson() {
        return sectionInsuranceRateJson;
    }

    public void setSectionInsuranceRateJson(String sectionInsuranceRateJson) {
        this.sectionInsuranceRateJson = sectionInsuranceRateJson;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public String getFundProviderName() {
        return fundProviderName;
    }

    public void setFundProviderName(String fundProviderName) {
        this.fundProviderName = fundProviderName;
    }
}
