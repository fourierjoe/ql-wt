package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.enums.complex.EssentialsStatus;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 10:24
 * @Description:
 */
public class EssentialsQueryForm extends ComplexRedemptionBaseQueryForm {
    @ApiModelProperty("要件状态")
    private EssentialsStatus status;

    public EssentialsStatus getStatus() {
        return status;
    }

    public void setStatus(EssentialsStatus status) {
        this.status = status;
    }
}
