package yhao.micro.service.surety.business.apilist.form.finance;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.constants.enums.YNEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/25 11:00
 * @Description:
 */
public class RewindSaveForm extends IdUnForm {
    @ApiModelProperty(value = "出账id，多个用','分隔",required = true)
    private String billingIds;
    @ApiModelProperty(value = "转回金额",required = true)
    private BigDecimal rewindAmount;
    @ApiModelProperty(value = "转回日期",required = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rewindDate;
    @ApiModelProperty("收款账号")
    private BigDecimal rewindAccountId;
    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteeId;
    @ApiModelProperty(value = "是否全选", required = true)
    private YNEnum isAll;

    public String getBillingIds() {
        return billingIds;
    }

    public void setBillingIds(String billingIds) {
        this.billingIds = billingIds;
    }

    public BigDecimal getRewindAmount() {
        return rewindAmount;
    }

    public void setRewindAmount(BigDecimal rewindAmount) {
        this.rewindAmount = rewindAmount;
    }

    public Date getRewindDate() {
        return rewindDate;
    }

    public void setRewindDate(Date rewindDate) {
        this.rewindDate = rewindDate;
    }

    public BigDecimal getRewindAccountId() {
        return rewindAccountId;
    }

    public void setRewindAccountId(BigDecimal rewindAccountId) {
        this.rewindAccountId = rewindAccountId;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public YNEnum getIsAll() {
        return isAll;
    }

    public void setIsAll(YNEnum isAll) {
        this.isAll = isAll;
    }
}
