package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.apilist.validate.IdUnForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 15:19
 * @Description:
 */
public class FinanceArrivalSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteeId;
    @ApiModelProperty("资金类别")
    private String fundAccountId ;
    @ApiModelProperty(value = "到账金额",required = true)
    private BigDecimal arrivalAmount;
    @ApiModelProperty(value = "到账日期",required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalDate;
    @ApiModelProperty(value = "银行账户",required = true)
    private String bankAccountId;
    @ApiModelProperty("备注")
    private String remark;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getFundAccountId() {
        return fundAccountId;
    }

    public void setFundAccountId(String fundAccountId) {
        this.fundAccountId = fundAccountId;
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

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
