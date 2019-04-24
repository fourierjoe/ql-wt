package yhao.micro.service.surety.business.apilist.model.enums.twiceRepay;

/**
 * @Description:
 * @Created by ql on 2019/2/21 15:30
 * @Version: v1.0
 */
public enum OperateNameEnum {
	MANAGER_START("客户经理发起"),
	REQUISITES_CONFIRM("要件员确认"),
	TWICE_ARRIVAL("二次到账"),
	TWICE_APPLICATION("申请出账"),
	CANCLE_TWICE_APPLICATION("申请出账"),
	TWICE_BILLING("财务二次出账"),
	TWICE_REDEEM("还款"),
	TWICE_REDEEM_EDIT("修改还款"),
	TWICE_REDEEM_CONFIRM_BALANCE("余款确认"),
	;

	OperateNameEnum(String desc) {
		this.desc = desc;
	}

	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
