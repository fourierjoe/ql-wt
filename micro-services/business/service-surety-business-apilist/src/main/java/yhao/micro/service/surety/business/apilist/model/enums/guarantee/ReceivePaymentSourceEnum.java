package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/1/4 14:37
 * @Version: v1.0
 */
public enum ReceivePaymentSourceEnum {
	SUPERVISION("监管资金"),
	MERCHANTS("商业贷款"),
	PUBLIC("公积金贷款"),
	;

	ReceivePaymentSourceEnum(String desc) {
		this.desc = desc;
	}

	public static List<EnumModel> toEnumModelList() {
		List<EnumModel> enumModelList = new ArrayList<>();
		for (ReceivePaymentSourceEnum receivePaymentSourceEnum : ReceivePaymentSourceEnum.values()) {
			EnumModel enumModel = new EnumModel();
			enumModel.setName(receivePaymentSourceEnum.getDesc());
			enumModel.setValue(receivePaymentSourceEnum.name());
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
