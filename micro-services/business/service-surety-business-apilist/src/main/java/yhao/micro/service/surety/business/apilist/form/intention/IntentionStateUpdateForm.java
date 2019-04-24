package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;


public class IntentionStateUpdateForm extends IdForm {

    @ApiModelProperty(value = "意向单状态, 保存=SAVE/客户经理提交=SUBMITED/跟单员接受=RECEIVED/跟单员已转单=TRANSFERD",
            required = true, example = "SAVE")
    @NotBlank(message = "意向单状态不得为空")
    private String intentionState;

    public String getIntentionState() {
        return intentionState;
    }

    public void setIntentionState(String intentionState) {
        this.intentionState = intentionState;
    }
}
