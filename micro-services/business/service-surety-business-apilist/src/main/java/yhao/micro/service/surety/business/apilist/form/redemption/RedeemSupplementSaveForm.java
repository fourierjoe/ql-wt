package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 16:20
 * @Description:
 */
public class RedeemSupplementSaveForm implements ValidationForm {
    @ApiModelProperty(value = "交凭证日期", required = true)
    private Date certificateDate;
    @ApiModelProperty(value = "赎楼日期", required = true)
    private Date redeemDate;
    @ApiModelProperty(value = "赎楼人员", required = true)
    private String redeemOperatorId;
    @ApiModelProperty(value = "客户补差额", required = true)
    private BigDecimal personBalance;
    @ApiModelProperty(value = "赎楼金额", required = true)
    private BigDecimal redeemAmount;
    @ApiModelProperty(value = "余款金额", required = true)
    private BigDecimal balanceAmount;

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public String getRedeemOperatorId() {
        return redeemOperatorId;
    }

    public void setRedeemOperatorId(String redeemOperatorId) {
        this.redeemOperatorId = redeemOperatorId;
    }

    public BigDecimal getPersonBalance() {
        return personBalance;
    }

    public void setPersonBalance(BigDecimal personBalance) {
        this.personBalance = personBalance;
    }

    public BigDecimal getRedeemAmount() {
        return redeemAmount;
    }

    public void setRedeemAmount(BigDecimal redeemAmount) {
        this.redeemAmount = redeemAmount;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
