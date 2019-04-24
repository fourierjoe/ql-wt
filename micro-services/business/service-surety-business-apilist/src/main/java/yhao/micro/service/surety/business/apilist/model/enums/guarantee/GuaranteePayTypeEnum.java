package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 担保单付款方式
 * @Created by ql on 2018/12/10 11:50
 * @Version: v1.0
 */
public enum GuaranteePayTypeEnum {
    MORTGAGE_LOAN("按揭贷款"),
    COMBINATION_LOAN("组合贷款"),
    PUBLIC_LOAN("公积金贷款"),
    ONETIME_LOAN("一次性贷款"),
    ;

    GuaranteePayTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (GuaranteePayTypeEnum guaranteePayTypeEnum : GuaranteePayTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(guaranteePayTypeEnum.getDesc());
            enumModel.setValue(guaranteePayTypeEnum.name());
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
