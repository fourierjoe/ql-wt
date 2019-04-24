package yhao.micro.service.workflow.apilist.model.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.Date;

public class TaskNodeWarnModel extends Entity<String> {
    @ApiModelProperty("任务Id")
    private String taskId;
    @ApiModelProperty("节点Id")
    private String nodeId;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("限定结束时间")
    private Date limitEndTime;
    @ApiModelProperty("提醒时间")
    private Date limitWarnTime;
    @ApiModelProperty("1级预警时间")
    private Date levelOneTime;
    @ApiModelProperty("2级预警时间")
    private Date levelTwoTime;
    @ApiModelProperty("3级预警时间")
    private Date levelThreeTime;
    @ApiModelProperty("预警记录")
    private Integer warnFlag;
    @ApiModelProperty("检查时间")
    private Date checkTime;

    public Integer getWarnFlag() {
        return warnFlag;
    }

    public void setWarnFlag(Integer warnFlag) {
        this.warnFlag = warnFlag;
    }


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getLimitWarnTime() {
        return limitWarnTime;
    }

    public void setLimitWarnTime(Date limitWarnTime) {
        this.limitWarnTime = limitWarnTime;
    }

    public Date getLevelOneTime() {
        return levelOneTime;
    }

    public void setLevelOneTime(Date levelOneTime) {
        this.levelOneTime = levelOneTime;
    }

    public Date getLevelTwoTime() {
        return levelTwoTime;
    }

    public void setLevelTwoTime(Date levelTwoTime) {
        this.levelTwoTime = levelTwoTime;
    }

    public Date getLevelThreeTime() {
        return levelThreeTime;
    }

    public void setLevelThreeTime(Date levelThreeTime) {
        this.levelThreeTime = levelThreeTime;
    }

    public Date getLimitEndTime() {
        return limitEndTime;
    }

    public void setLimitEndTime(Date limitEndTime) {
        this.limitEndTime = limitEndTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}
