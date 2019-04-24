package yhao.micro.service.surety.erp.auth.apilist.form.system;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2017/9/21.
 */
public class SystemOrgLinkQueryForm implements ValidationForm {
    @ApiModelProperty(value = "系统key",required = true)
    @NotEmpty(message = "系统key不得为空")
    private String systemKey;

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }
}
