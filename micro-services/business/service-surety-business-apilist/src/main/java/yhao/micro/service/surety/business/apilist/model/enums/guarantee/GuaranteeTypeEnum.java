package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 单据类型枚举
 * @Created by ql on 2018/12/9 17:53
 * @Version: v1.0
 */
public enum GuaranteeTypeEnum {
    INTERNAL("内单"),
    EXTERNAL("外单"),
    RECOMMEND("推荐单"),
    ;

    GuaranteeTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (GuaranteeTypeEnum guaranteeTypeEnum : GuaranteeTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(guaranteeTypeEnum.getDesc());
            enumModel.setValue(guaranteeTypeEnum.name());
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
