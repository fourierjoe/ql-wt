package yhao.micro.service.surety.erp.org.service;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonListUtil;
import yhao.infra.common.util.PinYinUtil;
import yhao.infra.common.util.RandomUtil;
import yhao.micro.service.surety.erp.org.apilist.enums.OrgTypeEnum;
import yhao.micro.service.surety.erp.org.apilist.form.IdsForm;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgPropertyChangeForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.PositionOrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;
import yhao.micro.service.surety.erp.org.dao.automapper.OrgDao;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrgService {
    @Resource
    private OrgDao orgDao;

    public Pagination<OrgModel> queryOrgPage(OrgQueryForm form) {
        Pagination<OrgModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        if (StringUtils.isNotBlank(form.getOrgTypes())) {
            form.setOrgTypeList(Arrays.asList(form.getOrgTypes().split(",")));
        }
        orgDao.queryOrg(page, form);
        return page;
    }

    public List<OrgModel> queryOrgList(OrgQueryForm form) {
        if (StringUtils.isNotBlank(form.getOrgTypes())) {
            form.setOrgTypeList(Arrays.asList(form.getOrgTypes().split(",")));
        }
        List<OrgModel> orgModelList = orgDao.queryOrg(form);
        findOrgParent(orgModelList, form);
        return orgModelList;
    }

    public List<OrgModel> queryOrgListByPosition(PositionOrgQueryForm form) {
        List<OrgModel> cityOrgList = orgDao.queryCityOrgByPositionLinkId(form.getPositionLinkId());
        if (CollectionUtils.isEmpty(cityOrgList)) {
            return null;
        }
        OrgModel rootCity = cityOrgList.get(0);
        for (OrgModel cityOrg : cityOrgList) {
            if (cityOrg.getLongNumber().length() > rootCity.getLongNumber().length()) {
                rootCity = cityOrg;
            }
        }
        OrgQueryForm queryForm = new OrgQueryForm();
        queryForm.setRootLongNumber(rootCity.getLongNumber());
        queryForm.setOrgTypes(form.getOrgTypes());
        queryForm.setFindParent(form.getFindParent());
        return queryOrgList(queryForm);
    }

    public OrgModel queryCityOrgByChildOrgId(IdForm form) {
        return orgDao.queryCityOrgByChildOrgId(form);
    }

    public OrgModel selectById(String id) {
        return orgDao.selectById(id);
    }

    public boolean saveOrg(OrgModel org) {
        if (StringUtils.isEmpty(org.getId())) {
            org.setNumber(PinYinUtil.converterToFirstSpell(org.getName()) + RandomUtil.makeRandomNumberString(3));
        }
        if (StringUtils.isNotEmpty(org.getParentId())) {
            OrgModel parentOrg = orgDao.selectById(org.getParentId());
            if (StringUtils.isEmpty(org.getId())) {
                org.setLongNumber(parentOrg.getLongNumber() + "#" + org.getNumber());
            } else {
                OrgModel oldOrg = orgDao.selectById(org.getId());
                org.setLongNumber(parentOrg.getLongNumber() + "#" + oldOrg.getNumber());
            }
            org.setLevel(org.getLongNumber().split("#").length);
        } else {
            org.setParentId(null);
            org.setLongNumber(org.getNumber());
        }
        if (StringUtils.isEmpty(org.getId())) {
            org.setLevel(org.getLongNumber().split("#").length);
            org.setId(UUID.randomUUID().toString());
            orgDao.insertOrg(org);
        } else {
            orgDao.updateOrg(org);
            //同时处理状态的修改
        }
        return true;
    }

    public boolean orgStatusChange(StatusUpdateForm form) {
        //OrgModel org = new OrgModel();
        //org.setId(id);
        //org.setStatus(status);
        //org.addOperatorInfo(operatorId);
        //orgDao.updateOrg(org);

        OrgModel model = orgDao.selectById(form.getId());
        form.setLongNumber(model.getLongNumber());
        orgDao.changeStatusByLongNumber(form);
        return true;
    }

    public void deleteOrg(IdForm form) {
        //找到组织下所有下级组织
        OrgModel org = orgDao.selectById(form.getId());
        if (org != null) {
            List<OrgModel> orgList = orgDao.queryChildOrgByLongNumber(org.getLongNumber());
            if (orgList != null && orgList.size() > 0) {
                List<String> ids = orgList.stream().map(orgModel -> orgModel.getId()).collect(Collectors.toList());
                //删除组织关联的position
                orgDao.deletePositionByOrgIds(ids);
                //删除组织关联的positionLink
                orgDao.deletePositionLinkByOrgIds(ids);
                //删除组织下所有人
                orgDao.deletePersonByOrgIds(ids);
                //删除组织关联的systemLink
                orgDao.deleteSystemLinkByOrgIds(ids);
            }
        }
    }

    public boolean cityOrgChange(OrgPropertyChangeForm form) {
        if (1 == form.getCityOrg()) {
            List<OrgModel> childrenHas = orgDao.queryCityOrgByParentId(form.getId());
            if (childrenHas.size() > 0) {
                throw new RuntimeException("子组织：[" + childrenHas.get(0).getName() + "]已经设置成城市公司，请先取消");
            }
            List<OrgModel> parentHas = orgDao.queryCityOrgByChildId(form.getId());
            if (parentHas.size() > 0) {
                throw new RuntimeException("父组织：[" + parentHas.get(0).getName() + "]已经设置成城市公司");
            }
        }
        OrgModel orgProperty = orgDao.selectOrgPropertyByOrgId(form.getId());
        form.setOperatorTime(new Date());
        if (orgProperty != null) {
            orgDao.updateOrgProperty(form);
        } else {
            orgDao.insertCityOrgProperty(form);
        }
        return true;
    }

    private void findOrgParent(List<OrgModel> orgModelList, OrgQueryForm form) {
        boolean findParent = CollectionUtils.isNotEmpty(orgModelList)
                && StringUtils.isNotBlank(form.getOrgTypes())
                && form.getFindParent() != null && form.getFindParent();
        if (!findParent) {
            return;
        }
        OrgQueryForm queryForm = new OrgQueryForm();
        queryForm.setRootLongNumber(form.getRootLongNumber());
        List<OrgModel> allOrgModelList = orgDao.queryOrg(queryForm);
        List<OrgModel> parentOrgModelList = new ArrayList<>();
        for (OrgModel orgModel : orgModelList) {
            if (orgModel.getOrgType() == OrgTypeEnum.CITY) {
                continue;
            }
            for (OrgModel parent : allOrgModelList) {//寻找父亲
                if (!orgModel.equals(parent)
                        && !parentOrgModelList.contains(parent)
                        && !orgModelList.contains(parent)
                        && orgModel.getLongNumber().contains(parent.getLongNumber())
                        ) {
                    parentOrgModelList.add(parent);
                }
            }
        }
        orgModelList.addAll(parentOrgModelList);
    }


}
