package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.validate.IdUnForm;

/**
 * @Description
 * @Author leice
 * @Date 2019/3/7 14:45
 * @Version 1.0
 */
public class OverdueExtensionTaskForm extends IdUnForm {

    @ApiModelProperty("担保单id")
    private String warrantyId;

    public String getWarrantyId() {
        return warrantyId;
    }

    public void setWarrantyId(String warrantyId) {
        this.warrantyId = warrantyId;
    }
}
