package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.List;

/**
 * @Description 展期申请model
 *
 * @Author leice
 * @Date 2018/1/3 19:25
 * @Version 1.0
 */
public class ExtensionApplicationModel extends Entity<String> {

    @ApiModelProperty("保单id")
    private String guaranteeId;

    @ApiModelProperty("借款id")
    private String loanId;

    @ApiModelProperty("展期业务类型1：现金 2：额度")
    private Integer types;

    @ApiModelProperty("展期天数")
    private Integer days;

    @ApiModelProperty("展期状态 1:正常 2：撤销 3：失效")
    private Integer status;

    @ApiModelProperty("展期收费状态1：未收费2：已收费未确认3：已收费已确认")
    private Integer statusFee;

    @ApiModelProperty("每日费率")
    private Double dailyRate;

    @ApiModelProperty("应收费率")
    private Double rateOfCharge;

    @ApiModelProperty("展期费小计")
    private Double subtotal;

    @ApiModelProperty("可退费用")
    private Double refundableFee;

    @ApiModelProperty("应交展期费")
    private Double shouldPay;

    @ApiModelProperty("展后到期日")
    private String postShowDueDate;

    @ApiModelProperty("创建时间")
    private String createDate;

    @ApiModelProperty("备注")
    private String remarks;

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public Integer getStatusFee() {
        return statusFee;
    }

    public void setStatusFee(Integer statusFee) {
        this.statusFee = statusFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(Double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Double getRateOfCharge() {
        return rateOfCharge;
    }

    public void setRateOfCharge(Double rateOfCharge) {
        this.rateOfCharge = rateOfCharge;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getRefundableFee() {
        return refundableFee;
    }

    public void setRefundableFee(Double refundableFee) {
        this.refundableFee = refundableFee;
    }

    public Double getShouldPay() {
        return shouldPay;
    }

    public void setShouldPay(Double shouldPay) {
        this.shouldPay = shouldPay;
    }

    public String getPostShowDueDate() {
        return postShowDueDate;
    }

    public void setPostShowDueDate(String postShowDueDate) {
        this.postShowDueDate = postShowDueDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
