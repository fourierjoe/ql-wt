package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @Created by ql on 2018/12/27 15:26
 * @Version: v1.0
 */
public class SysPamModel {
	@ApiModelProperty(value = "根参数")
	private String pamRot;

	@ApiModelProperty(value = "参数代码")
	private String pamCod;

	@ApiModelProperty(value = "参数代码解释")
	private String pamExp;

	public String getPamRot() {
		return pamRot;
	}

	public void setPamRot(String pamRot) {
		this.pamRot = pamRot;
	}

	public String getPamCod() {
		return pamCod;
	}

	public void setPamCod(String pamCod) {
		this.pamCod = pamCod;
	}

	public String getPamExp() {
		return pamExp;
	}

	public void setPamExp(String pamExp) {
		this.pamExp = pamExp;
	}
}
