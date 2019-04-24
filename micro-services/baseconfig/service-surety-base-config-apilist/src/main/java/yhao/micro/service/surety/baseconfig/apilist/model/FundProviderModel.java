package yhao.micro.service.surety.baseconfig.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.CommandScopeEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.FundProviderTypeEnum;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderSaveForm;

/**
 * Created with IntelliJ IDEA.
 * Description:资方管理模型 Model
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:53
 */
public class FundProviderModel extends Entity<String> {
    private Mapper mapper = new DozerBeanMapper();

    @ApiModelProperty(value = "所属城市组织id", example = "string")
    private String orgId;
    @ApiModelProperty(value = "名称", example = "中国人民银行")
    private String name;
    @ApiModelProperty(value = "简称", example = "中行")
    private String simpleName;
    @ApiModelProperty(value = "资方类型", example = "BRANCH")
    private FundProviderTypeEnum fundProviderType;
    @ApiModelProperty(value = "排序", example = "1")
    private Integer order;
    @ApiModelProperty(value = "银行logo图片Url", example = "http://xxxxxxxxxxx")
    private String logoUrl;
    @ApiModelProperty(value = "联系人姓名", example = "许仙")
    private String contactPersonName;
    @ApiModelProperty(value = "联系人电话", example = "18888888888")
    private String contactPhone;
    @ApiModelProperty(value = "地址", example = "广东省深圳市南山区中国人民银行")
    private String address;
    @ApiModelProperty(value = "是否为合作银行", example = "YES")
    private YNEnum isCooperation;
    @ApiModelProperty(value = "资金类型串，用,隔开", example = "AMOUNT,CASH")
    private String fundTypes;
    @ApiModelProperty(value = "状态", example = "ENABLED")
    private CommonStatusEnum status;
    @ApiModelProperty(value = "父级资方id", example = "string")
    private String parentId;

    /*以下是非数据库字段，是关联表的冗余字段，查询时可关联带出值*/
    @ApiModelProperty(value = "组织名称", example = "深圳万通")
    private String orgName;

    @ApiModelProperty(value = "状态中文描述", example = "启用")
    public String getStatusDesc() {
        if(status==null){
            return "";
        }
        if(status==CommonStatusEnum.ENABLED){
            return "启用";
        }
        if(status==CommonStatusEnum.DISABLED){
            return "禁用";
        }
        return "";
    }

    @ApiModelProperty(value = "资方类型中文描述", example = "总行")
    public String getFundProviderTypeDesc() {
        return fundProviderType != null ? fundProviderType.getDesc() : "";
    }

    @ApiModelProperty(value = "是否为合作银行中文描述", example = "是")
    public String getIsCooperationDesc() {
        return isCooperation != null ? isCooperation.getDesc() : "";
    }

    public FundProviderSaveForm toSaveForm() {
        return mapper.map(this, FundProviderSaveForm.class);
    }

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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
