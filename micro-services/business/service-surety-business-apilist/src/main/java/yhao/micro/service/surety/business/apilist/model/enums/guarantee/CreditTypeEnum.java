package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/4 11:15
 * @Version: v1.0
 */
public enum CreditTypeEnum {
	UNDETERMINED("时间待定"),
	DETERMINED("时间确定"),
	MANAGERDEAL("客户经理办理或客户办理"),
	;

	CreditTypeEnum(String desc) {
		this.desc = desc;
	}

	public static List<EnumModel> toEnumModelList() {
		List<EnumModel> enumModelList = new ArrayList<>();
		for (CreditTypeEnum creditTypeEnum : CreditTypeEnum.values()) {
			EnumModel enumModel = new EnumModel();
			enumModel.setName(creditTypeEnum.getDesc());
			enumModel.setValue(creditTypeEnum.name());
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
