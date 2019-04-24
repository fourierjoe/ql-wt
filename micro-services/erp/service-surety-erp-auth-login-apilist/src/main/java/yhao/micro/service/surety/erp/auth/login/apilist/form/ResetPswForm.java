package yhao.micro.service.surety.erp.auth.login.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by yoara on 2018/5/16.
 */
public class ResetPswForm extends CodeForm {
    @NotEmpty(message = "新密码不能为空不能为空")
    @ApiModelProperty(value = "新密码", required = true)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}