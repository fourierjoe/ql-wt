package yhao.micro.service.workflow.apilist.model.approve;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionType;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;

import java.util.Date;
import java.util.Optional;

/**
 * @Description:
 * @Created by ql on 2018/12/14 17:13
 * @Version: v1.0
 */
public class TaskPageOfCurrentPersonModel extends Entity<String> {

    @ApiModelProperty(value = "流程标题")
    private String processName;

    @ApiModelProperty(value = "流程分组")
    private ProcessDefinitionType processGroupe;

    @ApiModelProperty(value = "流程分组")
    private String processGroupeEnum;

    @ApiModelProperty(value = "发起开始日期")
    private Date startDate;

    @ApiModelProperty(value = "当前节点id")
    private String currentNodeId;

    @ApiModelProperty(value = "当前任务事项id")
    private String itemId;

    @ApiModelProperty(value = "是否核心事项")
    private String itemCore;

    @ApiModelProperty(value = "是否必要事项")
    private String itemNecessary;

    @ApiModelProperty(value = "当前节点名称")
    private String currentNodeName;

    @ApiModelProperty(value = "流程状态")
    private TaskStatus taskstatus;

    @ApiModelProperty(value = "流程状态")
    private String taskstatusEnum;

    @ApiModelProperty(value = "子任务接口路径")
    private String url;

    @ApiModelProperty(value = "流程编码")
    private String bizCode;

    @ApiModelProperty(value = "业务数据主键")
    private String bizEntityId;

    public String getBizEntityId() {
        return bizEntityId;
    }

    public void setBizEntityId(String bizEntityId) {
        this.bizEntityId = bizEntityId;
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProcessDefinitionType getProcessGroupe() {
        return processGroupe;
    }

    public void setProcessGroupe(ProcessDefinitionType processGroupe) {
        this.processGroupe = processGroupe;
    }

    public String getProcessGroupeEnum() {
        return processGroupeEnum;
    }

    public void setProcessGroupeEnum(String processGroupeEnum) {
        this.processGroupeEnum = Optional.ofNullable(processGroupe).orElseGet(()->ProcessDefinitionType.UNVALID).getDesc();
    }

    public TaskStatus getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(TaskStatus taskstatus) {
        this.taskstatus = taskstatus;
    }

    public String getTaskstatusEnum() {
        return taskstatusEnum;
    }

    public void setTaskstatusEnum(String taskstatusEnum) {
        this.taskstatusEnum = Optional.ofNullable(taskstatus).orElseGet(() -> TaskStatus.UNVALID).getDesc();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCurrentNodeName() {
        return currentNodeName;
    }

    public void setCurrentNodeName(String currentNodeName) {
        this.currentNodeName = currentNodeName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCurrentNodeId() {
        return currentNodeId;
    }

    public void setCurrentNodeId(String currentNodeId) {
        this.currentNodeId = currentNodeId;
    }

    public String getItemCore() {
        return itemCore;
    }

    public void setItemCore(String itemCore) {
        this.itemCore = itemCore;
    }

    public String getItemNecessary() {
        return itemNecessary;
    }

    public void setItemNecessary(String itemNecessary) {
        this.itemNecessary = itemNecessary;
    }
}
