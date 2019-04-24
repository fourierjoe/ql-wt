package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

public class FlowNodeConditionModel extends Entity<String> {

    @ApiModelProperty("节点条件ID")
    private String nodeConditionId;
    @ApiModelProperty("条件名称")
    private String conditionName;
    @ApiModelProperty("判断流程通过条件")
    private String condition;

    public String getNodeConditionId() {
        return nodeConditionId;
    }

    public void setNodeConditionId(String nodeConditionId) {
        this.nodeConditionId = nodeConditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
