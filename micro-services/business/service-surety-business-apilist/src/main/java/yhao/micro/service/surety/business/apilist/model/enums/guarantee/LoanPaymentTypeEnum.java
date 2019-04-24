package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

/**
 * @Description:
 * @Created by ql on 2019/3/7 18:16
 * @Version: v1.0
 */
public enum LoanPaymentTypeEnum {
	AUTONOMOUS("自主支付"),
	TRUSTEESHIP("受托支付"),
	;

	private String desc;
	LoanPaymentTypeEnum(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
