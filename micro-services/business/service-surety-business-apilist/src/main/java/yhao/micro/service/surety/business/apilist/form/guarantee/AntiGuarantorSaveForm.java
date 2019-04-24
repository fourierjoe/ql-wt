package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CtfTypEnum;

import javax.validation.constraints.NotNull;

public class AntiGuarantorSaveForm extends IdUnForm {

    @ApiModelProperty(value = "担保单ID", hidden = true)
    private String guaranteeId;

    @ApiModelProperty(value = "姓名",example = "反担保人姓名")
    @NotBlank(message = "姓名不得为空")
    private String contactName;

    @ApiModelProperty(value = "联系电话",example = "131")
    @NotBlank(message = "联系电话不得为空")
    private String contactTele;

    @ApiModelProperty(value = "证件类型",example = "P01")
    @NotNull(message = "证件类型不得为空")
    private CtfTypEnum ctfTyp;

    @ApiModelProperty(value = "证件号码",example = "633")
    @NotBlank(message = "证件号码不得为空")
    private String ctfIdc;

    @ApiModelProperty(value = "住址",example = "深圳")
    @NotBlank(message = "住址不得为空")
    private String address;

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
