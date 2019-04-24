package yhao.micro.service.surety.business.apilist.model.enums.finance;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:25
 * @Description:
 */
public enum PositionTypeEnum {
    CHOOSE_FUNDS("选择资方"),PLAN_FUNDS ("安排进度");

    PositionTypeEnum(String desc) {
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
