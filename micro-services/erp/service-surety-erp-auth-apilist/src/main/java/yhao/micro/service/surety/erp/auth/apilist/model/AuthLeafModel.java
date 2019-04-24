package yhao.micro.service.surety.erp.auth.apilist.model;


import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.CommonConstants;

/**
 * Created by yoara on 2017/9/2.
 */
public class AuthLeafModel extends Entity<String> {
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
    @ApiModelProperty(value = "所属菜单名称",example = "意向单管理")
    private String typeName;
    @ApiModelProperty(value = "所属菜单排序",example = "1")
    private Integer typeOrder;
    @ApiModelProperty(value = "所属一级菜单名称",example = "担保业务")
    private String typeTopName;
    @ApiModelProperty(value = "所属一级菜单排序",example = "1")
    private Integer typeTopOrder;
    @ApiModelProperty(value = "所属一级菜单id",example = "string")
    private String typeTopId;
    @ApiModelProperty(value = "是否具有该权限，GET=有，NOT=无",example = "GET")
    private String authType;


    public String getTypeTopName() {
        return typeTopName;
    }

    public void setTypeTopName(String typeTopName) {
        this.typeTopName = typeTopName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

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

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
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

    public String getTypeTopId() {
        return typeTopId;
    }

    public void setTypeTopId(String typeTopId) {
        this.typeTopId = typeTopId;
    }

    public Integer getTypeOrder() {
        return typeOrder;
    }

    public void setTypeOrder(Integer typeOrder) {
        this.typeOrder = typeOrder;
    }

    public Integer getTypeTopOrder() {
        return typeTopOrder;
    }

    public void setTypeTopOrder(Integer typeTopOrder) {
        this.typeTopOrder = typeTopOrder;
    }
}
