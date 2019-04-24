package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Description 通过担保单id查询其对应信息form
 *
 * @Author leice
 * @Date 2018/12/10 15:39
 * @Version 1.0
 */
public class QuerySingleGuaranteeInfoForm extends PageForm {

    @ApiModelProperty(value = "担保单id", required = true)
    @NotBlank(message = "担保单id不能为空")
    private String guaranteeId;

    public String getGuaranteeId() {
        return guaranteeId;
    }

    public void setGuaranteeId(String guaranteeId) {
        this.guaranteeId = guaranteeId;
    }
}
