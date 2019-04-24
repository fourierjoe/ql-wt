package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Description
 * @Author leice
 * @Date 2019/2/27 16:18
 * @Version 1.0
 */
public class CreateExtensionListForm extends PageForm {

    @ApiModelProperty("登录人id")
    private String loginId;


    @ApiModelProperty("单据号/物业/买卖双方")
    private String otherConditions;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getOtherConditions() {
        return otherConditions;
    }

    public void setOtherConditions(String otherConditions) {
        this.otherConditions = otherConditions;
    }
}
