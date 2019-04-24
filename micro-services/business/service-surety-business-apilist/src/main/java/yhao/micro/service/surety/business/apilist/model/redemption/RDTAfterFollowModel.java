package yhao.micro.service.surety.business.apilist.model.redemption;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 09:58
 * @Description:
 */
public class RDTAfterFollowModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("取原证日期")
    private Date takeCertDate;
    @ApiModelProperty("原证编号")
    private String takeCertNumber;
    @ApiModelProperty("取原证备注")
    private String takeCertRemark;
    @ApiModelProperty("注销日期")
    private Date certLogoutDate;
    @ApiModelProperty("注销回执")
    private String certLogoutNumber;
    @ApiModelProperty("注销备注")
    private String certLogoutRemark;
    @ApiModelProperty("过户日期")
    private Date transferDate;
    @ApiModelProperty("过户回执")
    private String transferNumber;
    @ApiModelProperty("过户备注")
    private String transferRemark;
    @ApiModelProperty("取新证日期")
    private Date takeNewCertDate;
    @ApiModelProperty("新证编号")
    private String newCertNumber;
    @ApiModelProperty("新证备注")
    private String takeNewCertRemark;
    @ApiModelProperty("抵押日期")
    private Date mortgageDate;
    @ApiModelProperty("抵押备注")
    private String mortgageRemark;
    @ApiModelProperty("是否解保")
    private YNEnum isUnprotected;
    @ApiModelProperty("解保备注")
    private String unProtectedRemark;
    @ApiModelProperty("解保时间")
    private Date unProtectedDate;
    @ApiModelProperty("是否退尾款")
    private YNEnum isWithdrawal;
    @ApiModelProperty("取原证人id")
    private String takeCertId;
    @ApiModelProperty("原证注销人id")
    private String certLogoutId;
    @ApiModelProperty("过户人id")
    private String transferId;
    @ApiModelProperty("取新证人id")
    private String takeNewCertId;
    @ApiModelProperty("抵押登记人id")
    private String mortgageId;
    @ApiModelProperty("解保人id")
    private String unprotectedId;

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

    public YNEnum getIsUnprotected() {
        return isUnprotected;
    }

    public void setIsUnprotected(YNEnum isUnprotected) {
        this.isUnprotected = isUnprotected;
    }

    public YNEnum getIsWithdrawal() {
        return isWithdrawal;
    }

    public void setIsWithdrawal(YNEnum isWithdrawal) {
        this.isWithdrawal = isWithdrawal;
    }

    public String getTakeCertId() {
        return takeCertId;
    }

    public void setTakeCertId(String takeCertId) {
        this.takeCertId = takeCertId;
    }

    public String getCertLogoutId() {
        return certLogoutId;
    }

    public void setCertLogoutId(String certLogoutId) {
        this.certLogoutId = certLogoutId;
    }

    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public String getTakeNewCertId() {
        return takeNewCertId;
    }

    public void setTakeNewCertId(String takeNewCertId) {
        this.takeNewCertId = takeNewCertId;
    }

    public String getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(String mortgageId) {
        this.mortgageId = mortgageId;
    }

    public String getUnprotectedId() {
        return unprotectedId;
    }

    public void setUnprotectedId(String unprotectedId) {

        this.unprotectedId = unprotectedId;
    }

    public String getUnProtectedRemark() {
        return unProtectedRemark;
    }

    public void setUnProtectedRemark(String unProtectedRemark) {
        this.unProtectedRemark = unProtectedRemark;
    }

    public Date getUnProtectedDate() {
        return unProtectedDate;
    }

    public void setUnProtectedDate(Date unProtectedDate) {
        this.unProtectedDate = unProtectedDate;
    }
}
