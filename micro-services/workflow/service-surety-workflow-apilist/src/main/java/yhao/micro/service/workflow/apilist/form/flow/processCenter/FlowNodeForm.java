package yhao.micro.service.workflow.apilist.form.flow.processCenter;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeAssignType;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeNotifyForm;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeTemplateForm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FlowNodeForm extends FlowNodeTemplateForm {

    @ApiModelProperty(value = "模板节点ID，保存流程时页面左边框拖过来的",required = true)
    @NotBlank(message = "模板节点ID不得为空")
    private String nodeTemplateId;

    @ApiModelProperty(value = "节点编号",required = true)
    @NotNull(message = "节点编号不得为空")
    private Integer orderNo;

    @ApiModelProperty(value = "通知设置")
    @NotEmpty(message = "通知设置不得为空")
    @Valid
    private List<FlowNodeNotifyForm> notifyList;

    @ApiModelProperty(value = "节点设置中的备注")
    private String nodeRemark;

    /*************************************************************************/

    @ApiModelProperty(value = "指派类型,PERSON=按人员/POSITION=按岗位", required = true, example = "PERSON")
    @NotNull(message = "指派类型不得为空")
    private FlowNodeAssignType assignType;

    @ApiModelProperty(value = "指派实体ID",required = true)
    @NotBlank(message = "指派id不得为空")
    private String assignEntityId;

    @ApiModelProperty(value = "事项设置,只有一个,后台自动生成,与节点名称一致", hidden=true)
    private FlowNodeItemForm item;

    @ApiModelProperty(value = "关联流程定义id",hidden = true)
    private String processId;

    @ApiModelProperty(value = "节点通过期望类型,大于", hidden = true)
    private RuleItemType nodeExpectType = RuleItemType.GT;

    @ApiModelProperty(value = "节点通过的条件名称,只适用于流程中心")
    private String nodeConditionName;

    @ApiModelProperty(value = "节点通过的条件配置(用于子流程),只适用于流程中心,比如审批的最大金额")
    private String nodeExpect;

    public String getNodeTemplateId() {
        return nodeTemplateId;
    }

    public void setNodeTemplateId(String nodeTemplateId) {
        this.nodeTemplateId = nodeTemplateId;
    }

    public String getNodeConditionName() {
        return nodeConditionName;
    }

    public void setNodeConditionName(String nodeConditionName) {
        this.nodeConditionName = nodeConditionName;
    }

    public String getNodeExpect() {
        return nodeExpect;
    }

    public void setNodeExpect(String nodeExpect) {
        this.nodeExpect = nodeExpect;
    }

    public RuleItemType getNodeExpectType() {
        return nodeExpectType;
    }

    public void setNodeExpectType(RuleItemType nodeExpectType) {
        this.nodeExpectType = nodeExpectType;
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

    public FlowNodeItemForm getItem() {
        return item;
    }

    public void setItem(FlowNodeItemForm item) {
        this.item = item;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public List<FlowNodeNotifyForm> getNotifyList() {
        return notifyList;
    }

    public void setNotifyList(List<FlowNodeNotifyForm> notifyList) {
        this.notifyList = notifyList;
    }

    public String getNodeRemark() {
        return nodeRemark;
    }

    public void setNodeRemark(String nodeRemark) {
        if (StringUtils.isEmpty(nodeRemark)) {
            this.nodeRemark = super.getNodeTemplateRemark();
        } else {
            this.nodeRemark = nodeRemark;
        }
    }

}
