package yhao.micro.service.workflow.apilist.form.approve;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.workflow.apilist.enums.flow.ProcessDefinitionType;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;

import java.util.Date;

/**
 * @Description: 已审批
 * @Created by ql on 2019/1/16 21:05
 * @Version: v1.0
 */
public class QueryTaskOfCurrentPersonApprovedPageForm extends PageForm {
	@ApiModelProperty(value = "当前人员ID", required = true)
	@NotBlank(message = "当前人员ID不得为空")
	private String finishPerson;

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

	@ApiModelProperty(value = "流程状态")
	private TaskStatus taskstatus;

	public TaskStatus getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(TaskStatus taskstatus) {
		this.taskstatus = taskstatus;
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
