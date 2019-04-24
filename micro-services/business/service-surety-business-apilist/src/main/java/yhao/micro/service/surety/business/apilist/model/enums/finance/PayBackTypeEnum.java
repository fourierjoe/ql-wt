package yhao.micro.service.surety.business.apilist.model.enums.finance;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:50
 * @Description:
 */
public enum PayBackTypeEnum {
    SELF_SAVE("业主自存"),
    DEDUCTION("回款扣除"),
    OTHER("其它");


    PayBackTypeEnum(String desc) {
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
