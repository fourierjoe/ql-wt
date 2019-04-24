package yhao.micro.service.surety.erp.auth.apilist.form.auth;

import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafType;

import java.util.Set;

/**
 * Created by yoara on 2017/9/18.
 */
public class AuthTreeSaveForm extends AuthTreeQueryForm {

    private AuthLeafType type;
    private Set<String> authIdArray;

    public Set<String> getAuthIdArray() {
        return authIdArray;
    }

    public void setAuthIdArray(Set<String> authIdArray) {
        this.authIdArray = authIdArray;
    }

    public AuthLeafType getType() {
        return type;
    }

    public void setType(AuthLeafType type) {
        this.type = type;
    }
}
