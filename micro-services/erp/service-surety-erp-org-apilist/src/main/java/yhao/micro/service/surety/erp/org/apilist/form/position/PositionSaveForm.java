package yhao.micro.service.surety.erp.org.apilist.form.position;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2017/8/24.
 */
public class PositionSaveForm implements ValidationForm {
    @ApiModelProperty(value = "id")
    // id
    private String id;
    @ApiModelProperty(value = "岗位名称")
    // 岗位名称
    private String name;
    @ApiModelProperty(value = "从属组织id")
    // 从属组织id
    private String orgId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
