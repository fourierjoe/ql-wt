package yhao.micro.service.surety.business.apilist.model.intention;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.intention.CreditAndRepayScheduleEnum;

/**
 * @Description:
 * @Created by ql on 2019/1/24 10:29
 * @Version: v1.0
 */
public class IntentionBasePageModel extends Entity<String> {

	@ApiModelProperty(value = "征信办理进度")
	private String creditState;

	@ApiModelProperty("还款申请办理进度")
	private String repayState;

	@ApiModelProperty(value = "征信办理进度(界面显示)")
	private String creditStateEnum;

	@ApiModelProperty("还款申请办理进度(界面显示)")
	private String repayStateEnum;

	public String getCreditStateEnum() {
		return creditStateEnum;
	}

	public void setCreditStateEnum(String creditStateEnum) {
		if (CreditAndRepayScheduleEnum.NO_DEAL.toString().equals(creditState)) {
			this.creditStateEnum = CreditAndRepayScheduleEnum.NO_DEAL.getDesc();
		} else if (CreditAndRepayScheduleEnum.NO_ARRANGE.toString().equals(creditState)) {
			this.creditStateEnum = CreditAndRepayScheduleEnum.NO_ARRANGE.getDesc();
		} else if (CreditAndRepayScheduleEnum.DEALED.toString().equals(creditState)) {
			this.creditStateEnum = CreditAndRepayScheduleEnum.DEALED.getDesc();
		} else {
			this.creditStateEnum = "";
		}
	}

	public String getRepayStateEnum() {
		return repayStateEnum;
	}

	public void setRepayStateEnum(String repayStateEnum) {
		if (CreditAndRepayScheduleEnum.NO_DEAL.toString().equals(repayState)) {
			this.repayStateEnum = CreditAndRepayScheduleEnum.NO_DEAL.getDesc();
		} else if (CreditAndRepayScheduleEnum.NO_ARRANGE.toString().equals(repayState)) {
			this.repayStateEnum = CreditAndRepayScheduleEnum.NO_ARRANGE.getDesc();
		} else if (CreditAndRepayScheduleEnum.DEALED.toString().equals(repayState)) {
			this.repayStateEnum = CreditAndRepayScheduleEnum.DEALED.getDesc();
		} else {
			this.repayStateEnum = "";
		}
	}

	public String getCreditState() {
		return creditState;
	}

	public void setCreditState(String creditState) {
		this.creditState = creditState;
	}

	public String getRepayState() {
		return repayState;
	}

	public void setRepayState(String repayState) {
		this.repayState = repayState;
	}
}
