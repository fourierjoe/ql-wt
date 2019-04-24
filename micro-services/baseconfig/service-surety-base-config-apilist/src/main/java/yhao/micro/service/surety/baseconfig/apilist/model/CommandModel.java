package yhao.micro.service.surety.baseconfig.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.baseconfig.apilist.enums.CommandValidityTypeEnum;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandSaveForm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 11:09
 */
public class CommandModel extends Entity<String> {
    private Mapper mapper = new DozerBeanMapper();
    @ApiModelProperty(value = "城市组织id", example = "string")
    private String orgId;
    @ApiModelProperty(value = "业务类型Id", example = "string")
    private String businessTypeId;
    @ApiModelProperty(value = "出赎楼歀银行ID", example = "string")
    private String redeemFundProviderId;
    @ApiModelProperty(value = "原贷款银行ID", example = "string")
    private String previousFundProviderId;
    @ApiModelProperty(value = "指令有效期类型，如：WORK_DAY", example = "WORK_DAY")
    private CommandValidityTypeEnum validityType;
    @ApiModelProperty(value = "天数", example = "5")
    private Integer dayCount;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;

    /*以下是非数据库字段，是关联表的冗余字段，查询时可关联带出值*/
    @ApiModelProperty(value = "业务类型名称", example = "string")
    private String businessTypeName;
    @ApiModelProperty(value = "出赎楼歀银行名称", example = "string")
    private String redeemFundProviderName;
    @ApiModelProperty(value = "原贷款银行名称", example = "string")
    private String previousFundProviderName;

    @ApiModelProperty(value = "状态中文描述", example = "启用")
    public String getStatusDesc() {
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

    @ApiModelProperty(value = "指令有效期类型中文描述", example = "工作日")
    public String getValidityTypeDesc() {
        return validityType != null ? validityType.getDesc() : "";
    }

    public CommandSaveForm toSaveForm() {
        return mapper.map(this, CommandSaveForm.class);
    }

    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(String businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public String getRedeemFundProviderId() {
        return redeemFundProviderId;
    }

    public void setRedeemFundProviderId(String redeemFundProviderId) {
        this.redeemFundProviderId = redeemFundProviderId;
    }

    public String getPreviousFundProviderId() {
        return previousFundProviderId;
    }

    public void setPreviousFundProviderId(String previousFundProviderId) {
        this.previousFundProviderId = previousFundProviderId;
    }

    public CommandValidityTypeEnum getValidityType() {
        return validityType;
    }

    public void setValidityType(CommandValidityTypeEnum validityType) {
        this.validityType = validityType;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public String getRedeemFundProviderName() {
        return redeemFundProviderName;
    }

    public void setRedeemFundProviderName(String redeemFundProviderName) {
        this.redeemFundProviderName = redeemFundProviderName;
    }

    public String getPreviousFundProviderName() {
        return previousFundProviderName;
    }

    public void setPreviousFundProviderName(String previousFundProviderName) {
        this.previousFundProviderName = previousFundProviderName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
