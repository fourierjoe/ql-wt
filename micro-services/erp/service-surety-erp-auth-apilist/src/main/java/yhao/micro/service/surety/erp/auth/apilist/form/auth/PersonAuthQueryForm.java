package yhao.micro.service.surety.erp.auth.apilist.form.auth;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.PageForm;

/**
 * Created by yoara on 2017/9/18.
 */
public class PersonAuthQueryForm extends PageForm {
    @ApiModelProperty(value = "组织id",example = "string",required = true)
    @NotEmpty(message = "组织id不能为空")
    private String orgId;
    @ApiModelProperty(value = "姓名/电话",example = "许仙")
    private String searchName;

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
