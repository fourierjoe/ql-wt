package yhao.micro.service.surety.business.apilist.model.enums.complex;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/5 17:12
 * @Description:
 */
public enum EssentialsType {
    REDEMPTION("赎楼"), REPAYMENT("跟进"),
    TRANSFER("中转");

    EssentialsType(String desc) {
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
