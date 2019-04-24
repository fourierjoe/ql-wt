package yhao.micro.service.surety.business.apilist.model.guarantee.page;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2019/1/14 16:08
 * @Version: v1.0
 */
public class EstatePageModel extends Entity<String> {
	@ApiModelProperty(value = "房产名称", example = "XX房产")
	private String estateName;

	public String getEstateName() {
		return estateName;
	}

	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}

}
