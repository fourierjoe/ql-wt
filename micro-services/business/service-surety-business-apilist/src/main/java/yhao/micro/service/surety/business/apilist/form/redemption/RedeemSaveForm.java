package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 16:11
 * @Description:
 */
public class RedeemSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",hidden = true)
    private String guaranteePid;
    @ApiModelProperty(value = "赎楼日期", required = true)
    private Date redeemDate;
    @ApiModelProperty(value = "客户补差额", required = true)
    private BigDecimal personBalance;
    @ApiModelProperty(value = "实际还贷本金", required = true)
    private BigDecimal realPayBackAmount;
    @ApiModelProperty(value = "利息", required = true)
    private BigDecimal interest;
    @ApiModelProperty(value = "罚息", required = true)
    private BigDecimal penaltyInterest;
    @ApiModelProperty(value = "公司账户", required = true)
    @NotBlank(message = "公司账户不得为空")
    private String companyAccount;
    @ApiModelProperty(value = "退还日期", required = true)
    private Date rebackDate;
    @ApiModelProperty(value = "备注", required = true)
    private String remark;
    private String createrId;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public BigDecimal getPersonBalance() {
        return personBalance;
    }

    public void setPersonBalance(BigDecimal personBalance) {
        this.personBalance = personBalance;
    }

    public BigDecimal getRealPayBackAmount() {
        return realPayBackAmount;
    }

    public void setRealPayBackAmount(BigDecimal realPayBackAmount) {
        this.realPayBackAmount = realPayBackAmount;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getPenaltyInterest() {
        return penaltyInterest;
    }

    public void setPenaltyInterest(BigDecimal penaltyInterest) {
        this.penaltyInterest = penaltyInterest;
    }

    public String getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(String companyAccount) {
        this.companyAccount = companyAccount;
    }

    public Date getRebackDate() {
        return rebackDate;
    }

    public void setRebackDate(Date rebackDate) {
        this.rebackDate = rebackDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }
}
