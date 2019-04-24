package yhao.micro.service.surety.erp.auth.apilist.form.auth;


import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/9/2.
 */
public class AuthLeafSaveForm extends Entity<String> {
    @ApiModelProperty(value = "名称",example = "查询")
    private String name;
    @ApiModelProperty(value = "功能标识",example = "INTENTION_SELECT")
    private String url;
    @ApiModelProperty(value = "所属菜单id",example = "string")
    private String typeId;
    @ApiModelProperty(value = "排序",example = "1")
    private Integer order;
    @ApiModelProperty(value = "是否显示",example = "false")
    private boolean menu;
    @ApiModelProperty(hidden = true)
    private String systemKey = CommonConstants.SYSTEM_KEY;

    public String getMenuCn() {
        return menu ? "显示" : "不显示";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public boolean isMenu() {
        return menu;
    }

    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object obj) {
        return idEqual(obj);
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }

}
