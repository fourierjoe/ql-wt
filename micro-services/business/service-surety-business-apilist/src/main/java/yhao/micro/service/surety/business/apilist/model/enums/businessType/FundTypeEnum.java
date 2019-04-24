package yhao.micro.service.surety.business.apilist.model.enums.businessType;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/9 17:31
 * @Version: v1.0
 */
public enum FundTypeEnum {
    AMOUNT("额度"),
    CASH("现金"),
    CREDIT("信用垫资"),
    ;

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
