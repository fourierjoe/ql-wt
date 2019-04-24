package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/9/18.
 */
public class PositionDataAuthSaveForm implements ValidationForm {
    @ApiModelProperty(value = "挂职岗位id",example = "string",required = true)
    @NotEmpty(message = "挂职ID不得为空")
    private String positionLinkId;
    @ApiModelProperty(value = "组织id串，用,隔开",example = "string")
    private String orgIds;
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;
    @ApiModelProperty(hidden = true)
    private String dataType = CommonConstants.SYSTEM_DATA_TYPE;
    @ApiModelProperty(hidden = true)
    private String[] orgIdArray;


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

    public String getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds;
    }

    public String[] getOrgIdArray() {
        return orgIdArray;
    }

    public void setOrgIdArray(String[] orgIdArray) {
        this.orgIdArray = orgIdArray;
    }
}
