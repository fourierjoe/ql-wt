package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import yhao.infra.apilist.ValidationForm;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/24 14:29
 * @Description:
 */
public class AntiGuaranteeQueryForm implements ValidationForm {
    @ApiModelProperty(value = "反担保人物业名称")
    private String propertyName;
    @ApiModelProperty(value = "反担保人姓名")
    private String contactName;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
