package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-08
 * Time: 11:47
 */
public class DataAuthQueryForm implements ValidationForm {
    @ApiModelProperty(value = "挂职岗位id",example = "string",required = true)
    @NotEmpty(message = "挂职岗位id不能为空")
    private String positionLinkId;
    @ApiModelProperty(value = "人员id",example = "string",required = true)
    private String personId;
    @ApiModelProperty(value = "父组织id",example = "string")
    private String parentOrgId;

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

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }
}
