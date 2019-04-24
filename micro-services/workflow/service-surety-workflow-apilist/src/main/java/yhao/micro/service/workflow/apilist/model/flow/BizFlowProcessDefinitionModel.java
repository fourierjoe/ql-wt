package yhao.micro.service.workflow.apilist.model.flow;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2018/12/18 17:30
 * @Version: v1.0
 */
public class BizFlowProcessDefinitionModel extends Entity<String> {

    @ApiModelProperty(value = "redis中的流程定义信息")
    private  FlowProcessDefinitionModel flowProcessDefinitionModel;

    @ApiModelProperty(value = "流程界面布局元素JSON串")
    private String layoutJson;

    public FlowProcessDefinitionModel getFlowProcessDefinitionModel() {
        return flowProcessDefinitionModel;
    }

    public void setFlowProcessDefinitionModel(FlowProcessDefinitionModel flowProcessDefinitionModel) {
        this.flowProcessDefinitionModel = flowProcessDefinitionModel;
    }

    public String getLayoutJson() {
        return layoutJson;
    }

    public void setLayoutJson(String layoutJson) {
        this.layoutJson = layoutJson;
    }
}
