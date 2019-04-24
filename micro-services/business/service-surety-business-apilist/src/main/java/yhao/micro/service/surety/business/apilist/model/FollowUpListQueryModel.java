package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

/**
 * @Description 跟进记录列表查询 model
 *
 * @Author leice
 * @Date 2018/12/10 14:42
 * @Version 1.0
 */
public class FollowUpListQueryModel extends Entity<String> {

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("操作时间")
    private String operatingTime;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("节点名称")
    private String nodeName;

    @ApiModelProperty("事项名称")
    private String matterName;

    @ApiModelProperty("内容")
    private String followUpContent;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
        this.operatingTime = operatingTime;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getMatterName() {
        return matterName;
    }

    public void setMatterName(String matterName) {
        this.matterName = matterName;
    }

    public String getFollowUpContent() {
        return followUpContent;
    }

    public void setFollowUpContent(String followUpContent) {
        this.followUpContent = followUpContent;
    }

    @Override
    public String toString() {
        return "FollowUpListQueryModel{" +
                "operator='" + operator + '\'' +
                ", operatingTime='" + operatingTime + '\'' +
                ", position='" + position + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", matterName='" + matterName + '\'' +
                ", followUpContent='" + followUpContent + '\'' +
                '}';
    }
}
