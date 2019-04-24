package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

public class FlowNodeNotifyModel extends Entity<String> {

    @ApiModelProperty(value = "节点Id", hidden = true)
    private String nodeId;

    @ApiModelProperty(value = "通知人id", hidden = true)
    private String personId;

    @ApiModelProperty(value = "完成后是否通知")
    private String isNotify;

    @ApiModelProperty(value = "通知类型,微信=WX/短信=DX/系统=XT")
    private String notifyType;

    @ApiModelProperty(value = "通知内容")
    private String notifyMessage;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getIsNotify() {
        return isNotify;
    }

    public void setIsNotify(String isNotify) {
        this.isNotify = isNotify;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public String getNotifyMessage() {
        return notifyMessage;
    }

    public void setNotifyMessage(String notifyMessage) {
        this.notifyMessage = notifyMessage;
    }
}
