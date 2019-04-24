package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.flow.ConditionNameType;

/**
 * @Description:
 * @Created by ql on 2018/12/15 14:58
 * @Version: v1.0
 */
public class ConditionVariableModel extends Entity<String> {

    @ApiModelProperty(value = "变量类型")
    private ConditionNameType variableName;

    @ApiModelProperty(value = "变量条件")
    private String variableText;

    public ConditionNameType getVariableName() {
        return variableName;
    }

    public void setVariableName(ConditionNameType variableName) {
        this.variableName = variableName;
    }

    public String getVariableText() {
        return variableText;
    }

    public void setVariableText(String variableText) {
        this.variableText = variableText;
    }
}
