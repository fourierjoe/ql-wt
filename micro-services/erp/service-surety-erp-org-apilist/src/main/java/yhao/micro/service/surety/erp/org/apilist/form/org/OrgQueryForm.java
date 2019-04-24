package yhao.micro.service.surety.erp.org.apilist.form.org;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;
import yhao.micro.service.surety.erp.org.apilist.enums.OrgTypeEnum;

import java.util.List;
import java.util.Set;

/**
 * Created by yoara on 2017/8/23.
 */
public class OrgQueryForm extends PageForm {
    @ApiModelProperty(value = "根组织长编码", example = "string")
    private String rootLongNumber;
    @ApiModelProperty(value = "组织类型，如：CITY,OPERATION_FINANCIAL", example = "CITY")
    private String orgTypes;
    @ApiModelProperty(value = "父组织id",example = "string",hidden = true)
    private String parentId;
    @ApiModelProperty(value = "组织类型列表",hidden = true)
    private List<String> orgTypeList;
    @ApiModelProperty(value = "是否找指定类型组织的父亲节点",hidden = true)
    private Boolean findParent;
    @ApiModelProperty(value = "idList列表",hidden = true)
    private List<String> idList;

    public String getRootLongNumber() {
        return rootLongNumber;
    }

    public void setRootLongNumber(String rootLongNumber) {
        this.rootLongNumber = rootLongNumber;
    }

    public List<String> getOrgTypeList() {
        return orgTypeList;
    }

    public void setOrgTypeList(List<String> orgTypeList) {
        this.orgTypeList = orgTypeList;
    }

    public String getOrgTypes() {
        return orgTypes;
    }

    public void setOrgTypes(String orgTypes) {
        this.orgTypes = orgTypes;
    }

    public Boolean getFindParent() {
        return findParent;
    }

    public void setFindParent(Boolean findParent) {
        this.findParent = findParent;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }
}
