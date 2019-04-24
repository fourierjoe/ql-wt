package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * @Description 展期信息model
 *
 * @Author leice
 * @Date 2018/12/6 19:32
 * @Version 1.0
 */
public class ExtensionInfoModel extends Entity<String> {

    @ApiModelProperty("借款金额")
    private String loanMoney;

    @ApiModelProperty("审批进度")
    private String approvalProgress;

    @ApiModelProperty("借款天数")
    private Integer loanDays;

    @ApiModelProperty("预计还款日期 yyyy-MM-dd")
    private Date expectedRepaymentTime;

    @ApiModelProperty("转展期天数")
    private Integer conversionExtensionDays;

    @ApiModelProperty("当前逾期天数")
    private Integer overdueDays;

    public String getLoanMoney() {
        return loanMoney;
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
    }

    public String getApprovalProgress() {
        return approvalProgress;
    }

    public void setApprovalProgress(String approvalProgress) {
        this.approvalProgress = approvalProgress;
    }

    public Integer getLoanDays() {
        return loanDays;
    }

    public void setLoanDays(Integer loanDays) {
        this.loanDays = loanDays;
    }

    public Date getExpectedRepaymentTime() {
        return expectedRepaymentTime;
    }

    public void setExpectedRepaymentTime(Date expectedRepaymentTime) {
        this.expectedRepaymentTime = expectedRepaymentTime;
    }

    public Integer getConversionExtensionDays() {
        return conversionExtensionDays;
    }

    public void setConversionExtensionDays(Integer conversionExtensionDays) {
        this.conversionExtensionDays = conversionExtensionDays;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    @Override
    public String toString() {
        return "ExtensionInfoModel{" +
                "loanMoney='" + loanMoney + '\'' +
                ", approvalProgress='" + approvalProgress + '\'' +
                ", loanDays='" + loanDays + '\'' +
                ", expectedRepaymentTime='" + expectedRepaymentTime + '\'' +
                ", conversionExtensionDays='" + conversionExtensionDays + '\'' +
                ", overdueDays='" + overdueDays + '\'' +
                '}';
    }
}
