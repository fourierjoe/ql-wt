package yhao.micro.service.surety.business.apilist.model.enums.twiceRepay;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 二次还款菜单资金状态
 * @Created by ql on 2018/12/9 19:03
 * @Version: v1.0
 */
public enum FundStateEnum {

    YARRIVAL("已到账"),
    BILLING("已出账");

    FundStateEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList() {
        List<EnumModel> enumModelList = new ArrayList<>();
        for (FundStateEnum fundStateEnum : FundStateEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(fundStateEnum.getDesc());
            enumModel.setValue(fundStateEnum.name());
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
