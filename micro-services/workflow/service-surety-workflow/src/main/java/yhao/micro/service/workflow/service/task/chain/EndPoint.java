package yhao.micro.service.workflow.service.task.chain;

import yhao.micro.service.workflow.service.task.TaskContext;

public interface EndPoint {
    void doPoint(TaskContext context);
}
