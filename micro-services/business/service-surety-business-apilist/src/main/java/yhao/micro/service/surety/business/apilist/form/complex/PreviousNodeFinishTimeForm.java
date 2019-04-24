package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/26 15:02
 * @Version 1.0
 */
public class PreviousNodeFinishTimeForm {

    public PreviousNodeFinishTimeForm(String taskId, Integer nodeOrder) {
        this.taskId = taskId;
        this.nodeOrder = nodeOrder;
    }

    @ApiModelProperty("任务id")
    private String taskId;

    @ApiModelProperty("节点顺序")
    private Integer nodeOrder;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
