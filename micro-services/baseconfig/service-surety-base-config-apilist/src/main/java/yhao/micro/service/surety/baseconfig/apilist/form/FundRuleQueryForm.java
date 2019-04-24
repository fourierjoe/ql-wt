package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.InsuranceTypeEnum;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:资金方案管理查询 Form
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 20:24
 */
public class FundRuleQueryForm extends PageForm {
    @ApiModelProperty(value = "资金方案名称，模糊查询", example = "资金方案")
    private String ruleName;
    @ApiModelProperty(value = "资金方名称，模糊查询", example = "中国人民银行")
    private String fundProviderName;
    @ApiModelProperty(value = "最小生效日期,格式：2018-11-24", example = "2018-11-24")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minEffectiveDate;
    @ApiModelProperty(value = "最大生效日期,格式：2018-11-24", example = "2018-11-24")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxEffectiveDate;
    @ApiModelProperty(value = "最小失效日期,格式：2018-11-24", example = "2018-11-24")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minExpirationDate;
    @ApiModelProperty(value = "最大失效日期,格式：2018-11-24", example = "2018-11-24")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxExpirationDate;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;
    @ApiModelProperty(value = "最小利率", example = "3.98", hidden = true)
    private Double minRate;
    @ApiModelProperty(value = "最大利率", example = "6.90", hidden = true)
    private Double maxRate;
    @ApiModelProperty(value = "是否有通道费率", example = "true", hidden = true)
    private Boolean hasChannelRate;
    @ApiModelProperty(value = "保险费类型", example = "FIXD", hidden = true)
    private InsuranceTypeEnum insuranceType;
    @ApiModelProperty(value = "资金方案id", example = "string", hidden = true)
    private String id;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getFundProviderName() {
        return fundProviderName;
    }

    public void setFundProviderName(String fundProviderName) {
        this.fundProviderName = fundProviderName;
    }

    public Date getMinEffectiveDate() {
        return minEffectiveDate;
    }

    public void setMinEffectiveDate(Date minEffectiveDate) {
        this.minEffectiveDate = minEffectiveDate;
    }

    public Date getMaxEffectiveDate() {
        return maxEffectiveDate;
    }

    public void setMaxEffectiveDate(Date maxEffectiveDate) {
        this.maxEffectiveDate = maxEffectiveDate;
    }

    public Date getMinExpirationDate() {
        return minExpirationDate;
    }

    public void setMinExpirationDate(Date minExpirationDate) {
        this.minExpirationDate = minExpirationDate;
    }

    public Date getMaxExpirationDate() {
        return maxExpirationDate;
    }

    public void setMaxExpirationDate(Date maxExpirationDate) {
        this.maxExpirationDate = maxExpirationDate;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public Double getMinRate() {
        return minRate;
    }

    public void setMinRate(Double minRate) {
        this.minRate = minRate;
    }

    public Double getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(Double maxRate) {
        this.maxRate = maxRate;
    }

    public Boolean getHasChannelRate() {
        return hasChannelRate;
    }

    public void setHasChannelRate(Boolean hasChannelRate) {
        this.hasChannelRate = hasChannelRate;
    }

    public InsuranceTypeEnum getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(InsuranceTypeEnum insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
