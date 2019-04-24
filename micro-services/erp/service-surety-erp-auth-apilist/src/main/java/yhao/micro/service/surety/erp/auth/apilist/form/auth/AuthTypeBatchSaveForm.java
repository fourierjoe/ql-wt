package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-06
 * Time: 14:42
 */
public class AuthTypeBatchSaveForm implements ValidationForm {
    @ApiModelProperty(value = "菜单列表")
    @NotEmpty(message = "菜单列表不能为空")
    private List<AuthTypeSaveForm> authTypeSaveFormList;

    public List<AuthTypeSaveForm> getAuthTypeSaveFormList() {
        return authTypeSaveFormList;
    }

    public void setAuthTypeSaveFormList(List<AuthTypeSaveForm> authTypeSaveFormList) {
        this.authTypeSaveFormList = authTypeSaveFormList;
    }
}
