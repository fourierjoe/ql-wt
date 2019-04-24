package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

/**
 * @Description:
 * @Created by ql on 2019/2/28 10:43
 * @Version: v1.0
 */
public enum BundTypeEnum {
	A("未申请"),
	B("待部门经理审批"),
	C("待副总审批"),
	D("待财务审批"),
	E("待总经理审批"),
	F("资金已到位"),
	G("额度款未到账"),
	H("额度款已到账"),
	I("驳回"),
	;

	private String desc;
	BundTypeEnum(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
