package yhao.micro.service.surety.erp.auth.apilist.restful;

import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthOrgModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPersonModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;

import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface PersonAuthConfigFeign {
    @RequestMapping(value = "/auth/personAuth/queryAllPersonAuthorityId",method = RequestMethod.POST)
    RequestResult<List<AuthLeafModel>> queryAllPersonAuthorityId(AuthTreeQueryForm form);

    @RequestMapping(value = "/auth/personAuth/queryPerson",method = RequestMethod.POST)
    RequestResult<Pagination<AuthPersonModel>> queryPerson(PersonAuthQueryForm form);

    @RequestMapping(value = "/auth/personAuth/savePersonAuth",method = RequestMethod.POST)
    RequestResult savePersonAuth(PersonAuthSaveForm form);

    @RequestMapping(value = "/auth/personAuth/resetPersonAuth",method = RequestMethod.POST)
    RequestResult resetPersonAuth(PersonAuthSaveForm form);

    @RequestMapping(value = "/auth/personAuth/queryAllPersonDataAuthority",method = RequestMethod.POST)
    RequestResult<List<DataAuthModel>> queryAllPersonDataAuthority(DataAuthTreeQueryForm form);

    @RequestMapping(value = "/auth/personAuth/resetPersonDataAuth",method = RequestMethod.POST)
    RequestResult resetPersonDataAuth(PersonDataAuthSaveForm form);

    @RequestMapping(value = "/auth/personAuth/savePersonDataAuth",method = RequestMethod.POST)
    RequestResult savePersonDataAuth(PersonDataAuthSaveForm form);

    @RequestMapping(value = "/auth/personAuth/checkPersonAuth",method = RequestMethod.POST)
    RequestResult<List<String>> checkPersonAuth(PersonAuthCheckForm form);
}
