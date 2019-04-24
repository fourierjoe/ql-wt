package yhao.micro.service.surety.business.apilist.model.intention.repay;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.intention.RepayTypeEnum;

import java.sql.Date;

/**
 * @Description:
 * @Created by ql on 2019/1/24 10:53
 * @Version: v1.0
 */
public class FollowerRedeemModel extends Entity<String> {
	@ApiModelProperty(value = "还款申请类型") //RepayTypeEnum
	private String repayType;

	@ApiModelProperty(value = "还款申请类型(页面显示)") //RepayTypeEnum
	private String repayTypeEnum;

	@ApiModelProperty(value = "还款申请安排时间")
	private Date repayExpectedDate;

	@ApiModelProperty(value = "还款申请办理人ID")
	private String redeemId;

	public String getRepayTypeEnum() {
		return repayTypeEnum;
	}

	public void setRepayTypeEnum(String repayTypeEnum) {
		if (RepayTypeEnum.DETERMINED.toString().equals(repayType)) {
			this.repayTypeEnum = RepayTypeEnum.DETERMINED.getDesc();
		} else if (RepayTypeEnum.UNDETERMINED.toString().equals(repayType)) {
			this.repayTypeEnum = RepayTypeEnum.UNDETERMINED.getDesc();
		} else if (RepayTypeEnum.TONGHUANSUIXING.toString().equals(repayType)) {
			this.repayTypeEnum = RepayTypeEnum.TONGHUANSUIXING.getDesc();
		} else if (RepayTypeEnum.MANAGERDEAL.toString().equals(repayType)) {
			this.repayTypeEnum = RepayTypeEnum.MANAGERDEAL.getDesc();
		} else {
			this.repayTypeEnum = "";
		}
	}

	public String getRepayType() {
		return repayType;
	}

	public void setRepayType(String repayType) {
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
