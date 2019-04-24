package yhao.micro.service.surety.erp.auth.apilist.restful;

import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthTypeModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;

import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface AuthConfigFeign {
    @RequestMapping(value = "/auth/auth/queryAuthType",method = RequestMethod.POST)
    RequestResult<List<AuthTypeModel>> queryAuthType(AuthTypeQueryForm form);

    @RequestMapping(value = "/auth/auth/pickAuthType",method = RequestMethod.POST)
    RequestResult<AuthTypeModel> pickAuthType(IdForm form);

    @RequestMapping(value = "/auth/auth/deleteAuthType",method = RequestMethod.POST)
    RequestResult deleteAuthType(IdForm form);

    @RequestMapping(value = "/auth/auth/saveAuthType",method = RequestMethod.POST)
    RequestResult saveAuthType(AuthTypeSaveForm form);

    @RequestMapping(value = "/auth/auth/batchSaveAuthType",method = RequestMethod.POST)
    RequestResult batchSaveAuthType(AuthTypeBatchSaveForm form);

    @RequestMapping(value = "/auth/auth/pageQueryAuthLeaf",method = RequestMethod.POST)
    RequestResult<Pagination<AuthLeafModel>> pageQueryAuthLeaf(AuthLeafQueryForm form);

    @RequestMapping(value = "/auth/auth/pickAuthLeaf",method = RequestMethod.POST)
    RequestResult<AuthLeafModel> pickAuthLeaf(IdForm form);

    @RequestMapping(value = "/auth/auth/saveAuthLeaf",method = RequestMethod.POST)
    RequestResult saveAuthLeaf(AuthLeafSaveForm form);

    @RequestMapping(value = "/auth/auth/deleteAuthLeaf",method = RequestMethod.POST)
    RequestResult deleteAuthLeaf(IdForm form);

    @RequestMapping(value = "/auth/auth/queryAuthLeafListBySystemKey",method = RequestMethod.POST)
    RequestResult<List<AuthLeafModel>> queryAuthLeafListBySystemKey(AuthTreeQueryForm form);
}
