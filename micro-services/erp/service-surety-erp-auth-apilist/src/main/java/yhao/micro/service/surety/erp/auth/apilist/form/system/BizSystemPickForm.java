package yhao.micro.service.surety.erp.auth.apilist.form.system;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2017/12/8.
 */
public class BizSystemPickForm implements ValidationForm {
    @ApiModelProperty(value = "系统key")
    @NotEmpty(message = "系统key不得为空")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
