package yhao.micro.service.workflow.apilist.model.flow;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;

public class FlowNodeItemModel extends Entity<String> {
    @ApiModelProperty("当前节点ID")
    private String nodeId;
    @ApiModelProperty("事项名称")
    private String itemName;
    @ApiModelProperty("事项条目设置，json格式，包含数组内容，数组内元素至少含有{\"result\"}结果项")
    private String itemConfig;
    @ApiModelProperty("期望结果")
    private String itemExcept;
    @ApiModelProperty("期望类型")
    private RuleItemType itemExceptType;
    @ApiModelProperty("是否必要事项")
    private String necessary;
    @ApiModelProperty("是否核心事项")
    private String core;

    @ApiModelProperty("事项展示顺序")
    private Integer itemOrder;
    @ApiModelProperty("事项编号")
    private String itemCode;
    @ApiModelProperty("城市组织ID")
    private String orgId;
    /********************************以下字段只适用于驳回时事项插入*************************************************/
    @ApiModelProperty(value = "事项结果", hidden = true)
    @JSONField(serialize = false)
    private String itemResult;
    @ApiModelProperty(value = "事项处理意见", hidden = true)
    @JSONField(serialize = false)
    private String itemExpandResult;
    // 改为String类型, union中date与null(String)一起插入会报错
    @ApiModelProperty(value = "事项完成时间", hidden = true)
    @JSONField(serialize = false)
    private String itemFinishTime;
    @ApiModelProperty(value = "事项处理人ID", hidden = true)
    @JSONField(serialize = false)
    private String itemFinishPerson;
    @ApiModelProperty(value = "事项处理人岗位", hidden = true)
    @JSONField(serialize = false)
    private String itemFinishPersonPosition;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemResult() {
        return itemResult;
    }

    public void setItemResult(String itemResult) {
        this.itemResult = itemResult;
    }

    public String getItemExpandResult() {
        return itemExpandResult;
    }

    public void setItemExpandResult(String itemExpandResult) {
        this.itemExpandResult = itemExpandResult;
    }

    public String getItemFinishTime() {
        return itemFinishTime;
    }

    public void setItemFinishTime(String itemFinishTime) {
        this.itemFinishTime = itemFinishTime;
    }

    public String getItemFinishPerson() {
        return itemFinishPerson;
    }

    public void setItemFinishPerson(String itemFinishPerson) {
        this.itemFinishPerson = itemFinishPerson;
    }

    public String getItemFinishPersonPosition() {
        return itemFinishPersonPosition;
    }

    public void setItemFinishPersonPosition(String itemFinishPersonPosition) {
        this.itemFinishPersonPosition = itemFinishPersonPosition;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
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

    public String getItemExcept() {
        return itemExcept;
    }

    public void setItemExcept(String itemExcept) {
        this.itemExcept = itemExcept;
    }

    public RuleItemType getItemExceptType() {
        return itemExceptType;
    }

    public void setItemExceptType(RuleItemType itemExceptType) {
        this.itemExceptType = itemExceptType;
    }

    public String getNecessary() {
        return necessary;
    }

    public void setNecessary(String necessary) {
        this.necessary = necessary;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public Integer getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Integer itemOrder) {
        this.itemOrder = itemOrder;
    }

}
