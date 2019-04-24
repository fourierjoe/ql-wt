package yhao.micro.service.surety.erp.auth.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/9/2.
 */
public class AuthTypeModel extends Entity<String> {
    @ApiModelProperty(value = "名称",example = "基础配置")
    private String name;
    @ApiModelProperty(value = "父级菜单ID",example = "string")
    private String parentId;
    @ApiModelProperty(value = "排序",example = "1")
    private Integer order;
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;
    @ApiModelProperty(value = "父级菜单名称",example = "基础配置")
    private String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }
}
