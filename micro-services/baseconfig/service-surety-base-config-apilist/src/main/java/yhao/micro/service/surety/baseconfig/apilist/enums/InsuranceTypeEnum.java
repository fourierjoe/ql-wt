package yhao.micro.service.surety.baseconfig.apilist.enums;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:保险费类型枚举
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 20:29
 */
public enum InsuranceTypeEnum {
    FIXD("固定费率"),
    SECTION("分段费率"),
    NONE("无");

    InsuranceTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (InsuranceTypeEnum insuranceTypeEnum : InsuranceTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(insuranceTypeEnum.getDesc());
            enumModel.setValue(insuranceTypeEnum.name());
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
