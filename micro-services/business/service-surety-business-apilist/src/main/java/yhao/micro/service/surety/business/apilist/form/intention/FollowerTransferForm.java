package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2019/1/8 16:45
 * @Version: v1.0
 */
public class FollowerTransferForm extends IdForm {
	@ApiModelProperty(value = "跟单员转单状态", required = true, example = "YES")
	@NotNull(message = "跟单员转单状态不得为空")
	private YNEnum transferState = YNEnum.YES;

	public YNEnum getTransferState() {
		return transferState;
	}

	public void setTransferState(YNEnum transferState) {
		this.transferState = transferState;
	}
}
