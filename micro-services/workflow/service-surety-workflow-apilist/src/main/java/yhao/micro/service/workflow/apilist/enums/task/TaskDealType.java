package yhao.micro.service.workflow.apilist.enums.task;

/**
 * 任务处理类型定义
 */
public enum TaskDealType {
    START("开启"),
    SAVE("保存"),
    PASS("通过"),
    REFUSE("驳回"),
    ;

    private String desc;

    TaskDealType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
