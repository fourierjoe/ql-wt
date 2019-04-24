package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 使用表名+字段替代
 * @Created by ql on 2018/12/9 18:15
 * @Version: v1.0
 */
public enum GuaranteeBankTypeEnum {

    LOAN_SELLER999FLOAN_MB_ID("原按揭银行"),
    GUARANTEE_SITUATION999FREDEEM_BANK_ID("出赎楼款银行"),
    LOAN_BUYER999FLOAN_MB_ID("新按揭银行"),
    LOAN_BUYER999FSUPERVISION_BANK_1_ID("监管银行"),
    LOAN_SELLER999FLOAN_PB_ID("公积金银行"),
    ;

    GuaranteeBankTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList() {
        List<EnumModel> enumModelList = new ArrayList<>();
        for (GuaranteeBankTypeEnum guaranteeBankTypeEnum : GuaranteeBankTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(guaranteeBankTypeEnum.getDesc());
            enumModel.setValue(guaranteeBankTypeEnum.name());
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
