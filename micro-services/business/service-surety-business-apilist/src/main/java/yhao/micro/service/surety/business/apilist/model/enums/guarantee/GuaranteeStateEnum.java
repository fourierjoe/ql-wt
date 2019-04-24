package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

/**
 * @Description:
 * @Created by ql on 2019/2/27 15:48
 * @Version: v1.0
 */
public enum GuaranteeStateEnum {
	SAVE("保存"),
	SUBMIT("提交"),
	RECALL("撤回"),
	;
	private String desc;
	GuaranteeStateEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
