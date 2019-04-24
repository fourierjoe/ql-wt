package yhao.micro.service.surety.baseconfig.apilist.enums;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:需要指令的业务范围枚举
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:19
 */
public enum CommandScopeEnum {
    ALL("全部"),
    SELF_REDEEM("自赎"),
    NOT_SELF_REDEEM("非自赎");

    CommandScopeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (CommandScopeEnum commandScopeEnum : CommandScopeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(commandScopeEnum.getDesc());
            enumModel.setValue(commandScopeEnum.name());
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
