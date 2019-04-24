package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/9/18.
 */
public class AuthTreeQueryForm implements ValidationForm {
    @ApiModelProperty(value = "挂职岗位id",example = "string")
    private String positionLinkId;
    @ApiModelProperty(value = "人员id",example = "string")
    private String personId;
    @ApiModelProperty(value = "功能权限url",example = "string",hidden = true)
    private String url;
    @ApiModelProperty(value = "岗位id",example = "string")
    private String positionId;
    @ApiModelProperty(hidden = true)
    private String authIds;
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;

    public String getPositionLinkId() {
        return positionLinkId;
    }

    public void setPositionLinkId(String positionLinkId) {
        this.positionLinkId = positionLinkId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String authIds) {
        this.authIds = authIds;
    }
}
