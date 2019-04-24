package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 *
 * @Auther: ql
 * @Date: 2018/12/8 17:40
 */
public class TwiceArrivalModel extends Entity<String> {

    @ApiModelProperty(value = "到账金额")
    private BigDecimal arrivalAmount;

    @ApiModelProperty(value = "到账日期")
    private Date arrivalDate;

    @ApiModelProperty(value = "银行账户")
    private String bankAccount;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "操作日期")
    private Date operateDate;

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
