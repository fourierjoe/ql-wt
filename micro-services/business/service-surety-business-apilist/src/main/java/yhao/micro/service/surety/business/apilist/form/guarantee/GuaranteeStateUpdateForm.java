package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.GuaranteeStateEnum;

/**
 * @Description:
 * @Created by ql on 2018/12/10 14:57
 * @Version: v1.0
 */
public class GuaranteeStateUpdateForm extends IdForm {

    @ApiModelProperty(value = "担保单状态, 保存=SAVE/提交=SUBMIT", required = true, example = "SAVE")
    @NotBlank(message = "担保单状态不得为空")
    private GuaranteeStateEnum guaranteeState;

    public GuaranteeStateEnum getGuaranteeState() {
        return guaranteeState;
    }

    public void setGuaranteeState(GuaranteeStateEnum guaranteeState) {
        this.guaranteeState = guaranteeState;
    }
}
