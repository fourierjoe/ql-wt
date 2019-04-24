package yhao.micro.service.surety.erp.auth.apilist.form.system;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2017/9/21.
 */
public class SystemOrgLinkSaveForm implements ValidationForm {
    @ApiModelProperty(value = "系统key",required = true)
    @NotEmpty(message = "系统key不得为空")
    private String systemKey;
    @ApiModelProperty(value = "组织ID")
    private String orgIds;
    @ApiModelProperty(value = "组织ID",hidden = true)
    private String[] orgIdArray;
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
