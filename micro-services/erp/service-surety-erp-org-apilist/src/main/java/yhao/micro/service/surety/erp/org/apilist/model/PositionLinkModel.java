package yhao.micro.service.surety.erp.org.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * Created by yoara on 2017/8/28.
 */
public class PositionLinkModel extends Entity<String> {
    // 组织id
    @ApiModelProperty(value = "组织id")
    private String orgId;

    // 组织名
    @ApiModelProperty(value = "组织名")
    private String orgName;

    // 岗位id
    @ApiModelProperty(value = "岗位id")
    private String positionId;

    // 岗位名
    @ApiModelProperty(value = "岗位名")
    private String positionName;

    // 岗位编码
    @ApiModelProperty(value = "岗位编码")
    private String positionNumber;

    @ApiModelProperty(value = "erp中是否为manager",hidden = true)
    private int erpManager;

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

    public int getErpManager() {
        return erpManager;
    }

    public void setErpManager(Integer erpManager) {
        this.erpManager = erpManager;
    }
}
