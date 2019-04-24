package yhao.micro.service.workflow.apilist.enums.task.rule;

public interface ItemMatcher {
    /**
     * @param expect 期望结果
     * @param result 给定结果
     * @return
     */
    boolean match(String expect,String result);
}
