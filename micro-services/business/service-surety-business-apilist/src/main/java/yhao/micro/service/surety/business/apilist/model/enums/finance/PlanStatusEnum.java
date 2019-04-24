package yhao.micro.service.surety.business.apilist.model.enums.finance;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 19:13
 * @Description:
 */
public enum PlanStatusEnum {
    WAITING_PICK("待选择平台"),WAITING_SEND("待报送平台"),SENDED ("已报送平台"),
    REJECT  ("平台已驳回"),AGREE ("平台已同意");

    PlanStatusEnum(String desc) {
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
