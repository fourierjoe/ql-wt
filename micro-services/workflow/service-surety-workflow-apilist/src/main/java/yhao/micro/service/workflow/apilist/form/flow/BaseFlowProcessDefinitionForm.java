package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionStatus;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionType;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessType;
import yhao.micro.service.workflow.apilist.enums.task.TaskBizCode;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BaseFlowProcessDefinitionForm extends IdUnForm {
    @ApiModelProperty(value = "流程名称",required = true)
    @NotBlank(message = "请输入流程名称")
    private String processName;

    @ApiModelProperty(value = "连接线",hidden = true)
    private List<FlowTransitionForm> trans;

    @ApiModelProperty(value = "状态, ENABLE=有效/DISENABLED=无效", required = true)
    @NotNull(message = "流程状态不能为空")
    private ProcessDefinitionStatus status = ProcessDefinitionStatus.ENABLED;

    @ApiModelProperty(value = "城市组织ID", required = true)
    @NotBlank(message = "城市组织ID不得为空")
    private String orgId;

    @ApiModelProperty(value = "流程分组", required = true)
    @NotNull(message = "流程分组不能为空")
    private ProcessDefinitionType processGroup;

    @ApiModelProperty(value = "流程类型", hidden = true)
    private ProcessType processType;

    @ApiModelProperty(value = "节点数", required = true)
    @NotNull(message = "节点数不能为空")
    private Integer nodeCount;

    @ApiModelProperty(value = "业务编码，与bizCodeStr之一不可为空，两者皆存在优先使用bizCode", hidden = true)
    private TaskBizCode bizCode;

    @ApiModelProperty(value = "业务编码自定义，与bizCode之一不可为空，两者皆存在优先使用bizCode, 保存不传,编辑必传")
    private String bizCodeStr;

    public ProcessType getProcessType() {
        return processType;
    }

    public void setProcessType(ProcessType processType) {
        this.processType = processType;
    }

    public List<FlowTransitionForm> getTrans() {
        return trans;
    }

    public void setTrans(List<FlowTransitionForm> trans) {
        this.trans = trans;
    }

    public ProcessDefinitionStatus getStatus() {
        return status;
    }

    public void setStatus(ProcessDefinitionStatus status) {
        this.status = status;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public ProcessDefinitionType getProcessGroup() {
        return processGroup;
    }

    public void setProcessGroup(ProcessDefinitionType processGroup) {
        this.processGroup = processGroup;
    }

    public Integer getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(Integer nodeCount) {
        this.nodeCount = nodeCount;
    }

    public TaskBizCode getBizCode() {
        return bizCode;
    }

    public void setBizCode(TaskBizCode bizCode) {
        this.bizCode = bizCode;
    }

    public String getBizCodeStr() {
        return bizCodeStr;
    }

    public void setBizCodeStr(String bizCodeStr) {
        this.bizCodeStr = bizCodeStr;
    }
}
