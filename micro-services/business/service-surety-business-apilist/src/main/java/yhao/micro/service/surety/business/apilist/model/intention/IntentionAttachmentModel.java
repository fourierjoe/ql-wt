package yhao.micro.service.surety.business.apilist.model.intention;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2018/12/10 16:49
 * @Version: v1.0
 */
public class IntentionAttachmentModel extends Entity<String> {

    @ApiModelProperty(value = "资料名字")
    private String dataName;

    @ApiModelProperty(value = "资料URL")
    private String dataUrl;

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
