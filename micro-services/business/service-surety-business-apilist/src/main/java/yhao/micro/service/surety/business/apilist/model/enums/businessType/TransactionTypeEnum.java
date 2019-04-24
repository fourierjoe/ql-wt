package yhao.micro.service.surety.business.apilist.model.enums.businessType;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 交易类型枚举
 * @Created by ql on 2018/12/9 17:28
 * @Version: v1.0
 */
public enum TransactionTypeEnum {
    TRANSACTION("交易类"),
    NOT_TRANSACTION("非交易类"),
    ;

    TransactionTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (TransactionTypeEnum transactionTypeEnum : TransactionTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(transactionTypeEnum.getDesc());
            enumModel.setValue(transactionTypeEnum.name());
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
