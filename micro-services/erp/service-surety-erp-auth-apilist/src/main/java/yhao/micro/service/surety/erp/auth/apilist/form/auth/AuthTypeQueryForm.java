package yhao.micro.service.surety.erp.auth.apilist.form.auth;


import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/9/18.
 */
public class AuthTypeQueryForm {
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;
    @ApiModelProperty(value = "菜单名称，模糊匹配", example = "基础配置")
    private String name;

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
