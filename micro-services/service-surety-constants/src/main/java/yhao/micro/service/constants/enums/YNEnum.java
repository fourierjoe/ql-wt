package yhao.micro.service.constants.enums;

/**
 * Created with IntelliJ IDEA.
 * Description:表示 是否的枚举
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:08
 */
public enum YNEnum {
    YES("是"), NO("否");

    YNEnum(String desc) {
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
