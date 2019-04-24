package yhao.micro.service.workflow.apilist.model.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeType;

public class FlowNodeTemplateModel extends Entity<String> {
    @ApiModelProperty("城市组织")
    private String orgId;

    @ApiModelProperty(value = "节点名称")
    private String name;

    @ApiModelProperty("节点类型")
    private FlowNodeType type;

    @ApiModelProperty("节点备注")
    private String remark;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlowNodeType getType() {
        return type;
    }

    public void setType(FlowNodeType type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
