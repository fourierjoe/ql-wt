package yhao.micro.service.surety.erp.org.apilist.form.position;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * Created by yoara on 2017/8/23.
 */
public class PositionQueryForm extends PageForm {
    @ApiModelProperty(value = "编码或名称",example = "string")
    private String positionKey;
    @ApiModelProperty(value = "组织id",example = "string")
    private String orgId;
    @ApiModelProperty(hidden = true)
    private String childOrgId;

    public String getPositionKey() {
        return positionKey;
    }

    public void setPositionKey(String positionKey) {
        this.positionKey = positionKey;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getChildOrgId() {
        return childOrgId;
    }

    public void setChildOrgId(String childOrgId) {
        this.childOrgId = childOrgId;
    }
}