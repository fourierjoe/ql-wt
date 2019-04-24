package yhao.micro.service.surety.erp.auth.apilist.form.auth;


import org.springframework.validation.annotation.Validated;
import yhao.infra.apilist.ValidationForm;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * Created by yoara on 2017/9/18.
 */
public class PersonAuthCheckForm implements ValidationForm {
    @NotNull(message = "人员id列表参数不得为空")
    @Valid
    private List<String> personIds;

    @NotNull(message = "权限列表参数不得为空")
    @Valid
    private Set<String> authUrl;

    @NotNull(message = "系统参数不得为空")
    private String systemKey;

    public List<String> getPersonIds() {
        return personIds;
    }

    public void setPersonIds(List<String> personIds) {
        this.personIds = personIds;
    }

    public Set<String> getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(Set<String> authUrl) {
        this.authUrl = authUrl;
    }

    public String getSystemKey() {
        return systemKey;
    }

    public void setSystemKey(String systemKey) {
        this.systemKey = systemKey;
    }
}
