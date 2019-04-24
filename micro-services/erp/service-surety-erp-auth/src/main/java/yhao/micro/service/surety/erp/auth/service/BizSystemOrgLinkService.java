package yhao.micro.service.surety.erp.auth.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkSaveForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthOrgModel;
import yhao.micro.service.surety.erp.auth.dao.automapper.AuthOrgDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/2/16.
 */
@Service
public class BizSystemOrgLinkService{
    @Resource
    private AuthOrgDao orgDao;
    public List<AuthOrgModel> querySystemOrgLink(SystemOrgLinkQueryForm form) {
        return orgDao.queryOrgLink(form);
    }

    @Transactional
    public boolean saveOrgLink(SystemOrgLinkSaveForm form) {
        orgDao.deleteOrgLink(form);
        if (StringUtils.isNotEmpty(form.getOrgIds())) {
            String[] orgArr = form.getOrgIds().split(",");
            form.setOrgIdArray(orgArr);
            //再新增绑定关系
            orgDao.saveOrgLink(form);
        }
        return true;
    }

    public List<AuthOrgModel> queryAllOrg() {
        return orgDao.queryOrg();
    }

    public List<AuthOrgModel> queryOrgListBySystemKey(String systemKey) {
        return orgDao.queryOrgBySystemKey(systemKey);
    }
}
