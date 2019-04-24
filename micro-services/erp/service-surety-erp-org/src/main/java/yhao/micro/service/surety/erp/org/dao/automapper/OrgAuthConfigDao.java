package yhao.micro.service.surety.erp.org.dao.automapper;

import yhao.micro.service.surety.erp.org.apilist.form.IdsForm;

/**
 * Created by yoara on 2017/8/23.
 */
public interface OrgAuthConfigDao {
    void deleteAllPersonRelationByPositionLinkIds(IdsForm param);

    void deleteAllPositionRelationByPositionLinkIds(IdsForm param);
}
