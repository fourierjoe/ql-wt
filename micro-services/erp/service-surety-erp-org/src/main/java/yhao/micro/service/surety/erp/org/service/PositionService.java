package yhao.micro.service.surety.erp.org.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.PinYinUtil;
import yhao.infra.common.util.RandomUtil;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.surety.erp.org.apilist.form.IdsForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionCodeModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;
import yhao.micro.service.surety.erp.org.constants.ErpOrgConstants;
import yhao.micro.service.surety.erp.org.dao.automapper.OrgAuthConfigDao;
import yhao.micro.service.surety.erp.org.dao.automapper.OrgDao;
import yhao.micro.service.surety.erp.org.dao.automapper.PositionDao;
import yhao.micro.service.surety.erp.org.dao.automapper.PositionLinkDao;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yoara on 2017/2/16.
 */
@Service
public class PositionService{
    @Resource
    private PositionDao positionDao;
    @Resource
    private PositionLinkDao positionLinkDao;
    @Resource
    private OrgAuthConfigDao authConfigDao;
    @Resource
    private OrgDao orgDao;
    @Resource
    private Environment environment;

    public Pagination<PositionModel> queryPositionPage(PositionQueryForm form) {
        Pagination<PositionModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        if(StringUtils.isNotEmpty(form.getChildOrgId())){
            OrgModel org = orgDao.selectTopOrgByChildId(form.getChildOrgId());
            form.setOrgId(org.getId());
        }
        positionDao.queryPosition(page, form);
        return page;
    }

    public boolean savePosition(PositionModel position) {
        if (StringUtils.isEmpty(position.getId())) {
            position.setNumber(PinYinUtil.converterToFirstSpell(position.getName()) + RandomUtil.makeRandomNumberString(3));
        }

        if (StringUtils.isEmpty(position.getId())) {
            position.setId(UUID.randomUUID().toString());
            positionDao.insertPosition(position);
        } else {
            positionDao.updatePosition(position);
        }
        return true;
    }


    public PositionModel selectById(String id) {
        return positionDao.selectById(id);
    }

    @Transactional
    public boolean deleteById(String id) {
        //删除岗位
        positionDao.deleteById(id);
        //获取挂职信息
        PositionLinkQueryForm positionLinkform = new PositionLinkQueryForm();
        positionLinkform.setPositionId(id);
        List<PositionLinkModel> linkModelList = positionLinkDao.queryPositionLink(positionLinkform);
        if(linkModelList!=null&&linkModelList.size()>0){
            //删除挂职
            positionLinkDao.deleteByPositionId(id);

            List<String> ids = new ArrayList<>(linkModelList.size()*2);
            for(PositionLinkModel model:linkModelList){
                ids.add(model.getId());
            }
            IdsForm form = new IdsForm();
            form.setIds(ids);
            //删除人员关联的挂职
            authConfigDao.deleteAllPersonRelationByPositionLinkIds(form);
            //删除岗位关联的挂职
            authConfigDao.deleteAllPositionRelationByPositionLinkIds(form);
        }
        return true;
    }

    public List<PositionCodeModel> queryFollowerAndDeclarerCodeByCityOrg(IdForm idForm) {
        String orgId = idForm.getId();
        List<PositionCodeModel> positionCodeModelList = new ArrayList<>();
        String followerPositionCode = "";
        String declarerPositionCode = "";
        if (orgId.equals(environment.getProperty(ErpOrgConstants.WANTONG_ORG_ID_CONFIG_KEY))) {
            followerPositionCode = environment.getProperty(ErpOrgConstants.WANTONG_FOLLOWER_POSITION_CODE_CONFIG_KEY);
            declarerPositionCode = environment.getProperty(ErpOrgConstants.WANTONG_DECLARER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_ORG_ID_CONFIG_KEY))) {
            followerPositionCode = environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_FOLLOWER_POSITION_CODE_CONFIG_KEY);
            declarerPositionCode = environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_DECLARER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_ORG_ID_CONFIG_KEY))) {
            followerPositionCode = environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_FOLLOWER_POSITION_CODE_CONFIG_KEY);
            declarerPositionCode = environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_DECLARER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_ORG_ID_CONFIG_KEY))) {
            followerPositionCode = environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_FOLLOWER_POSITION_CODE_CONFIG_KEY);
            declarerPositionCode = environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_DECLARER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_ORG_ID_CONFIG_KEY))) {
            followerPositionCode = environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_FOLLOWER_POSITION_CODE_CONFIG_KEY);
            declarerPositionCode = environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_DECLARER_POSITION_CODE_CONFIG_KEY);
        }
        PositionCodeModel follower = new PositionCodeModel();
        PositionCodeModel declarer = new PositionCodeModel();
        follower.setPositionType(CommonConstants.POSITION_TYPE_FOLLOWER);
        follower.setPositionCode(followerPositionCode);
        declarer.setPositionType(CommonConstants.POSITION_TYPE_DECLARER);
        declarer.setPositionCode(declarerPositionCode);
        positionCodeModelList.add(follower);
        positionCodeModelList.add(declarer);
        return positionCodeModelList;
    }

    public List<PositionCodeModel> queryObtainerAndForecloserCodeByCityOrg(IdForm idForm) {
        String orgId = idForm.getId();
        List<PositionCodeModel> positionCodeModelList = new ArrayList<>();
        String obtainerPositionCode = "";
        String forecloserPositionCode = "";
        if (orgId.equals(environment.getProperty(ErpOrgConstants.WANTONG_ORG_ID_CONFIG_KEY))) {
            obtainerPositionCode = environment.getProperty(ErpOrgConstants.WANTONG_OBTAINER_POSITION_CODE_CONFIG_KEY);
            forecloserPositionCode = environment.getProperty(ErpOrgConstants.WANTONG_FORECLOSER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_ORG_ID_CONFIG_KEY))) {
            obtainerPositionCode = environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_OBTAINER_POSITION_CODE_CONFIG_KEY);
            forecloserPositionCode = environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_FORECLOSER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_ORG_ID_CONFIG_KEY))) {
            obtainerPositionCode = environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_OBTAINER_POSITION_CODE_CONFIG_KEY);
            forecloserPositionCode = environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_FORECLOSER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_ORG_ID_CONFIG_KEY))) {
            obtainerPositionCode = environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_OBTAINER_POSITION_CODE_CONFIG_KEY);
            forecloserPositionCode = environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_FORECLOSER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_ORG_ID_CONFIG_KEY))) {
            obtainerPositionCode = environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_OBTAINER_POSITION_CODE_CONFIG_KEY);
            forecloserPositionCode = environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_FORECLOSER_POSITION_CODE_CONFIG_KEY);
        }
        PositionCodeModel obtainer = new PositionCodeModel();
        PositionCodeModel forecloser = new PositionCodeModel();
        obtainer.setPositionType(CommonConstants.POSITION_TYPE_OBTAINER);
        obtainer.setPositionCode(obtainerPositionCode);
        forecloser.setPositionType(CommonConstants.POSITION_TYPE_FORECLOSER);
        forecloser.setPositionCode(forecloserPositionCode);
        positionCodeModelList.add(obtainer);
        positionCodeModelList.add(forecloser);
        return positionCodeModelList;
    }

    public PositionCodeModel queryCreditClerkCodeByCityOrg(IdForm idForm) {
        String orgId = idForm.getId();
        String positionCode;
        if (orgId.equals(environment.getProperty(ErpOrgConstants.WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.WANTONG_CREDIT_CLERK_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_CREDIT_CLERK_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_CREDIT_CLERK_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_CREDIT_CLERK_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_CREDIT_CLERK_POSITION_CODE_CONFIG_KEY);
        }else {
            return null;
        }
        PositionCodeModel positionCodeModel = new PositionCodeModel();
        positionCodeModel.setPositionCode(positionCode);
        positionCodeModel.setPositionType(CommonConstants.POSITION_TYPE_CREDIT_CLERK);
        return positionCodeModel;
    }


    public PositionCodeModel queryManagerCodeByCityOrg(IdForm idForm) {
        String orgId = idForm.getId();
        String positionCode;
        if (orgId.equals(environment.getProperty(ErpOrgConstants.WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.WANTONG_MANAGER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_MANAGER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_MANAGER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_MANAGER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_MANAGER_POSITION_CODE_CONFIG_KEY);
        }else {
            return null;
        }
        PositionCodeModel positionCodeModel = new PositionCodeModel();
        positionCodeModel.setPositionCode(positionCode);
        positionCodeModel.setPositionType(CommonConstants.POSITION_TYPE_MANAGER);
        return positionCodeModel;
    }

    public PositionCodeModel queryResidentCodeByCityOrg(IdForm idForm) {
        String orgId = idForm.getId();
        String positionCode;
        if (orgId.equals(environment.getProperty(ErpOrgConstants.WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.WANTONG_RESIDENT_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_RESIDENT_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_RESIDENT_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_RESIDENT_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_RESIDENT_POSITION_CODE_CONFIG_KEY);
        }else {
            return null;
        }
        PositionCodeModel positionCodeModel = new PositionCodeModel();
        positionCodeModel.setPositionCode(positionCode);
        positionCodeModel.setPositionType(CommonConstants.POSITION_TYPE_RESIDENT);
        return positionCodeModel;
    }

    public PositionCodeModel queryExaminerCodeByCityOrg(IdForm idForm) {
        String orgId = idForm.getId();
        String positionCode;
        if (orgId.equals(environment.getProperty(ErpOrgConstants.WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.WANTONG_EXAMINER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.SHENZHEN_WANTONG_EXAMINER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.ZHUHAI_WANTONG_EXAMINER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.GUANGZHOU_ZHONGAN_EXAMINER_POSITION_CODE_CONFIG_KEY);
        } else if (orgId.equals(environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_ORG_ID_CONFIG_KEY))) {
            positionCode = environment.getProperty(ErpOrgConstants.DONGGUAN_WANTONG_EXAMINER_POSITION_CODE_CONFIG_KEY);
        }else {
            return null;
        }
        PositionCodeModel positionCodeModel = new PositionCodeModel();
        positionCodeModel.setPositionCode(positionCode);
        positionCodeModel.setPositionType(CommonConstants.POSITION_TYPE_EXAMINER);
        return positionCodeModel;
    }


}
