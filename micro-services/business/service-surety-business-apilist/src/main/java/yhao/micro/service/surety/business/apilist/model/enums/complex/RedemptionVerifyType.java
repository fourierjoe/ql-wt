package yhao.micro.service.surety.business.apilist.model.enums.complex;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 16:44
 * @Description:退尾款核实方式
 */

public enum RedemptionVerifyType {
    PHONE("电话核实"),ACCOUNT("附账号"),
    WITNESS("见证人");

    RedemptionVerifyType(String desc) {
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
