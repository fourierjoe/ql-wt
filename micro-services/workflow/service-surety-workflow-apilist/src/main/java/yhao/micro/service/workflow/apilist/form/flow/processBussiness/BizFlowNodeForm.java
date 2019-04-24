package yhao.micro.service.workflow.apilist.form.flow.processBussiness;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeNotifyForm;
import yhao.micro.service.workflow.apilist.form.flow.FlowNodeTemplateForm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BizFlowNodeForm extends FlowNodeTemplateForm {

    @ApiModelProperty(value = "节点编号",required = true)
    @NotNull(message = "节点编号不得为空")
    private Integer orderNo;

    @ApiModelProperty(value = "模板节点ID，保存流程时页面左边框拖过来的",required = true)
    @NotBlank(message = "模板节点ID不得为空")
    private String nodeTemplateId ;

    @ApiModelProperty(value = "通知设置")
    @NotEmpty(message = "通知设置不得为空")
    @Valid
    private List<FlowNodeNotifyForm> notifyList;

    @ApiModelProperty(value = "节点设置中的备注")
    private String nodeRemark;

    @ApiModelProperty(value = "子流程id")
    private String subProcessId;

    @ApiModelProperty(value = "事项设置")
    @Valid
    private List<BizFlowNodeItemForm> items;

    @ApiModelProperty(value = "关联流程定义id",hidden = true)
    private String processId;

    @ApiModelProperty(value = "节点通过条件,(完成事项/子流程通过)废除",hidden = true)
    private String nodeCondition;

    @ApiModelProperty(value = "是否设置预警")
    private YNEnum warn;

    @ApiModelProperty(value = "节点预警信息")
    private BizFlowNodeWarnForm bizNodemWarn;

    public String getNodeTemplateId() {
        return nodeTemplateId;
    }

    public void setNodeTemplateId(String nodeTemplateId) {
        this.nodeTemplateId = nodeTemplateId;
    }

    public String getSubProcessId() {
        return subProcessId;
    }

    public void setSubProcessId(String subProcessId) {
        this.subProcessId = subProcessId;
    }

    public List<BizFlowNodeItemForm> getItems() {
        return items;
    }

    public void setItems(List<BizFlowNodeItemForm> items) {
        this.items = items;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getNodeCondition() {
        return nodeCondition;
    }

    public void setNodeCondition(String nodeCondition) {
        this.nodeCondition = nodeCondition;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public List<FlowNodeNotifyForm> getNotifyList() {
        return notifyList;
    }

    public void setNotifyList(List<FlowNodeNotifyForm> notifyList) {
        this.notifyList = notifyList;
    }

    public String getNodeRemark() {
        return nodeRemark;
    }

    public void setNodeRemark(String nodeRemark) {
        if (StringUtils.isEmpty(nodeRemark)) {
            this.nodeRemark = super.getNodeTemplateRemark();
        } else {
            this.nodeRemark = nodeRemark;
        }
    }

    public YNEnum getWarn() {
        return warn;
    }

    public void setWarn(YNEnum warn) {
        this.warn = warn;
    }

    public BizFlowNodeWarnForm getBizNodemWarn() {
        return bizNodemWarn;
    }

    public void setBizNodemWarn(BizFlowNodeWarnForm bizNodemWarn) {
        this.bizNodemWarn = bizNodemWarn;
    }
}
