package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/3 17:55
 * @Version 1.0
 */
public class ExtensionApplicationFeeStatus extends IdUnForm {

    @ApiModelProperty("展期收费状态1：未收费2：已收费未确认3：已收费已确认")
    private Integer feeStatus;

    public Integer getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(Integer feeStatus) {
        this.feeStatus = feeStatus;
    }
}
