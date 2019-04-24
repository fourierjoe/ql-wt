package yhao.micro.service.surety.erp.auth.login.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.LoginForm;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/12/11.
 */
public class AuthLoginForm extends LoginForm {
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;
    @ApiModelProperty(hidden = true)
    private boolean needPsw = true;
    @ApiModelProperty(
            value = "微信openId，公众号登陆时传值",
            example = "string"
    )
    private String wxOpenId;

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

    public boolean isNeedPsw() {
        return needPsw;
    }

    public void setNeedPsw(boolean needPsw) {
        this.needPsw = needPsw;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }
}
