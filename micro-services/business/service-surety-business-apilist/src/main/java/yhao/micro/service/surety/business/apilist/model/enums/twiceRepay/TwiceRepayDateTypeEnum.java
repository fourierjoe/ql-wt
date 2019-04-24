package yhao.micro.service.surety.business.apilist.model.enums.twiceRepay;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/9 19:07
 * @Version: v1.0
 */
public enum TwiceRepayDateTypeEnum {
    FN_BILLING_GENERAL999FCONFIRM_BILLING_DATE("确认出账日期"),
    FN_ARRIVAL_GENERAL999FCONFIRM_ARRIVAL_DATE("到账日期"),
    REDEEM999FREDEEM_DATE("赎楼日期"),
    ;

    TwiceRepayDateTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (TwiceRepayDateTypeEnum twiceRepayDateTypeEnum : TwiceRepayDateTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(twiceRepayDateTypeEnum.getDesc());
            enumModel.setValue(twiceRepayDateTypeEnum.name());
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
