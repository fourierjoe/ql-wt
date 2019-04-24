package yhao.micro.service.workflow.apilist.enums.flow;

public enum ProcessDefinitionStatus {
    ENABLED("生效"),
    DISENABLED("失效"),
    OVERRIDE("覆盖"),
    UNVALID("未定义"),
    ;
    private String desc;
    ProcessDefinitionStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
