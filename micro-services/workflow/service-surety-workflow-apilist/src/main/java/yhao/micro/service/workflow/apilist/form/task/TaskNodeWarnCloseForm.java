package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class TaskNodeWarnCloseForm extends TaskNodeWarnBaseForm {
    @ApiModelProperty(value = "结束时间",required = true)
    @NotEmpty(message = "结束时间不得为空")
    private Date endTime;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
