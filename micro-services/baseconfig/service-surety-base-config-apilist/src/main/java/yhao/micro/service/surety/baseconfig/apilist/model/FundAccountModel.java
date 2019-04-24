package yhao.micro.service.surety.baseconfig.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.baseconfig.apilist.enums.AccountTypeEnum;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountSaveForm;

/**
 * Created with IntelliJ IDEA.
 * Description:资金账号管理 Model
 * User: GUO.MAO.LIN
 * Date: 2018-11-30
 * Time: 13:56
 */
public class FundAccountModel extends Entity<String> {
    private Mapper mapper = new DozerBeanMapper();

    @ApiModelProperty(value = "资金账号所属组织id", example = "string")
    private String orgId;
    @ApiModelProperty(value = "账号类型", example = "BASE_TAX_PAYER")
    private AccountTypeEnum accountType;
    @ApiModelProperty(value = "资方id", example = "string")
    private String fundProviderId;
    @ApiModelProperty(value = "开户行", example = "中国人民银行高新园支行")
    private String accountBank;
    @ApiModelProperty(value = "账号名称，模糊匹配", example = "账号名称")
    private String accountName;
    @ApiModelProperty(value = "账号", example = "62237287378723874238478")
    private String accountNumber;
    @ApiModelProperty(value = "状态", example = "ENABLED")
    private CommonStatusEnum status;
    @ApiModelProperty(value = "备注", example = "备注")
    private String remark;

    /*以下是非数据库字段，是关联表的冗余字段，查询时可关联带出值*/
    @ApiModelProperty(value = "组织名称", example = "深圳万通")
    private String orgName;
    @ApiModelProperty(value = "资方名称", example = "中国人民银行")
    private String fundProviderName;

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

    @ApiModelProperty(value = "账号类型中文描述", example = "自有资金")
    public String getAccountTypeDesc() {
        return accountType != null ? accountType.getDesc() : "";
    }

    public FundAccountSaveForm toSaveForm() {
        return mapper.map(this, FundAccountSaveForm.class);
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public String getFundProviderId() {
        return fundProviderId;
    }

    public void setFundProviderId(String fundProviderId) {
        this.fundProviderId = fundProviderId;
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getFundProviderName() {
        return fundProviderName;
    }

    public void setFundProviderName(String fundProviderName) {
        this.fundProviderName = fundProviderName;
    }
}
