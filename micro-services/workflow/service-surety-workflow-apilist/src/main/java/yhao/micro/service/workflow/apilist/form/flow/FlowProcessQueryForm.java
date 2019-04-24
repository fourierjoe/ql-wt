package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionStatus;

public class FlowProcessQueryForm extends PageForm {
    @ApiModelProperty("流程状态, ENABLED=生效, DISENABLED=失效")
    @NotBlank(message = "流程状态不得为空")
    private String status = ProcessDefinitionStatus.ENABLED.toString();

    @ApiModelProperty(value = "城市组织ID")
    private String orgId;

    @ApiModelProperty(value = "流程名称")
    private String name;

    @ApiModelProperty(value = "流程分组")
    private String processGroupe;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProcessGroupe() {
        return processGroupe;
    }

    public void setProcessGroupe(String processGroupe) {
        this.processGroupe = processGroupe;
    }
}
