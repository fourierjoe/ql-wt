package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

/**
 * @Description:
 * @Created by ql on 2019/2/28 10:53
 * @Version: v1.0
 */
public enum ModelEnum {
	NO("未建模"),
	YES("已建模"),
	ASSOCIATE("已关联"),
	;

	private String desc;
	ModelEnum(String desc) {
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
