package yhao.micro.service.surety.erp.org.dao.automapper;


import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.form.person.PersonQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.AddPositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkDeleteForm;
import yhao.micro.service.surety.erp.org.apilist.model.AddPositionLinkModel;
import yhao.micro.service.surety.erp.org.apilist.model.PersonModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionListModel;

import java.util.List;

/**
 * Created by yoara on 2017/8/23.
 */
public interface PersonDao {
    PersonModel pickPersonById(String id);

    void queryPerson(Pagination<PersonModel> pagination, PersonQueryForm param);

    void insertPerson(PersonModel person);

    void updatePerson(PersonModel person);

    List<PersonModel> queryPerson(PersonQueryForm param);

    int selectMaxNumber();

    void saveAddPosition(AddPositionLinkSaveForm form);

    void deleteAddPosition(AddPositionLinkSaveForm form);

    List<PositionLinkModel> queryAddPosition(String personId);

    void insertPositionListModel(PositionListModel model);

    void addEndTimeToPositionList(AddPositionLinkSaveForm form);

    List<PositionListModel> queryPersonPositionListModel(String personId);

    void deleteAllPersonPositionBySystem(PositionLinkDeleteForm param);

    void insertAddPosition(AddPositionLinkModel model);

    PersonModel pickPersonByPhone(String phone);

    void updatePassword(PersonModel person);

    void updateAddPosition(AddPositionLinkModel model);
}
