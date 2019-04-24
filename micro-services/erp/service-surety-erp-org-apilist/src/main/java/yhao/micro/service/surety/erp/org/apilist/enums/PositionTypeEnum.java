package yhao.micro.service.surety.erp.org.apilist.enums;

/**
 * Created by yoara on 2018/1/10.
 */
public enum PositionTypeEnum {
    MAJOR("主职"),
    PART("兼职"),
    ;

    private String desc;

    PositionTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
