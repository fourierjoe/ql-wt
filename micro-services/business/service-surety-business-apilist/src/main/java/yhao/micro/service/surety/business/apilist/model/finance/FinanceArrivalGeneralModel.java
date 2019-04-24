package yhao.micro.service.surety.business.apilist.model.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;

import java.math.BigDecimal;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/7 09:34
 * @Description:到账概况
 */
public class FinanceArrivalGeneralModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("累计到账金额")
    private BigDecimal arrivalTotalAmount;
    @ApiModelProperty("是否确认到账")
    private YNEnum isConfirm;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public BigDecimal getArrivalTotalAmount() {
        return arrivalTotalAmount;
    }

    public void setArrivalTotalAmount(BigDecimal arrivalTotalAmount) {
        this.arrivalTotalAmount = arrivalTotalAmount;
    }

    public YNEnum getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(YNEnum isConfirm) {
        this.isConfirm = isConfirm;
    }
}
