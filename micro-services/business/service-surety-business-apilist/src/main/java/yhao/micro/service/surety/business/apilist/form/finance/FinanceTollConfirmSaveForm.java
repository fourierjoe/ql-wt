package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/10 10:15
 * @Description:
 */
public class FinanceTollConfirmSaveForm extends IdUnForm {
    @ApiModelProperty(value = "确认收费类型 WARRANTY 担保费 OVERDUE 逾期费, DELAY 展期费",required = true)
    private String chargeType;
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }
}
