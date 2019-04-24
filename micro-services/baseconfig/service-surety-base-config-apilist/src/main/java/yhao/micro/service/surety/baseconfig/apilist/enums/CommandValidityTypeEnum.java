package yhao.micro.service.surety.baseconfig.apilist.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 10:21
 */
public enum  CommandValidityTypeEnum {
    WORK_DAY("工作日"),NATURAL_DAY("自然日"),PERMANENT("长期有效");

    CommandValidityTypeEnum(String desc) {
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
