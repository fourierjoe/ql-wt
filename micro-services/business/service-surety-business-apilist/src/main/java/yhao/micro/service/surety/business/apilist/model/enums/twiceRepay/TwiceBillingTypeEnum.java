package yhao.micro.service.surety.business.apilist.model.enums.twiceRepay;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/2/21 11:46
 * @Version: v1.0
 */
public enum TwiceBillingTypeEnum {
	CASH("现金"),
	CHECK("支票"),
	;

	TwiceBillingTypeEnum(String desc) {
		this.desc = desc;
	}

	public static List<EnumModel> toEnumModelList() {
		List<EnumModel> enumModelList = new ArrayList<>();
		for (TwiceBillingTypeEnum twiceBillingTypeEnum : TwiceBillingTypeEnum.values()) {
			EnumModel enumModel = new EnumModel();
			enumModel.setName(twiceBillingTypeEnum.getDesc());
			enumModel.setValue(twiceBillingTypeEnum.name());
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
