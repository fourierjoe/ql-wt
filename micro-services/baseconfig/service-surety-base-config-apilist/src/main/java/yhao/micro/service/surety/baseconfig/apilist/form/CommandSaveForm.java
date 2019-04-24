package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.CommandValidityTypeEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 10:34
 */
public class CommandSaveForm extends IdUnForm {
    @ApiModelProperty(value = "城市组织id", example = "string")
    private String orgId;
    @ApiModelProperty(value = "业务类型Id",example = "string")
    private String businessTypeId;
    @ApiModelProperty(value = "出赎楼歀银行ID",example = "string")
    private String redeemFundProviderId;
    @ApiModelProperty(value = "原贷款银行ID",example = "string")
    private String previousFundProviderId;
    @ApiModelProperty(value = "指令有效期类型，如：WORK_DAY",example = "WORK_DAY")
    private CommandValidityTypeEnum validityType;
    @ApiModelProperty(value = "天数",example = "5")
    private Integer dayCount;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;

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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
