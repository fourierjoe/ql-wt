package yhao.micro.service.workflow.apilist.form.flow.processCenter;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.micro.service.workflow.apilist.form.flow.BaseFlowProcessDefinitionForm;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

public class FlowProcessDefinitionForm extends BaseFlowProcessDefinitionForm {

    @ApiModelProperty(value = "节点",required = true)
    @NotEmpty(message = "至少两个节点")
    @Size(min = 2, message = "至少两个节点")
    @Valid
    private List<FlowNodeForm> nodes;

    @ApiModelProperty(value = "流程界面布局元素JSON串", hidden = true)
    @NotBlank(message = "流程界面布局元素JSON串不能为空")
    private String layoutJson = "流程界面布局元素JSON串";

    public List<FlowNodeForm> getNodes() {
        return nodes;
    }

    public void setNodes(List<FlowNodeForm> nodes) {
        this.nodes = nodes;
    }

    public String getLayoutJson() {
        return layoutJson;
    }

    public void setLayoutJson(String layoutJson) {
        this.layoutJson = layoutJson;
    }

}
