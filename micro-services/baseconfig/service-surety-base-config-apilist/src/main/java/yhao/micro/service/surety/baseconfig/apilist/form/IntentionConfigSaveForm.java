package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.IntentionPositionTypeEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:单据分配设置保存/更新 Form
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 14:07
 */
public class IntentionConfigSaveForm extends IdUnForm {
    @ApiModelProperty(value = "组织ID", example = "string")
    private String orgId;
    @ApiModelProperty(value = "岗位类型，如：FOLLOWER", example = "FOLLOWER")
    private IntentionPositionTypeEnum positionType;
    @ApiModelProperty(value = "跟单员或者报单员的账号id", example = "string")
    private String personId;
    @ApiModelProperty(value = "负责的部门组织ID串，用,隔开", example = "string")
    private String responsibleOrgIds;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public IntentionPositionTypeEnum getPositionType() {
        return positionType;
    }

    public void setPositionType(IntentionPositionTypeEnum positionType) {
        this.positionType = positionType;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getResponsibleOrgIds() {
        return responsibleOrgIds;
    }

    public void setResponsibleOrgIds(String responsibleOrgIds) {
        this.responsibleOrgIds = responsibleOrgIds;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }
}
