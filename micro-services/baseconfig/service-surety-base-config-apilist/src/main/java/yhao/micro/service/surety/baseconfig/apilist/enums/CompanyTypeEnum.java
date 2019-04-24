package yhao.micro.service.surety.baseconfig.apilist.enums;

import yhao.micro.service.constants.model.EnumModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:合作方公司类型 枚举
 * User: GUO.MAO.LIN
 * Date: 2018-12-01
 * Time: 14:26
 */
public enum CompanyTypeEnum {
    INTERMEDIARY_COMPANY("中介公司"),
    LAW_FIRM("律师楼"),
    OTHER("其他");

    CompanyTypeEnum(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static List<EnumModel> toEnumModelList(){
        List<EnumModel> enumModelList = new ArrayList<>();
        for (CompanyTypeEnum companyTypeEnum : CompanyTypeEnum.values()) {
            EnumModel enumModel = new EnumModel();
            enumModel.setName(companyTypeEnum.getDesc());
            enumModel.setValue(companyTypeEnum.name());
            enumModelList.add(enumModel);
        }
        return enumModelList;
    }
}
