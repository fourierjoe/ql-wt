package yhao.micro.service.surety.baseconfig.apilist.enums;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资方银行类型 枚举
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 15:13
 */
public enum FundProviderTypeEnum {
    BRANCH("分行"),
    HEAD("总行");

    FundProviderTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (FundProviderTypeEnum fundProviderTypeEnum : FundProviderTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(fundProviderTypeEnum.getDesc());
            enumModel.setValue(fundProviderTypeEnum.name());
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
