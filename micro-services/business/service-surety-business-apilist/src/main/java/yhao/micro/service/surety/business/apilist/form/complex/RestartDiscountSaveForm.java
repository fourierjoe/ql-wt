package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.LoanDetailsSaveForm;
import yhao.micro.service.surety.business.apilist.form.guarantee.LoanGeneralSaveForm;
import yhao.micro.service.surety.business.apilist.model.LoanDetailsInfoModel;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description 重新发起打折申请form
 *
 * @Author leice
 * @Date 2018/12/10 10:31
 * @Version 1.0
 */
public class RestartDiscountSaveForm extends IdUnForm {

    @ApiModelProperty("请求类型 1:重新发起打折申请 2：撤销打折申请")
    private Integer requestType;

    @ApiModelProperty("修改打折申请时必填,重新发起/撤销时不用此参数")
    private RefuseWarrantyReviewForm refuseWarrantyReviewForm;

    @NotNull
    @Length(max = 200,message = "撤单原因最多可输入200汉字")
    @ApiModelProperty("打折原因")
    private String discountReason;

    @ApiModelProperty("打折记录id")
    private String discountId;

    @ApiModelProperty("担保单id")
    private String guaranteeId;

    @ApiModelProperty("担保天数")
    private Integer guaranteeDays;

    @ApiModelProperty("手续费")
    private Double handlingFee;

    @ApiModelProperty("对外费率")
    private Double externalRate;

    @ApiModelProperty("应收担保费")
    private Double securityFeeReceivable;

    @ApiModelProperty("实收费率")
    private Double actualRate;

    @ApiModelProperty("应收合计")
    private Double shouldFee;

    @ApiModelProperty("实收合计")
    private Double actualFee;

    @ApiModelProperty("总费率")
    private Double marketFeeRate;

    @ApiModelProperty("应收咨询费小计")
    private Double adviceFee;


    @ApiModelProperty(value = "总额",example = "133.3")
    private Double loanTotalAmount;

    @ApiModelProperty(value = "总天数",example = "100")
    private Integer totalDays;

    @ApiModelProperty(value = "总手续费",example = "200")
    private Double charges;

    @ApiModelProperty("实收担保费")
    private Double paidGuaranteeFee;

    @ApiModelProperty(value = "借款有关信息")
    private List<LoanDetailsInfoForm> LoanRateInfoList;

    public RefuseWarrantyReviewForm getRefuseWarrantyReviewForm() {
        return refuseWarrantyReviewForm;
    }

    public void setRefuseWarrantyReviewForm(RefuseWarrantyReviewForm refuseWarrantyReviewForm) {
        this.refuseWarrantyReviewForm = refuseWarrantyReviewForm;
    }

    public Double getMarketFeeRate() {
        return marketFeeRate;
    }

    public void setMarketFeeRate(Double marketFeeRate) {
        this.marketFeeRate = marketFeeRate;
    }

    public Double getAdviceFee() {
        return adviceFee;
    }

    public void setAdviceFee(Double adviceFee) {
        this.adviceFee = adviceFee;
    }

    public Double getLoanTotalAmount() {
        return loanTotalAmount;
    }

    public void setLoanTotalAmount(Double loanTotalAmount) {
        this.loanTotalAmount = loanTotalAmount;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Double getShouldFee() {
        return shouldFee;
    }

    public void setShouldFee(Double shouldFee) {
        this.shouldFee = shouldFee;
    }

    public Double getActualFee() {
        return actualFee;
    }

    public void setActualFee(Double actualFee) {
        this.actualFee = actualFee;
    }

    public List<LoanDetailsInfoForm> getLoanRateInfoList() {
        return LoanRateInfoList;
    }

    public void setLoanRateInfoList(List<LoanDetailsInfoForm> loanRateInfoList) {
        LoanRateInfoList = loanRateInfoList;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public Integer getGuaranteeDays() {
        return guaranteeDays;
    }

    public void setGuaranteeDays(Integer guaranteeDays) {
        this.guaranteeDays = guaranteeDays;
    }

    public Double getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(Double handlingFee) {
        this.handlingFee = handlingFee;
    }

    public Double getExternalRate() {
        return externalRate;
    }

    public void setExternalRate(Double externalRate) {
        this.externalRate = externalRate;
    }

    public Double getSecurityFeeReceivable() {
        return securityFeeReceivable;
    }

    public void setSecurityFeeReceivable(Double securityFeeReceivable) {
        this.securityFeeReceivable = securityFeeReceivable;
    }

    public Double getActualRate() {
        return actualRate;
    }

    public void setActualRate(Double actualRate) {
        this.actualRate = actualRate;
    }

    public Double getPaidGuaranteeFee() {
        return paidGuaranteeFee;
    }

    public void setPaidGuaranteeFee(Double paidGuaranteeFee) {
        this.paidGuaranteeFee = paidGuaranteeFee;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }


    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    @Override
    public String toString() {
        return "RestartDiscountSaveForm{" +
                "discountReason='" + discountReason + '\'' +
                ", discountId='" + discountId + '\'' +
                ", guaranteeId='" + guaranteeId + '\'' +
                ", guaranteeDays=" + guaranteeDays +
                ", handlingFee='" + handlingFee + '\'' +
                ", externalRate=" + externalRate +
                ", securityFeeReceivable='" + securityFeeReceivable + '\'' +
                ", actualRate=" + actualRate +
                ", paidGuaranteeFee='" + paidGuaranteeFee + '\'' +
                '}';
    }
}
