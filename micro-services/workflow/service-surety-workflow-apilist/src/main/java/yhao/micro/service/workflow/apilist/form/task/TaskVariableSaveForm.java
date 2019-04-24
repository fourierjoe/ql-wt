package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.workflow.apilist.enums.flow.ConditionNameType;

/**
 * @Description:
 * @Created by ql on 2018/12/26 15:20
 * @Version: v1.0
 */
public class TaskVariableSaveForm extends IdUnForm {
	@ApiModelProperty(value = "业务单据ID")
	private String bizEntityId;

	@ApiModelProperty(value = "变量类型,例如担保金额")
	private ConditionNameType variableName;

	@ApiModelProperty(value = "变量条件具体内容,例如某一担保单的具体担保金额(万)")
	private String variableText;

	public String getBizEntityId() {
		return bizEntityId;
	}

	public void setBizEntityId(String bizEntityId) {
		this.bizEntityId = bizEntityId;
	}

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
