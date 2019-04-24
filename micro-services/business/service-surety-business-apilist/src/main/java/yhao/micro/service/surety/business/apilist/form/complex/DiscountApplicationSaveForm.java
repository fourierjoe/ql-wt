package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import yhao.infra.apilist.validate.IdUnForm;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/21 10:51
 * @Version 1.0
 */
public class DiscountApplicationSaveForm extends IdUnForm {

    @NotNull
    @Length(max = 200,message = "打折申请原因最多可输入200汉字")
    @ApiModelProperty("打折申请原因")
    private String discountReason;

    @ApiModelProperty("担保单id")
    private String guaranteeId;

    @ApiModelProperty("创建时间")
    private String createTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getDiscountReason() {
        return discountReason;
    }

    public void setDiscountReason(String discountReason) {
        this.discountReason = discountReason;
    }
}
