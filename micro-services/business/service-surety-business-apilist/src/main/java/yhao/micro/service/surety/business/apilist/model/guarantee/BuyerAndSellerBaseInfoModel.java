package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

public class BuyerAndSellerBaseInfoModel extends Entity<String> {

    @ApiModelProperty(value = "用户类型", example = "BUYER/SELLER")
    private String cltTyp;

    @ApiModelProperty(value = "用户姓名")
    private String cltName;

    @ApiModelProperty(value = "联系电话")
    private String contactTele;

    @ApiModelProperty(value = "国籍")
    private String ctfIssCntCod;

    @ApiModelProperty(value = "证件类型")
    private String ctfTyp;

    @ApiModelProperty(value = "证件号码")
    private String ctfIdc;

    @ApiModelProperty(value = "产权份额")
    private String propertyPortion;

    @ApiModelProperty(value = "住址")
    private String address;

    public String getCltTyp() {
        return cltTyp;
    }

    public void setCltTyp(String cltTyp) {
        this.cltTyp = cltTyp;
    }

    public String getCltName() {
        return cltName;
    }

    public void setCltName(String cltName) {
        this.cltName = cltName;
    }

    public String getContactTele() {
        return contactTele;
    }

    public void setContactTele(String contactTele) {
        this.contactTele = contactTele;
    }

    public String getCtfIssCntCod() {
        return ctfIssCntCod;
    }

    public void setCtfIssCntCod(String ctfIssCntCod) {
        this.ctfIssCntCod = ctfIssCntCod;
    }

    public String getCtfTyp() {
        return ctfTyp;
    }

    public void setCtfTyp(String ctfTyp) {
        this.ctfTyp = ctfTyp;
    }

    public String getCtfIdc() {
        return ctfIdc;
    }

    public void setCtfIdc(String ctfIdc) {
        this.ctfIdc = ctfIdc;
    }

    public String getPropertyPortion() {
        return propertyPortion;
    }

    public void setPropertyPortion(String propertyPortion) {
        this.propertyPortion = propertyPortion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
