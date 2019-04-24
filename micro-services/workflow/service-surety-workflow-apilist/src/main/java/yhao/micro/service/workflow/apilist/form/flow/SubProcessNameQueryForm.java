package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessType;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Created by ql on 2018/12/13 10:48
 * @Version: v1.0
 */
public class SubProcessNameQueryForm implements ValidationForm {

    @ApiModelProperty(value = "城市组织ID", required = true)
    @NotBlank(message = "城市组织ID不得为空的")
    private String orgId;

    @ApiModelProperty(value = "子流程名称,支持模糊查询")
    private String subProcessName;

    @ApiModelProperty(value = "流程类型", hidden = true)
    @NotNull(message = "流程类型不得为空")
    private ProcessType processType = ProcessType.SUB;

    public String getSubProcessName() {
        return subProcessName;
    }

    public void setSubProcessName(String subProcessName) {
        this.subProcessName = subProcessName;
    }

    public ProcessType getProcessType() {
        return processType;
    }

    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
