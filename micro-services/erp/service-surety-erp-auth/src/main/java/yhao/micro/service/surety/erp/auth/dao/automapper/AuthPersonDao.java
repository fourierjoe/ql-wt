package yhao.micro.service.surety.erp.auth.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PersonAuthQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPersonModel;
import yhao.micro.service.surety.erp.auth.login.apilist.form.AuthLoginForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPositionLinkModel;

import java.util.List;

/**
 * Created by yoara on 2017/8/23.
 */
public interface AuthPersonDao {
    void queryPerson(Pagination<AuthPersonModel> pagination, PersonAuthQueryForm param);

    LoginPersonModel authenticatePerson(AuthLoginForm form);

    /**
     * 不包含主职
     */
    List<String> queryAllAddPositionLinkId(String personId);

    /**
     * 包含主职
     */
    List<String> queryAllPositionLinkId(String personId);

    LoginPositionLinkModel pickLoginPositionLink(String positionLinkId);

    String queryCityOrgIdAndLongNumberByChildOrgId(String childOrgId);
}
