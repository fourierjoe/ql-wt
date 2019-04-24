package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.constants.enums.YNEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/24 10:36
 * @Description: 消费记录返回
 */
public class ConsumeRecordResultForm implements ValidationForm {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("出账日期")
    private Date billingDate;
    @ApiModelProperty("应还款日期")
    private Date arrangedRepay;
    @ApiModelProperty("借款金额")
    private BigDecimal loanAmount;
    @ApiModelProperty("产生费用")
    private BigDecimal totalFees =new BigDecimal(0);
    @ApiModelProperty("是否确认回款 YES 是 NO 否")
    private YNEnum isConfirm;
    @ApiModelProperty("借款id")
    private String id;
    @ApiModelProperty("费率周期详情")
    private List<ConsumeRecordDetailForm> consumeDetailList;

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(BigDecimal totalFees) {
        this.totalFees = totalFees;
    }

    public YNEnum getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(YNEnum isConfirm) {
        this.isConfirm = isConfirm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ConsumeRecordDetailForm> getConsumeDetailList() {
        return consumeDetailList;
    }

    public void setConsumeDetailList(List<ConsumeRecordDetailForm> consumeDetailList) {
        this.consumeDetailList = consumeDetailList;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public Date getArrangedRepay() {
        return arrangedRepay;
    }

    public void setArrangedRepay(Date arrangedRepay) {
        this.arrangedRepay = arrangedRepay;
    }
}
