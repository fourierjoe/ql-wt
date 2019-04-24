package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;

import java.util.Date;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/28 16:46
 * @Description:
 */
public class UnProtectedQueryResultForm extends GuaranteePageModel {
    @ApiModelProperty("用途")
    private String estateUse;
    @ApiModelProperty(value = "付款方式, MORTGAGE_LOAN=按揭贷款/COMBINATION_LOAN=组合贷款/PUBLIC_LOAN=公积金贷款/ONETIME_LOAN=一次性贷款",
            example = "MORTGAGE_LOAN")
    private String payType;
    @ApiModelProperty("放款款日期")
    private Date confirmBillingDate;
    @ApiModelProperty("赎楼日期")
    private Date redeemDate;
    @ApiModelProperty("注销日期")
    private Date certLogoutDate;
    @ApiModelProperty("过户日期")
    private Date transferDate;
    @ApiModelProperty("取新证日期")
    private Date takeNewCertDate;
    @ApiModelProperty("抵押日期")
    private Date mortgageDate;
    @ApiModelProperty("过户人")
    private String transferPersonName;
    @ApiModelProperty("申请人")
    private String guaranteeApplicantIds;

    public String getEstateUse() {
        return estateUse;
    }

    public void setEstateUse(String estateUse) {
        this.estateUse = estateUse;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Date getConfirmBillingDate() {
        return confirmBillingDate;
    }

    public void setConfirmBillingDate(Date confirmBillingDate) {
        this.confirmBillingDate = confirmBillingDate;
    }

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public Date getCertLogoutDate() {
        return certLogoutDate;
    }

    public void setCertLogoutDate(Date certLogoutDate) {
        this.certLogoutDate = certLogoutDate;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Date getTakeNewCertDate() {
        return takeNewCertDate;
    }

    public void setTakeNewCertDate(Date takeNewCertDate) {
        this.takeNewCertDate = takeNewCertDate;
    }

    public Date getMortgageDate() {
        return mortgageDate;
    }

    public void setMortgageDate(Date mortgageDate) {
        this.mortgageDate = mortgageDate;
    }

    public String getTransferPersonName() {
        return transferPersonName;
    }

    public void setTransferPersonName(String transferPersonName) {
        this.transferPersonName = transferPersonName;
    }

    public String getGuaranteeApplicantIds() {
        return guaranteeApplicantIds;
    }

    public void setGuaranteeApplicantIds(String guaranteeApplicantIds) {
        this.guaranteeApplicantIds = guaranteeApplicantIds;
    }
}
