package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.micro.service.constants.enums.YNEnum;
import yhao.micro.service.surety.business.apilist.form.complex.ComplexRedemptionBaseQueryForm;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/10 17:56
 * @Description:
 */
public class RedemptionQueryForm extends ComplexRedemptionBaseQueryForm {
    @ApiModelProperty("赎楼状态 YES 已赎楼 NO 未赎楼")
    private YNEnum status;
    @ApiModelProperty(value = "操作类型 未出账 no_billing  待赎楼 no_redeem  已赎楼 redeem",required = true)
    @NotBlank(message = "操作类型不能为空")
    private String positionType;

    public YNEnum getStatus() {
        return status;
    }

    public void setStatus(YNEnum status) {
        this.status = status;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
