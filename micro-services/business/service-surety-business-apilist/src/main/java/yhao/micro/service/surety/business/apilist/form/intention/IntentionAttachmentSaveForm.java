package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

public class IntentionAttachmentSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单ID", hidden = true)
    private String guaranteeId;

    @ApiModelProperty(value = "资料ID")
    private String dataId;

    @ApiModelProperty(value = "资料名字")
    private String dataName;

    @ApiModelProperty(value = "资料URL")
    private String dataUrl;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl;
    }
}
