package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;
import yhao.micro.service.surety.business.apilist.model.enums.complex.OrderType;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/28 10:16
 * @Description:
 */
public class OrderApplySaveForm implements ValidationForm {
   @ApiModelProperty(value = "担保单id", required = true)
   private String guaranteeId;
   @ApiModelProperty(value = "id", hidden = true)
   private String createOperatorId;
   @ApiModelProperty(value = "指令类型 BANK_ORDER 银行指令", required = true)
   private OrderType orderType;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getCreateOperatorId() {
        return createOperatorId;
    }

    public void setCreateOperatorId(String createOperatorId) {
        this.createOperatorId = createOperatorId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
}
