package yhao.micro.service.surety.business.apilist.model.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.model.enums.finance.PayBackTypeEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:52
 * @Description:
 */
public class FundPayBackDetailModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("回款账户id")
    private String repayAccountId;
    @ApiModelProperty("公司账号")
    private String companyAccountId;
    @ApiModelProperty("回款金额")
    private BigDecimal repayAmount;
    @ApiModelProperty("回款日期")
    private Date repayDate;
    @ApiModelProperty("逾期天数")
    private Integer overdueDays;
    @ApiModelProperty("使用天数")
    private Integer useDays;
    @ApiModelProperty("回款类型")
    private PayBackTypeEnum repayType;
    @ApiModelProperty("逾期费用")
    private BigDecimal overdueFee;
    @ApiModelProperty("剩余可退")
    private BigDecimal overRefundAmount;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("担保费")
    private BigDecimal warranty;
    @ApiModelProperty("展期费")
    private BigDecimal delay;
    @ApiModelProperty("逾期费")
    private BigDecimal overdue;
    @ApiModelProperty("减免金额")
    private BigDecimal reduceAmount;
    @ApiModelProperty("实际应收金额")
    private BigDecimal realNomalAmount;
    @ApiModelProperty("借款id")
    private String loanId;
    @ApiModelProperty("担保费率")
    private Double warrantyRate;
    @ApiModelProperty("展期费率")
    private Double delayRate;
    @ApiModelProperty("逾期费率")
    private Double overdueRate;

    @ApiModelProperty("是否有申请减免 1:有 2：没有")
    private Integer isHave;

    @ApiModelProperty("默认逾期费率")
    private Double startRate;

    public Integer getIsHave() {
        return isHave;
    }

    public void setIsHave(Integer isHave) {
        this.isHave = isHave;
    }

    public Double getStartRate() {
        return startRate;
    }

    public void setStartRate(Double startRate) {
        this.startRate = startRate;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getRepayAccountId() {
        return repayAccountId;
    }

    public void setRepayAccountId(String repayAccountId) {
        this.repayAccountId = repayAccountId;
    }

    public BigDecimal getOverRefundAmount() {
        return overRefundAmount;
    }

    public void setOverRefundAmount(BigDecimal overRefundAmount) {
        this.overRefundAmount = overRefundAmount;
    }

    public String getCompanyAccountId() {
        return companyAccountId;
    }

    public void setCompanyAccountId(String companyAccountId) {
        this.companyAccountId = companyAccountId;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }


    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public PayBackTypeEnum getRepayType() {
        return repayType;
    }

    public void setRepayType(PayBackTypeEnum repayType) {
        this.repayType = repayType;
    }

    public BigDecimal getOverdueFee() {
        return overdueFee;
    }

    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getWarranty() {
        return warranty;
    }

    public void setWarranty(BigDecimal warranty) {
        this.warranty = warranty;
    }

    public BigDecimal getDelay() {
        return delay;
    }

    public void setDelay(BigDecimal delay) {
        this.delay = delay;
    }

    public BigDecimal getOverdue() {
        return overdue;
    }

    public void setOverdue(BigDecimal overdue) {
        this.overdue = overdue;
    }


    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public BigDecimal getRealNomalAmount() {
        return realNomalAmount;
    }

    public void setRealNomalAmount(BigDecimal realNomalAmount) {
        this.realNomalAmount = realNomalAmount;
    }


    public Integer getUseDays() {
        return useDays;
    }

    public void setUseDays(Integer useDays) {
        this.useDays = useDays;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Double getWarrantyRate() {
        return warrantyRate;
    }

    public void setWarrantyRate(Double warrantyRate) {
        this.warrantyRate = warrantyRate;
    }

    public Double getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(Double delayRate) {
        this.delayRate = delayRate;
    }

    public Double getOverdueRate() {
        return overdueRate;
    }

    public void setOverdueRate(Double overdueRate) {
        this.overdueRate = overdueRate;
    }
}
