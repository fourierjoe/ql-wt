package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/3/2 17:31
 * @Description:赎楼后跟进保存
 */
public class RedeemAfterSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",required = true)
    @NotBlank(message = "担保单id不能为空")
    private String guaranteeId;
    @ApiModelProperty("取原证日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date takeCertDate;
    @ApiModelProperty("原证编号")
    private String takeCertNumber;
    @ApiModelProperty("取原证备注")
    private String takeCertRemark;
    @ApiModelProperty("注销日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date certLogoutDate;
    @ApiModelProperty("注销回执")
    private String certLogoutNumber;
    @ApiModelProperty("注销备注")
    private String certLogoutRemark;
    @ApiModelProperty("过户日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transferDate;
    @ApiModelProperty("过户回执")
    private String transferNumber;
    @ApiModelProperty("过户备注")
    private String transferRemark;
    @ApiModelProperty("取新证日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date takeNewCertDate;
    @ApiModelProperty("新证编号")
    private String newCertNumber;
    @ApiModelProperty("新证备注")
    private String takeNewCertRemark;
    @ApiModelProperty("抵押日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date mortgageDate;
    @ApiModelProperty("抵押备注")
    private String mortgageRemark;
    @ApiModelProperty(hidden = true)
    private String createOperatorId;

    @ApiModelProperty(value = "操作类型 待取原证 takeCert 待注销 " +
            "certLogout 待过户 transfer 取新证takeNewCert 抵押登记  mortgage 申请退尾款 withdrawal 解保 unprotected",required = true)
    @NotBlank(message = "操作类型不能为空")
    private String positionType;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Date getTakeCertDate() {
        return takeCertDate;
    }

    public void setTakeCertDate(Date takeCertDate) {
        this.takeCertDate = takeCertDate;
    }

    public String getTakeCertNumber() {
        return takeCertNumber;
    }

    public void setTakeCertNumber(String takeCertNumber) {
        this.takeCertNumber = takeCertNumber;
    }

    public String getTakeCertRemark() {
        return takeCertRemark;
    }

    public void setTakeCertRemark(String takeCertRemark) {
        this.takeCertRemark = takeCertRemark;
    }

    public Date getCertLogoutDate() {
        return certLogoutDate;
    }

    public void setCertLogoutDate(Date certLogoutDate) {
        this.certLogoutDate = certLogoutDate;
    }

    public String getCertLogoutNumber() {
        return certLogoutNumber;
    }

    public void setCertLogoutNumber(String certLogoutNumber) {
        this.certLogoutNumber = certLogoutNumber;
    }

    public String getCertLogoutRemark() {
        return certLogoutRemark;
    }

    public void setCertLogoutRemark(String certLogoutRemark) {
        this.certLogoutRemark = certLogoutRemark;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferNumber() {
        return transferNumber;
    }

    public void setTransferNumber(String transferNumber) {
        this.transferNumber = transferNumber;
    }

    public String getTransferRemark() {
        return transferRemark;
    }

    public void setTransferRemark(String transferRemark) {
        this.transferRemark = transferRemark;
    }

    public Date getTakeNewCertDate() {
        return takeNewCertDate;
    }

    public void setTakeNewCertDate(Date takeNewCertDate) {
        this.takeNewCertDate = takeNewCertDate;
    }

    public String getNewCertNumber() {
        return newCertNumber;
    }

    public void setNewCertNumber(String newCertNumber) {
        this.newCertNumber = newCertNumber;
    }

    public String getTakeNewCertRemark() {
        return takeNewCertRemark;
    }

    public void setTakeNewCertRemark(String takeNewCertRemark) {
        this.takeNewCertRemark = takeNewCertRemark;
    }

    public Date getMortgageDate() {
        return mortgageDate;
    }

    public void setMortgageDate(Date mortgageDate) {
        this.mortgageDate = mortgageDate;
    }

    public String getMortgageRemark() {
        return mortgageRemark;
    }

    public void setMortgageRemark(String mortgageRemark) {
        this.mortgageRemark = mortgageRemark;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getCreateOperatorId() {
        return createOperatorId;
    }

    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }
}
