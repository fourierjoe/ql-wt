package yhao.micro.service.surety.erp.org.apilist.form.person;

import yhao.infra.apilist.validate.IdUnForm;
import yhao.infra.common.CommonStatusEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-12
 * Time: 20:03
 */
public class PersonPropertiesSaveForm extends IdUnForm {
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
}
