package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2019/1/17 11:36
 * @Version: v1.0
 */
public class ItemResultModel extends Entity<String> {
	@ApiModelProperty(value = "事项结果编码集合")
	private String itemConfig;

	@ApiModelProperty(value = "事项结果期望值编码")
	private String itemExpect;

	public String getItemConfig() {
		return itemConfig;
	}

	public void setItemConfig(String itemConfig) {
		this.itemConfig = itemConfig;
	}

	public String getItemExpect() {
		return itemExpect;
	}

	public void setItemExpect(String itemExpect) {
		this.itemExpect = itemExpect;
	}
}
