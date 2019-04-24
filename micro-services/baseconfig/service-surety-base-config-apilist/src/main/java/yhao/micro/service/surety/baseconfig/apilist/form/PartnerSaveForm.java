package yhao.micro.service.surety.baseconfig.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.micro.service.surety.baseconfig.apilist.enums.CompanyTypeEnum;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:合作方管理保存/更新 Form
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:27
 */
public class PartnerSaveForm extends IdUnForm {
    @ApiModelProperty(value = "合作方管理所属组织id", example = "string")
    private String orgId;
    @ApiModelProperty(value = "公司类型，如：INTERMEDIARY_COMPANY", example = "INTERMEDIARY_COMPANY")
    private CompanyTypeEnum companyType;
    @ApiModelProperty(value = "公司名称", example = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "返佣用户名", example = "返佣用户名")
    private String rebateAccountName;
    @ApiModelProperty(value = "返佣账号", example = "返佣账号")
    private String rebateAccountNumber;
    @ApiModelProperty(value = "返佣开户行", example = "返佣开户行")
    private String rebateAccountBank;
    @ApiModelProperty(value = "协议到期日,格式：2018-11-24", example = "2018-11-24")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date agreementEndDate;
    @ApiModelProperty(value = "状态，ENABLED=启用，DISABLED=禁用", example = "ENABLED")
    private CommonStatusEnum status;

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

    public Date getAgreementEndDate() {
        return agreementEndDate;
    }

    public void setAgreementEndDate(Date agreementEndDate) {
        this.agreementEndDate = agreementEndDate;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }
}
