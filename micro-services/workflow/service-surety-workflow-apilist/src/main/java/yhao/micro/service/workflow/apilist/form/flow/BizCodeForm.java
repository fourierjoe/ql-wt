package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

/**
 * @Description:
 * @Created by ql on 2018/12/14 16:16
 * @Version: v1.0
 */
public class BizCodeForm implements ValidationForm {

    @ApiModelProperty(value = "业务码", required = true)
    @NotBlank(message = "业务码不得为空")
    private String bizCode;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }
}
