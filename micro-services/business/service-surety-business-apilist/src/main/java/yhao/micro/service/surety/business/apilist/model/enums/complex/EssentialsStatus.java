package yhao.micro.service.surety.business.apilist.model.enums.complex;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/7 11:02
 * @Description:要件状态
 */
public enum EssentialsStatus {
    TAKE("已收取"), LEND("已借出"),
    REMAND("已收回"),REBACK("已退回");

    EssentialsStatus(String desc) {
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
