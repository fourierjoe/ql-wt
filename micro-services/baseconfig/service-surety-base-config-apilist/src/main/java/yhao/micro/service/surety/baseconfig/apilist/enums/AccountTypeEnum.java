package yhao.micro.service.surety.baseconfig.apilist.enums;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资金账号类型枚举
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 20:56
 */
public enum AccountTypeEnum {
    BASE_TAX_PAYER("基本账户(纳税户)"),
    BASE_SALAY("基本账户(工资、费用户)"),
    NORMAL_SURETY("一般账户(担保费)"),
    NORMAL_FINANCIAL("一般账户(协议存款及理财)"),
    NORMAL_LINES("一般账户(额度款)"),
    NORMAL_REDEMPTION("一般账户(赎楼户)"),
    NORMAL_PAY_BACK("一般账户(中行对他行回款户)"),
    NORMAL_REDEMPTION_PERSON("一般账户(赎楼员账户)"),
    NORMAL_REST("一般账户(收付余款)"),
    NORMAL_CONSULT("一般账户(咨询业务)"),
    NORMAL_MORTGAGE("一般账户(按揭款)"),
    NORMAL_SELF("自有资金"),
    CASH("现金"),
    SECUIRTY_FUND_FIXED("保证金定期"),
    SECUIRTY_FUND_CURRENT("保证金活期");

    AccountTypeEnum(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (AccountTypeEnum accountTypeEnum : AccountTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(accountTypeEnum.getDesc());
            enumModel.setValue(accountTypeEnum.name());
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
