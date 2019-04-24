package yhao.micro.service.surety.business.apilist.model.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.common.model.Entity;

import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 11:48
 * @Description:
 */
public class RedemptionOrderModel extends Entity<String> {
    @ApiModelProperty("担保单id")
    private String guaranteePid;
    @ApiModelProperty("指令内容")
    private String orderContent;
    @ApiModelProperty("指令日期")
    private Date orderDate;
    @ApiModelProperty("备注")
    private String orderRemark;
    @ApiModelProperty("指令配置id")
    private String baseCommandId;
    @ApiModelProperty("指令有效日期")
    private Date orderEndDate;

    public String getGuaranteePid() {
        return guaranteePid;
    }

    public void setGuaranteePid(String guaranteePid) {
        this.guaranteePid = guaranteePid;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public String getBaseCommandId() {
        return baseCommandId;
    }

    public void setBaseCommandId(String baseCommandId) {
        this.baseCommandId = baseCommandId;
    }

    public Date getOrderEndDate() {
        return orderEndDate;
    }

    public void setOrderEndDate(Date orderEndDate) {
        this.orderEndDate = orderEndDate;
    }
}
