package yhao.micro.service.surety.erp.org.apilist.form;

import yhao.infra.apilist.ValidationForm;

import java.util.List;

public class IdsForm implements ValidationForm {
    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
