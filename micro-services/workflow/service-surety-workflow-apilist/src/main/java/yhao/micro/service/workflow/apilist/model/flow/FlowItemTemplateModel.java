package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

public class FlowItemTemplateModel extends Entity {
    @ApiModelProperty("城市组织")
    private String orgId;

    @ApiModelProperty("事项类型")
    private String itemtype;

    @ApiModelProperty("事项名称")
    private String itemName;

    @ApiModelProperty("事项条目设置，json格式，包含数组内容，数组内元素至少含有{\"result\"}结果项")
    private String itemConfig;

    @ApiModelProperty("启用状态")
    private String itemStatus;

    @ApiModelProperty("事项备注")
    private String itemRemark;

    @ApiModelProperty("事项编码")
    private String itemCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
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

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }
}
