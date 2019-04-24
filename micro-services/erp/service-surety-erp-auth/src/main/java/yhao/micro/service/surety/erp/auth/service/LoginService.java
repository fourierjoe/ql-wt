package yhao.micro.service.surety.erp.auth.service;


import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.AuthLeafIdsForm;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.AuthTreeQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.DataAuthTreeQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import yhao.micro.service.surety.erp.auth.dao.automapper.AuthConfigDao;
import yhao.micro.service.surety.erp.auth.dao.automapper.AuthPersonDao;
import yhao.micro.service.surety.erp.auth.login.apilist.form.AuthLoginForm;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginDataAuthModel;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonResponse;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPositionLinkModel;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yoara on 2016/12/07.
 */
@Service
public class LoginService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Mapper mapper = new DozerBeanMapper();
    @Resource
    private PersonAuthConfigService personAuthConfigService;
    @Resource
    private AuthPersonDao personDao;
    @Resource
    private AuthConfigDao authConfigDao;
    @Resource
    private Environment environment;


    public LoginPersonResponse authenticatePerson(AuthLoginForm form) {
        LoginPersonResponse response = new LoginPersonResponse();
        LoginPersonModel loginPerson = personDao.authenticatePerson(form);
        if (loginPerson != null) {
            if (form.isNeedPsw()) {
                if (!Objects.equals(loginPerson.getPassword(), form.getPassword())) {
                    response.setSuccess(false);
                    response.setErrCode(LoginPersonResponse.ERR_CODE_WRONG_PSW);
                    response.setErrMessage("用户名或密码有误");
                    return response;
                }
            }
            response.setSuccess(true);
            response.setModel(loginPerson);
            initLoginPerson(form, loginPerson);
        } else {
            response.setErrCode(LoginPersonResponse.ERR_CODE_NO_PERSON);
            response.setErrMessage("用户名或密码有误");
        }
        return response;
    }

    private void initLoginPerson(AuthLoginForm form, LoginPersonModel loginPerson) {
        String superManager = environment.getProperty("superManager");
        if (superManager != null && superManager.contains(loginPerson.getPhone())) {
            loginPerson.setAdmin(true);
        }
        //查询所有的岗位
        List<String> addPositionLinkIds = CommonListUtil.NEW(loginPerson.getPositionLinkId());
        addPositionLinkIds.addAll(personDao.queryAllAddPositionLinkId(loginPerson.getId()));
        List<LoginPositionLinkModel> positionLinkModelList = new ArrayList<>();
        Map<String, Set<String>> authMap = new HashMap<>();
        Map<String, LinkedHashMap<String, LinkedHashSet<String>>> menuMap = new HashMap<>();
        Map<String, Map<String, List<LoginDataAuthModel>>> dataAuthMap = new HashMap<>();
        loginPerson.setPositionLinkModelList(positionLinkModelList);
        loginPerson.setAuthMap(authMap);
        loginPerson.setMenuMap(menuMap);
        loginPerson.setDataAuthMap(dataAuthMap);

        for (String positionLinkId : addPositionLinkIds) {
            LoginPositionLinkModel loginPlm = personDao.pickLoginPositionLink(positionLinkId);
            if (loginPlm == null) {
                continue;
            }
            //设置兼职岗位所属城市组织
            String cityOrgInfoString = personDao.queryCityOrgIdAndLongNumberByChildOrgId(loginPlm.getOrgId());
            loginPlm.setCityOrgId(StringUtils.isNotBlank(cityOrgInfoString) ? cityOrgInfoString.split(",")[0] : null);
            loginPlm.setCityOrgLongNumber(StringUtils.isNotBlank(cityOrgInfoString) && cityOrgInfoString.length() >= 2 ? cityOrgInfoString.split(",")[1] : null);
            loginPlm.setCityOrgName(StringUtils.isNotBlank(cityOrgInfoString) && cityOrgInfoString.length() >= 3 ? cityOrgInfoString.split(",")[2] : null);

            if (loginPlm.getId().equals(loginPerson.getPositionLinkId())) {
                loginPlm.setMajor(true);
                loginPerson.setCityOrgId(loginPlm.getCityOrgId());
                loginPerson.setCityOrgLongNumber(loginPlm.getCityOrgLongNumber());
                loginPerson.setCityOrgName(loginPlm.getCityOrgName());
            }
            //非erp导入数据，则只要主岗位上是管理岗则全部设置成管理岗
            if (!"system".equals(loginPerson.getCreateOperatorId())
                    && loginPerson.isManager()) {
                loginPlm.setManager(loginPerson.isManager());
            }
            positionLinkModelList.add(loginPlm);
            //获取当前用户已绑定权限
            AuthTreeQueryForm queryForm = new AuthTreeQueryForm();
            queryForm.setPersonId(loginPerson.getId());
            queryForm.setSystemKey(form.getSystemKey());
            queryForm.setPositionLinkId(positionLinkId);
            List<AuthLeafModel> result = personAuthConfigService.queryAllPersonAuthorityId(queryForm);
            if (result != null && result.size() > 0) {
                //权限url
                Set<String> auth = new HashSet<>();
                authMap.put(loginPlm.getId(), auth);

                //获取菜单可见权限
                String[] ids = getLeafsId(result);
                AuthLeafIdsForm authParam = new AuthLeafIdsForm();
                authParam.setIds(ids);
                List<AuthLeafModel> auths = personAuthConfigService.queryAuthLeafListByIds(authParam);
                LinkedHashMap<String, LinkedHashSet<String>> menu = new LinkedHashMap<>();
                for (AuthLeafModel dto : auths) {
                    auth.add(dto.getUrl());
                    if (!menu.containsKey(dto.getTypeTopName())) {
                        menu.put(dto.getTypeTopName(), new LinkedHashSet<>());
                    }
                    menu.get(dto.getTypeTopName()).add(dto.getTypeName());
                }
                menuMap.put(loginPlm.getId(), menu);
            }

            //获取当前用户已绑定数据
            DataAuthTreeQueryForm dataTreeForm = new DataAuthTreeQueryForm();
            dataTreeForm.setPersonId(loginPerson.getId());
            dataTreeForm.setSystemKey(form.getSystemKey());
            dataTreeForm.setPositionLinkId(positionLinkId);
            List<DataAuthModel> dataAuthList = personAuthConfigService.queryAllPersonDataAuthority(dataTreeForm);
            if (dataAuthList != null && dataAuthList.size() > 0) {
                Map<String, List<LoginDataAuthModel>> dataAuth = new HashMap<>();
                dataAuthMap.put(loginPlm.getId(), dataAuth);
                for (DataAuthModel dto : dataAuthList) {
                    if (!dataAuth.containsKey(dto.getDataType())) {
                        dataAuth.put(dto.getDataType(), new ArrayList<>());
                    }
                    dataAuth.get(dto.getDataType()).add(mapper.map(dto, LoginDataAuthModel.class));
                }
            }
        }
        //目前所有菜单项
        AuthTreeQueryForm authForm = new AuthTreeQueryForm();
        authForm.setSystemKey(form.getSystemKey());
        List<AuthLeafModel> allLeaf = authConfigDao.queryAuthLeafBySystemKey(authForm);
        LinkedHashMap<String, LinkedHashSet<String>> allMenu = new LinkedHashMap<>();
        for (AuthLeafModel dto : allLeaf) {
            if (!allMenu.containsKey(dto.getTypeTopName())) {
                allMenu.put(dto.getTypeTopName(), new LinkedHashSet<>());
            }
            allMenu.get(dto.getTypeTopName()).add(dto.getTypeName());
        }
        loginPerson.setAllMenu(allMenu);
    }

    private String[] getLeafsId(List<AuthLeafModel> leafs) {
        if (leafs == null || leafs.size() == 0) {
            return null;
        }
        String[] ids = new String[leafs.size()];
        for (int i = 0; i < leafs.size(); i++) {
            ids[i] = leafs.get(i).getId();
        }
        return ids;
    }

}
