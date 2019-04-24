package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * @Description
 * @Author leice
 * @Date 2019/1/3 18:14
 * @Version 1.0
 */
public class QueryExtensionByIdForm extends PageForm {

    @ApiModelProperty("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
