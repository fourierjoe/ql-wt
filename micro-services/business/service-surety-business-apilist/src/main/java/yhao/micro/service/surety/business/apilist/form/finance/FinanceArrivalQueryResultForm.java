package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 15:08
 * @Description:
 */
public class FinanceArrivalQueryResultForm implements ValidationForm {
    private String id;
    @ApiModelProperty("资金类别")
    private String fundAccountName;
    @ApiModelProperty("银行账户")
    private String bankAccountName;
    @ApiModelProperty("金额")
    private BigDecimal arrivalAmount;
    @ApiModelProperty("到账日期")
    private Date arrivalDate;
    @ApiModelProperty("操作日期")
    private Date createDate;
    @ApiModelProperty("备注")
    private String remark;

    public String getFundAccountName() {
        return fundAccountName;
    }

    public void setFundAccountName(String fundAccountName) {
        this.fundAccountName = fundAccountName;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
