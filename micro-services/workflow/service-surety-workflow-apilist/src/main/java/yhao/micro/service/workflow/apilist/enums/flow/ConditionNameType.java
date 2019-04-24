package yhao.micro.service.workflow.apilist.enums.flow;

/**
 * @Description:
 * @Created by ql on 2018/12/15 16:21
 * @Version: v1.0
 */
public enum ConditionNameType {

    GUARANTEE_AMOUNT("担保/借款金额"),
    BILLING_AMOUNT("出账金额"),
    ;

    private String desc;
    ConditionNameType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
