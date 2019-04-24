package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 10:07
 * @Description:
 */
public class FundPayBackConfirmBizForm implements ValidationForm {
    @ApiModelProperty("借款金额")
    private BigDecimal loanAmount;
    @ApiModelProperty("回款金额")
    private BigDecimal payBackAmount;

}
