package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.FundProviderTypeEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:资方管理保存/更新 Form
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:31
 */
public class FundProviderSaveForm extends IdUnForm {
    @ApiModelProperty(value = "所属城市组织id", example = "string")
    private String orgId;
    @ApiModelProperty(value = "名称", example = "中国人民银行")
    private String name;
    @ApiModelProperty(value = "简称", example = "中行")
    private String simpleName;
    @ApiModelProperty(value = "资方类型，如：BRANCH", example = "BRANCH")
    private FundProviderTypeEnum fundProviderType;
    @ApiModelProperty(value = "排序", example = "1")
    private Integer order;
    @ApiModelProperty(value = "银行logo图片Url，如：http://xxxxxxxxxxx", example = "http://xxxxxxxxxxx")
    private String logoUrl;
    @ApiModelProperty(value = "联系人姓名", example = "许仙")
    private String contactPersonName;
    @ApiModelProperty(value = "联系人电话", example = "18888888888")
    private String contactPhone;
    @ApiModelProperty(value = "地址", example = "广东省深圳市南山区中国人民银行")
    private String address;
    @ApiModelProperty(value = "是否为合作银行，如：YES", example = "YES")
    private YNEnum isCooperation;
    @ApiModelProperty(value = "资金类型串，用,隔开，如：AMOUNT,CASH", example = "AMOUNT,CASH")
    private String fundTypes;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;
    @ApiModelProperty(value = "父级资方id", example = "string")
    private String parentId;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public FundProviderTypeEnum getFundProviderType() {
        return fundProviderType;
    }

    public void setFundProviderType(FundProviderTypeEnum fundProviderType) {
        this.fundProviderType = fundProviderType;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public YNEnum getIsCooperation() {
        return isCooperation;
    }

    public void setIsCooperation(YNEnum isCooperation) {
        this.isCooperation = isCooperation;
    }

    public String getFundTypes() {
        return fundTypes;
    }

    public void setFundTypes(String fundTypes) {
        this.fundTypes = fundTypes;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
