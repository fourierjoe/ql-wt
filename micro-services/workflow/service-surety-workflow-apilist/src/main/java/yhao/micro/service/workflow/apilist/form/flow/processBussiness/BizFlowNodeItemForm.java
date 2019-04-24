package yhao.micro.service.workflow.apilist.form.flow.processBussiness;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.enums.flow.ItemExceptResult;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;

import javax.validation.constraints.NotNull;

public class BizFlowNodeItemForm extends IdUnForm {
    @ApiModelProperty(value = "nodeId",hidden = true)
    private String nodeId;

    @ApiModelProperty(value = "事项编号", required = true)
    @NotBlank(message = "事项编号不得为空")
    private String itemCode;

//    @ApiModelProperty(value = "事项名",required = true)
//    @NotBlank(message = "事项名不得为空")
//    private String itemName;
//
//    @ApiModelProperty(value = "事项条目设置",required = true)
//    @NotBlank(message = "事项条目设置不得为空")
//    private String itemConfig;

    @ApiModelProperty(value = "期望结果编码", required = true)
    @NotNull(message = "期望结果编码不得为空")
    private ItemExceptResult itemExcept;

    @ApiModelProperty(value = "期望类型, 等于=EQ/小于/大于", example = "EQ", required = true)
    @NotNull(message = "期望类型不得为空")
    private RuleItemType itemExceptType;

    @ApiModelProperty(value = "是否必要条件, YES/NO", example = "NO",required = true)
    @NotNull(message = "是否必要条件不得为空")
    private YNEnum necessary = YNEnum.NO;

    @ApiModelProperty(value = "是否核心条件, YES/NO",required = true, example = "YES")
    @NotNull(message = "是否核心条件不得为空")
    private YNEnum core;

    @ApiModelProperty(value = "事项显示顺序",required = true, dataType = "整数", example = "1")
    @NotNull(message = "是否核心条件不得为空")
    private Integer itemOrder;

    @ApiModelProperty(value = "事项城市组织ID",required = true)
    @NotBlank(message = "事项城市组织ID不得为空")
    private String orgId;

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

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public ItemExceptResult getItemExcept() {
        return itemExcept;
    }

    public void setItemExcept(ItemExceptResult itemExcept) {
        this.itemExcept = itemExcept;
    }

    public RuleItemType getItemExceptType() {
        return itemExceptType;
    }

    public void setItemExceptType(RuleItemType itemExceptType) {
        this.itemExceptType = itemExceptType;
    }

    public YNEnum getNecessary() {
        return necessary;
    }

    public void setNecessary(YNEnum necessary) {
        this.necessary = necessary;
    }

    public YNEnum getCore() {
        return core;
    }

    public void setCore(YNEnum core) {
        this.core = core;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

}
