package yhao.micro.service.surety.business.apilist.model.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.common.model.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 *
 * @Auther: ql
 * @Date: 2018/12/8 17:46
 */
public class TwiceApplicationModel extends Entity<String> {
    @ApiModelProperty(value = "收款人类型")
    private String receipterType;

    @ApiModelProperty(value = "收款账户名")
    private String receipterAccount;

    @ApiModelProperty(value = "卡号")
    private String cardNumber;

    @ApiModelProperty(value = "开户行")
    private String bank;

    @ApiModelProperty(value = "申请金额")
    private BigDecimal applicationAmount;

    @ApiModelProperty(value = "赎楼/还款日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date repayDate;

    @ApiModelProperty(value = "申请人姓名")
    private String applicationName;

    @ApiModelProperty(value = "还款申请备注")
    private String applicationRemark;

    @ApiModelProperty(value = "出账状态(未出账/已出账)")
    private String billingStateDesc;

    @ApiModelProperty(value = "二次还款状态(1=客户经理发起,2=要件员确认,3=二次到账确认,4=申请出账,5=二次到账确认,6=二次赎楼)", hidden = true)
    private int twiceRepayState;

    @ApiModelProperty(value = "二次还款状态(1=客户经理发起,2=要件员确认,3=二次到账确认,4=申请出账,5=二次到账确认,6=二次赎楼)")
    private String twiceRepayStateStr;

    public String getReceipterType() {
        return receipterType;
    }

    public void setReceipterType(String receipterType) {
        this.receipterType = receipterType;
    }

    public String getReceipterAccount() {
        return receipterAccount;
    }

    public void setReceipterAccount(String receipterAccount) {
        this.receipterAccount = receipterAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public BigDecimal getApplicationAmount() {
        return applicationAmount;
    }

    public void setApplicationAmount(BigDecimal applicationAmount) {
        this.applicationAmount = applicationAmount;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationRemark() {
        return applicationRemark;
    }

    public void setApplicationRemark(String applicationRemark) {
        this.applicationRemark = applicationRemark;
    }

    public int getTwiceRepayState() {
        return twiceRepayState;
    }

    public void setTwiceRepayState(int twiceRepayState) {
        this.twiceRepayState = twiceRepayState;
    }

    public String getTwiceRepayStateStr() {
        if (twiceRepayState == 4 && twiceRepayState != 5) {
            this.twiceRepayStateStr = "审批中";
        } else if (twiceRepayState >= 5) {
            this.twiceRepayStateStr = "已完成";
        } else {
        }

        return twiceRepayStateStr;
    }

    public void setTwiceRepayStateStr(String twiceRepayStateStr) {
        this.twiceRepayStateStr = twiceRepayStateStr;
    }

    public String getBillingStateDesc() {
        if (twiceRepayState < 5) {
            this.billingStateDesc = "未出账";
        } else if (twiceRepayState >= 5) {
            this.billingStateDesc = "已出账";
        } else {
        }
        return billingStateDesc;
    }

    public void setBillingStateDesc(String billingStateDesc) {
        this.billingStateDesc = billingStateDesc;
    }
}
