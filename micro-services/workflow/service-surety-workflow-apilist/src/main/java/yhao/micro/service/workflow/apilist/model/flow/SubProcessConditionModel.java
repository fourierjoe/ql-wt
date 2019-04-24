package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.flow.ConditionNameType;
import yhao.micro.service.workflow.apilist.enums.task.RuleItemType;

/**
 * @Description:
 * @Created by ql on 2018/12/15 11:15
 * @Version: v1.0
 */
public class SubProcessConditionModel extends Entity<String> {

    @ApiModelProperty(value = "节点id")
    private String nodeId;

    @ApiModelProperty(value = "节点通过期望类型")
    private RuleItemType nodeExpectType;

    @ApiModelProperty(value = "节点条件名称")
    private ConditionNameType nodeConditionName;

    @ApiModelProperty(value = "节点条件")
    private String nodeExpect;

    public RuleItemType getNodeExpectType() {
        return nodeExpectType;
    }

    public void setNodeExpectType(RuleItemType nodeExpectType) {
        this.nodeExpectType = nodeExpectType;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
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
}
