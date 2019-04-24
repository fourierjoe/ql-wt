package yhao.micro.service.workflow.apilist.form.flow.processBussiness;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.enums.flow.NotifyType;

public class BizFlowNodeWarnForm extends IdUnForm {
    @ApiModelProperty(value = "节点id",hidden = true)
    private String nodeId;

    @ApiModelProperty(value = "规定时限")
    private Integer limit;

    @ApiModelProperty(value = "提前未完成提醒")
    private Integer limitWarn;

    @ApiModelProperty(value = "延期，1级预警")
    private Integer levelOneWarn;

    @ApiModelProperty(value = "延期，1级预警是否通知")
    private YNEnum levelOneWarnIsWarn;

    @ApiModelProperty(value = "延期，1级预警通知方式,WX/DX/XT")
    private NotifyType levelOneWarnType;

    @ApiModelProperty(value = "延期，1级预警通知内容")
    private String levelOneWarnMessage;

    @ApiModelProperty(value = "延期，2级预警")
    private Integer levelTwoWarn;

    @ApiModelProperty(value = "延期，2级预警是否通知")
    private YNEnum levelTwoWarnIsWarn;

    @ApiModelProperty(value = "延期，2级预警通知方式,WX/DX/XT")
    private NotifyType levelTwoWarnType;

    @ApiModelProperty(value = "延期，2级预警通知内容")
    private String levelTwoWarnMessage;

    @ApiModelProperty(value = "延期，3级预警")
    private Integer levelThreeWarn;

    @ApiModelProperty(value = "延期，3级预警是否通知")
    private YNEnum levelThreeWarnIsWarn;

    @ApiModelProperty(value = "延期，3级预警通知方式,WX/DX/XT")
    private NotifyType levelThreeWarnType;

    @ApiModelProperty(value = "延期，3级预警通知内容")
    private String levelThreeWarnMessage;

    @ApiModelProperty(value = "预警对象,目前只预警客户经理ID")
    private String warnPerson;

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

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public YNEnum getLevelOneWarnIsWarn() {
        return levelOneWarnIsWarn;
    }

    public void setLevelOneWarnIsWarn(YNEnum levelOneWarnIsWarn) {
        this.levelOneWarnIsWarn = levelOneWarnIsWarn;
    }

    public NotifyType getLevelOneWarnType() {
        return levelOneWarnType;
    }

    public void setLevelOneWarnType(NotifyType levelOneWarnType) {
        this.levelOneWarnType = levelOneWarnType;
    }

    public String getLevelOneWarnMessage() {
        return levelOneWarnMessage;
    }

    public void setLevelOneWarnMessage(String levelOneWarnMessage) {
        this.levelOneWarnMessage = levelOneWarnMessage;
    }

    public YNEnum getLevelTwoWarnIsWarn() {
        return levelTwoWarnIsWarn;
    }

    public void setLevelTwoWarnIsWarn(YNEnum levelTwoWarnIsWarn) {
        this.levelTwoWarnIsWarn = levelTwoWarnIsWarn;
    }

    public NotifyType getLevelTwoWarnType() {
        return levelTwoWarnType;
    }

    public void setLevelTwoWarnType(NotifyType levelTwoWarnType) {
        this.levelTwoWarnType = levelTwoWarnType;
    }

    public String getLevelTwoWarnMessage() {
        return levelTwoWarnMessage;
    }

    public void setLevelTwoWarnMessage(String levelTwoWarnMessage) {
        this.levelTwoWarnMessage = levelTwoWarnMessage;
    }

    public YNEnum getLevelThreeWarnIsWarn() {
        return levelThreeWarnIsWarn;
    }

    public void setLevelThreeWarnIsWarn(YNEnum levelThreeWarnIsWarn) {
        this.levelThreeWarnIsWarn = levelThreeWarnIsWarn;
    }

    public NotifyType getLevelThreeWarnType() {
        return levelThreeWarnType;
    }

    public void setLevelThreeWarnType(NotifyType levelThreeWarnType) {
        this.levelThreeWarnType = levelThreeWarnType;
    }

    public String getLevelThreeWarnMessage() {
        return levelThreeWarnMessage;
    }

    public void setLevelThreeWarnMessage(String levelThreeWarnMessage) {
        this.levelThreeWarnMessage = levelThreeWarnMessage;
    }

    public String getWarnPerson() {
        return warnPerson;
    }

    public void setWarnPerson(String warnPerson) {
        this.warnPerson = warnPerson;
    }
}
