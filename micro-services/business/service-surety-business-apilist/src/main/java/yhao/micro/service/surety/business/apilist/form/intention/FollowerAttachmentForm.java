package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2019/1/8 15:15
 * @Version: v1.0
 */
public class FollowerAttachmentForm extends IdForm {

	@ApiModelProperty(value = "是否收到")
	@NotNull(message = "档案资料是否收到必传")
	private YNEnum isReceive;

	@ApiModelProperty(value = "跟单员收到的资料份数")
	@NotBlank(message = "跟单员收到的资料份数必传")
	private String receiveNums;

	public YNEnum getIsReceive() {
		return isReceive;
	}

	public void setIsReceive(YNEnum isReceive) {
		this.isReceive = isReceive;
	}

	public String getReceiveNums() {
		return receiveNums;
	}

	public void setReceiveNums(String receiveNums) {
		this.receiveNums = receiveNums;
	}
}
