package yhao.micro.service.surety.business.apilist.model.enums.intention;

import yhao.micro.service.constants.model.EnumModel;
import yhao.micro.service.surety.business.apilist.model.enums.guarantee.CreditTypeEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 还款申请类型
 * @Created by ql on 2019/1/8 15:32
 * @Version: v1.0
 */
public enum RepayTypeEnum {
	UNDETERMINED("时间待定"),
	DETERMINED("时间确定"),
	TONGHUANSUIXING("同还随行"),
	MANAGERDEAL("客户经理办理或客户办理"),
	;

	RepayTypeEnum(String desc) {
		this.desc = desc;
	}

	public static List<EnumModel> toEnumModelList() {
		List<EnumModel> enumModelList = new ArrayList<>();
		for (RepayTypeEnum repayTypeEnum : RepayTypeEnum.values()) {
			EnumModel enumModel = new EnumModel();
			enumModel.setName(repayTypeEnum.getDesc());
			enumModel.setValue(repayTypeEnum.name());
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
