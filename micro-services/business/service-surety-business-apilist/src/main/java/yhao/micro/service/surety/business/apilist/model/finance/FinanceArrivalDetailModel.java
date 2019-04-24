package yhao.micro.service.surety.business.apilist.model.finance;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;
import yhao.micro.service.constants.enums.YNEnum;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/12 15:28
 * @Description:到账详情model
 */
public class FinanceArrivalDetailModel extends Entity<String> {
    @ApiModelProperty("到账概况id")
    private String arrivalGeneralId;
    @ApiModelProperty("担保单id")
    private String guaranteeId;
    @ApiModelProperty("到账金额")
    private BigDecimal arrivalAmount;
    @ApiModelProperty("到账日期")
    private Date arrivalDate;
    @ApiModelProperty("银行账户")
    private String bankAccountId;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("是否删除 YES 是 NO 否")
    private YNEnum isDelete;

    public String getArrivalGeneralId() {
        return arrivalGeneralId;
    }

    public void setArrivalGeneralId(String arrivalGeneralId) {
        this.arrivalGeneralId = arrivalGeneralId;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }


    public BigDecimal getArrivalAmount() {
        return arrivalAmount;
    }

    public void setArrivalAmount(BigDecimal arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public YNEnum getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(YNEnum isDelete) {
        this.isDelete = isDelete;
    }
}
