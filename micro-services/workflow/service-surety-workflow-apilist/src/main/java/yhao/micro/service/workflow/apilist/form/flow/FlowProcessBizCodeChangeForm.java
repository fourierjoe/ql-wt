package yhao.micro.service.workflow.apilist.form.flow;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.workflow.apilist.enums.task.TaskBizCode;

public class FlowProcessBizCodeChangeForm extends IdForm {
    @ApiModelProperty(value = "业务编码")
    private TaskBizCode bizCode;

    @ApiModelProperty(value = "业务编码自定义")
    private String bizCodeStr;

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
