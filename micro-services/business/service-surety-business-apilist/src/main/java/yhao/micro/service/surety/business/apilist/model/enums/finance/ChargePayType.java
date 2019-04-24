package yhao.micro.service.surety.business.apilist.model.enums.finance;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/14 16:19
 * @Description:
 */
public enum ChargePayType {
    CASH("现金"), BANK("银行"), MONTHLY("月结");

    ChargePayType(String desc) {
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
