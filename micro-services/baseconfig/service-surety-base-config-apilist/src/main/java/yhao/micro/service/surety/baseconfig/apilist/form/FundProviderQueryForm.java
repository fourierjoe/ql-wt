package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.CommandScopeEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.FundProviderTypeEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:资方管理查询 Form
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 15:12
 */
public class FundProviderQueryForm extends PageForm {
    @ApiModelProperty(value = "资方类型，如：BRANCH",example = "BRANCH")
    private FundProviderTypeEnum fundProviderType;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用",example = "ENABLED")
    private CommonStatusEnum status;
    @ApiModelProperty(value = "所属城市组织id",example = "string")
    private String orgId;
    @ApiModelProperty(value = "父级资方id",example = "string")
    private String parentId;
    @ApiModelProperty(value = "名称，全匹配",example = "中国人民银行",hidden = true)
    private String name;
    @ApiModelProperty(value = "简称，全匹配",example = "中行",hidden = true)
    private String simpleName;
    @ApiModelProperty(value = "联系人姓名，全匹配",example = "许仙",hidden = true)
    private String contactPersonName;
    @ApiModelProperty(value = "联系人电话，全匹配",example = "18888888888",hidden = true)
    private String contactPhone;
    @ApiModelProperty(value = "是否为合作银行",example = "YES",hidden = true)
    private YNEnum isCooperation;
    @ApiModelProperty(value = "资金类型，包含就算",example = "AMOUNT",hidden = true)
    private String fundType;
    @ApiModelProperty(value = "资金类型并且关系串，必须包含列表中所有的资金类型",example = "AMOUNT,CASH",hidden = true)
    private String andFundTypes;
    @ApiModelProperty(value = "资金类型或者关系串，只要包含列表中所有的资金类型中的一项即可",example = "AMOUNT,CASH",hidden = true)
    private String orFundTypes;
    @ApiModelProperty(value = "名称或简称，模糊匹配",example = "中行")
    private String searchName;
    @ApiModelProperty(value = "资方id", example = "string",hidden = true)
    private String id;
    @ApiModelProperty(value = "是否包含自己",example = "true")
    private Boolean withSelf;
    @ApiModelProperty(value = "排除id",example = "string",hidden = true)
    private String excludeId;

    public FundProviderTypeEnum getFundProviderType() {
        return fundProviderType;
    }

    public void setFundProviderType(FundProviderTypeEnum fundProviderType) {
        this.fundProviderType = fundProviderType;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public YNEnum getIsCooperation() {
        return isCooperation;
    }

    public void setIsCooperation(YNEnum isCooperation) {
        this.isCooperation = isCooperation;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public String getAndFundTypes() {
        return andFundTypes;
    }

    public void setAndFundTypes(String andFundTypes) {
        this.andFundTypes = andFundTypes;
    }

    public String getOrFundTypes() {
        return orFundTypes;
    }

    public void setOrFundTypes(String orFundTypes) {
        this.orFundTypes = orFundTypes;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getWithSelf() {
        return withSelf;
    }

    public void setWithSelf(Boolean withSelf) {
        this.withSelf = withSelf;
    }

    public String getExcludeId() {
        return excludeId;
    }

    public void setExcludeId(String excludeId) {
        this.excludeId = excludeId;
    }
}
