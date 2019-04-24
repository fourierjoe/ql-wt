package yhao.micro.service.surety.erp.auth.service;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResultException;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthTypeModel;
import yhao.micro.service.surety.erp.auth.dao.automapper.AuthConfigDao;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * Created by yoara on 2016/12/07.
 */
@Service
public class AuthConfigService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private AuthConfigDao authConfigDao;

    public List<AuthTypeModel> queryAuthType(AuthTypeQueryForm form) {
        return authConfigDao.queryAuthType(form);
    }

    public AuthTypeModel pickAuthTypeById(String id) {
        return authConfigDao.pickAuthTypeById(id);
    }

    @Transactional
    public boolean deleteAuthType(String id) {
        int deleted = authConfigDao.deleteAuthType(id);
        List<AuthTypeModel> childrenList = authConfigDao.queryAuthByParentId(id);
        if(CollectionUtils.isNotEmpty(childrenList)){
            throw new RequestResultException("请先删除该菜单下的子菜单！");
        }
        if (deleted > 0) {
            //删除权限叶子信息
            AuthLeafQueryForm param = new AuthLeafQueryForm();
            param.setTypeId(id);
            List<AuthLeafModel> list = authConfigDao.queryAuthLeaf(param);
            for (AuthLeafModel model : list) {
                deleteAuthLeaf(model.getId());
            }
//            //删除从属类别
//            List<AuthTypeModel> childrenList = authConfigDao.queryAuthByParentId(id);
//            for (AuthTypeModel child : childrenList) {
//                deleteAuthType(child.getId());
//            }
        }
        return deleted > 0;
    }

    public boolean saveAuthType(AuthTypeSaveForm form) {
        if (StringUtils.isEmpty(form.getParentId())) {
            form.setParentId(null);
        }
        if (StringUtils.isNotEmpty(form.getId())) {
            return authConfigDao.updateAuthType(form) > 0;
        } else {
            return authConfigDao.insertAuthType(form) > 0;
        }
    }

    @Transactional
    public boolean batchSaveAuthType(AuthTypeBatchSaveForm form) {
        boolean result = true;
        for (AuthTypeSaveForm authTypeForm : form.getAuthTypeSaveFormList()) {
            result = saveAuthType(authTypeForm);
        }
        return result;
    }

    public boolean deleteAuthLeaf(String id) {
        authConfigDao.deletePersonAuthByAuthLeafId(id);
        authConfigDao.deletePositionAuthByAuthLeafId(id);
        authConfigDao.deleteBasePositionAuthByAuthLeafId(id);
        return authConfigDao.deleteAuthLeaf(id) > 0;
    }

    public boolean saveAuthLeaf(AuthLeafSaveForm form) {
        form.setUrl(form.getUrl().trim());
        if (StringUtils.isNotEmpty(form.getId())) {
            return authConfigDao.updateAuthLeaf(form) > 0;
        } else {
            return authConfigDao.insertAuthLeaf(form) > 0;
        }
    }

    public AuthLeafModel pickAuthLeafById(String id) {
        return authConfigDao.pickAuthLeafById(id);
    }

    public Pagination<AuthLeafModel> pageQueryAuthLeaf(AuthLeafQueryForm form) {
        Pagination<AuthLeafModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        authConfigDao.queryAuthLeaf(page, form);
        return page;
    }

    public List<AuthLeafModel> queryAuthLeafListBySystemKey(AuthTreeQueryForm form) {
        return authConfigDao.queryAuthLeafBySystemKey(form);
    }

    //合并数据
    public void mergeData(String[] nodeIds, Set<String> allNodeId, Set<String> personNodeId) {
        if (ArrayUtils.isNotEmpty(nodeIds)) {
            for (String nodeId : nodeIds) {
                //列表中包含该id，则说明没有做变动
                if (allNodeId.contains(nodeId)) {
                    //从总列表中移除该id，剩下的都是被取消的
                    allNodeId.remove(nodeId);
                } else {  //总列表中中不包含该id，则说明这是新增加的
                    personNodeId.add(nodeId);
                }
            }
        }
    }
}
