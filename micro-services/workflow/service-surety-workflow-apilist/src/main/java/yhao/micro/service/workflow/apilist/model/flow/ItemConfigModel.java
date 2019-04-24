package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description:
 * @Created by ql on 2019/1/17 19:48
 * @Version: v1.0
 */
public class ItemConfigModel extends Entity<String> {
	@ApiModelProperty(value = "事项名称")
	private String itemName;

	@ApiModelProperty(value = "事项配置")
	private String itemConfig;

	@ApiModelProperty(value = "事项编码")
	private String itemCode;

	@ApiModelProperty(value = "事项结果编码")
	private String itemResultCode;

	@ApiModelProperty(value = "事项结果(文字)")
	private String itemResult;

	public String getItemResultCode() {
		return itemResultCode;
	}

	public void setItemResultCode(String itemResultCode) {
		this.itemResultCode = itemResultCode;
	}

	public String getItemResult() {
		return itemResult;
	}

	public void setItemResult(String itemResult) {
		this.itemResult = itemResult;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemConfig() {
		return itemConfig;
	}

	public void setItemConfig(String itemConfig) {
		this.itemConfig = itemConfig;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
}
