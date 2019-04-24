package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

/**
 * @Description 新增跟进记录form
 *
 * @Author leice
 * @Date 2018/12/10 14:35
 * @Version 1.0
 */
public class FollowUpSaveForm extends IdUnForm {

    @ApiModelProperty("登录用户id")
    private String userId;

    @ApiModelProperty("节点名称")
    private String nodeName;

    @ApiModelProperty("事项名称")
    private String matterName;

    @ApiModelProperty("事项id")
    private String matterId;

    @ApiModelProperty("内容")
    private String followUpContent;

    @ApiModelProperty("创建时间")
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getMatterId() {
        return matterId;
    }

    public void setMatterId(String matterId) {
        this.matterId = matterId;
    }

    public String getFollowUpContent() {
        return followUpContent;
    }

    public void setFollowUpContent(String followUpContent) {
        this.followUpContent = followUpContent;
    }

    @Override
    public String toString() {
        return "FollowUpSaveForm{" +
                "userId='" + userId + '\'' +
                ", nodeName='" + nodeName + '\'' +
                ", matterName='" + matterName + '\'' +
                ", matterId='" + matterId + '\'' +
                ", followUpContent='" + followUpContent + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
