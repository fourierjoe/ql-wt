package yhao.micro.service.surety.erp.org.apilist.form.person;

import io.swagger.annotations.ApiModelProperty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2018/1/19.
 */
public class PersonUpdatePswForm implements ValidationForm {
    @ApiModelProperty(value = "旧密码,MD5小写加密")
    private String oldPswMd5;

    @ApiModelProperty(value = "新密码,MD5小写加密")
    private String newPswMd5;

    @ApiModelProperty(hidden = true)
    private String personId;

    public String getOldPswMd5() {
        return oldPswMd5;
    }

    public void setOldPswMd5(String oldPswMd5) {
        this.oldPswMd5 = oldPswMd5;
    }

    public String getNewPswMd5() {
        return newPswMd5;
    }

    public void setNewPswMd5(String newPswMd5) {
        this.newPswMd5 = newPswMd5;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
