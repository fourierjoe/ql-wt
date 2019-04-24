package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description: 物业业主信息
 * @Created by ql on 2019/1/4 18:47
 * @Version: v1.0
 */
public class EstateSellerModel extends Entity<String> {
	@ApiModelProperty(value = "业主ID")
	private String personId;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}
}
