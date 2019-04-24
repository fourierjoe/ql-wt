package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.PageForm;

import javax.validation.constraints.NotNull;

/**
 * @Description 跟进列表查询form
 *
 * @Author leice
 * @Date 2018/12/12 15:57
 * @Version 1.0
 */
public class FollowUpListForm extends PageForm {

    @ApiModelProperty("事项id")
    @NotNull(message = "事项id不能为空")
    private String matterId;

    public String getMatterId() {
        return matterId;
    }

    public void setMatterId(String matterId) {
        this.matterId = matterId;
    }

    @Override
    public String toString() {
        return "FollowUpListForm{" +
                "matterId='" + matterId + '\'' +
                '}';
    }
}
