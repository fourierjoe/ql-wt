package yhao.micro.service.constants.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 14:13
 */
public class TreeModel {
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "父级id")
    private String pid;
    @ApiModelProperty(value = "父级名称")
    private String pName;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "排序")
    private Integer order;
    @ApiModelProperty(value = "是否展开")
    private Boolean expand;
    @ApiModelProperty(value = "是否选中")
    private Boolean checked;
    @ApiModelProperty(value = "是否为叶子结点")
    private Boolean leaf;
    @ApiModelProperty(value = "组织长编码")
    private String longNumber;
    @ApiModelProperty(value = "子节点")
    private List<TreeModel> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getExpand() {
        return expand;
    }

    public void setExpand(Boolean expand) {
        this.expand = expand;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public String getLongNumber() {
        return longNumber;
    }

    public void setLongNumber(String longNumber) {
        this.longNumber = longNumber;
    }

    public List<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeModel treeModel = (TreeModel) o;
        return Objects.equals(id, treeModel.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
