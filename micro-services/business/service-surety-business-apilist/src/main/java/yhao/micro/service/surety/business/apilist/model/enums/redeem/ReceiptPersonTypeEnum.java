package yhao.micro.service.surety.business.apilist.model.enums.redeem;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/2 17:44
 * @Description:
 */
public enum ReceiptPersonTypeEnum {
    seller("业主"),
    redeemer("赎楼员");

    ReceiptPersonTypeEnum(String desc) {
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
