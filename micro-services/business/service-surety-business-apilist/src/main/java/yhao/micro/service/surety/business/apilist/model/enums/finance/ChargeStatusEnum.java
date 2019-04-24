package yhao.micro.service.surety.business.apilist.model.enums.finance;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/14 14:49
 * @Description:
 */
public enum ChargeStatusEnum {
    NO_CHARGE("未收费"), NO_CONFIRM("已收费未确认"), CONFIRM("已确认");

    ChargeStatusEnum(String desc) {
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
