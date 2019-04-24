package yhao.micro.service.surety.erp.auth.login.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.List;

/**
 * Created by yoara on 2017/8/28.
 */
public class LoginPositionLinkModel extends Entity<String> {
    // 组织id
    @ApiModelProperty(value = "组织id")
    private String orgId;

    // 组织名
    @ApiModelProperty(value = "组织名")
    private String orgName;

    // 组织名
    @ApiModelProperty(value = "组织长编码")
    private String orgLongNumber;

    @ApiModelProperty(value = "组织所在城市分公司长编码")
    private String cityOrgLongNumber;

    @ApiModelProperty(value = "组织所在城市分公司ID")
    private String cityOrgId;

    @ApiModelProperty(value = "组织所在城市分公司名称")
    private String cityOrgName;

    // 岗位id
    @ApiModelProperty(value = "岗位id")
    private String positionId;

    // 岗位名
    @ApiModelProperty(value = "岗位名")
    private String positionName;

    // 岗位编码
    @ApiModelProperty(value = "岗位编码")
    private String positionNumber;

    //是否为主岗位
    @ApiModelProperty(value = "是否为主岗位")
    private boolean major;

    //是否为管理岗
    @ApiModelProperty(value = "是否为管理岗")
    private boolean manager;

    public boolean isMajor() {
        return major;
    }

    public void setMajor(boolean major) {
        this.major = major;
    }

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

    public String getOrgLongNumber() {
        return orgLongNumber;
    }

    public void setOrgLongNumber(String orgLongNumber) {
        this.orgLongNumber = orgLongNumber;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public String getCityOrgLongNumber() {
        return cityOrgLongNumber;
    }

    public void setCityOrgLongNumber(String cityOrgLongNumber) {
        this.cityOrgLongNumber = cityOrgLongNumber;
    }

    public String getCityOrgId() {
        return cityOrgId;
    }

    public void setCityOrgId(String cityOrgId) {
        this.cityOrgId = cityOrgId;
    }

    public String getCityOrgName() {
        return cityOrgName;
    }

    public void setCityOrgName(String cityOrgName) {
        this.cityOrgName = cityOrgName;
    }
}
