package yhao.micro.service.surety.business.apilist.model.intention.follower;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2019/1/8 17:40
 * @Version: v1.0
 */
public class FollowerAttachmentModel extends Entity<String> {

	@ApiModelProperty(value = "资料名字")
	private String dataName;

	@ApiModelProperty(value = "是否收到")
	private String isReceive;

	@ApiModelProperty(value = "跟单员收到的资料份数")
	private String receiveNums;

	public String getIsReceive() {
		return isReceive;
	}

	public void setIsReceive(String isReceive) {
		this.isReceive = isReceive;
	}

	public String getReceiveNums() {
		return receiveNums;
	}

	public void setReceiveNums(String receiveNums) {
		this.receiveNums = receiveNums;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
}
