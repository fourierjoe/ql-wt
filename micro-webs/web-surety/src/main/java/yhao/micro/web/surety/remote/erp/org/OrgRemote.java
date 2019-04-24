package yhao.micro.web.surety.remote.erp.org;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.PositionOrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;
import yhao.micro.service.surety.erp.org.apilist.restful.OrgFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoara on 2017/11/16.
 */
@Service
public class OrgRemote {
    private Logger logger = LoggerFactory.getLogger(OrgRemote.class);
    @Resource
    private OrgFeign orgFeign;


    @HystrixCommand(fallbackMethod = "queryOrgListDown")
    public List<OrgModel> queryOrgList(OrgQueryForm form) {
        return orgFeign.queryOrgList(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryOrgListByPositionDown")
    public List<OrgModel> queryOrgListByPosition(PositionOrgQueryForm form) {
        return orgFeign.queryOrgListByPosition(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryCityOrgByChildOrgIdDown")
    public OrgModel queryCityOrgByChildOrgId(IdForm form) {
        return orgFeign.queryCityOrgByChildOrgId(form).pickBody();
    }

    public List<OrgModel> queryOrgListDown(OrgQueryForm form, Throwable e) {
        logger.error("Service Down:[OrgService.queryOrgListDown]");
        logger.error(e.getMessage(), e.getCause());
        return new ArrayList<>();
    }

    public List<OrgModel> queryOrgListByPositionDown(PositionOrgQueryForm form, Throwable e) {
        logger.error("Service Down:[OrgService.queryOrgListByPositionDown]");
        logger.error(e.getMessage(), e.getCause());
        return null;
    }

    public OrgModel queryCityOrgByChildOrgIdDown(IdForm form, Throwable e) {
        logger.error("Service Down:[OrgService.queryCityOrgByChildOrgIdDown]");
        logger.error(e.getMessage(), e.getCause());
        return null;
    }


}
