package yhao.micro.service.surety.erp.org.apilist.form.position;

import yhao.infra.apilist.ValidationForm;

import java.util.List;

public class PositionLinkDeleteForm implements ValidationForm {
    private String personId;
    private List<String> positionLinkIds;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public List<String> getPositionLinkIds() {
        return positionLinkIds;
    }

    public void setPositionLinkIds(List<String> positionLinkIds) {
        this.positionLinkIds = positionLinkIds;
    }
}
