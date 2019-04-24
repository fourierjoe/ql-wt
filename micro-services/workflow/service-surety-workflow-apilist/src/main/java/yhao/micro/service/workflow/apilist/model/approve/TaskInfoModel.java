package yhao.micro.service.workflow.apilist.model.approve;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.model.flow.FlowProcessDefinitionModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeModel;

import java.util.List;

/**
 * @Description: 所有任务的处理进度信息
 * @Created by ql on 2018/12/16 18:34
 * @Version: v1.0
 */
public class TaskInfoModel extends Entity<String> {

    @ApiModelProperty(value = "当前节点ID")
    private String currentNodeId;

    @ApiModelProperty(value = "流程定义信息")
    private FlowProcessDefinitionModel flowProcessDefinitionModel;

    @ApiModelProperty(value = "当前任务所有节点信息")
    private List<TaskNodeModel> taskNodeModelList;

    public String getCurrentNodeId() {
        return currentNodeId;
    }

    public void setCurrentNodeId(String currentNodeId) {
        this.currentNodeId = currentNodeId;
    }

    public FlowProcessDefinitionModel getFlowProcessDefinitionModel() {
        return flowProcessDefinitionModel;
    }

    public void setFlowProcessDefinitionModel(FlowProcessDefinitionModel flowProcessDefinitionModel) {
        this.flowProcessDefinitionModel = flowProcessDefinitionModel;
    }

    public List<TaskNodeModel> getTaskNodeModelList() {
        return taskNodeModelList;
    }

    public void setTaskNodeModelList(List<TaskNodeModel> taskNodeModelList) {
        this.taskNodeModelList = taskNodeModelList;
    }
}
