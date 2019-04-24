package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/15 11:15
 * @Description:回款详情查询
 */
public class FundPayBackRecordQueryForm implements ValidationForm {
    @ApiModelProperty(value = "借款金额",required = true)
    private BigDecimal loanAmount;
    @ApiModelProperty(value = "借款id",required = true)
    private String loanId;

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }
}
