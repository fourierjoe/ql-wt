package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/9/18.
 */
public class PersonAuthSaveForm implements ValidationForm {
    @ApiModelProperty(value = "岗位挂职id",example = "string",required = true)
    @NotEmpty(message = "挂职ID不能为空")
    private String positionLinkId;
    @ApiModelProperty(value = "人员id",example = "string",required = true)
    @NotEmpty(message = "personId")
    private String personId;
    @ApiModelProperty(value = "菜单功能权限id串，用,隔开",example = "string")
    private String authIds;
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;

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

    public String getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String authIds) {
        this.authIds = authIds;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
