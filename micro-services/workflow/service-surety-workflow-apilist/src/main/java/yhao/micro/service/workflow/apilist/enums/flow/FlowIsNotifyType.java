package yhao.micro.service.workflow.apilist.enums.flow;

/**
 * @Description:
 * @Created by ql on 2018/12/11 16:43
 * @Version: v1.0
 */
public enum FlowIsNotifyType {
    NO("无需通知"),
    MANAGER("客户经理"),
    ;

    private String desc;
    FlowIsNotifyType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc() {
        this.desc = desc;
    }
}
