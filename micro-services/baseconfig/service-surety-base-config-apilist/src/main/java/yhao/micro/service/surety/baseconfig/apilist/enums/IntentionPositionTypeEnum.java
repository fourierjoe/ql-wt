package yhao.micro.service.surety.baseconfig.apilist.enums;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:单据分配中岗位类型枚举
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 14:11
 */
public enum IntentionPositionTypeEnum {
    FOLLOWER("跟单员"),
    DECLARER("报单员");

    IntentionPositionTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (IntentionPositionTypeEnum positionTypeEnum : IntentionPositionTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(positionTypeEnum.getDesc());
            enumModel.setValue(positionTypeEnum.name());
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
