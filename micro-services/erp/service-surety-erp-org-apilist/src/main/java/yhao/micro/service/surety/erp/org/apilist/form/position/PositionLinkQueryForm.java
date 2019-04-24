package yhao.micro.service.surety.erp.org.apilist.form.position;


import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2017/8/23.
 */
public class PositionLinkQueryForm implements ValidationForm {
    @ApiModelProperty(value = "组织id",example = "string")
    private String orgId;
    @ApiModelProperty(value = "岗位id",example = "string")
    private String positionId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }
}