package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用户类型
 * @Created by ql on 2019/1/4 11:06
 * @Version: v1.0
 */
public enum CltTypEnum {
	BUYER("买家"),
	SELLER("卖家"),
	;

	CltTypEnum(String desc) {
		this.desc = desc;
	}

	public static List<EnumModel> toEnumModelList() {
		List<EnumModel> enumModelList = new ArrayList<>();
		for (CltTypEnum cltTypEnum : CltTypEnum.values()) {
			EnumModel enumModel = new EnumModel();
			enumModel.setName(cltTypEnum.getDesc());
			enumModel.setValue(cltTypEnum.name());
			enumModelList.add(enumModel);
		}
		return enumModelList;
	}

	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
