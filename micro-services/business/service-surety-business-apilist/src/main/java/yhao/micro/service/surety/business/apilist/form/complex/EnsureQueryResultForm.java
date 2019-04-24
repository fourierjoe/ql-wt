package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.enums.complex.RedemptionEnsureStatus;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 14:34
 * @Description:
 */
public class EnsureQueryResultForm extends GuaranteePageModel {
    @ApiModelProperty("保函状态  SEND 已寄送, NO_SEND 未寄送 REBACK 已退回")
    private RedemptionEnsureStatus status;


    public RedemptionEnsureStatus getStatus() {
        return status;
    }

    public void setStatus(RedemptionEnsureStatus status) {
        this.status = status;
    }

}
