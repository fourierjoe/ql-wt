package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.enums.flow.FlowItemType;

import javax.validation.constraints.NotNull;

public class FlowNodeItemTemplateSaveForm extends IdUnForm {
    @ApiModelProperty(value = "事项名称",required = true)
    @NotBlank(message = "事项名称不得为空")
    private String itemName;

    @ApiModelProperty(value = "事项条目设置,JSON字符串",example = "[{\"code\":\"R001\",\"value\":\"包含已寄出\"}]")
    private String itemConfig;

    @ApiModelProperty(value = "事项备注")
    private String remark;

    @ApiModelProperty(value = "城市组织ID数组", required = true)
    @NotEmpty(message = "城市组织ID数组不得为空")
    private String[] orgIdArr;

    @ApiModelProperty(value = "城市组织ID串", hidden = true)
    private String orgId;

    @ApiModelProperty(value = "事项类型", hidden = true)
    private FlowItemType itemType = FlowItemType.ITEM;

    @ApiModelProperty(value = "状态", required = true)
    @NotNull(message = "事项状态不能为空")
    private YNEnum itemState;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String[] getOrgIdArr() {
        return orgIdArr;
    }

    public void setOrgIdArr(String[] orgIdArr) {
        this.orgIdArr = orgIdArr;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemConfig() {
        return itemConfig;
    }

    public void setItemConfig(String itemConfig) {
        this.itemConfig = itemConfig;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public FlowItemType getItemType() {
        return itemType;
    }

    public void setItemType(FlowItemType itemType) {
        this.itemType = itemType;
    }

    public YNEnum getItemState() {
        return itemState;
    }

    public void setItemState(YNEnum itemState) {
        this.itemState = itemState;
    }
}
