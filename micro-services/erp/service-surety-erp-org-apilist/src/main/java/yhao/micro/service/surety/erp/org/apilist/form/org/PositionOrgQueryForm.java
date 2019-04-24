package yhao.micro.service.surety.erp.org.apilist.form.org;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-08
 * Time: 11:17
 */
public class PositionOrgQueryForm implements ValidationForm {
    @ApiModelProperty(value = "挂职岗位id", example = "string", required = true)
    private String positionLinkId;
    @ApiModelProperty(value = "组织类型，如：CITY,OPERATION_FINANCIAL", example = "CITY")
    private String orgTypes;
    @ApiModelProperty(value = "是否找指定类型组织的父亲节点",hidden = true)
    private Boolean findParent;

    public String getPositionLinkId() {
        return positionLinkId;
    }

    public void setPositionLinkId(String positionLinkId) {
        this.positionLinkId = positionLinkId;
    }

    public String getOrgTypes() {
        return orgTypes;
    }

    public void setOrgTypes(String orgTypes) {
        this.orgTypes = orgTypes;
    }

    public Boolean getFindParent() {
        return findParent;
    }

    public void setFindParent(Boolean findParent) {
        this.findParent = findParent;
    }
}
