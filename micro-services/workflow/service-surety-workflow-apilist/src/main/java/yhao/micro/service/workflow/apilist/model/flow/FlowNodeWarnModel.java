package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

public class FlowNodeWarnModel extends Entity<String> {
    @ApiModelProperty("节点Id")
    private String nodeId;

    @ApiModelProperty(value = "规定时限")
    private Integer limit;

    @ApiModelProperty(value = "提前未完成提醒")
    private Integer limitWarn;

    @ApiModelProperty(value = "延期，1级预警")
    private Integer levelOneWarn;

    @ApiModelProperty(value = "延期，2级预警")
    private Integer levelTwoWarn;

    @ApiModelProperty(value = "延期，3级预警")
    private Integer levelThreeWarn;

    @ApiModelProperty(value = "预警通知对象(只预警客户经理)")
    private String warnPerson;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimitWarn() {
        return limitWarn;
    }

    public void setLimitWarn(Integer limitWarn) {
        this.limitWarn = limitWarn;
    }

    public Integer getLevelOneWarn() {
        return levelOneWarn;
    }

    public void setLevelOneWarn(Integer levelOneWarn) {
        this.levelOneWarn = levelOneWarn;
    }

    public Integer getLevelTwoWarn() {
        return levelTwoWarn;
    }

    public void setLevelTwoWarn(Integer levelTwoWarn) {
        this.levelTwoWarn = levelTwoWarn;
    }

    public Integer getLevelThreeWarn() {
        return levelThreeWarn;
    }

    public void setLevelThreeWarn(Integer levelThreeWarn) {
        this.levelThreeWarn = levelThreeWarn;
    }

    public String getWarnPerson() {
        return warnPerson;
    }

    public void setWarnPerson(String warnPerson) {
        this.warnPerson = warnPerson;
    }
}
