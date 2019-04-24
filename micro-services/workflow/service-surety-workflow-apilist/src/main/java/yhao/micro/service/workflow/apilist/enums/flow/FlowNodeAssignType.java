package yhao.micro.service.workflow.apilist.enums.flow;

/**
 * 任务指派类型
 */
public enum FlowNodeAssignType {
    PERSON("人员"),
    POSITION("岗位"),
    ;

    private String desc;
    FlowNodeAssignType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
