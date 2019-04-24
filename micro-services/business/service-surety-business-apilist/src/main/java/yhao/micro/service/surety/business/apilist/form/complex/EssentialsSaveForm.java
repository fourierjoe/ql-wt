package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.complex.EssentialsAssort;
import yhao.micro.service.surety.business.apilist.model.enums.complex.EssentialsType;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/7 15:12
 * @Description:
 */
public class EssentialsSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id",required = true)
    private String guaranteePid;
    @ApiModelProperty(value="要件类别",required = true)
    private EssentialsAssort essentialsAssort;
    @ApiModelProperty(value = "要件类型",required = true)
    private EssentialsType essentialsType;
    @ApiModelProperty(value = "要件明细",required = true)
    private String essentialsContent;
    @ApiModelProperty(value = "账户名",required = true)
    private String accountName;
    @ApiModelProperty(value = "开户行",required = true)
    private String accountBank;
    @ApiModelProperty(value = "账号",required = true)
    private String accountNumber;
    @ApiModelProperty(value = "收取日期",required = true)
    private Date takeDate;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty(hidden = true)
    private Date createTime;
    @ApiModelProperty(hidden = true)
    private String createOperatorId;
    @ApiModelProperty(value = "请求类型 TAKE 收取 LEND 借出 REMAND 归还 REBACK 退回",required = true)
    private String positionType;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public EssentialsAssort getEssentialsAssort() {
        return essentialsAssort;
    }

    public void setEssentialsAssort(EssentialsAssort essentialsAssort) {
        this.essentialsAssort = essentialsAssort;
    }

    public EssentialsType getEssentialsType() {
        return essentialsType;
    }

    public void setEssentialsType(EssentialsType essentialsType) {
        this.essentialsType = essentialsType;
    }

    public String getEssentialsContent() {
        return essentialsContent;
    }

    public void setEssentialsContent(String essentialsContent) {
        this.essentialsContent = essentialsContent;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateOperatorId() {
        return createOperatorId;
    }

    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
