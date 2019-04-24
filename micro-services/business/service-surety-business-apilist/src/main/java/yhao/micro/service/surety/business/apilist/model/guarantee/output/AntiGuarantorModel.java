package yhao.micro.service.surety.business.apilist.model.guarantee.output;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CtfTypEnum;

import java.util.List;

public class AntiGuarantorModel extends Entity<String> {

    @ApiModelProperty(value = "担保单ID", hidden = true)
    private String guaranteeId;

    @ApiModelProperty(value = "姓名",example = "反担保人姓名")
    private String contactName;

    @ApiModelProperty(value = "联系电话",example = "131")
    private String contactTele;

    @ApiModelProperty(value = "证件类型",example = "P01")
    private CtfTypEnum ctfTyp;

    @ApiModelProperty(value = "证件号码",example = "633")
    private String ctfIdc;

    @ApiModelProperty(value = "住址",example = "深圳")
    private String address;

    @ApiModelProperty(value = "反担保人物业信息")
    private List<AntiEstateModel> antiEstateModelList;

    public List<AntiEstateModel> getAntiEstateModelList() {
        return antiEstateModelList;
    }

    public void setAntiEstateModelList(List<AntiEstateModel> antiEstateModelList) {
        this.antiEstateModelList = antiEstateModelList;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTele() {
        return contactTele;
    }

    public void setContactTele(String contactTele) {
        this.contactTele = contactTele;
    }

    public CtfTypEnum getCtfTyp() {
        return ctfTyp;
    }

    public void setCtfTyp(CtfTypEnum ctfTyp) {
        this.ctfTyp = ctfTyp;
    }

    public String getCtfIdc() {
        return ctfIdc;
    }

    public void setCtfIdc(String ctfIdc) {
        this.ctfIdc = ctfIdc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
