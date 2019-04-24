package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.CommonStatusEnum;

import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * Description:单据分配设置启用/禁用 Form
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 14:35
 */
public class StatusChangeForm extends IdForm {
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    @NotNull(message = "状态不能为空")
    private CommonStatusEnum status;

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }
}
