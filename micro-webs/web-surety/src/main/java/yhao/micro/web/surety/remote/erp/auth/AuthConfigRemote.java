package yhao.micro.web.surety.remote.erp.auth;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthTypeModel;
import yhao.micro.service.surety.erp.auth.apilist.restful.AuthConfigFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoara on 2017/11/16.
 */
@Service
public class AuthConfigRemote {
    private Logger logger = LoggerFactory.getLogger(AuthConfigRemote.class);
    @Resource
    private AuthConfigFeign authConfigFeign;

    @HystrixCommand(fallbackMethod = "queryAuthTypeDown")
    public List<AuthTypeModel> queryAuthType(AuthTypeQueryForm form) {
        return authConfigFeign.queryAuthType(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryAuthLeafListBySystemKeyDown")
    public List<AuthLeafModel> queryAuthLeafListBySystemKey(AuthTreeQueryForm form) {
        return authConfigFeign.queryAuthLeafListBySystemKey(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "pageQueryAuthLeafDown")
    public Pagination<AuthLeafModel> pageQueryAuthLeaf(AuthLeafQueryForm form) {
        return authConfigFeign.pageQueryAuthLeaf(form).pickBody();
    }

    public void deleteAuthType(IdForm form) {
        authConfigFeign.deleteAuthType(form).pickBody();
    }

    public void saveAuthType(AuthTypeSaveForm form) {
        authConfigFeign.saveAuthType(form).pickBody();
    }

    public void batchSaveAuthType(AuthTypeBatchSaveForm form) {
        authConfigFeign.batchSaveAuthType(form).pickBody();
    }

    public void saveAuthLeaf(AuthLeafSaveForm form) {
        authConfigFeign.saveAuthLeaf(form).pickBody();
    }

    public void deleteAuthLeaf(IdForm form) {
        authConfigFeign.deleteAuthLeaf(form).pickBody();
    }

    
    public List<AuthLeafModel> queryAuthLeafListBySystemKeyDown(AuthTreeQueryForm form,Throwable e) {
        logger.error("Service Down:[AuthConfigService.queryAuthLeafListBySystemKey]");
        logger.error(e.getMessage(),e.getCause());
        return new ArrayList<>();
    }
    
    public List<AuthTypeModel> queryAuthTypeDown(AuthTypeQueryForm form,Throwable e) {
        logger.error("Service Down:[AuthConfigService.queryAuthTypeDown]");
        logger.error(e.getMessage(),e.getCause());
        return new ArrayList<>();
    }
    public Pagination<AuthLeafModel> pageQueryAuthLeafDown(AuthLeafQueryForm form,Throwable e) {
        logger.error("Service Down:[AuthConfigService.pageQueryAuthLeafDown]");
        logger.error(e.getMessage(),e.getCause());
        return new Pagination<>();
    }
}
