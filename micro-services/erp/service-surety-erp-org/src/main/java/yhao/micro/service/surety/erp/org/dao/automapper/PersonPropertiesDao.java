package yhao.micro.service.surety.erp.org.dao.automapper;

import yhao.micro.service.surety.erp.org.apilist.form.person.PersonPropertiesSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.PersonPropertiesModel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-12
 * Time: 19:46
 */
public interface PersonPropertiesDao {
    PersonPropertiesModel queryPersonPropertiesByPersonId(String personId);

    int updatePersonProperties(PersonPropertiesSaveForm saveForm);


    int insertPersonProperties(PersonPropertiesSaveForm saveForm);
}
