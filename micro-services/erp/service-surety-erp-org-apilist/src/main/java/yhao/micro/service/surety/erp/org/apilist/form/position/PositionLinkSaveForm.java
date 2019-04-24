package yhao.micro.service.surety.erp.org.apilist.form.position;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.util.List;

/**
 * Created by yoara on 2017/8/24.
 */
public class PositionLinkSaveForm implements ValidationForm {
    @ApiModelProperty(value = "从属组织id")
    private String orgId;

    @ApiModelProperty(value = "岗位id，用,分开")
    private String positionIds;

    @ApiModelProperty(value = "操作人",hidden = true)
    private String operatorId;

    @ApiModelProperty(value = "岗位id",hidden = true)
    private List<String> positionIdArray;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getPositionIds() {
        return positionIds;
    }

    public void setPositionIds(String positionIds) {
        this.positionIds = positionIds;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public List<String> getPositionIdArray() {
        return positionIdArray;
    }

    public void setPositionIdArray(List<String> positionIdArray) {
        this.positionIdArray = positionIdArray;
    }
}
