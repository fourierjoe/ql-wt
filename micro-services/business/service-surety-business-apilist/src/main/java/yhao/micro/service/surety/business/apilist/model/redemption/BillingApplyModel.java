package yhao.micro.service.surety.business.apilist.model.redemption;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.redeem.ReceiptPersonTypeEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/2 16:44
 * @Description:
 */
public class BillingApplyModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("借款id")
    private String loanId;
    @ApiModelProperty("收款人类型")
    private ReceiptPersonTypeEnum personType;
    @ApiModelProperty("收款人账户")
    private String receiptAccountId;
    @ApiModelProperty("收款人开户行")
    private String receiptAccountBank;
    @ApiModelProperty("收款人账号")
    private String receiptAccountNum;
    @ApiModelProperty("赎楼日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date redeemDate;
    @ApiModelProperty("申请金额")
    private BigDecimal applyAmount;
    @ApiModelProperty("任务id")
    private String taskId;
    @ApiModelProperty("任务状态")
    private String taskStatus;
    @ApiModelProperty("任务进度")
    private String taskProsess;
    @ApiModelProperty("赎楼员名称")
    private String redeemName;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("已出账金额")
    private BigDecimal billingAmount;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public ReceiptPersonTypeEnum getPersonType() {
        return personType;
    }

    public void setPersonType(ReceiptPersonTypeEnum personType) {
        this.personType = personType;
    }

    public String getReceiptAccountId() {
        return receiptAccountId;
    }

    public void setReceiptAccountId(String receiptAccountId) {
        this.receiptAccountId = receiptAccountId;
    }

    public String getReceiptAccountBank() {
        return receiptAccountBank;
    }

    public void setReceiptAccountBank(String receiptAccountBank) {
        this.receiptAccountBank = receiptAccountBank;
    }

    public String getReceiptAccountNum() {
        return receiptAccountNum;
    }

    public void setReceiptAccountNum(String receiptAccountNum) {
        this.receiptAccountNum = receiptAccountNum;
    }

    public Date getRedeemDate() {
        return redeemDate;
    }

    public void setRedeemDate(Date redeemDate) {
        this.redeemDate = redeemDate;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskProsess() {
        return taskProsess;
    }

    public void setTaskProsess(String taskProsess) {
        this.taskProsess = taskProsess;
    }

    public String getRedeemName() {
        return redeemName;
    }

    public void setRedeemName(String redeemName) {
        this.redeemName = redeemName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getBillingAmount() {
        return billingAmount;
    }

    public void setBillingAmount(BigDecimal billingAmount) {
        this.billingAmount = billingAmount;
    }
}
