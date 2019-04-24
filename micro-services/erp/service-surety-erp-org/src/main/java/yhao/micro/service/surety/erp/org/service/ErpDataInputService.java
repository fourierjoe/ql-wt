package yhao.micro.service.surety.erp.org.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.cache.RedisCache;
import yhao.micro.service.constants.enums.ConstantsCacheKey;
import yhao.micro.service.surety.erp.org.apilist.enums.OrgTypeEnum;
import yhao.micro.service.surety.erp.org.apilist.enums.PositionTypeEnum;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.ErpPersonResetForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkDeleteForm;
import yhao.micro.service.surety.erp.org.apilist.model.*;
import yhao.micro.service.surety.erp.org.dao.automapper.OrgDao;
import yhao.micro.service.surety.erp.org.dao.automapper.PersonDao;
import yhao.micro.service.surety.erp.org.dao.automapper.PositionDao;
import yhao.micro.service.surety.erp.org.dao.automapper.PositionLinkDao;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ErpDataInputService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private Environment env;
    @Resource
    private JdbcTemplate erpJdbcTemplate;
    @Resource
    private OrgDao orgDao;
    @Resource
    private PositionDao positionDao;
    @Resource
    private PositionLinkDao positionLinkDao;
    @Resource
    private PersonDao personDao;
    @Resource
    private RedisCache redisCache;
    @Resource
    private PersonService personService;

    /**
     * 组织异动时调用的处理逻辑。
     */
    public void erpOrgRevise(String msg) {
        JSONObject msgInfo = JSONObject.parseObject(msg);
        String orgId = msgInfo.getString("orgId");
        if (checkOrg(orgId)) {
            List<String> orgIds = synchErpOrg(orgId);
            List<String> positionTypeIds = synchErpPositionType(orgIds);
            List<String> basePositionIds = synchErpPosition(positionTypeIds);
            synchErpPersonPosition(basePositionIds, null);
        }
    }

    /**
     * 判断该组织是否属于租赁
     **/
    private boolean checkOrg(String orgId) {
        String rootLongNumber = pickRootOrgLongNumber();

        List<Map<String, Object>> org = erpJdbcTemplate.queryForList(SQL_SELECT_ORG_BY_ID, orgId);
        if (org != null && org.size() > 0) {
            String orgLongNumber = (String) org.get(0).get("FLONGNUMBER");
            if (orgLongNumber.startsWith(rootLongNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取租赁的组织长编码
     **/
    private String pickRootOrgLongNumber() {
        String rootOrgId = env.getProperty("basic.erp.orgid");
        List<Map<String, Object>> root = erpJdbcTemplate.queryForList(SQL_SELECT_ORG_BY_ID, rootOrgId);
        return (String) root.get(0).get("FLONGNUMBER");
    }

    /**
     * 人员入职时调用的逻辑
     */
    public void erpPersonEnroll(String msg) {
        erpEnrollOrTransfer(msg);
    }

    /**
     * 人员异动时调用的逻辑
     */
    public void erpPersonTransfer(String msg) {
        erpEnrollOrTransfer(msg);
    }

    /**
     * 入职和异动调用的方式是一致的
     **/
    private void erpEnrollOrTransfer(String msg) {
        JSONObject msgInfo = JSONObject.parseObject(msg);
        String personId = msgInfo.getString("personId");
        if (checkPerson(personId)) {
            ErpPersonResetForm form = new ErpPersonResetForm();
            form.setId(personId);
            resetErpPerson(form);
        }
    }

    /**
     * 判断该人员是否属于租赁
     **/
    private boolean checkPerson(String personId) {
        String rootLongNumber = pickRootOrgLongNumber();

        List<Map<String, Object>> orgList =
                erpJdbcTemplate.queryForList(SQL_SELECT_PERSONPOSITIONINFO_BY_PERSONID, personId);
        if (orgList != null && orgList.size() > 0) {
            for (Map<String, Object> map : orgList) {
                String orgLongNumber = (String) map.get("FLONGNUMBER");
                if (orgLongNumber != null && orgLongNumber.startsWith(rootLongNumber)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 人员离职时调用的方法
     */
    public void erpPersonLeave(String msg) {
        JSONObject msgInfo = JSONObject.parseObject(msg);
        PersonModel model = new PersonModel();
        model.setId(msgInfo.getString("personId"));
        model.setStatus(CommonStatusEnum.DISABLED);
        personDao.updatePerson(model);
        changePersonSuretyStatus(model.getId(),model.getStatus());
    }

    /**
     * 通过id或手机号同步人员信息
     */
    public boolean resetErpPerson(ErpPersonResetForm form) {
        //同步人
        Map<String, Object> map;
        if (StringUtils.isNotEmpty(form.getId())) {
            map = erpJdbcTemplate.queryForMap(SQL_SELECT_PERSON, form.getId());
        } else {
            map = erpJdbcTemplate.queryForMap(SQL_SELECT_PERSON_BY_PHONE, form.getPhone());
        }
        if (map != null) {
            String id = (String) map.get("FID");
            List<Map<String, Object>> list =
                    erpJdbcTemplate.queryForList(SQL_SELECT_PERSONPOSITIONINFO_BY_PERSONID, id);
            if (list != null) {
                String rootLongNumber = pickRootOrgLongNumber();
                List<String> positionIds = new ArrayList<>();
                for (Map<String, Object> orgInfo : list) {
                    String orgLongNumber = (String) orgInfo.get("FLONGNUMBER");
                    String positionId = (String) orgInfo.get("FKPOSITIONID");
                    if (orgLongNumber.startsWith(rootLongNumber)) {
                        positionIds.add(positionId);
                    }
                }
                if (positionIds != null && positionIds.size() > 0) {
                    synchErpPersonPosition(positionIds, id);
                }
            }
        }
        return true;
    }

    /**
     * 全量同步组织和人员信息
     */
    public boolean synchErpOrgInfo() {
        List<String> orgIds = synchErpOrg(null);
        List<String> positionTypeIds = synchErpPositionType(orgIds);
        List<String> positionIds = synchErpPosition(positionTypeIds);
        synchErpPersonPosition(positionIds, null);
        return true;
    }

    /**
     * 判断该用户是否在ERP中存在
     */
    public boolean checkHasPerson(ErpPersonResetForm form) {
        List<Map<String, Object>> list = erpJdbcTemplate.queryForList(SQL_SELECT_PERSON_BY_PHONE, form.getPhone());
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    /**
     * 通过岗位id同步挂职及人员信息。
     **/
    private void synchErpPersonPosition(List<String> positionIds, String specifyPersonId) {
        if (positionIds == null || positionIds.size() == 0) {
            return;
        }
        String sql = SQL_SELECT_PERSONPOSITION + " ('" + StringUtils.join(positionIds, "','") + "')";
        if (StringUtils.isNotEmpty(specifyPersonId)) {
            sql += " and FKPERSONID='" + specifyPersonId + "'";
        }
        List<Map<String, Object>> list = erpJdbcTemplate.queryForList(sql);
        if (list != null && list.size() > 0) {
            PositionLinkDeleteForm param = new PositionLinkDeleteForm();
            param.setPersonId(specifyPersonId);
            if (StringUtils.isEmpty(specifyPersonId)) {
                param.setPositionLinkIds(positionIds);
            }
            personDao.deleteAllPersonPositionBySystem(param);
            for (Map<String, Object> map : list) {
                try {
                    AddPositionLinkModel model = new AddPositionLinkModel();
                    String id = (String) map.get("FID");
                    String personId = (String) map.get("FKPERSONID");
                    String primary = map.get("FISPRIMARY").toString();
                    PositionTypeEnum statusEnum = "1".equals(primary) ?
                            PositionTypeEnum.MAJOR : PositionTypeEnum.PART;

                    model.setPersonId(personId);
                    model.setPositionLinkId((String) map.get("FKPOSITIONID"));
                    model.setId(id);
                    model.setType(statusEnum);
                    model.setCreateTime(new Date());
                    model.setCreateOperatorId("system");
                    try {
                        personDao.insertAddPosition(model);
                    } catch (Exception e) {
                        //主键重复则更新数据
                        personDao.updateAddPosition(model);
                    }
                    synchErpPerson(personId, model.getPositionLinkId(), statusEnum == PositionTypeEnum.MAJOR);
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * isMajor为true时更新数据
     * isMajor为false时:
     * oldPerson的岗位ID=positonLinkId时更新
     */
    private void synchErpPerson(String personId, String positionLinkId, boolean isMajor) {
        Map<String, Object> map = erpJdbcTemplate.queryForMap(SQL_SELECT_PERSON, personId);
        PersonModel oldPerson = personDao.pickPersonById(personId);
        if (!isMajor) {
            if (oldPerson != null && !positionLinkId.equalsIgnoreCase(oldPerson.getPositionLinkId())) {
                return;
            }
        }

        if (map != null) {
            try {
                PositionLinkModel positionLinkModel = positionLinkDao.selectById(positionLinkId);
                PersonModel model = new PersonModel();
                String id = (String) map.get("FID");
                String state = (String) map.get("FPOSTSTATUS");
                CommonStatusEnum statusEnum = "ON_GUARD".equals(state) ?
                        CommonStatusEnum.ENABLED : CommonStatusEnum.DISABLED;
                Integer sex = Integer.parseInt(map.get("FGENDER").toString());
                sex = sex == 2 ? 0 : 1;

                model.setName((String) map.get("FNAME"));
                model.setNumber((String) map.get("FNUMBER"));
                model.setPhone((String) map.get("FCELL"));
                model.setCardId((String) map.get("FIDCARD"));
                model.setPassword((String) map.get("FPASSWORD"));
                model.setJoinDate((Date) map.get("FINTERDATE"));
                model.setPhotoUrl((String) map.get("FPHOTOURL"));
                model.setStatus(statusEnum);
                model.setSex(sex);
                model.setPositionLinkId(positionLinkId);
                model.setManager(positionLinkModel.getErpManager() > 0);
                model.setOrgId(positionLinkModel.getOrgId());
                model.setId(id);
                model.setUpdateTime((Date) map.get("FMODIFYTIME"));
                model.addOperatorInfo("system", true);
                if(CommonStatusEnum.DISABLED.equals(statusEnum)){//erp禁用之后，担保系统人员属性也禁用
                    changePersonSuretyStatus(model.getId(),model.getStatus());
                }
                if (oldPerson != null) {
                    personDao.updatePerson(model);
                    redisCache.remove(ConstantsCacheKey.MGR_SESSION_REFRESH, id);
                } else {
                    model.setCreateTime((Date) map.get("FCREATETIME"));
                    model.setCreateOperatorId("system");
                    personDao.insertPerson(model);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private void changePersonSuretyStatus(String personId,CommonStatusEnum status){
        StatusUpdateForm statusUpdateForm = new StatusUpdateForm();
        statusUpdateForm.setId(personId);
        statusUpdateForm.setStatus(status);
        personService.suretyPersonStatusChange(statusUpdateForm);
    }

    /**
     * 通过挂职id同步所有岗位信息
     */
    private List<String> synchErpPosition(List<String> positionTypeIds) {
        if (positionTypeIds == null || positionTypeIds.size() == 0) {
            return null;
        }
        String sql = SQL_SELECT_POSITION + " ('" + StringUtils.join(positionTypeIds, "','") + "')";
        List<String> positionIds = new ArrayList<>();
        List<Map<String, Object>> list = erpJdbcTemplate.queryForList(sql);
        if (list != null && list.size() > 0) {
            positionIds = list.stream().map(o -> (String) o.get("FID")).collect(Collectors.toList());
            Date now = new Date();
            positionLinkDao.deleteAllBySystem(positionIds);
            for (Map<String, Object> map : list) {
                try {
                    PositionLinkModel model = new PositionLinkModel();
                    String id = (String) map.get("FID");
                    model.setOrgId((String) map.get("FKORGID"));
                    model.setPositionId((String) map.get("FKPOSITIONTYPEID"));
                    model.setErpManager(Integer.parseInt(map.get("FISMANAGER").toString()));
                    model.setId(id);
                    model.addOperatorInfo("system", true);
                    if (positionLinkDao.selectById(id) != null) {
                        positionLinkDao.updatePositionLink(model);
                    } else {
                        model.setCreateTime(now);
                        model.setCreateOperatorId("system");
                        positionLinkDao.insertPositionLink(model);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return positionIds;
    }

    /**
     * 初始化所有职级数据。
     * erp的positionType对应我们的position；erp的position对应我们的positionLink
     *
     * @param orgIds
     * @return 返回职级id
     */
    private List<String> synchErpPositionType(List<String> orgIds) {
        if (orgIds == null && orgIds.size() == 0) {
            return null;
        }
        String sql = SQL_SELECT_POSITIONTYPE + " ('" + StringUtils.join(orgIds, "','") + "')";
        List<String> positionTypeIds = new ArrayList<>();
        List<Map<String, Object>> list = erpJdbcTemplate.queryForList(sql);
        if (list != null && list.size() > 0) {
            positionTypeIds = list.stream().map(o -> (String) o.get("FID")).collect(Collectors.toList());
            Date now = new Date();
            positionDao.deleteAllBySystem(positionTypeIds);
            for (Map<String, Object> map : list) {
                try {
                    PositionModel model = new PositionModel();
                    String id = (String) map.get("FID");
                    model.setName((String) map.get("FNAME"));
                    model.setNumber((String) map.get("FNUMBER"));
                    model.setOrgId((String) map.get("FKCUID"));
                    model.setId(id);
                    model.addOperatorInfo("system", true);
                    if (positionDao.selectById(id) != null) {
                        positionDao.updatePosition(model);
                    } else {
                        model.setCreateTime(now);
                        model.setCreateOperatorId("system");
                        positionDao.insertPosition(model);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return positionTypeIds;
    }

    /**
     * 初始化所有组织信息
     *
     * @return 返回组织id
     */
    private List<String> synchErpOrg(String rootOrgId) {
        String rootId = StringUtils.isEmpty(rootOrgId) ? env.getProperty("basic.erp.orgid") : rootOrgId;
        if (StringUtils.isEmpty(rootId)) {
            logger.error("org rootid is wrong");
            return null;
        }
        List<Map<String, Object>> list = erpJdbcTemplate.queryForList(SQL_SELECT_ORG, rootId);
        List<String> orgIds = new ArrayList<>();
        if (list != null && list.size() > 0) {
            orgIds = list.stream().map(o -> (String) o.get("FID")).collect(Collectors.toList());
            Date now = new Date();
            orgDao.deleteAllBySystem(orgIds);
            for (Map<String, Object> map : list) {
                try {
                    OrgModel model = new OrgModel();
                    String id = (String) map.get("FID");
                    String longNumber = (String) map.get("FLONGNUMBER");
                    longNumber = longNumber.replaceAll("!", "#").replaceAll("SHJT#", "");
                    String status = (String) map.get("FSTATE");
                    CommonStatusEnum statusEnum = "EFFECTIVE".equals(status) ?
                            CommonStatusEnum.ENABLED : CommonStatusEnum.DISABLED;
                    Integer level = Integer.parseInt(map.get("FLEVEL").toString()) - 1;
                    model.setId(id);
                    if (level != 1) {
                        model.setParentId((String) map.get("FKPARENTID"));
                    }
                    model.setName((String) map.get("FNAME"));
                    model.setNumber((String) map.get("FNUMBER"));
                    model.setLongNumber(longNumber);
                    model.setLevel(level);
                    model.setStatus(statusEnum);
                    model.setOrgType(mapperToOrgType(map.get("FISCU"), map.get("FBIZTYPE")));
                    model.addOperatorInfo("system", true);
                    if (orgDao.selectById(id) != null) {
                        orgDao.updateOrg(model);
                    } else {
                        model.setCreateTime(now);
                        model.setCreateOperatorId("system");
                        model.setValidDate(now);
                        orgDao.insertOrg(model);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
        return orgIds;
    }

    private OrgTypeEnum mapperToOrgType(Object isCu, Object bizType) {
        if (isCu!=null && "1".equals(isCu.toString())) {
            return OrgTypeEnum.CITY;
        }
        if (bizType != null) {
            switch ((String) bizType) {
                case "OPERATION_FINANCIAL":
                    return OrgTypeEnum.OPERATION_FINANCIAL;
                case "OPERATION_HUMANRESOURCE":
                    return OrgTypeEnum.OPERATION_HUMANRESOURCE;
                case "OPERATION_MORTGAGE":
                    return OrgTypeEnum.OPERATION_MORTGAGE;
                case "OPERATION_RESOURCEMANAGE":
                    return OrgTypeEnum.OPERATION_RESOURCEMANAGE;
                case "OPERATION_ADMIN":
                    return OrgTypeEnum.OPERATION_ADMIN;
                case "OPERATION_GENERALMANAGER":
                    return OrgTypeEnum.OPERATION_GENERALMANAGER;
                case "OPERATION_LEGAL":
                    return OrgTypeEnum.OPERATION_LEGAL;
                case "OPERATION_TRAIN":
                    return OrgTypeEnum.OPERATION_TRAIN;
                case "OPERATION_SECURITY":
                    return OrgTypeEnum.OPERATION_SECURITY;
                case "OPERATION_OTHER":
                    return OrgTypeEnum.OPERATION_OTHER;
                default:
                    return OrgTypeEnum.ERP_OTHER;
            }
        }
        return OrgTypeEnum.ERP_OTHER;
    }

    private static String SQL_SELECT_ORG =
            "select FID,FKPARENTID,FNAME,FNUMBER,FLONGNUMBER,FLEVEL,FSTATE,FBIZTYPE,FISCU " +
                    "from T_HR_ORG " +
                    "where FSTATE='EFFECTIVE' and FLONGNUMBER like (select FLONGNUMBER||'%' from T_HR_ORG " +
                    "where FID=? and rownum <= 1)";

    private static String SQL_SELECT_POSITIONTYPE =
            "select FID,FNAME,FKCUID,FNUMBER " +
                    "from T_HR_POSITIONTYPE  " +
                    "where FSTATE='EFFECTIVE' and FKCUID in ";

    private static String SQL_SELECT_POSITION =
            "select P.FID,P.FKORGID,P.FKPOSITIONTYPEID,P.FISMANAGER " +
                    "from T_HR_POSITION P " +
                    "where P.FSTATE='EFFECTIVE' AND EXISTS(SELECT 1 FROM T_HR_ORG O WHERE P.FKORGID=O.FID AND O.FSTATE='EFFECTIVE') " +
                    "and P.FKPOSITIONTYPEID in ";

    private static String SQL_SELECT_PERSONPOSITION =
            "select FID,FISPRIMARY,FKPERSONID,FKPOSITIONID " +
                    "from T_HR_PERSONPOSITION " +
                    "where FKPOSITIONID in ";

    private static String SQL_SELECT_PERSON =
            "select FID,FNUMBER,FNAME,FCELL,FIDCARD,FPOSTSTATUS,FGENDER,FPASSWORD,FINTERDATE,FPHOTOURL,nvl(FMODIFYTIME,FCREATETIME) as FMODIFYTIME,FCREATETIME " +
                    "from T_HR_PERSON " +
                    "where FID = ?";

    private static String SQL_SELECT_PERSON_BY_PHONE =
            "select FID,FNUMBER,FNAME,FCELL,FIDCARD,FPOSTSTATUS,FGENDER,FPASSWORD,FINTERDATE " +
                    "from T_HR_PERSON " +
                    "where FCELL = ?";

    private static String SQL_SELECT_ORG_BY_ID =
            "select FID,FLONGNUMBER " +
                    "from T_HR_ORG " +
                    "where FID = ?";

    private static String SQL_SELECT_PERSONPOSITIONINFO_BY_PERSONID =
            "select torg.FLONGNUMBER,pp.FID as FPERSONPOSITIONID,pp.FKPOSITIONID as FKPOSITIONID " +
                    "from T_HR_PERSON tp " +
                    "left join T_HR_PERSONPOSITION pp on pp.FKPERSONID = tp.FID " +
                    "left join T_HR_POSITION thrp on thrp.fid=pp.FKPOSITIONID " +
                    "left join T_HR_ORG torg on torg.FID = thrp.FKORGID " +
                    "where tp.fid=?";
}
