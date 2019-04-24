package yhao.micro.service.surety.business.apilist.model.enums.complex;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/28 10:19
 * @Description:
 */
public enum OrderType {
    BANK_ORDER("银行指令");

    OrderType(String desc) {
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
