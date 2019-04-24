package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.flow.FlowTransitionType;

/**
 * 节点之间的关系线
 */
public class FlowTransitionModel extends Entity<String> {
    @ApiModelProperty("关联流程定义ID")
    private String processDefinitionId;
    @ApiModelProperty("来源节点")
    private String sourceId;
    @ApiModelProperty("目的节点")
    private String destinationId;
    @ApiModelProperty("连接类型")
    private FlowTransitionType type;
    @ApiModelProperty("目的节点序号")
    private Integer destinationNodeOrder;

    public Integer getDestinationNodeOrder() {
        return destinationNodeOrder;
    }

    public void setDestinationNodeOrder(Integer destinationNodeOrder) {
        this.destinationNodeOrder = destinationNodeOrder;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public FlowTransitionType getType() {
        return type;
    }

    public void setType(FlowTransitionType type) {
        this.type = type;
    }


}
