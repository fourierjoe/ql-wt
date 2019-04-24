package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.workflow.apilist.enums.flow.FlowTransitionType;

import javax.validation.constraints.NotNull;

public class FlowTransitionForm extends IdUnForm {
    @ApiModelProperty(value = "来源节点编号",required = true)
    private Integer sourceOrderNo;

    @ApiModelProperty(value = "来源节点id",hidden = true)
    private String sourceId;

    @ApiModelProperty(value = "目的节点编号",required = true)
    private Integer destinationOrderNo;

    @ApiModelProperty(value = "目的节点id",hidden = true)
    private String destinationId;

    @ApiModelProperty(value = "连接类型")
    private FlowTransitionType type = FlowTransitionType.PASS;

    @ApiModelProperty(value = "关联流程定义id",hidden = true)
    private String processId;

    public Integer getDestinationOrderNo() {
        return destinationOrderNo;
    }

    public void setDestinationOrderNo(Integer destinationOrderNo) {
        this.destinationOrderNo = destinationOrderNo;
    }

    public Integer getSourceOrderNo() {
        return sourceOrderNo;
    }

    public void setSourceOrderNo(Integer sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    public FlowTransitionType getType() {
        return type;
    }

    public void setType(FlowTransitionType type) {
        this.type = type;
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

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }
}
