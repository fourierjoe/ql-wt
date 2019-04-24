package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafType;
import yhao.micro.service.constants.CommonConstants;

import java.util.Set;

/**
 * Created by yoara on 2017/9/18.
 */
public class PositionAuthSaveForm implements ValidationForm {
    @ApiModelProperty(value = "岗位id",example = "string",required = true)
    @NotEmpty(message = "岗位id不能为空")
    private String positionId;
    @ApiModelProperty(value = "功能权限id串，用,隔开",example = "string")
    private String authIds;
    @ApiModelProperty(value = "岗位挂职id",example = "string",hidden = true)
    private String positionLinkId;
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;
    @ApiModelProperty(hidden = true)
    private Set<String> authIdSet;
    @ApiModelProperty(hidden = true)
    private String url;
    @ApiModelProperty(hidden = true)
    private AuthLeafType type;
    @ApiModelProperty(hidden = true)
    private Set<String> authIdArray;

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
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

    public String getAuthIds() {
        return authIds;
    }

    public void setAuthIds(String authIds) {
        this.authIds = authIds;
    }

    public Set<String> getAuthIdSet() {
        return authIdSet;
    }

    public void setAuthIdSet(Set<String> authIdSet) {
        this.authIdSet = authIdSet;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AuthLeafType getType() {
        return type;
    }

    public void setType(AuthLeafType type) {
        this.type = type;
    }

    public Set<String> getAuthIdArray() {
        return authIdArray;
    }

    public void setAuthIdArray(Set<String> authIdArray) {
        this.authIdArray = authIdArray;
    }
}
