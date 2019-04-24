package yhao.micro.service.surety.erp.org.apilist.form.person;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2018/1/19.
 */
public class PersonUpdateForm implements ValidationForm {
    @ApiModelProperty(value = "个人介绍")
    @NotEmpty(message="个人介绍不能为空")
    private String personIntro;

    @ApiModelProperty(value = "个人头像，erp的修改无用")
    private String photoUrl;

    @ApiModelProperty(hidden = true)
    private String personId;

    public String getPersonIntro() {
        return personIntro;
    }

    public void setPersonIntro(String personIntro) {
        this.personIntro = personIntro;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
