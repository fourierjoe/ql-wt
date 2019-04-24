package yhao.micro.service.surety.business.apilist.form.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Description:
 * @Created by ql on 2019/2/28 10:00
 * @Version: v1.0
 */
public class AssociateGuaranteeForm extends PageForm {
	@ApiModelProperty(value = "单号/业主/客户姓名")
	private String mixQuery;

	public String getMixQuery() {
		return mixQuery;
	}

	public void setMixQuery(String mixQuery) {
		this.mixQuery = mixQuery;
	}
}
