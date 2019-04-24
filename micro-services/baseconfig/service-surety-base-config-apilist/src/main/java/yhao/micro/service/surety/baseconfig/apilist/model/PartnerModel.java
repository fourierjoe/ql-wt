package yhao.micro.service.surety.baseconfig.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.baseconfig.apilist.enums.CompanyTypeEnum;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerSaveForm;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:合作方管理 Model
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:29
 */
public class PartnerModel extends Entity<String> {
    private Mapper mapper = new DozerBeanMapper();

    @ApiModelProperty(value = "合作方管理所属组织id", example = "string")
    private String orgId;
    @ApiModelProperty(value = "公司类型", example = "INTERMEDIARY_COMPANY")
    private CompanyTypeEnum companyType;
    @ApiModelProperty(value = "公司名称，模糊查询", example = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "返佣用户名，模糊查询", example = "返佣用户名")
    private String rebateAccountName;
    @ApiModelProperty(value = "返佣账号", example = "返佣账号")
    private String rebateAccountNumber;
    @ApiModelProperty(value = "返佣开户行", example = "返佣开户行")
    private String rebateAccountBank;
    @ApiModelProperty(value = "协议到期日", example = "2018-11-24")
    private Date agreementEndDate;
    @ApiModelProperty(value = "状态", example = "ENABLED")
    private CommonStatusEnum status;

    /*以下是非数据库字段，是关联表的冗余字段，查询时可关联带出值*/
    @ApiModelProperty(value = "所属组织名称", example = "深圳万通")
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

    @ApiModelProperty(value = "公司类型中文描述", example = "中介公司")
    public String getCompanyTypeDesc() {
        return companyType != null ? companyType.getDesc() : "";
    }

    public PartnerSaveForm toSaveForm() {
        return mapper.map(this, PartnerSaveForm.class);
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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
