package yhao.micro.service.workflow.apilist.form.flow.processBussiness;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.micro.service.workflow.apilist.form.flow.BaseFlowProcessDefinitionForm;

import javax.validation.Valid;
import java.util.List;

public class BizFlowProcessDefinitionForm extends BaseFlowProcessDefinitionForm {

    @ApiModelProperty(value = "节点",required = true)
    @NotEmpty(message = "节点不得为空")
    @Valid
    private List<BizFlowNodeForm> bizNodes;

    public List<BizFlowNodeForm> getBizNodes() {
        return bizNodes;
    }

    public void setBizNodes(List<BizFlowNodeForm> bizNodes) {
        this.bizNodes = bizNodes;
    }

}
