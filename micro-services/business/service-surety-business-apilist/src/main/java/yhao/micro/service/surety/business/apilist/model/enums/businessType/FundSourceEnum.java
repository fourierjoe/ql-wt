package yhao.micro.service.surety.business.apilist.model.enums.businessType;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 资金来源枚举
 * @Created by ql on 2018/12/9 17:31
 * @Version: v1.0
 */
public enum FundSourceEnum {
    BANK_FUND("银行资金"),
    COMPANY_FUND("公司资金"),
    FORIGN_FUND("外部资金"),
    ;

    FundSourceEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (FundSourceEnum fundSourceEnum : FundSourceEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(fundSourceEnum.getDesc());
            enumModel.setValue(fundSourceEnum.name());
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
