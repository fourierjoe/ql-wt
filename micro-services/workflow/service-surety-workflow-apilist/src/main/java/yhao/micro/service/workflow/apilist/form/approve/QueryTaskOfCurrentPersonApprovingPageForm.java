package yhao.micro.service.workflow.apilist.form.approve;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionType;

import java.util.Date;

/**
 * @Description: 待审批form
 * @Created by ql on 2018/12/14 17:08
 * @Version: v1.0
 */
public class QueryTaskOfCurrentPersonApprovingPageForm extends PageForm {

    @ApiModelProperty(value = "当前人员ID", required = true)
    @NotBlank(message = "当前人员ID不得为空")
    private String finishPerson;

    @ApiModelProperty(value = "当前岗位ID", required = true)
    @NotBlank(message = "当前岗位ID不得为空")
    private String positionId;

    @ApiModelProperty(value = "流程标题")
    private String processName;

    @ApiModelProperty(value = "发起开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @ApiModelProperty(value = "结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @ApiModelProperty(value = "流程分组")
    private ProcessDefinitionType processGroupe;

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getFinishPerson() {
        return finishPerson;
    }

    public void setFinishPerson(String finishPerson) {
        this.finishPerson = finishPerson;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ProcessDefinitionType getProcessGroupe() {
        return processGroupe;
    }

    public void setProcessGroupe(ProcessDefinitionType processGroupe) {
        this.processGroupe = processGroupe;
    }
}
