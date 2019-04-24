package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.CompanyTypeEnum;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:合作方管理查询 Form
 * User: GUO.MAO.LIN
 * Date: 2018-12-01
 * Time: 14:28
 */
public class PartnerQueryForm extends PageForm {
    @ApiModelProperty(value = "资料id", example = "string",hidden = true)
    private String id;
    @ApiModelProperty(value = "合作方管理所属组织id", example = "string",hidden = true)
    private String orgId;
    @ApiModelProperty(value = "公司类型，如：INTERMEDIARY_COMPANY", example = "INTERMEDIARY_COMPANY",hidden = true)
    private CompanyTypeEnum companyType;
    @ApiModelProperty(value = "公司名称，模糊查询", example = "公司名称",hidden = true)
    private String companyName;
    @ApiModelProperty(value = "返佣用户名，模糊查询", example = "返佣用户名",hidden = true)
    private String rebateAccountName;
    @ApiModelProperty(value = "返佣账号", example = "返佣账号",hidden = true)
    private String rebateAccountNumber;
    @ApiModelProperty(value = "返佣开户行", example = "返佣开户行",hidden = true)
    private String rebateAccountBank;
    @ApiModelProperty(value = "最小协议到期日,格式：2018-11-24", example = "2018-11-24",hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minAgreementEndDate;
    @ApiModelProperty(value = "最大协议到期日,格式：2018-11-24", example = "2018-11-24",hidden = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxAgreementEndDate;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public CompanyTypeEnum getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyTypeEnum companyType) {
        this.companyType = companyType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRebateAccountName() {
        return rebateAccountName;
    }

    public void setRebateAccountName(String rebateAccountName) {
        this.rebateAccountName = rebateAccountName;
    }

    public String getRebateAccountNumber() {
        return rebateAccountNumber;
    }

    public void setRebateAccountNumber(String rebateAccountNumber) {
        this.rebateAccountNumber = rebateAccountNumber;
    }

    public String getRebateAccountBank() {
        return rebateAccountBank;
    }

    public void setRebateAccountBank(String rebateAccountBank) {
        this.rebateAccountBank = rebateAccountBank;
    }

    public Date getMinAgreementEndDate() {
        return minAgreementEndDate;
    }

    public void setMinAgreementEndDate(Date minAgreementEndDate) {
        this.minAgreementEndDate = minAgreementEndDate;
    }

    public Date getMaxAgreementEndDate() {
        return maxAgreementEndDate;
    }

    public void setMaxAgreementEndDate(Date maxAgreementEndDate) {
        this.maxAgreementEndDate = maxAgreementEndDate;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }
}
