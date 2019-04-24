package yhao.micro.service.surety.erp.auth.service;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafType;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPersonModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import yhao.micro.service.surety.erp.auth.dao.automapper.AuthConfigDao;
import yhao.micro.service.surety.erp.auth.dao.automapper.AuthPersonDao;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yoara on 2017/9/21.
 */
@Service
public class PersonAuthConfigService {
    @Resource
    private AuthPersonDao personDao;
    @Resource
    private AuthConfigDao authConfigDao;
    @Resource
    private AuthConfigService authConfigService;
    @Resource
    private PositionAuthConfigService positionAuthConfigService;
    @Resource
    private PersonAuthConfigService personAuthConfigService;

    private Mapper mapper = new DozerBeanMapper();

    public Pagination<AuthPersonModel> queryPerson(PersonAuthQueryForm form) {
        Pagination<AuthPersonModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        personDao.queryPerson(page, form);
        return page;
    }

    @Transactional
    public boolean savePersonAuth(AuthTreeQueryForm form) {
        String[] authIds = StringUtils.isBlank(form.getAuthIds()) ?
                new String[]{} : form.getAuthIds().split(",");
        //找到从属岗位的id，对比包含关系
        Set<String> positionAuths = positionAuthConfigService.queryAllPositionAuthorityIds(form);
        //计算取消和多选的权限
        Set<String> personAuths = new HashSet<>();
        authConfigService.mergeData(authIds, positionAuths, personAuths);
        //先删除所有的绑定关系
        authConfigDao.deleteRelationByPersonId(form);

        AuthTreeSaveForm saveForm = mapper.map(form, AuthTreeSaveForm.class);

        //再新增绑定关系
        if (personAuths.size() > 0) {
            saveForm.setType(AuthLeafType.GET);
            saveForm.setAuthIdArray(personAuths);
            authConfigDao.savePersonAuth(saveForm);
        }
        if (positionAuths.size() > 0) {
            saveForm.setType(AuthLeafType.NOT);
            saveForm.setAuthIdArray(positionAuths);
            authConfigDao.savePersonAuth(saveForm);
        }
        return true;
    }

    public boolean resetPersonAuth(AuthTreeQueryForm param) {
        authConfigDao.deleteRelationByPersonId(param);
        return true;
    }

    public List<AuthLeafModel> queryAllPersonAuthorityId(AuthTreeQueryForm form) {
        //获取从岗位上继承的权限
        List<AuthLeafModel> positionAuthList = positionAuthConfigService.queryAllPositionAuthority(form);
        List<AuthLeafModel> authList = new ArrayList<>();
        if (positionAuthList != null) {
            authList.addAll(positionAuthList);
        }
        //从个人权限设置上并集权限
        List<AuthLeafModel> personAuthList = authConfigDao.queryAllPersonAuthorityId(form);
        if (personAuthList != null) {
            for (AuthLeafModel pa : personAuthList) {
                if (AuthLeafType.NOT.name().equals(pa.getAuthType())) {
                    authList.remove(pa);
                } else {
                    authList.add(pa);
                }
            }
        }
        return authList;
    }

    @Transactional
    public boolean savePersonDataAuth(PersonDataAuthSaveForm form) {
        //先删除所有的绑定关系
        authConfigDao.deletePersonDataAuthRelation(form);
        if (StringUtils.isNotEmpty(form.getOrgIds())) {
            String[] orgIds = form.getOrgIds().split(",");
            DataAuthTreeQueryForm dataAuthTreeQueryForm = mapper.map(form, DataAuthTreeQueryForm.class);
            //找到从属岗位的id，对比包含关系
            List<DataAuthModel> positionDataAuthList = authConfigDao.queryAllPositionDataAuthority(dataAuthTreeQueryForm);
            Set<String> positionOrgIds = new HashSet<>();
            if (positionDataAuthList != null) {
                for (DataAuthModel model : positionDataAuthList) {
                    positionOrgIds.add(model.getOrgId());
                }
            }
            //计算取消和多选的权限
            Set<String> personDataAuth = new HashSet<>();

            authConfigService.mergeData(orgIds, positionOrgIds, personDataAuth);

            //再新增绑定关系
            if (personDataAuth.size() > 0) {
                form.setOrgIdArray(personDataAuth);
                form.setAuthType(AuthLeafType.GET);
                authConfigDao.savePersonDataAuth(form);
            }
            if (positionOrgIds.size() > 0) {
                form.setOrgIdArray(positionOrgIds);
                form.setAuthType(AuthLeafType.NOT);
                authConfigDao.savePersonDataAuth(form);
            }
        }
        return true;
    }

    public boolean resetPersonDataAuth(PersonDataAuthSaveForm form) {
        authConfigDao.deletePersonDataAuthRelation(form);
        return true;
    }

    public List<DataAuthModel> queryAllPersonDataAuthority(DataAuthTreeQueryForm form) {
        //获取从岗位上继承的权限
        List<DataAuthModel> positionDataAuthList = authConfigDao.queryAllPositionDataAuthority(form);
        List<DataAuthModel> dataAuthList = new ArrayList<>();
        if (positionDataAuthList != null) {
            dataAuthList.addAll(positionDataAuthList);
        }

        //从个人权限设置上并集权限
        List<DataAuthModel> personDataAuthList = authConfigDao.queryAllPersonDataAuthority(form);
        if (personDataAuthList != null) {
            for (DataAuthModel model : personDataAuthList) {
                if (AuthLeafType.NOT.name().equals(model.getAuthType())) {
                    for (int index = 0; index < dataAuthList.size(); index++) {
                        if (dataAuthList.get(index).getOrgId().equals(model.getOrgId())) {
                            dataAuthList.remove(index);
                            break;
                        }
                    }
                } else {
                    dataAuthList.add(model);
                }
            }
        }
        return dataAuthList;
    }

    public List<AuthLeafModel> queryAuthLeafListByIds(AuthLeafIdsForm authParam) {
        return authConfigDao.queryAuthLeafListByIds(authParam);
    }

    public List<String> checkPersonAuth(PersonAuthCheckForm form) {
        List<String> checked = new ArrayList<>();
        for (String personId : form.getPersonIds()) {
            List<String> allPositionLinkIds = personDao.queryAllPositionLinkId(personId);
            boolean personHas = false;
            AuthTreeQueryForm queryForm = new AuthTreeQueryForm();
            AuthLeafIdsForm idsForm = new AuthLeafIdsForm();
            for (String positionLinkId : allPositionLinkIds) {
                //获取当前用户已绑定权限
                queryForm.setPersonId(personId);
                queryForm.setSystemKey(form.getSystemKey());
                queryForm.setPositionLinkId(positionLinkId);
                List<AuthLeafModel> result = personAuthConfigService.queryAllPersonAuthorityId(queryForm);
                if (result != null && result.size() > 0) {
                    //获取菜单可见权限
                    List<String> ids = result.stream().map(o -> o.getId()).collect(Collectors.toList());
                    idsForm.setIds(ids.toArray(new String[]{}));
                    List<AuthLeafModel> auths = personAuthConfigService.queryAuthLeafListByIds(idsForm);
                    Set<String> hasAuth = auths.stream().map(o -> o.getUrl()).collect(Collectors.toSet());
                    if (hasAuth.containsAll(form.getAuthUrl())) {
                        personHas = true;
                        break;
                    }
                }
            }
            if (personHas) {
                checked.add(personId);
            }
        }
        return checked;
    }
}
