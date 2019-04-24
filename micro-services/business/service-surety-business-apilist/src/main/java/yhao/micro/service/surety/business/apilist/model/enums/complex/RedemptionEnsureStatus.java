package yhao.micro.service.surety.business.apilist.model.enums.complex;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/5 16:21
 * @Description:
 */
public enum RedemptionEnsureStatus {
    SEND("已寄送"), NO_SEND("未寄送"),FOLLOW("跟进"),
    REBACK("已退回");

    RedemptionEnsureStatus(String desc) {
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
