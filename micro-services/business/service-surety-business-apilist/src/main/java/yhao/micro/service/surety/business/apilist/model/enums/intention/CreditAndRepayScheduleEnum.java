package yhao.micro.service.surety.business.apilist.model.enums.intention;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 查征信进度和还款申请进度枚举
 * @Created by ql on 2018/12/9 17:10
 * @Version: v1.0
 */
public enum CreditAndRepayScheduleEnum {

    NO_ARRANGE("未安排"),
    NO_DEAL("已安排待办理"),
    DEALED("已办理,确认办结"),
    ;

    CreditAndRepayScheduleEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (CreditAndRepayScheduleEnum creditAndRepayScheduleEnum : CreditAndRepayScheduleEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(creditAndRepayScheduleEnum.getDesc());
            enumModel.setValue(creditAndRepayScheduleEnum.name());
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
