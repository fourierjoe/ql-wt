package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 证件类型
 * @Created by ql on 2019/1/4 11:09
 * @Version: v1.0
 */
public enum CtfTypEnum {

	P01("身份证"),
	P31("护照"),
	;

	CtfTypEnum(String desc) {
		this.desc = desc;
	}

	public static List<EnumModel> toEnumModelList() {
		List<EnumModel> enumModelList = new ArrayList<>();
		for (CtfTypEnum ctfTypEnum : CtfTypEnum.values()) {
			EnumModel enumModel = new EnumModel();
			enumModel.setName(ctfTypEnum.getDesc());
			enumModel.setValue(ctfTypEnum.name());
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
