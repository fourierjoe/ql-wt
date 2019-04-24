package yhao.micro.service.surety.business.apilist.form.redemption;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.business.apilist.form.complex.ComplexRedemptionBaseQueryForm;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 11:39
 * @Description:
 */
public class RDTAfterFollowQueryForm extends ComplexRedemptionBaseQueryForm {

    @ApiModelProperty(value = "业务类型 待取原证 takeCert 待注销 " +
            "certLogout 待过户 transfer 取新证takeNewCert 抵押登记  mortgage 申请退尾款 withdrawal 解保 unprotected",required = true)
    @NotBlank(message = "业务类型不能为空")
    private String positionType;

      public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }
}
