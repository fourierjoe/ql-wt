package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 担保导航菜单搜索收费状态
 * @Created by ql on 2018/12/9 17:41
 * @Version: v1.0
 */
public enum GuaranteeChargeStateEnum {

    NO_CHARGE("未收费"),
    CHARGED("已收费"),
    FINANCIAL_CONFIRMED("财务已确认"),
    ;

    GuaranteeChargeStateEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (GuaranteeChargeStateEnum guaranteeChargeStateEnum : GuaranteeChargeStateEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(guaranteeChargeStateEnum.getDesc());
            enumModel.setValue(guaranteeChargeStateEnum.name());
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
