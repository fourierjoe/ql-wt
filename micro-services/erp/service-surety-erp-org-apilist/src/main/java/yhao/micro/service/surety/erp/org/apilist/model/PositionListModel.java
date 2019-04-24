package yhao.micro.service.surety.erp.org.apilist.model;

import yhao.micro.service.surety.erp.org.apilist.enums.PositionTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.infra.common.util.CommonDateUtil;

import java.util.Date;

/**
 * Created by yoara on 2018/1/10.
 * 履职表记录
 */
public class PositionListModel extends Entity<String> {
    @ApiModelProperty(value = "人员ID")
    private String personId;

    @ApiModelProperty(value = "挂职id")
    private String positionLinkId;

    @ApiModelProperty(value = "入职时间")
    private Date startTime;

    @ApiModelProperty(value = "离职时间")
    private Date endTime;

    @ApiModelProperty(value = "类型")
    private PositionTypeEnum type;

    //桥接数据
    @ApiModelProperty(value = "组织名")
    private String orgName;
    @ApiModelProperty(value = "岗位名")
    private String positionName;


    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPositionLinkId() {
        return positionLinkId;
    }

    public void setPositionLinkId(String positionLinkId) {
        this.positionLinkId = positionLinkId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getStartTimeDesc() {
        if(startTime==null){
            return "";
        }
        return CommonDateUtil.formatDateToyyyy_MM_dd(startTime);
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getEndTimeDesc() {
        if(endTime==null){
            return "至今";
        }
        return CommonDateUtil.formatDateToyyyy_MM_dd(endTime);
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public PositionTypeEnum getType() {
        return type;
    }

    public String getTypeDesc() {
        return type.getDesc();
    }

    public void setType(PositionTypeEnum type) {
        this.type = type;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
