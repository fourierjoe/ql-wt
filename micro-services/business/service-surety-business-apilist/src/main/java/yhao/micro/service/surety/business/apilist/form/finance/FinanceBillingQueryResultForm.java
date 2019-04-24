package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 15:51
 * @Description:
 */
public class FinanceBillingQueryResultForm implements ValidationForm {

    @ApiModelProperty("出账汇总")
    private List<FinanceBillingQueryResultBizForm>billingList;

    public List<FinanceBillingQueryResultBizForm> getBillingList() {
        return billingList;
    }

    public void setBillingList(List<FinanceBillingQueryResultBizForm> billingList) {
        this.billingList = billingList;
    }
}
