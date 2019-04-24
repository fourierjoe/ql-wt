package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;

public class  TaskNodeItemModel extends Entity<String> {
    /************ 事项配置常量值 **********/
    public final static String ITEM_RESULT = "result";

    @ApiModelProperty("当前任务ID")
    private String taskId;
    @ApiModelProperty("当前节点ID")
    private String taskNodeId;
    @ApiModelProperty("事项编号(事项ID)")
    private String itemId;
    @ApiModelProperty("事项名称")
    private String itemName;
    @ApiModelProperty("事项条目设置，json格式，包含数组内容，数组内元素至少含有{\"result\"}结果项")
    private String itemConfig;
    @ApiModelProperty("事项结果编码")
    private String itemResultCode;
    @ApiModelProperty("事项结果")
    private String itemResult;
    @ApiModelProperty("期望结果")
    private String itemExcept;
    @ApiModelProperty("期望类型")
    private RuleItemType itemExceptType;
    @ApiModelProperty("是否必要条件")
    private String necessary;

    @ApiModelProperty(value = "事项处理意见")
    private String itemExpandResult;

    @ApiModelProperty(value = "是否核心条件")
    private String core;
    @ApiModelProperty(value = "事项编号")
    private String itemCode;

    // 改为String类型, union中date与null(String)一起插入会报错
    @ApiModelProperty(value = "事项完成时间")
    private String itemFinishTime;

    @ApiModelProperty(value = "事项处理人ID")
    private String itemFinishPerson;

    @ApiModelProperty(value = "事项处理人岗位")
    private String itemFinishPersonPosition;

    @ApiModelProperty(value = "事项处理人名称")
    private String itemFinishPersonName;

    @ApiModelProperty(value = "节点进度展示顺序,每次通过节点时生成")
    private Integer nodeScheduleOrder;

    @ApiModelProperty(value = "事项页面显示顺序")
    private Integer itemOrder;

    @ApiModelProperty(value = "事项是否成功")
    private String isMatch;

    public String getIsMatch() {
        return isMatch;
    }

    public void setIsMatch(String isMatch) {
        this.isMatch = isMatch;
    }

    public String getItemResultCode() {
        return itemResultCode;
    }

    public void setItemResultCode(String itemResultCode) {
        this.itemResultCode = itemResultCode;
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

    public Integer getNodeScheduleOrder() {
        return nodeScheduleOrder;
    }

    public void setNodeScheduleOrder(Integer nodeScheduleOrder) {
        this.nodeScheduleOrder = nodeScheduleOrder;
    }

    public String getItemExpandResult() {
        return itemExpandResult;
    }

    public void setItemExpandResult(String itemExpandResult) {
        this.itemExpandResult = itemExpandResult;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public String getItemFinishPersonName() {
        return itemFinishPersonName;
    }

    public void setItemFinishPersonName(String itemFinishPersonName) {
        this.itemFinishPersonName = itemFinishPersonName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskNodeId() {
        return taskNodeId;
    }

    public void setTaskNodeId(String taskNodeId) {
        this.taskNodeId = taskNodeId;
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

    public String getItemResult() {
        return itemResult;
    }

//    public JSONArray getItemConfigJson() {
//        if(StringUtils.isEmpty(itemConfig)){
//            return null;
//        }else{
//            return JSONObject.parseArray(itemConfig);
//        }
//    }

    public void setItemResult(String itemResult) {
        this.itemResult = itemResult;
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

    public String getItemFinishTime() {
        return itemFinishTime;
    }

    public void setItemFinishTime(String itemFinishTime) {
        this.itemFinishTime = itemFinishTime;
    }
}
