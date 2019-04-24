package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Description:
 * @Created by ql on 2019/3/4 11:33
 * @Version: v1.0
 */
public class BalanceConfirmForm extends IdForm {
	@ApiModelProperty(value = "担保单Id")
	@NotBlank(message = "担保单Id不能为空")
	private String guaranteeId;

	@ApiModelProperty(value = "余款到账日期")
	@NotNull(message = "余款到账日期不能为空")
	private Date balanceConfirmDate;

	public String getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(String guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public Date getBalanceConfirmDate() {
		return balanceConfirmDate;
	}

	public void setBalanceConfirmDate(Date balanceConfirmDate) {
		this.balanceConfirmDate = balanceConfirmDate;
	}
}
