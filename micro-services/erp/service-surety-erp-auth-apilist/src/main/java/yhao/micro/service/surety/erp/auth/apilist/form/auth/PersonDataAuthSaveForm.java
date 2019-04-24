package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafType;

import java.util.Set;

/**
 * Created by yoara on 2017/9/18.
 */
public class PersonDataAuthSaveForm implements ValidationForm {
    @ApiModelProperty(value = "人员id", example = "string", required = true)
    @NotEmpty(message = "personId")
    private String personId;
    @ApiModelProperty(value = "挂职岗位id", example = "string")
    @NotEmpty(message = "挂职岗位id不能为空")
    private String positionLinkId;
    @ApiModelProperty(value = "组织id串，用,隔开", example = "string")
    private String orgIds;
    @ApiModelProperty(hidden = true)
    private Set<String> orgIdArray;
    @ApiModelProperty(hidden = true)
    private AuthLeafType authType;
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;
    @ApiModelProperty(hidden = true)
    private String dataType = CommonConstants.SYSTEM_DATA_TYPE;


    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds;
    }

    public Set<String> getOrgIdArray() {
        return orgIdArray;
    }

    public void setOrgIdArray(Set<String> orgIdArray) {
        this.orgIdArray = orgIdArray;
    }

    public AuthLeafType getAuthType() {
        return authType;
    }

    public void setAuthType(AuthLeafType authType) {
        this.authType = authType;
    }

    public String getPositionLinkId() {
        return positionLinkId;
    }

    public void setPositionLinkId(String positionLinkId) {
        this.positionLinkId = positionLinkId;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
