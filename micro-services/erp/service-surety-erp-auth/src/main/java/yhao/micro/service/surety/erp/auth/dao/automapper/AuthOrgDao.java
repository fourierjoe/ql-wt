package yhao.micro.service.surety.erp.auth.dao.automapper;


import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkSaveForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthOrgModel;

import java.util.List;

/**
 * Created by yoara on 2017/8/23.
 */
public interface AuthOrgDao {
    List<AuthOrgModel> queryOrg();

    void deleteOrgLink(SystemOrgLinkSaveForm form);

    void saveOrgLink(SystemOrgLinkSaveForm form);

    List<AuthOrgModel> queryOrgLink(SystemOrgLinkQueryForm form);

    List<AuthOrgModel> queryOrgBySystemKey(String systemKey);
}
