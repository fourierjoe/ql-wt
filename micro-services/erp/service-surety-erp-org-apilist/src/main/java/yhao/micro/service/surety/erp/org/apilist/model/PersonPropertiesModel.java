package yhao.micro.service.surety.erp.org.apilist.model;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Entity;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonPropertiesSaveForm;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-12
 * Time: 19:55
 */
public class PersonPropertiesModel extends Entity<String> {
    private Mapper mapper = new DozerBeanMapper();
    private String personId;
    private String wxOpenId;
    private CommonStatusEnum status;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public CommonStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CommonStatusEnum status) {
        this.status = status;
    }

    public PersonPropertiesSaveForm toSaveForm() {
        return mapper.map(this, PersonPropertiesSaveForm.class);
    }
}
