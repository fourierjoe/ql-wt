package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

/**
 * @Description:
 * @Created by ql on 2018/12/28 09:43
 * @Version: v1.0
 */
public class BizEntityIdUpdateForm implements ValidationForm {
	@ApiModelProperty(value = "子任务ID")
	@NotBlank(message = "子任务ID不得为空")
	private String id;

	@ApiModelProperty(value = "关联的业务数据主键,单据号")
	@NotBlank(message = "关联的业务数据主键不得为空")
	private String bizEntityId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBizEntityId() {
		return bizEntityId;
	}

	public void setBizEntityId(String bizEntityId) {
		this.bizEntityId = bizEntityId;
	}
}
