package yhao.micro.service.surety.business.apilist.model.enums.guarantee;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 类型使用表名,易于查表
 * @Created by ql on 2018/12/9 18:02
 * @Version: v1.0
 */
public enum GuaranteeDateTypeEnum {
    REDEEM999FREDEEM_DATE("赎楼日期"),
    FN_BILLING_GENERAL999FFIRST_BILLING_DATE("放款日期"),
    RDT_AFTER_FOLLOW999FCERT_LOGOUT_DATE("注销日期"),
    RDT_AFTER_FOLLOW999FTRANSFER_DATE("过户日期"),
    RDT_AFTER_FOLLOW999FTAKE_NEWCERT_DATE("取新证日期"),
    RDT_AFTER_FOLLOW999FTAKE_CERT_DATE("取原证日期"),
    RDT_AFTER_FOLLOW999FMORTGAGE_DATE("抵押日期"),
    RDT_AFTER_FOLLOW999FUNPROTECTED_DATE("解保日期"),
    TOLL_GENERAL999FCONFIRM_WARRANTY_DATE("收费确认日期"),
    REDEMPTION_ENSURE999FSEND_DATE("保函寄出日期"),
    ;

    GuaranteeDateTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (GuaranteeDateTypeEnum guaranteeDateTypeEnum : GuaranteeDateTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(guaranteeDateTypeEnum.getDesc());
            enumModel.setValue(guaranteeDateTypeEnum.name());
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
