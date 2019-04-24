package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/8 15:24
 * @Version 1.0
 */
public class CancleExtensionForm {

    @ApiModelProperty("展期id")
    private String extensionId;

    public String getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(String extensionId) {
        this.extensionId = extensionId;
    }
}
