package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.AccountTypeEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:资金账号管理查询 Form
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 21:13
 */
public class FundAccountQueryForm extends PageForm {
    @ApiModelProperty(value = "资金账号所属组织id",example = "string")
    private String orgId;
    @ApiModelProperty(value = "账号名称，模糊匹配",example = "账号名称")
    private String accountName;
    @ApiModelProperty(value = "账号类型，如：BASE_TAX_PAYER",example = "BASE_TAX_PAYER")
    private AccountTypeEnum accountType;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用",example = "ENABLED")
    private CommonStatusEnum status;
    @ApiModelProperty(value = "银行名称",example = "中国人民银行",hidden = true)
    private String fundProviderId;
    @ApiModelProperty(value = "开户行",example = "中国人民银行高新园支行",hidden = true)
    private String accountBank;
    @ApiModelProperty(value = "账号",example = "62237287378723874238478",hidden = true)
    private String accountNumber;
    @ApiModelProperty(value = "资金账号id", example = "string",hidden = true)
    private String id;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
