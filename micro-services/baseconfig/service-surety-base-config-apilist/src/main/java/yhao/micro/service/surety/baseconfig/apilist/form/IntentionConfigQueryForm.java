package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.IntentionPositionTypeEnum;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:单据分配设置查询 Form
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 14:04
 */
public class IntentionConfigQueryForm extends PageForm {
    @ApiModelProperty(value = "岗位类型，如：FOLLOWER", example = "FOLLOWER")
    private IntentionPositionTypeEnum positionType;
    @ApiModelProperty(value = "所属城市组织ID", example = "string")
    private String orgId;
    @ApiModelProperty(value = "负责的部门组织ID", example = "string")
    private String responsibleOrgId;
    @ApiModelProperty(value = "负责的部门组织ID列表，只要包含列表中所有的组织ID中的一项即可", example = "string",hidden = true)
    private List<String> orResponsibleOrgIdList;
    @ApiModelProperty(value = "负责的部门组织ID列表，必须包含列表中所有的组织ID中的所有项", example = "string",hidden = true)
    private List<String> andResponsibleOrgIdList;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;
    @ApiModelProperty(value = "跟单员或者报单员的账号id", example = "string")
    private String personId;
    @ApiModelProperty(value = "排除ID", example = "string",hidden = true)
    private String excludeId;

    public IntentionPositionTypeEnum getPositionType() {
        return positionType;
    }

    public void setPositionType(IntentionPositionTypeEnum positionType) {
        this.positionType = positionType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getResponsibleOrgId() {
        return responsibleOrgId;
    }

    public void setResponsibleOrgId(String responsibleOrgId) {
        this.responsibleOrgId = responsibleOrgId;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<String> getOrResponsibleOrgIdList() {
        return orResponsibleOrgIdList;
    }

    public void setOrResponsibleOrgIdList(List<String> orResponsibleOrgIdList) {
        this.orResponsibleOrgIdList = orResponsibleOrgIdList;
    }

    public List<String> getAndResponsibleOrgIdList() {
        return andResponsibleOrgIdList;
    }

    public void setAndResponsibleOrgIdList(List<String> andResponsibleOrgIdList) {
        this.andResponsibleOrgIdList = andResponsibleOrgIdList;
    }

    public String getExcludeId() {
        return excludeId;
    }

    public void setExcludeId(String excludeId) {
        this.excludeId = excludeId;
    }
}
