package yhao.micro.service.workflow.apilist.form.flow;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.internal.engine.groups.Group;
import org.springframework.validation.annotation.Validated;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.workflow.apilist.enums.flow.FlowNodeType;
import yhao.micro.service.workflow.apilist.form.flow.validatedGroup.SaveNodeTemplate;

import javax.validation.constraints.NotNull;

@JSONType(serializeEnumAsJavaBean = true)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class FlowNodeTemplateForm extends IdUnForm {
    @ApiModelProperty(value = "节点名称",required = true)
    @NotBlank(message = "节点名称不得为空",groups = {SaveNodeTemplate.class})
    private String nodeName;

    @ApiModelProperty(value = "节点类型",required = true)
    @NotNull(message = "节点类型不得为空", groups = {SaveNodeTemplate.class})
    private FlowNodeType type;

    @ApiModelProperty(value = "城市组织ID",required = true)
    @NotBlank(message = "城市组织ID不得为空", groups = {SaveNodeTemplate.class})
    private String orgId;

    @ApiModelProperty("节点模板备注")
    private String nodeTemplateRemark;


    public FlowNodeType getType() {
        return type;
    }

    public void setType(FlowNodeType type) {
        this.type = type;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getNodeTemplateRemark() {
        return nodeTemplateRemark;
    }

    public void setNodeTemplateRemark(String nodeTemplateRemark) {
        this.nodeTemplateRemark = nodeTemplateRemark;
    }
}
