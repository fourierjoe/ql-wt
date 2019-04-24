package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.CommandValidityTypeEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 10:18
 */
public class CommandQueryForm extends PageForm {
    @ApiModelProperty(value = "城市组织id", example = "string")
    private String orgId;
    @ApiModelProperty(value = "id",example = "string",hidden = true)
    private String id;
    @ApiModelProperty(value = "业务类型ID",example = "string")
    private String businessTypeId;
    @ApiModelProperty(value = "出赎楼歀银行名称，模糊查询",example = "string")
    private String redeemFundProviderName;
    @ApiModelProperty(value = "原贷款银行名称，模糊查询",example = "string")
    private String previousFundProviderName;
    @ApiModelProperty(value = "指令有效期类型，如：WORK_DAY",example = "WORK_DAY",hidden = true)
    private CommandValidityTypeEnum validityType;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用",example = "ENABLED")
    private CommonStatusEnum status;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(String businessTypeId) {
        this.businessTypeId = businessTypeId;
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

    public CommandValidityTypeEnum getValidityType() {
        return validityType;
    }

    public void setValidityType(CommandValidityTypeEnum validityType) {
        this.validityType = validityType;
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
