package yhao.micro.service.surety.business.apilist.model.enums.finance;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/14 16:13
 * @Description:
 */
public enum ChargeType {
    WARRANTY ("担保费"), OVERDUE ("逾期费"), DELAY ("展期费"), OTHER ("其它");

    ChargeType(String desc) {
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
