package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/17 17:46
 * @Version: v1.0
 */
public class TaskNodeModel extends Entity<String> {
    @ApiModelProperty("流程业务码")
    private String bizCode;

    @ApiModelProperty("节点名称")
    private String nodeName;

    @ApiModelProperty("任务指定类型,用于子流程")
    private String assignType;

    @ApiModelProperty("指派主体id,用于子流程")
    private String assignEntityId;

    @ApiModelProperty("指派主体岗位,用于子流程")
    private String assignEntityPosition;

    @ApiModelProperty("指派主体名称,用于子流程")
    private String assignEntityName;

    @ApiModelProperty("节点事项")
    private List<TaskNodeItemModel> items;

    @ApiModelProperty(value = "节点进度展示顺序")
    private Integer nodeScheduleOrder;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public Integer getNodeScheduleOrder() {
        return nodeScheduleOrder;
    }

    public void setNodeScheduleOrder(Integer nodeScheduleOrder) {
        this.nodeScheduleOrder = nodeScheduleOrder;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }

    public String getAssignEntityId() {
        return assignEntityId;
    }

    public void setAssignEntityId(String assignEntityId) {
        this.assignEntityId = assignEntityId;
    }

    public String getAssignEntityPosition() {
        return assignEntityPosition;
    }

    public void setAssignEntityPosition(String assignEntityPosition) {
        this.assignEntityPosition = assignEntityPosition;
    }

    public String getAssignEntityName() {
        return assignEntityName;
    }

    public void setAssignEntityName(String assignEntityName) {
        this.assignEntityName = assignEntityName;
    }

    public List<TaskNodeItemModel> getItems() {
        return items;
    }

    public void setItems(List<TaskNodeItemModel> items) {
        this.items = items;
    }
}
