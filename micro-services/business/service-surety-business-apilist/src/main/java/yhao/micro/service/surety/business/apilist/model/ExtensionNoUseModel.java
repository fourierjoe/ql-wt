package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description 修改展期状态时查询还款日期model
 *
 * @Author leice
 * @Date 2019/1/8 10:39
 * @Version 1.0
 */
public class ExtensionNoUseModel{

    @ApiModelProperty("展期id")
    private String extensionId;

    public String getExtensionId() {
        return extensionId;
    }

    public void setExtensionId(String extensionId) {
        this.extensionId = extensionId;
    }

}
