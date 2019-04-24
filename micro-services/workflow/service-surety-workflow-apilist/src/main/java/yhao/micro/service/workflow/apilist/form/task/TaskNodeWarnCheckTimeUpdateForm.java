package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;

import java.util.Date;
import java.util.List;

public class TaskNodeWarnCheckTimeUpdateForm extends IdUnForm {
    @ApiModelProperty(value = "更新时间",required = true)
    @NotEmpty(message = "更新时间不得为空")
    private Date checkTime;

    @ApiModelProperty(value = "id",required = true)
    @NotEmpty(message = "id不得为空")
    private List<String> warnId;

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public List<String> getWarnId() {
        return warnId;
    }

    public void setWarnId(List<String> warnId) {
        this.warnId = warnId;
    }
}
