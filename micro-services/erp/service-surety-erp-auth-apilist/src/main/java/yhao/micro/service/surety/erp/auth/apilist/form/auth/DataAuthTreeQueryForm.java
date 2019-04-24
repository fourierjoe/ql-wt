package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/9/18.
 */
public class DataAuthTreeQueryForm implements ValidationForm {
    @ApiModelProperty(value = "挂职岗位id",example = "string",required = true)
    @NotEmpty(message = "挂职岗位id不能为空")
    private String positionLinkId;
    @ApiModelProperty(value = "人员id",example = "string")
    private String personId;
    @ApiModelProperty(value = "父组织id",example = "string")
    private String parentOrgId;
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;
    @ApiModelProperty(hidden = true)
    private String dataType = CommonConstants.SYSTEM_DATA_TYPE;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
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

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }
}
