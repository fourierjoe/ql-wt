package yhao.micro.service.surety.erp.auth.apilist.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * Created by yoara on 2017/8/23.
 */
@ApiModel
public class AuthOrgModel extends Entity<String> {
    // 父组织id
    @ApiModelProperty(value = "父组织id")
    private String parentId;
    // 组织名称
    @ApiModelProperty(value = "组织名称")
    private String name;
    // 自动生成的编码
    @ApiModelProperty(value = "自动生成的编码")
    private String number;
    // 自动生成并拼接父类的编码
    @ApiModelProperty(value = "自动生成并拼接父类的编码")
    private String longNumber;
    // 组织层级，最顶层为1
    @ApiModelProperty(value = "组织层级，最顶层为1")
    private Integer level;
    // 是否启用
    @ApiModelProperty(value = "是否启用")
    private CommonStatusEnum status;
    // 生效日期
    @ApiModelProperty(value = "生效日期")
    private Date validDate;

    private String parentOrgName;
    private String systemKeyLink;
    private String statusDesc;

    public void setParentId(String parentId){
        this.parentId = parentId;
    }

    public String getParentId(){
        return parentId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(String longNumber) {
        this.longNumber = longNumber;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setStatus(CommonStatusEnum status){
        this.status = status;
    }

    public CommonStatusEnum getStatus(){
        return status;
    }

    public String getStatusDesc(){
        if(status==null){
            return statusDesc;
        }
        return status.getDesc();
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public void setValidDate(Date validDate){
        this.validDate = validDate;
    }

    public Date getValidDate(){
        return validDate;
    }

    public String getParentOrgName() {
        return parentOrgName;
    }

    public void setParentOrgName(String parentOrgName) {
        this.parentOrgName = parentOrgName;
    }

    public String getSystemKeyLink() {
        return systemKeyLink;
    }

    public void setSystemKeyLink(String systemKeyLink) {
        this.systemKeyLink = systemKeyLink;
    }

    @Override
    public boolean equals(Object obj) {
        return idEqual(obj);
    }
}
