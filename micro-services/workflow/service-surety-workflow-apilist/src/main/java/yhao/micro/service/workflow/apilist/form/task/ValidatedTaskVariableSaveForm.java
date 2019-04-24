package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.workflow.apilist.enums.flow.ConditionNameType;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2019/1/21 22:53
 * @Version: v1.0
 */
public class ValidatedTaskVariableSaveForm implements ValidationForm {
	@ApiModelProperty(value = "业务单据ID")
	@NotBlank(message = "处理子流程第一个节点时必须传入子表单业务主键...")
	private String bizEntityId;

	@ApiModelProperty(value = "变量类型,例如担保金额")
	@NotNull(message = "处理子流程第一个节点时必须传入变量类型,例如GUARANTEE_AMOUNT(担保金额)")
	private ConditionNameType variableName;

	@ApiModelProperty(value = "变量条件具体内容,例如某一担保单的具体担保金额(万)")
	@NotBlank(message = "处理子流程第一个节点时必须传入条件内容")
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
