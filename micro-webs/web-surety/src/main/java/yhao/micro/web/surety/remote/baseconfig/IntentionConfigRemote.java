package yhao.micro.web.surety.remote.baseconfig;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.IntentionConfigModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.IntentionConfigFeign;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;
import yhao.micro.service.surety.erp.org.apilist.restful.OrgFeign;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:单据分配设置 Remote
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 14:45
 */
@Service
public class IntentionConfigRemote {
    private Logger logger = LoggerFactory.getLogger(IntentionConfigRemote.class);
    @Resource
    private IntentionConfigFeign intentionConfigFeign;
    @Resource
    private OrgFeign orgFeign;

    @HystrixCommand(fallbackMethod = "pageQueryDown")
    public Pagination<IntentionConfigModel> pageQuery(IntentionConfigQueryForm form) {
        Pagination<IntentionConfigModel> page = intentionConfigFeign.pageQuery(form).pickBody();
        if (page != null && CollectionUtils.isNotEmpty(page.getItems())) {
            for (IntentionConfigModel configModel : page.getItems()) {
                configModel.setResponsibleOrgNames(getResponsibleOrgNames(configModel));
            }
        }
        return page;
    }

    public void save(IntentionConfigSaveForm form) {
        intentionConfigFeign.save(form).pickBody();
    }

    public void statusChange(StatusChangeForm form) {
        intentionConfigFeign.statusChange(form).pickBody();
    }

    public void deleteById(IdForm form) {
        intentionConfigFeign.deleteById(form).pickBody();
    }

    public Pagination<IntentionConfigModel> pageQueryDown(IntentionConfigQueryForm form, Throwable e) {
        logger.error("Service Down:[IntentionConfigService.pageQueryFundProviderDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    private String getResponsibleOrgNames(IntentionConfigModel configModel) {
        if (StringUtils.isBlank(configModel.getResponsibleOrgIds())) {
            return null;
        }
        List<String> orgIdList = Arrays.asList(configModel.getResponsibleOrgIds().split(","));
        OrgQueryForm queryForm = new OrgQueryForm();
        queryForm.setIdList(orgIdList);
        List<OrgModel> orgModelList = orgFeign.queryOrgList(queryForm).pickBody();
        if (CollectionUtils.isNotEmpty(orgModelList)) {
            StringBuilder responsibleOrgNames = new StringBuilder();
            for (int i = 0; i < orgModelList.size(); i++) {
                OrgModel orgModel = orgModelList.get(i);
                if (i == 0) {
                    responsibleOrgNames.append(orgModel.getName());
                }else {
                    responsibleOrgNames.append(",").append(orgModel.getName());
                }
            }
            return responsibleOrgNames.toString();
        }
        return null;
    }
}
