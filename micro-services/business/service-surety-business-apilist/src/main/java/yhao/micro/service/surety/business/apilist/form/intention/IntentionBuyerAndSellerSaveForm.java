package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CltTypEnum;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CreditTypeEnum;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class IntentionBuyerAndSellerSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单ID", hidden = true)
    private String guaranteeId;

    @ApiModelProperty(value = "用户类型", example = "BUYER", required = true)
    @NotNull(message = "用户类型不得为空")
    private CltTypEnum cltTyp;

    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank(message = "姓名不得为空")
    private String cltName;

    @ApiModelProperty(value = "电话", required = true)
    @NotBlank(message = "电话不得为空")
    private String contactTele;

    @ApiModelProperty(value = "征信查询方式", required = true)
    @NotNull(message = "征信查询方式不得为空")
    private CreditTypeEnum creditType;

    @ApiModelProperty(value = "征信预计查询日期")
    private Date creditExpectedDate;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public CltTypEnum getCltTyp() {
        return cltTyp;
    }

    public void setCltTyp(CltTypEnum cltTyp) {
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

    public CreditTypeEnum getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditTypeEnum creditType) {
        this.creditType = creditType;
    }

    public Date getCreditExpectedDate() {
        return creditExpectedDate;
    }

    public void setCreditExpectedDate(Date creditExpectedDate) {
        this.creditExpectedDate = creditExpectedDate;
    }
}
