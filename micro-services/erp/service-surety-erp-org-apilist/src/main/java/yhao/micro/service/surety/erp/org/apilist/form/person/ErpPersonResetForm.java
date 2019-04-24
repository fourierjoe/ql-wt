package yhao.micro.service.surety.erp.org.apilist.form.person;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.PageForm;

/**
 * Created by yoara on 2017/8/23.
 */
public class ErpPersonResetForm extends PageForm {
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "id")
    private String id;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
