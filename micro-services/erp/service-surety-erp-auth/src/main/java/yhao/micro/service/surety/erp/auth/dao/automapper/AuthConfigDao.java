package yhao.micro.service.surety.erp.auth.dao.automapper;


import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthTypeModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;

import java.util.List;

/**
 * Created by yoara on 2017/8/23.
 */
public interface AuthConfigDao {
    List<AuthTypeModel> queryAuthType(AuthTypeQueryForm param);

    void queryAuthType(Pagination<AuthTypeModel> page, AuthTypeQueryForm form);

    AuthTypeModel pickAuthTypeById(String id);

    int deleteAuthType(String id);

    int deleteAuthLeaf(String id);

    List<AuthTypeModel> queryAuthByParentId(String id);

    int updateAuthType(AuthTypeSaveForm model);

    int insertAuthType(AuthTypeSaveForm model);

    int updateAuthLeaf(AuthLeafSaveForm model);

    int insertAuthLeaf(AuthLeafSaveForm model);

    AuthLeafModel pickAuthLeafById(String id);

    List<AuthLeafModel> queryAuthLeaf(AuthLeafQueryForm param);

    void queryAuthLeaf(Pagination<AuthLeafModel> page, AuthLeafQueryForm form);

    List<AuthLeafModel> queryAuthLeafBySystemKey(AuthTreeQueryForm form);

    List<AuthLeafModel> queryAllPositionLinkAuthorityId(AuthTreeQueryForm form);

    List<AuthLeafModel> queryAllPositionBaseAuthorityId(AuthTreeQueryForm form);

    void deleteRelationByPositionId(PositionAuthSaveForm param);

    void savePositionAuth(PositionAuthSaveForm param);

    List<AuthLeafModel> queryAllPersonAuthorityId(AuthTreeQueryForm form);

    void deleteRelationByPersonId(AuthTreeQueryForm param);

    void savePersonAuth(AuthTreeSaveForm form);

    List<DataAuthModel> queryAllPositionDataAuthority(DataAuthTreeQueryForm param);

    void savePositionDataAuth(PositionDataAuthSaveForm param);

    void deletePositionDataAuthRelation(PositionDataAuthSaveForm param);

    void savePersonDataAuth(PersonDataAuthSaveForm param);

    void deletePersonDataAuthRelation(PersonDataAuthSaveForm param);

    List<DataAuthModel> queryAllPersonDataAuthority(DataAuthTreeQueryForm param);

    List<AuthLeafModel> queryAuthLeafListByIds(AuthLeafIdsForm authParam);

    String pickPositionIdByLinkId(String positionLinkId);

    void deleteBaseRelationByPositionId(PositionAuthSaveForm param);

    void savePositionBaseAuth(PositionAuthSaveForm param);

    void deletePersonAuthByAuthLeafId(String id);

    void deletePositionAuthByAuthLeafId(String id);

    void deleteBasePositionAuthByAuthLeafId(String id);
}
