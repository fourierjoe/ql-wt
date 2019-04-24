package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;

public class FlowNodeNotifyQueryForm extends IdUnForm {
    @ApiModelProperty(value = "当前节点id",required = true)
    @NotEmpty(message = "节点id不得为空")
    private String nodeId;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }
}
