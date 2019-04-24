package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.finance.FundPayBackDetailModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/3/1 19:03
 * @Description:
 */
public class OverdueRecordResultForm implements ValidationForm {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("借款id")
    private String id;
    @ApiModelProperty("借款金额")
    private BigDecimal loanAmount;
    @ApiModelProperty("逾期金额")
    private BigDecimal overdueAmount;
    @ApiModelProperty("逾期天数")
    private Integer overdueDates;
    @ApiModelProperty("应还款日期")
    private Date arrangedRepay;
    @ApiModelProperty("申请最低费率")
    private Double marketFeeRate;
    @ApiModelProperty("回款记录")
    private List<FundPayBackDetailModel>payBackDetailList;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Integer getOverdueDates() {
        return overdueDates;
    }

    public void setOverdueDates(Integer overdueDates) {
        this.overdueDates = overdueDates;
    }

    public Date getArrangedRepay() {
        return arrangedRepay;
    }

    public void setArrangedRepay(Date arrangedRepay) {
        this.arrangedRepay = arrangedRepay;
    }

    public List<FundPayBackDetailModel> getPayBackDetailList() {
        return payBackDetailList;
    }

    public void setPayBackDetailList(List<FundPayBackDetailModel> payBackDetailList) {
        this.payBackDetailList = payBackDetailList;
    }

    public Double getMarketFeeRate() {
        return marketFeeRate;
    }

    public void setMarketFeeRate(Double marketFeeRate) {
        this.marketFeeRate = marketFeeRate;
    }
}
