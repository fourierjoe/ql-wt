package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.enums.complex.RedemptionEnsureStatus;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 09:48
 * @Description:
 */
public class EnsureQueryForm extends ComplexRedemptionBaseQueryForm {
    @ApiModelProperty("保函状态")
    private RedemptionEnsureStatus status;

    public RedemptionEnsureStatus getStatus() {
        return status;
    }

    public void setStatus(RedemptionEnsureStatus status) {
        this.status = status;
    }
}
