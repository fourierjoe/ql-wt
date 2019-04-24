package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @Description
 * @Author leice
 * @Date 2019/3/7 20:52
 * @Version 1.0
 */
public class RefuseWarrantyReviewForm {

    @ApiModelProperty(value = "任务id", required = true)
    @NotBlank(message = "任务id不得为空")
    private String taskId;

    @ApiModelProperty(value = "登录人ID", required = true)
    @NotBlank(message = "(其他服务)事项处理人ID不得为空")
    private String itemFinishPerson;

    @ApiModelProperty(value = "登录人组织ID", required = true)
    @NotBlank(message = "(其他服务)事项处理人组织ID不得为空")
    private String itemFinishPersonOrgId;

    @ApiModelProperty(value = "事项编号")
    private String itemCode;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getItemFinishPerson() {
        return itemFinishPerson;
    }

    public void setItemFinishPerson(String itemFinishPerson) {
        this.itemFinishPerson = itemFinishPerson;
    }

    public String getItemFinishPersonOrgId() {
        return itemFinishPersonOrgId;
    }

    public void setItemFinishPersonOrgId(String itemFinishPersonOrgId) {
        this.itemFinishPersonOrgId = itemFinishPersonOrgId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
