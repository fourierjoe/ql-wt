package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/8 16:02
 * @Description:
 */
public class OrderSaveForm implements ValidationForm {
    @ApiModelProperty(value = "担保单id", required = true)
    private String guaranteePid;
    @ApiModelProperty(value = "指令内容", required = true)
    private String orderContent;
    @ApiModelProperty(value = "指令日期", required = true)
    private Date orderDate;
    @ApiModelProperty(value = "备注")
    private String orderRemark;
    @ApiModelProperty(value = "指令id", required = true)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

}
