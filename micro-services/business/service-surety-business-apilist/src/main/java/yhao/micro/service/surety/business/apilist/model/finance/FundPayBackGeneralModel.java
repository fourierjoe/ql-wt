package yhao.micro.service.surety.business.apilist.model.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/14 09:41
 * @Description:
 */
public class FundPayBackGeneralModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("累计回款金额")
    private BigDecimal repayTotalAmount;
    @ApiModelProperty("剩余回款")
    private BigDecimal repayBalance;
    @ApiModelProperty("是否确认回款")
    private YNEnum isConfirm;
    @ApiModelProperty("确认回款时间")
    private Date confirmDate;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public BigDecimal getRepayTotalAmount() {
        return repayTotalAmount;
    }

    public void setRepayTotalAmount(BigDecimal repayTotalAmount) {
        this.repayTotalAmount = repayTotalAmount;
    }

    public BigDecimal getRepayBalance() {
        return repayBalance;
    }

    public void setRepayBalance(BigDecimal repayBalance) {
        this.repayBalance = repayBalance;
    }

    public YNEnum getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(YNEnum isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }
}
