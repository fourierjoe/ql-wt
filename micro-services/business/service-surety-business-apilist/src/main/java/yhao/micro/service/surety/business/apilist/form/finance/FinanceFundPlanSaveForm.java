package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/4 16:29
 * @Description:用款计划保存
 */
public class FinanceFundPlanSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;
    @ApiModelProperty("创建人id")
    private String createOperatorId;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getCreateOperatorId() {
        return createOperatorId;
    }

    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }
}
