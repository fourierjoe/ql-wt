package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.workflow.apilist.enums.flow.FlowIsNotifyType;

import javax.validation.constraints.NotNull;

public class FlowNodeNotifyForm extends IdUnForm {
    @ApiModelProperty(value = "nodeId",hidden = true)
    private String nodeId;

    @ApiModelProperty(value = "完成后是否通知, 无需通知=NO/客户经理", required = true)
    @NotNull(message = "完成后是否通知不得为空")
    private FlowIsNotifyType isNotify = FlowIsNotifyType.NO;

    @ApiModelProperty(value = "通知人id,只支持客户经理")
    private String personId;

    @ApiModelProperty(value = "通知类型, 微信=WX/短信=DX/系统=XT", example = "WX")
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

    public FlowIsNotifyType getIsNotify() {
        return isNotify;
    }

    public void setIsNotify(FlowIsNotifyType isNotify) {
        this.isNotify = isNotify;
    }
}
