package yhao.micro.service.workflow.apilist.enums.flow;

/**
 * @Description:
 * @Created by ql on 2018/12/12 14:45
 * @Version: v1.0
 */
public enum NotifyType {
    WX("微信"),
    DX("短信"),
    XT("系统"),
    ;

    private String desc;

    NotifyType(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
