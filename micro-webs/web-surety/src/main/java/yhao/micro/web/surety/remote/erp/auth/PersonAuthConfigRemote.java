package yhao.micro.web.surety.remote.erp.auth;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPersonModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import yhao.micro.service.surety.erp.auth.apilist.restful.PersonAuthConfigFeign;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.restful.PersonFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoara on 2017/11/16.
 */
@Service
public class PersonAuthConfigRemote {
    private Logger logger = LoggerFactory.getLogger(PersonAuthConfigRemote.class);
    @Resource
    private PersonAuthConfigFeign personAuthConfigFeign;
    @Resource
    private PersonFeign personFeign;

    @HystrixCommand(fallbackMethod = "queryAllPersonAuthorityIdDown")
    public List<AuthLeafModel> queryAllPersonAuthorityId(AuthTreeQueryForm form) {
        return personAuthConfigFeign.queryAllPersonAuthorityId(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryPersonDown")
    public Pagination<AuthPersonModel> queryPerson(PersonAuthQueryForm form) {
        return personAuthConfigFeign.queryPerson(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryAllPersonDataAuthorityDown")
    public List<DataAuthModel> queryAllPersonDataAuthority(DataAuthTreeQueryForm form) {
        return personAuthConfigFeign.queryAllPersonDataAuthority(form).pickBody();
    }

    public void savePersonAuth(PersonAuthSaveForm form) {
        personAuthConfigFeign.savePersonAuth(form).pickBody();
    }

    public void savePersonDataAuth(PersonDataAuthSaveForm form) {
        personAuthConfigFeign.savePersonDataAuth(form).pickBody();
    }

    public void suretyPersonStatusChange(StatusUpdateForm form) {
        personFeign.suretyPersonStatusChange(form).pickBody();
    }

    public List<AuthLeafModel> queryAllPersonAuthorityIdDown(AuthTreeQueryForm form) {
        logger.error("Service Down:[PersonAuthConfigService.queryAllPersonAuthorityId]");
        return new ArrayList<>();
    }

    public List<DataAuthModel> queryAllPersonDataAuthorityDown(DataAuthTreeQueryForm form) {
        logger.error("Service Down:[PersonAuthConfigService.queryAllPersonDataAuthority]");
        return new ArrayList<>();
    }

    public Pagination<AuthPersonModel> queryPersonDown(PersonAuthQueryForm form) {
        logger.error("Service Down:[PersonAuthConfigService.queryPerson]");
        return new Pagination<>();
    }


}
