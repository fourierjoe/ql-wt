package yhao.micro.service.surety.business.apilist.model.enums.twiceRepay;

/**
 * @Description:
 * @Created by ql on 2019/2/27 17:41
 * @Version: v1.0
 */
public enum ReceipterTypeEnum {
	COMPANY("公司/赎楼员"),
	SELLER("业主"),
	;

	private  String  desc;
	ReceipterTypeEnum(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
