package yhao.micro.service.workflow.apilist.enums.flow;

/**
 * 节点类型
 */
public enum FlowNodeType {
    MAIN("主流程节点"),
    SUB("子流程节点"),
    ;

    private String desc;
    FlowNodeType(String desc) {
        this.desc = desc;
    }
}
