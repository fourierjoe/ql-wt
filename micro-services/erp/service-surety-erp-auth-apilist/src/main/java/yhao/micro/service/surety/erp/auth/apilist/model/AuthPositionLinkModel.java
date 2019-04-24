package yhao.micro.service.surety.erp.auth.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * Created by yoara on 2017/8/28.
 */
public class AuthPositionLinkModel extends Entity<String> {
    @ApiModelProperty(value = "组织id")
    private String orgId;
    @ApiModelProperty(value = "组织名")
    private String orgName;
    @ApiModelProperty(value = "岗位id")
    private String positionId;
    @ApiModelProperty(value = "岗位名")
    private String positionName;
    @ApiModelProperty(value = "岗位编码")
    private String positionNumber;

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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(String positionNumber) {
        this.positionNumber = positionNumber;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
