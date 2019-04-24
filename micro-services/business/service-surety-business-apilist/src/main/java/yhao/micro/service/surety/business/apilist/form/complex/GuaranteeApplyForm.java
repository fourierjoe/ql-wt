package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/27 16:00
 * @Description:
 */
public class GuaranteeApplyForm implements ValidationForm {
    @ApiModelProperty("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ApiModelProperty("姓名")
    private String name;



}
