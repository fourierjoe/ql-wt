package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/4 11:02
 * @Version: v1.0
 */
public enum  DeedTypeEnum {
	FCZ("房产证"),
	BDCZ("不动产证"),
	;

	DeedTypeEnum(String desc) {
		this.desc = desc;
	}

	public static List<EnumModel> toEnumModelList() {
		List<EnumModel> enumModelList = new ArrayList<>();
		for (DeedTypeEnum deedTypeEnum : DeedTypeEnum.values()) {
			EnumModel enumModel = new EnumModel();
			enumModel.setName(deedTypeEnum.getDesc());
			enumModel.setValue(deedTypeEnum.name());
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
