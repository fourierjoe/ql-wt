package yhao.micro.service.surety.erp.org.dao.automapper;


import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.form.IdsForm;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgPropertyChangeForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;

import java.util.List;

/**
 * Created by yoara on 2017/8/23.
 */
public interface OrgDao {

    OrgModel selectById(String id);

    void queryOrg(Pagination<OrgModel> pagination, OrgQueryForm param);

    void insertOrg(OrgModel org);

    void updateOrg(OrgModel org);

    List<OrgModel> queryOrg(OrgQueryForm param);

    OrgModel selectTopOrgByChildId(String id);

    void changeStatusByLongNumber(StatusUpdateForm param);

    void deleteAllBySystem(List ids);

    void cityOrgChange(OrgPropertyChangeForm form);

    List<OrgModel> queryCityOrgByParentId(String id);

    List<OrgModel> queryCityOrgByChildId(String id);

    OrgModel selectOrgPropertyByOrgId(String id);

    void updateOrgProperty(OrgPropertyChangeForm form);

    void insertCityOrgProperty(OrgPropertyChangeForm form);

    List<OrgModel> queryChildOrgByLongNumber(String longNumber);

    void deletePositionByOrgIds(List<String> ids);

    void deletePositionLinkByOrgIds(List<String> ids);

    void deletePersonByOrgIds(List<String> ids);

    void deleteSystemLinkByOrgIds(List<String> ids);

    List<String> queryCityOrgLongNumber(String orgLongNumber);

    void queryAllParent(IdsForm idsForm);

    List<OrgModel> queryCityOrgByPositionLinkId(String positionLinkId);

    OrgModel queryCityOrgByChildOrgId(IdForm form);
}
