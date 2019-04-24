package yhao.micro.service.surety.erp.org.dao.automapper;


import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;

import java.util.List;

/**
 * Created by yoara on 2017/8/23.
 */
public interface PositionLinkDao {
    List<PositionLinkModel> queryPositionLink(PositionLinkQueryForm param);

    void savePositionLink(PositionLinkSaveForm param);

    void insertPositionLink(PositionLinkModel model);

    void updatePositionLink(PositionLinkModel model);

    void deleteById(String id);

    void deleteAllBySystem(List ids);

    void deleteByPositionId(String id);

    PositionLinkModel selectById(String id);

    Integer sumErpManagerByPersonId(String id);
}
