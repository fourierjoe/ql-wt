package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/20 11:22
 * @Description:
 */
public class UpdateLoanGeneralAmountForm implements ValidationForm {
    @ApiModelProperty("借款总金额")
    private BigDecimal loanTotalMount;
    @ApiModelProperty(value = "担保单ID")
    private String guaranteeId;
    private Date updateTime;
    private String updateOperatorId;

    public BigDecimal getLoanTotalMount() {
        return loanTotalMount;
    }

    public void setLoanTotalMount(BigDecimal loanTotalMount) {
        this.loanTotalMount = loanTotalMount;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateOperatorId() {
        return updateOperatorId;
    }

    public void setUpdateOperatorId(String updateOperatorId) {
        this.updateOperatorId = updateOperatorId;
    }
}
