package yhao.micro.service.surety.business.apilist.model.enums.twiceRepay;

/**
 * @Description:
 * @Created by ql on 2019/2/25 17:46
 * @Version: v1.0
 */
public enum DataAuthEnum {
	K("客户经理发起", 1),
	Y("要件员确认", 2),
	D("二次到账", 3),
	S("出账申请", 4),
	C("二次出账", 5),
	H("二次还款", 6),
	;

	private String desc;
	private int twiceRepayState;

	public int getTwiceRepayState() {
		return twiceRepayState;
	}

	public void setTwiceRepayState(int twiceRepayState) {
		this.twiceRepayState = twiceRepayState;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	DataAuthEnum(String desc, int twiceRepayState) {
		this.desc = desc;
		this.twiceRepayState = twiceRepayState;
	}
}
