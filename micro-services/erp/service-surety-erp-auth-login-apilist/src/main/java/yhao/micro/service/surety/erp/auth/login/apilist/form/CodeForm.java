package yhao.micro.service.surety.erp.auth.login.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2018/5/16.
 */
public class CodeForm implements ValidationForm {
    @NotEmpty(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码，不区分大小写", required = true)
    private String code;

    @NotEmpty(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}