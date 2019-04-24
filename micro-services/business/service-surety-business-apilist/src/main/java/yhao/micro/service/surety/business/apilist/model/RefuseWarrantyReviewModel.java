package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.workflow.apilist.form.task.validatedGroup.RefuseTask;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author leice
 * @Date 2019/3/8 9:44
 * @Version 1.0
 */
public class RefuseWarrantyReviewModel{

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "事项关联节点id")
    private String nodeId;

    // 事项id通过pick任务获取,子任务事项id为子流程节点ID
    @ApiModelProperty(value = "事项Id")
    private String itemId;

    @ApiModelProperty(value = "处理事项结果编码")
    @NotBlank(message = "处理事项结果编码不得为空")
    private String itemResultCode;

    @ApiModelProperty(value = "是否必要条件, YES/NO")
    private YNEnum itemNecessary;

    @ApiModelProperty(value = "是否核心条件, YES/NO")
    private YNEnum itemCore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemResultCode() {
        return itemResultCode;
    }

    public void setItemResultCode(String itemResultCode) {
        this.itemResultCode = itemResultCode;
    }

    public YNEnum getItemNecessary() {
        return itemNecessary;
    }

    public void setItemNecessary(YNEnum itemNecessary) {
        this.itemNecessary = itemNecessary;
    }

    public YNEnum getItemCore() {
        return itemCore;
    }

    public void setItemCore(YNEnum itemCore) {
        this.itemCore = itemCore;
    }
}
