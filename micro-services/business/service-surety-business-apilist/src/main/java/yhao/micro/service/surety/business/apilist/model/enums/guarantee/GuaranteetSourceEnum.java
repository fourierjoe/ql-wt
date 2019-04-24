package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/9 18:10
 * @Version: v1.0
 */
public enum GuaranteetSourceEnum {
    BANK("银行"),
    AGENCY_NAME("中介"),
    FRIEND("朋友"),
    RECOMMEND("推荐"),
    ;

    GuaranteetSourceEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (GuaranteetSourceEnum guaranteetSourceEnum : GuaranteetSourceEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(guaranteetSourceEnum.getDesc());
            enumModel.setValue(guaranteetSourceEnum.name());
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
