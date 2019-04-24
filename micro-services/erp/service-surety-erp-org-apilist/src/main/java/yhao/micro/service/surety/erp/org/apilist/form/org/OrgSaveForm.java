package yhao.micro.service.surety.erp.org.apilist.form.org;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.ValidationForm;
import yhao.infra.common.CommonStatusEnum;

import java.util.Date;

/**
 * Created by yoara on 2017/8/24.
 */
public class OrgSaveForm implements ValidationForm {
    @ApiModelProperty(value = "id")
    // id
    private String id;
    @ApiModelProperty(value = "父组织id")
    // 父组织id
    private String parentId;
    @ApiModelProperty(value = "组织名称", required = true)
    // 组织名称
    private String name;
    @ApiModelProperty(value = "是否启用", required = true)
    // 是否启用
    private CommonStatusEnum status;
    @ApiModelProperty(value = "生效日期", required = true)
    // 生效日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date validDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }
}
