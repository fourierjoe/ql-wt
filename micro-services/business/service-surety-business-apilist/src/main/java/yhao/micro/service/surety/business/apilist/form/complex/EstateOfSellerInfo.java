package yhao.micro.service.surety.business.apilist.form.complex;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/24 15:06
 * @Description:
 */
public class EstateOfSellerInfo implements ValidationForm {
    @ApiModelProperty(value = "业主姓名")
    private String contactName;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
