package yhao.micro.service.surety.business.apilist.model;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description 打折表model
 *
 * @Author leice
 * @Date 2018/12/21 15:10
 * @Version 1.0
 */
public class DiscountApplicationByIdModel {

    @ApiModelProperty("id")
    private String discountId;

    @ApiModelProperty("打折申请原因")
    private String discountReason;

    @ApiModelProperty("担保单id")
    private String guaranteeId;

    @ApiModelProperty("创建时间")
    private String createTime;

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
