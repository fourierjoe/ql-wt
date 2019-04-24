package yhao.micro.service.surety.erp.auth.apilist.form.auth;


import yhao.infra.apilist.ValidationForm;

/**
 * Created by yoara on 2017/9/18.
 */
public class AuthLeafIdsForm implements ValidationForm {
    private String[] ids;

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }
}
