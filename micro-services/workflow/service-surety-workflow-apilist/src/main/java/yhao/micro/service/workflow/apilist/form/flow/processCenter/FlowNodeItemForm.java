package yhao.micro.service.workflow.apilist.form.flow.processCenter;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;

public class FlowNodeItemForm extends IdUnForm {
    @ApiModelProperty(value = "nodeId",hidden = true)
    private String nodeId;

    @ApiModelProperty(value = "事项编号", required = true)
    @NotBlank(message = "事项编号不得为空")
    private String itemCode;

//    @ApiModelProperty(value = "事项名", required = true)
//    @NotBlank(message = "事项名不得为空")
//    private String itemName;
//
//    @ApiModelProperty(value = "事项条目设置",hidden = true)
//    private String itemConfig = "{result1:通过,result2:驳回}";

    @ApiModelProperty(value = "期望结果", hidden = true)
    private String itemExpect = CommonConstants.PASS;

    @ApiModelProperty(value = "期望类型, 等于=EQ/小于/大于", hidden = true)
    private RuleItemType itemExpectType = RuleItemType.EQ;

    @ApiModelProperty(value = "是否必要条件, NO", hidden = true)
    private YNEnum itemNecessary = YNEnum.NO;

    @ApiModelProperty(value = "是否核心条件, YES",hidden = true)
    private YNEnum itemCore = YNEnum.NO;

    @ApiModelProperty(value = "事项显示顺序",hidden = true)
    private Integer itemOrder;

    @ApiModelProperty(value = "城市组织id",hidden = true)
    private String orgId;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getItemExpect() {
        return itemExpect;
    }

    public void setItemExpect(String itemExpect) {
        this.itemExpect = itemExpect;
    }

    public RuleItemType getItemExpectType() {
        return itemExpectType;
    }

    public void setItemExpectType(RuleItemType itemExpectType) {
        this.itemExpectType = itemExpectType;
    }

    public YNEnum getItemNecessary() {
        return itemNecessary;
    }

    public void setItemNecessary(YNEnum itemNecessary) {
        this.itemNecessary = itemNecessary;
    }

    public YNEnum getItemCore() {
        return itemCore;
    }

    public void setItemCore(YNEnum itemCore) {
        this.itemCore = itemCore;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
