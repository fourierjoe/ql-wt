package yhao.micro.service.surety.erp.org.apilist.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:组织类型枚举
 * User: GUO.MAO.LIN
 * Date: 2018-12-06
 * Time: 18:35
 */
public enum OrgTypeEnum {
    CITY("城市组织"),
    OPERATION_FINANCIAL("财务组织"),
    OPERATION_HUMANRESOURCE("人力组织"),
    OPERATION_MORTGAGE("按揭组织"),
    OPERATION_RESOURCEMANAGE("资源管理"),
    OPERATION_ADMIN("行政部"),
    OPERATION_GENERALMANAGER("总经办"),
    OPERATION_LEGAL("法务组织"),
    OPERATION_TRAIN("培训组织"),
    OPERATION_SECURITY("担保组织"),
    OPERATION_OTHER("其他"),
    ERP_OTHER("ERP其他组织");

    OrgTypeEnum(String desc) {
        this.desc = desc;
    }

    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
