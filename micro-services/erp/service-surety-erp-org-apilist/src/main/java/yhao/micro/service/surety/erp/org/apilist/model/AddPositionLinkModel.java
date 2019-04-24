package yhao.micro.service.surety.erp.org.apilist.model;

import yhao.micro.service.surety.erp.org.apilist.enums.PositionTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * Created by yoara on 2017/8/24.
 */
public class AddPositionLinkModel extends Entity<String> {
    @ApiModelProperty(value = "挂职岗位ID")
    private String positionLinkId;

    @ApiModelProperty(value = "人员ID")
    private String personId;

    @ApiModelProperty(value = "职务类型",hidden = true)
    private PositionTypeEnum type;

    public String getPositionLinkId() {
        return positionLinkId;
    }

    public void setPositionLinkId(String positionLinkId) {
        this.positionLinkId = positionLinkId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public PositionTypeEnum getType() {
        return type;
    }

    public void setType(PositionTypeEnum type) {
        this.type = type;
    }
}
