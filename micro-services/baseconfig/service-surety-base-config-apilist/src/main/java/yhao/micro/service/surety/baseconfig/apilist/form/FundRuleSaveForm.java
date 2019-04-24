package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.InsuranceTypeEnum;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:资金方案管理保存/更新 Form
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 20:37
 */
public class FundRuleSaveForm extends IdUnForm {
    @ApiModelProperty(value = "资金方案名称",example = "资金方案")
    private String ruleName;
    @ApiModelProperty(value = "资金方id",example = "string")
    private String fundProviderId;
    @ApiModelProperty(value = "生效日期，格式：2018-11-29",example = "2018-11-29")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date effectiveDate;
    @ApiModelProperty(value = "失效日期，格式：2018-11-29",example = "2018-11-29")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;
    @ApiModelProperty(value = "利率",example = "3.20")
    private Double rate;
    @ApiModelProperty(value = "通道费率",example = "4.3")
    private Double channelRate;
    @ApiModelProperty(value = "保险费类型，如：FIXD",example = "FIXD")
    private InsuranceTypeEnum insuranceType;
    @ApiModelProperty(value = "保险费固定费率",example = "4.3")
    private Double fixInsuranceRate;
    @ApiModelProperty(value = "保险费分段费率json串，格式：[{min:起止天数，max:终止天数，rate:费率}]",example = "[{min:起止天数，max:终止天数，rate:费率}]")
    private String sectionInsuranceRateJson;
    @ApiModelProperty(value = "备注",example = "备注")
    private String remark;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用",example = "ENABLED")
    private CommonStatusEnum status;


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
}
