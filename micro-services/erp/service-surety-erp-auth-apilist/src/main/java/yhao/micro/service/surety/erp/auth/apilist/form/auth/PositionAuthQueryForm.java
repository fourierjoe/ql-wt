package yhao.micro.service.surety.erp.auth.apilist.form.auth;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.PageForm;

/**
 * Created by yoara on 2017/9/18.
 */
public class PositionAuthQueryForm extends PageForm {
    @ApiModelProperty(value = "所属组织id", example = "string", required = true)
    @NotEmpty(message = "组织id不能为空")
    private String orgId;
    @ApiModelProperty(value = "岗位名称，模糊查询", example = "string")
    private String positionName;
    @ApiModelProperty(value = "岗位id",example = "string",hidden = true)
    private String positionId;
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }
}
