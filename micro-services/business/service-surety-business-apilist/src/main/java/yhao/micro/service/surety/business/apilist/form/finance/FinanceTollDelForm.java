package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.finance.ChargeType;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/9 17:59
 * @Description: 收费删除
 */
public class FinanceTollDelForm extends IdUnForm {
    @ApiModelProperty(value = "收费类型",required = true)
    private ChargeType chargeType;

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }
}
