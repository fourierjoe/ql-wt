package yhao.micro.service.surety.business.apilist.model.guarantee;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * 反担保人
 */
public class AntiModel extends Entity<String> {
	@ApiModelProperty(value = "反担保人房产Id")
	private String estateId;

	public String getEstateId() {
		return estateId;
	}

	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}
}
