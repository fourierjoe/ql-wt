package yhao.micro.service.surety.erp.org.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.CommonStatusEnum;

import javax.validation.constraints.NotNull;

public class StatusUpdateForm extends IdForm {
    @ApiModelProperty(value = "状态",required = true)
    @NotNull(message = "状态")
    private CommonStatusEnum status;

    @ApiModelProperty(value = "组织长编码",hidden = true)
    private String longNumber;

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public String getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(String longNumber) {
        this.longNumber = longNumber;
    }
}
