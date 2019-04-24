package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

public class FlowNodeTemplateQueryForm extends PageForm {

    @ApiModelProperty(value = "城市组织ID")
    private String orgId;

    @ApiModelProperty("节点名称")
    private String nodeName;

    @ApiModelProperty("节点类型, MAIN=主流程节点, SUB=子流程节点")
    private String nodeType;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }
}
