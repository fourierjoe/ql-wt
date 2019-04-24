package yhao.micro.service.surety.erp.org.apilist.form.person;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.erp.org.apilist.enums.PositionTypeEnum;

import java.util.List;

/**
 * Created by yoara on 2017/8/23.
 */
public class PersonQueryForm extends PageForm {
    @ApiModelProperty(value = "根组织长编码")
    private String rootLongNumber;
    @ApiModelProperty(value = "编码或姓名或证件号")
    private String personKey;
    @ApiModelProperty(value = "上级组织id")
    private String orgId;
    @ApiModelProperty(value = "岗位类型，主职还是兼职，",example = "MAJOR")
    private PositionTypeEnum positionType;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "岗位编码,可多个，用逗号分隔")
    private String positionCodes;
    @ApiModelProperty(value = "岗位编码列表",hidden = true)
    private List<String> positionCodeList;
    @ApiModelProperty(value = "人员状态")
    private CommonStatusEnum suretyStatus;

    public String getPersonKey() {
        return personKey;
    }

    public void setPersonKey(String personKey) {
        this.personKey = personKey;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRootLongNumber() {
        return rootLongNumber;
    }

    public void setRootLongNumber(String rootLongNumber) {
        this.rootLongNumber = rootLongNumber;
    }

    public PositionTypeEnum getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionTypeEnum positionType) {
        this.positionType = positionType;
    }

    public String getPositionCodes() {
        return positionCodes;
    }

    public void setPositionCodes(String positionCodes) {
        this.positionCodes = positionCodes;
    }

    public CommonStatusEnum getSuretyStatus() {
        return suretyStatus;
    }

    public void setSuretyStatus(CommonStatusEnum suretyStatus) {
        this.suretyStatus = suretyStatus;
    }

    public List<String> getPositionCodeList() {
        return positionCodeList;
    }

    public void setPositionCodeList(List<String> positionCodeList) {
        this.positionCodeList = positionCodeList;
    }
}
