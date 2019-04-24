package yhao.micro.service.qiaolong_demo.apilist.form;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.validate.IdUnForm;

import javax.validation.constraints.Min;

public class QuickStartInsertForm extends IdUnForm {
    @ApiModelProperty(value = "姓名",required = true)
    @NotEmpty(message = "姓名不得为空")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
