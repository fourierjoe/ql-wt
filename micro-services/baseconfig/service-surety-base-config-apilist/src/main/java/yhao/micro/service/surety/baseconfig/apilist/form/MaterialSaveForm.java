package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.CommonStatusEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:资料设置保存/更新 Form
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:34
 */
public class MaterialSaveForm extends IdUnForm {
    @ApiModelProperty(value = "资料名称", example = "资料名称")
    private String name;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }
}
