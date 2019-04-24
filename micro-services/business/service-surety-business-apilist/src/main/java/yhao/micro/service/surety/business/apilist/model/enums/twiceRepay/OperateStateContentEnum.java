package yhao.micro.service.surety.business.apilist.model.enums.twiceRepay;

/**
 * @Description:
 * @Created by ql on 2019/2/22 10:55
 * @Version: v1.0
 */
public enum OperateStateContentEnum {
	MANAGER_START_CONTENT("完成", "发起"),
	REQUISITES_CONFIRM_CONTENT("完成", "已确认"),
	TWICE_ARRIVAL_CONTENT("完成", "财务已确认到账，金额{0}元"),
	TWICE_APPLICATION_CONTENT("完成", "发起出账申请, 金额{0}元"),
	TWICE_CANCEL_APPLICATION_CONTENT("完成", "撤销出账申请, 金额{0}元"),
	TWICE_BILLING_CONTENT("完成", "已财务二次出账，金额{0}元"),
	TWICE_REDEEM_CONTENT("完成", "已还款, 还款合计{0}元, 余额{1}元"),
	TWICE_EDIT_REDEEM_CONTENT("完成", "修改还款, 还款合计{0}元, 余额{1}元"),
	TWICE_CONFIRM_BALANCE_CONTENT("完成", "已确认"),
	;

	private String state;
	private String content;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	OperateStateContentEnum(String state, String content) {
		this.state = state;
		this.content = content;
	}
}
