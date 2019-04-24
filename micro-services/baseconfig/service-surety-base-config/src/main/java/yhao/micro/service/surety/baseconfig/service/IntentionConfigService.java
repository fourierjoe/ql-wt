package yhao.micro.service.surety.baseconfig.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResultException;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.CommonStatusEnum;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.enums.IntentionPositionTypeEnum;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.IntentionConfigModel;
import yhao.micro.service.surety.baseconfig.dao.automapper.IntentionConfigDao;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-11
 * Time: 15:06
 */
@Service
public class IntentionConfigService {
    @Resource
    private IntentionConfigDao intentionConfigDao;

    public Pagination<IntentionConfigModel> pageQuery(IntentionConfigQueryForm form) {
        Pagination<IntentionConfigModel> page = new Pagination<>(form.getPageSize(), form.getCurrentPage());
        intentionConfigDao.query(page, form);
        return page;
    }

    public List<IntentionConfigModel> query(IntentionConfigQueryForm form) {
        return intentionConfigDao.query(form);
    }

    @Transactional
    public boolean save(IntentionConfigSaveForm form) {
        removeOrgFromOtherConfig(form);//先把这些组织从其他的配置中移除
        if (StringUtils.isNotBlank(form.getId())) {
            return intentionConfigDao.update(form) > 0;
        }
        return intentionConfigDao.insert(form) > 0;
    }

    public boolean deleteById(IdForm form) {
        return intentionConfigDao.deleteById(form) > 0;
    }

    public boolean statusChange(StatusChangeForm form) {
        return intentionConfigDao.statusChange(form) > 0;
    }

    private void removeOrgFromOtherConfig(IntentionConfigSaveForm form) {
        if (StringUtils.isNotBlank(form.getResponsibleOrgIds())) {
            IntentionConfigQueryForm queryForm = new IntentionConfigQueryForm();
            queryForm.setPositionType(form.getPositionType());
            queryForm.setOrResponsibleOrgIdList(Arrays.asList(form.getResponsibleOrgIds().split(",")));
            queryForm.setExcludeId(form.getId());
            List<IntentionConfigModel> duplicateConfigModelList = intentionConfigDao.query(queryForm);
            if (CollectionUtils.isNotEmpty(duplicateConfigModelList)) {
                List<String> orgIdList = queryForm.getOrResponsibleOrgIdList();
                duplicateConfigModelList.forEach(configModel -> orgIdList.forEach(orgId -> configModel.setResponsibleOrgIds(configModel.getResponsibleOrgIds().replaceAll(orgId + ",", "").replaceAll(orgId, ""))));
                duplicateConfigModelList.forEach(configModel -> {
                    if (StringUtils.isBlank(configModel.getResponsibleOrgIds())) {//没有剩余的负责组织的时候，自动禁用该配置
                        configModel.setStatus(CommonStatusEnum.DISABLED);
                    }
                    intentionConfigDao.update(configModel.toSaveForm());
                });
            }
        }
    }

    public IntentionConfigModel pickFollowerByResponsibleOrgId(IdForm idForm) {
        IntentionConfigQueryForm queryForm = new IntentionConfigQueryForm();
        queryForm.setPositionType(IntentionPositionTypeEnum.FOLLOWER);
        queryForm.setStatus(CommonStatusEnum.ENABLED);
        queryForm.setResponsibleOrgId(idForm.getId());
        List<IntentionConfigModel> intentionConfigModelList = query(queryForm);
        return CollectionUtils.isNotEmpty(intentionConfigModelList) ? intentionConfigModelList.get(0) : null;
    }


    public IntentionConfigModel pickDeclarerByResponsibleOrgId(IdForm idForm) {
        IntentionConfigQueryForm queryForm = new IntentionConfigQueryForm();
        queryForm.setPositionType(IntentionPositionTypeEnum.DECLARER);
        queryForm.setStatus(CommonStatusEnum.ENABLED);
        queryForm.setResponsibleOrgId(idForm.getId());
        List<IntentionConfigModel> intentionConfigModelList = query(queryForm);
        return CollectionUtils.isNotEmpty(intentionConfigModelList) ? intentionConfigModelList.get(0) : null;
    }
}
