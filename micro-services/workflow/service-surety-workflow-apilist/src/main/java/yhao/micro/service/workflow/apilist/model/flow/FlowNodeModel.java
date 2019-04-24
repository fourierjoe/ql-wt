package yhao.micro.service.workflow.apilist.model.flow;


import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.flow.ConditionNameType;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeAssignType;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeType;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;

import java.util.List;

/**
 * 流程节点
 */
public class FlowNodeModel extends Entity<String> {
    @ApiModelProperty(value = "关联流程定义ID", hidden = true)
    @JSONField(serialize = false)
    private String processDefinitionId;

    @ApiModelProperty(value = "模板节点ID")
    private String nodeTemplateId;

    @ApiModelProperty("节点名称")
    private String nodeName;
    @ApiModelProperty("节点类型")
    private FlowNodeType nodeType;
    @ApiModelProperty("指派类型")
    private FlowNodeAssignType assignType;
    @ApiModelProperty("指派实体ID")
    private String assignEntityId;

    @ApiModelProperty("人员名称")
    private String personName;
    @ApiModelProperty("岗位名称")
    private String positionName;

    @ApiModelProperty("是否有预警")
    private String warn;
    @ApiModelProperty("子流程id")
    private String subProcessId;
    @ApiModelProperty("预警设置")
    private FlowNodeWarnModel nodeWarn;
    @ApiModelProperty("事项设置")
    private List<FlowNodeItemModel> items;

    @ApiModelProperty("节点备注")
    private String remark;

    @ApiModelProperty(value = "通知")
    private List<FlowNodeNotifyModel> notifyList;

    /*******************************以下字段适用于子流程**********************************************************/
    @ApiModelProperty(value = "判断流程条件(用于子流程),条件名称")
    private ConditionNameType nodeConditionName;
    @ApiModelProperty(value = "期望类型,默认(大于)＞", hidden = true)
    @JSONField(serialize = false)
    private RuleItemType nodeExpectType;
    @ApiModelProperty(value = "判断流程条件配置(用于子流程),比如审批的最大金额")
    private String nodeExpect;

    /**********************************用于驳回***************************/
    @ApiModelProperty(value = "事项处理意见", hidden = true)
    @JSONField(serialize = false)
    private String itemExpandResult;

    public String getNodeTemplateId() {
        return nodeTemplateId;
    }

    public void setNodeTemplateId(String nodeTemplateId) {
        this.nodeTemplateId = nodeTemplateId;
    }

    public String getItemExpandResult() {
        return itemExpandResult;
    }

    public void setItemExpandResult(String itemExpandResult) {
        this.itemExpandResult = itemExpandResult;
    }

    public RuleItemType getNodeExpectType() {
        return nodeExpectType;
    }

    public void setNodeExpectType(RuleItemType nodeExpectType) {
        this.nodeExpectType = nodeExpectType;
    }

    public ConditionNameType getNodeConditionName() {
        return nodeConditionName;
    }

    public void setNodeConditionName(ConditionNameType nodeConditionName) {
        this.nodeConditionName = nodeConditionName;
    }

    public String getNodeExpect() {
        return nodeExpect;
    }

    public void setNodeExpect(String nodeExpect) {
        this.nodeExpect = nodeExpect;
    }

    public FlowNodeWarnModel getNodeWarn() {
        return nodeWarn;
    }

    public void setNodeWarn(FlowNodeWarnModel nodeWarn) {
        this.nodeWarn = nodeWarn;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public FlowNodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(FlowNodeType nodeType) {
        this.nodeType = nodeType;
    }

    public FlowNodeAssignType getAssignType() {
        return assignType;
    }

    public void setAssignType(FlowNodeAssignType assignType) {
        this.assignType = assignType;
    }

    public String getAssignEntityId() {
        return assignEntityId;
    }

    public void setAssignEntityId(String assignEntityId) {
        this.assignEntityId = assignEntityId;
    }

    public String getWarn() {
        return warn;
    }

    public void setWarn(String warn) {
        this.warn = warn;
    }

    public List<FlowNodeItemModel> getItems() {
        return items;
    }

    public void setItems(List<FlowNodeItemModel> items) {
        this.items = items;
    }

    public String getSubProcessId() {
        return subProcessId;
    }

    public void setSubProcessId(String subProcessId) {
        this.subProcessId = subProcessId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<FlowNodeNotifyModel> getNotifyList() {
        return notifyList;
    }

    public void setNotifyList(List<FlowNodeNotifyModel> notifyList) {
        this.notifyList = notifyList;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof FlowNodeModel)){
            return false;
        }
        return this.getId().equals(((FlowNodeModel)obj).getId());
    }
}
