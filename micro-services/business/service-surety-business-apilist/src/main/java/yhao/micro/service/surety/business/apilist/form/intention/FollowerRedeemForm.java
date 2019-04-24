package yhao.micro.service.surety.business.apilist.form.intention;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.surety.business.apilist.model.enums.intention.RepayTypeEnum;

import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/8 15:10
 * @Version: v1.0
 */
public class FollowerRedeemForm extends IdForm {

	@ApiModelProperty(value = "还款申请类型")
	@NotNull(message = "还款申请类型不得为空")
	private RepayTypeEnum repayType;

	@ApiModelProperty(value = "还款申请安排时间")
	private Date repayExpectedDate;

	@ApiModelProperty(value = "还款申请办理人ID")
	private String redeemId;

	public RepayTypeEnum getRepayType() {
		return repayType;
	}

	public void setRepayType(RepayTypeEnum repayType) {
		this.repayType = repayType;
	}

	public Date getRepayExpectedDate() {
		return repayExpectedDate;
	}

	public void setRepayExpectedDate(Date repayExpectedDate) {
		this.repayExpectedDate = repayExpectedDate;
	}

	public String getRedeemId() {
		return redeemId;
	}

	public void setRedeemId(String redeemId) {
		this.redeemId = redeemId;
	}

}
