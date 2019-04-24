package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 *
 * @Auther: ql
 * @Date: 2018/12/8 17:40
 */
public class TwiceArrivalSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单id", required = true)
    @NotBlank(message = "担保单id不能为空")
    private String guaranteeId;

    @ApiModelProperty(value = "到账金额", required = true)
    @NotNull(message = "到账金额不得为空")
    private BigDecimal arrivalAmount;

    @ApiModelProperty(value = "到账日期", required = true)
    @NotNull(message = "到账日期不得为空")
    private Date arrivalDate;

    @ApiModelProperty(value = "银行账户", required = true)
    @NotBlank(message = "银行账户不得为空")
    private String twiceBankAccountId;

    @ApiModelProperty(value = "备注", required = true)
    @NotBlank(message = "备注不得为空")
    private String arrivalRemark;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public BigDecimal getArrivalAmount() {
        return arrivalAmount;
    }

    public void setArrivalAmount(BigDecimal arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getTwiceBankAccountId() {
        return twiceBankAccountId;
    }

    public void setTwiceBankAccountId(String twiceBankAccountId) {
        this.twiceBankAccountId = twiceBankAccountId;
    }

    public String getArrivalRemark() {
        return arrivalRemark;
    }

    public void setArrivalRemark(String arrivalRemark) {
        this.arrivalRemark = arrivalRemark;
    }
}
