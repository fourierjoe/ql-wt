package yhao.micro.service.surety.erp.auth.apilist.form.auth;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.PageForm;

/**
 * Created by yoara on 2017/9/18.
 */
public class AuthLeafQueryForm extends PageForm {
    @ApiModelProperty(value = "所属菜单id",example = "string",required = true)
    @NotEmpty(message = "菜单id不能为空")
    private String typeId;

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
