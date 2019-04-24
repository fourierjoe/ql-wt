package yhao.micro.service.surety.erp.auth.service;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.common.model.Entity;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafType;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPositionLinkModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import yhao.micro.service.surety.erp.auth.dao.automapper.AuthConfigDao;
import yhao.micro.service.surety.erp.auth.dao.automapper.PositionLinkDao;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yoara on 2017/9/21.
 */
@Service
public class PositionAuthConfigService {
    @Resource
    private PositionLinkDao positionLinkDao;
    @Resource
    private AuthConfigDao authConfigDao;
    @Resource
    private AuthConfigService authConfigService;

    private Mapper mapper = new DozerBeanMapper();

    public Pagination<AuthPositionLinkModel> queryPosition(PositionAuthQueryForm form) {
        Pagination<AuthPositionLinkModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        positionLinkDao.queryPositionLink(page, form);
        return page;
    }

    @Transactional
    public boolean savePositionBaseAuth(PositionAuthSaveForm form) {
        //先删除所有的绑定关系
        authConfigDao.deleteBaseRelationByPositionId(form);
        if (StringUtils.isNotEmpty(form.getAuthIds())) {
            String[] authArr = form.getAuthIds().split(",");
            form.setAuthIdArray(new HashSet<>(Arrays.asList(authArr)));
            //再新增绑定关系
            authConfigDao.savePositionBaseAuth(form);
        }
        return true;
    }

    @Transactional
    public boolean savePositionAuth(PositionAuthSaveForm form) {
        String[] authIds = StringUtils.isBlank(form.getAuthIds()) ?
                new String[]{} : form.getAuthIds().split(",");

        if (StringUtils.isEmpty(form.getPositionId())) {
            String positionId = authConfigDao.pickPositionIdByLinkId(form.getPositionLinkId());
            form.setPositionId(positionId);
        }
        AuthTreeQueryForm authForm = mapper.map(form, AuthTreeQueryForm.class);

        List<AuthLeafModel> positionBaseAuth = authConfigDao.queryAllPositionBaseAuthorityId(authForm);
        //找到从属岗位的id，对比包含关系
        Set<String> positionBaseAuthSet = positionBaseAuth.stream().map(Entity::getId).collect(Collectors.toSet());
        //计算取消和多选的权限
        Set<String> positionLinkAuths = new HashSet<>();
        authConfigService.mergeData(authIds, positionBaseAuthSet, positionLinkAuths);

        //先删除所有的绑定关系
        authConfigDao.deleteRelationByPositionId(form);

        //再新增绑定关系
        if (positionLinkAuths.size() > 0) {
            form.setType(AuthLeafType.GET);
            form.setAuthIdArray(positionLinkAuths);
            authConfigDao.savePositionAuth(form);
        }
        if (positionBaseAuthSet.size() > 0) {
            form.setType(AuthLeafType.NOT);
            form.setAuthIdArray(positionBaseAuthSet);
            authConfigDao.savePositionAuth(form);
        }

        return true;
    }

    public Set<String> queryAllPositionAuthorityIds(AuthTreeQueryForm form) {
        List<AuthLeafModel> list = queryAllPositionAuthority(form);
        Set<String> positionAuths = new HashSet<>(list.size() * 2);
        for (AuthLeafModel model : list) {
            positionAuths.add(model.getId());
        }
        return positionAuths;
    }

    public List<AuthLeafModel> queryAllPositionAuthority(AuthTreeQueryForm form) {
        String positionId = form.getPositionId();
        if (StringUtils.isEmpty(positionId)) {
            positionId = authConfigDao.pickPositionIdByLinkId(form.getPositionLinkId());
            form.setPositionId(positionId);
        }
        List<AuthLeafModel> positionBaseAuth = authConfigDao.queryAllPositionBaseAuthorityId(form);
        List<AuthLeafModel> positionLinkAuth = authConfigDao.queryAllPositionLinkAuthorityId(form);
        if (positionBaseAuth == null) {
            positionBaseAuth = new ArrayList<>();
        }
        if (positionLinkAuth != null) {
            for (AuthLeafModel pa : positionLinkAuth) {
                if (AuthLeafType.NOT.name().equals(pa.getAuthType())) {
                    positionBaseAuth.remove(pa);
                } else {
                    positionBaseAuth.add(pa);
                }
            }
        }
        return positionBaseAuth;
    }

    public List<DataAuthModel> queryAllPositionDataAuthority(DataAuthTreeQueryForm param) {
        return authConfigDao.queryAllPositionDataAuthority(param);
    }

    public boolean savePositionDataAuth(PositionDataAuthSaveForm form) {
        //先删除所有的绑定关系
        authConfigDao.deletePositionDataAuthRelation(form);
        if (StringUtils.isNotEmpty(form.getOrgIds())) {
            String[] orgIds = form.getOrgIds().split(",");
            form.setOrgIdArray(orgIds);
            //再新增绑定关系
            authConfigDao.savePositionDataAuth(form);
        }

        return true;
    }

    public boolean resetPositionLinkAuth(PositionAuthSaveForm form) {
        authConfigDao.deleteRelationByPositionId(form);
        return true;
    }
}
