package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.complex.EssentialsAssort;
import yhao.micro.service.surety.business.apilist.model.enums.complex.EssentialsStatus;
import yhao.micro.service.surety.business.apilist.model.enums.complex.EssentialsType;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/5 17:08
 * @Description:
 */
public class RedemptionEssentialsTakeModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("要件状态")
    private EssentialsStatus essentialsStatus;
    @ApiModelProperty("要件类别")
    private EssentialsAssort essentialsAssort;
    @ApiModelProperty("要件类型")
    private EssentialsType essentialsType;
    @ApiModelProperty("要件明细")
    private String essentialsContent;
    @ApiModelProperty("账户名")
    private String accountName;
    @ApiModelProperty("开户行")
    private String accountBank;
    @ApiModelProperty("账号")
    private String accountNumber;
    @ApiModelProperty("收取日期")
    private Date takeDate;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("已借出内容")
    private String lendContent;

    public EssentialsStatus getEssentialsStatus() {
        return essentialsStatus;
    }

    public void setEssentialsStatus(EssentialsStatus essentialsStatus) {
        this.essentialsStatus = essentialsStatus;
    }

    public EssentialsAssort getEssentialsAssort() {
        return essentialsAssort;
    }

    public void setEssentialsAssort(EssentialsAssort essentialsAssort) {
        this.essentialsAssort = essentialsAssort;
    }

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
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

    public String getLendContent() {
        return lendContent;
    }

    public void setLendContent(String lendContent) {
        this.lendContent = lendContent;
    }
}
