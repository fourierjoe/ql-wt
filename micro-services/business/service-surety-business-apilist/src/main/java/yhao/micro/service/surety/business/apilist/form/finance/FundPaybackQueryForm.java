package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.micro.service.constants.enums.YNEnum;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:35
 * @Description:
 */
public class FundPaybackQueryForm extends FinanceBaseQueryForm {
    @ApiModelProperty("回款状态")
    private String payBackStatus;
    private Date planPayBackEndDate;
    @ApiModelProperty("确认回款开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date realPayBackStartDate;
    @ApiModelProperty("确认回款结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date realPayBackEndDate;
    @ApiModelProperty("确认出账开始日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billingStartDate;
    @ApiModelProperty("确认出账结束日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date billingEndDate;
    @ApiModelProperty("是否仅显示逾期记录")
    private YNEnum isOverdue;

    public String getPayBackStatus() {
        return payBackStatus;
    }

    public void setPayBackStatus(String payBackStatus) {
        this.payBackStatus = payBackStatus;
    }

    public Date getPlanPayBackEndDate() {
        return planPayBackEndDate;
    }

    public void setPlanPayBackEndDate(Date planPayBackEndDate) {
        this.planPayBackEndDate = planPayBackEndDate;
    }

    public Date getRealPayBackStartDate() {
        return realPayBackStartDate;
    }

    public void setRealPayBackStartDate(Date realPayBackStartDate) {
        this.realPayBackStartDate = realPayBackStartDate;
    }

    public Date getRealPayBackEndDate() {
        return realPayBackEndDate;
    }

    public void setRealPayBackEndDate(Date realPayBackEndDate) {
        this.realPayBackEndDate = realPayBackEndDate;
    }

    public Date getBillingStartDate() {
        return billingStartDate;
    }

    public void setBillingStartDate(Date billingStartDate) {
        this.billingStartDate = billingStartDate;
    }

    public Date getBillingEndDate() {
        return billingEndDate;
    }

    public void setBillingEndDate(Date billingEndDate) {
        this.billingEndDate = billingEndDate;
    }

    public YNEnum getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(YNEnum isOverdue) {
        this.isOverdue = isOverdue;
    }
}
