package yhao.micro.service.workflow.service.task;

import yhao.micro.service.workflow.apilist.model.flow.FlowNodeModel;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;

/**
 * 任务上下文
 */
public class TaskContext {
    //当前任务信息
    private TaskModel task;
    //当前节点
    private FlowNodeModel currentNode;
    //流转下一节点
    private FlowNodeModel nextNode;
    //业务对象id
    private String bizEntityId;
    //处理记录
    private StringBuffer history;

    public TaskContext() {
        this.history = new StringBuffer();
    }

    public TaskModel getTask() {
        return task;
    }

    public void setTask(TaskModel task) {
        this.task = task;
    }

    public FlowNodeModel getNextNode() {
        return nextNode;
    }

    public void setNextNode(FlowNodeModel nextNode) {
        this.nextNode = nextNode;
    }

    public String getBizEntityId() {
        return bizEntityId;
    }

    public void setBizEntityId(String bizEntityId) {
        this.bizEntityId = bizEntityId;
    }

    public StringBuffer getHistory() {
        return history;
    }

    public FlowNodeModel getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(FlowNodeModel currentNode) {
        this.currentNode = currentNode;
    }
}
