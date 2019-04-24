package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CltTypEnum;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreditResultSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单ID", hidden = true)
    private String guaranteeId;

    @ApiModelProperty(value = "业主或买家ID", required = true)
    @NotBlank(message = "业主或买家ID不得为空")
    private String tradesId;

    @ApiModelProperty(value = "用户类型", example = "BUYER", required = true)
    @NotNull(message = "用户类型不得为空")
    private CltTypEnum cltTyp;

    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank(message = "姓名不得为空")
    private String cltName;

    @ApiModelProperty(value = "查询结果", required = true)
    @NotBlank(message = "查询结果不得为空")
    private String creditResult;

    @ApiModelProperty(value = "附件JSON串", required = true)
    @NotBlank(message = "附件不得为空")
    private String attachUrl;

    @ApiModelProperty("征信备注")
    private String creditRemark;

    @ApiModelProperty(value = "征信实际查询时间", required = true)
    @NotNull(message = "征信实际查询时间不得为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creditRealDate;

    public String getTradesId() {
        return tradesId;
    }

    public void setTradesId(String tradesId) {
        this.tradesId = tradesId;
    }

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

    public String getCreditResult() {
        return creditResult;
    }

    public void setCreditResult(String creditResult) {
        this.creditResult = creditResult;
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
    }

    public String getCreditRemark() {
        return creditRemark;
    }

    public void setCreditRemark(String creditRemark) {
        this.creditRemark = creditRemark;
    }

    public Date getCreditRealDate() {
        return creditRealDate;
    }

    public void setCreditRealDate(Date creditRealDate) {
        this.creditRealDate = creditRealDate;
    }
}
