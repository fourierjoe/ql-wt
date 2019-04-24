package yhao.micro.service.surety.erp.auth.login.apilist.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by yoara on 2018/6/25.
 */
public class LoginPersonResponse {
    public final static String ERR_CODE_NO_PERSON = "ERR_CODE_NO_PERSON";
    public final static String ERR_CODE_WRONG_PSW = "ERR_CODE_WRONG_PSW";

    @ApiModelProperty(value = "返回结果，如果为false，则数据为空，errMessage中将返回原因")
    private boolean success;
    @ApiModelProperty(value = "数据为空原因")
    private String errMessage;
    @ApiModelProperty(value = "数据为空原因编码")
    private String errCode;
    @ApiModelProperty(value = "登录结果")
    private LoginPersonModel model;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public LoginPersonModel getModel() {
        return model;
    }

    public void setModel(LoginPersonModel model) {
        this.model = model;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }
}
