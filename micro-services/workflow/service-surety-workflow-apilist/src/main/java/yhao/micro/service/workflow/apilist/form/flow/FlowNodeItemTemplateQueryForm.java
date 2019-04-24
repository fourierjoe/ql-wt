package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;

public class FlowNodeItemTemplateQueryForm extends PageForm {

    @ApiModelProperty(value = "城市组织ID")
    private String orgId;

    @ApiModelProperty(value = "事项名称")
    private String itemName;

    @ApiModelProperty(value = "事项状态")
    @NotNull(message = "事项状态不得为空")
    private YNEnum itemStatus = YNEnum.YES;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public YNEnum getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(YNEnum itemStatus) {
        this.itemStatus = itemStatus;
    }
}
