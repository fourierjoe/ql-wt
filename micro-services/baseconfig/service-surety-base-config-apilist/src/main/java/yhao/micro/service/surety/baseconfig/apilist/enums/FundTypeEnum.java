package yhao.micro.service.surety.baseconfig.apilist.enums;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资金类型枚举
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:11
 */
public enum FundTypeEnum {
    AMOUNT("额度"), CASH("现金");

    FundTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (FundTypeEnum fundTypeEnum : FundTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(fundTypeEnum.getDesc());
            enumModel.setValue(fundTypeEnum.name());
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
