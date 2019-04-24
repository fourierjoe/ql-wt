package yhao.micro.service.surety.erp.auth.api.restful;

import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthTypeModel;
import yhao.micro.service.surety.erp.auth.service.AuthConfigService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/auth/auth")
public class AuthConfigApi extends RestfulBaseController {
    @Resource
    private AuthConfigService authConfigService;

    @PostMapping("/queryAuthType")
    public RequestResult<List<AuthTypeModel>> queryAuthType(@RequestBody AuthTypeQueryForm form){
        return new RequestResult<>(authConfigService.queryAuthType(form));
    }

    @PostMapping("/pickAuthType")
    public RequestResult<AuthTypeModel> pickAuthType(@RequestBody IdForm form){
        return new RequestResult<>(authConfigService.pickAuthTypeById(form.getId()));
    }

    @PostMapping("/deleteAuthType")
    public RequestResult deleteAuthType(@RequestBody IdForm form){
        return new RequestResult<>(authConfigService.deleteAuthType(form.getId()));
    }

    @PostMapping("/saveAuthType")
    public RequestResult saveAuthType(@RequestBody AuthTypeSaveForm form){
        return new RequestResult<>(authConfigService.saveAuthType(form));
    }

    @PostMapping("/batchSaveAuthType")
    public RequestResult batchSaveAuthType(@RequestBody AuthTypeBatchSaveForm form){
        return new RequestResult<>(authConfigService.batchSaveAuthType(form));
    }

    @PostMapping("/pageQueryAuthLeaf")
    public RequestResult<Pagination<AuthLeafModel>> pageQueryAuthLeaf(@RequestBody AuthLeafQueryForm form){
        return new RequestResult<>(authConfigService.pageQueryAuthLeaf(form));
    }

    @PostMapping("/pickAuthLeaf")
    public RequestResult<AuthLeafModel> pickAuthLeaf(@RequestBody IdForm form){
        return new RequestResult<>(authConfigService.pickAuthLeafById(form.getId()));
    }

    @PostMapping("/saveAuthLeaf")
    public RequestResult saveAuthLeaf(@RequestBody AuthLeafSaveForm form){
        return new RequestResult<>(authConfigService.saveAuthLeaf(form));
    }

    @PostMapping("/deleteAuthLeaf")
    public RequestResult deleteAuthLeaf(@RequestBody IdForm form){
        return new RequestResult<>(authConfigService.deleteAuthLeaf(form.getId()));
    }

    @PostMapping("/queryAuthLeafListBySystemKey")
    public RequestResult<List<AuthLeafModel>> queryAuthLeafListBySystemKey(@RequestBody AuthTreeQueryForm form){
        return new RequestResult<>(authConfigService.queryAuthLeafListBySystemKey(form));
    }
}
