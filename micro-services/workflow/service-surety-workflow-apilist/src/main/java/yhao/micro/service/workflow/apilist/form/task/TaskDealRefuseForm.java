package yhao.micro.service.workflow.apilist.form.task;

import io.swagger.annotations.ApiModelProperty;
import yhao.micro.service.constants.enums.YNEnum;

import javax.validation.constraints.NotNull;

public class TaskDealRefuseForm extends TaskDealForm {
    @ApiModelProperty(value = "驳回上一级节点Id,默认为当前节点的上一级主节点")
    private String refuseNodeId;

    @ApiModelProperty(value = "被驳回节点核心事项有关信息是否保留,保留传YES,不保留传NO")
    @NotNull(message = "被驳回节点核心事项有关信息是否保留不得为空")
    private YNEnum coreItemIsReserved = YNEnum.NO;

    public String getRefuseNodeId() {
        return refuseNodeId;
    }

    public void setRefuseNodeId(String refuseNodeId) {
        this.refuseNodeId = refuseNodeId;
    }

    public YNEnum getCoreItemIsReserved() {
        return coreItemIsReserved;
    }

    public void setCoreItemIsReserved(YNEnum coreItemIsReserved) {
        this.coreItemIsReserved = coreItemIsReserved;
    }
}
