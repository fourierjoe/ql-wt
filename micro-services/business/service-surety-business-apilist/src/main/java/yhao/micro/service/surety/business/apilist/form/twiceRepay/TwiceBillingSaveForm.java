package yhao.micro.service.surety.business.apilist.form.twiceRepay;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.IdUnForm;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.TwiceBillingTypeEnum;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:
 *
 * @Auther: ql
 * @Date: 2018/12/8 17:46
 */
public class TwiceBillingSaveForm extends IdUnForm {
    @ApiModelProperty(value = "担保单Id")
    @NotBlank(message = "担保单Id不能为空")
    private String guaranteeId;

    @ApiModelProperty(value = "公司账户", required = true)
    @NotBlank(message = "公司账户不得为空")
    private String twiceBillingAccountId;

    @ApiModelProperty(value = "出账类型", required = true)
    @NotNull(message = "出账类型不得为空")
    private TwiceBillingTypeEnum twiceBillingType;

    @ApiModelProperty(value = "出账金额", required = true)
    @NotNull(message = "出账金额不得为空")
    private BigDecimal twiceBillingAmount;

    @ApiModelProperty(value = "出账日期", required = true)
    @NotNull(message = "出账日期不得为空")
    private Date twiceBillingDate;

    @ApiModelProperty(value = "出账申请表id", required = true)
    @NotBlank(message = "出账申请表id不得为空")
    private String applicationId;

    public String getTwiceBillingAccountId() {
        return twiceBillingAccountId;
    }

    public void setTwiceBillingAccountId(String twiceBillingAccountId) {
        this.twiceBillingAccountId = twiceBillingAccountId;
    }

    public TwiceBillingTypeEnum getTwiceBillingType() {
        return twiceBillingType;
    }

    public void setTwiceBillingType(TwiceBillingTypeEnum twiceBillingType) {
        this.twiceBillingType = twiceBillingType;
    }

    public BigDecimal getTwiceBillingAmount() {
        return twiceBillingAmount;
    }

    public void setTwiceBillingAmount(BigDecimal twiceBillingAmount) {
        this.twiceBillingAmount = twiceBillingAmount;
    }

    public Date getTwiceBillingDate() {
        return twiceBillingDate;
    }

    public void setTwiceBillingDate(Date twiceBillingDate) {
        this.twiceBillingDate = twiceBillingDate;
    }

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }
}
