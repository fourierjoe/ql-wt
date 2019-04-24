package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdForm;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author leice
 * @Date 2019/2/28 11:12
 * @Version 1.0
 */
public class ExtensionSomeFiledForm extends IdForm {

    @ApiModelProperty("展期业务类型1：现金 2：额度")
    @NotNull(message = "业务类型不能为空")
    private Integer types;

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }
}
