package yhao.micro.service.surety.erp.auth.api.restful;

import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPersonModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import yhao.micro.service.surety.erp.auth.service.PersonAuthConfigService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/auth/personAuth")
public class AuthPersonApi extends RestfulBaseController {
    @Resource
    private PersonAuthConfigService personAuthConfigService;

    @PostMapping("/queryAllPersonAuthorityId")
    public RequestResult<List<AuthLeafModel>> queryAllPersonAuthorityId(@RequestBody AuthTreeQueryForm form){
        return new RequestResult<>(personAuthConfigService.queryAllPersonAuthorityId(form));
    }

    @PostMapping("/queryPerson")
    public RequestResult<Pagination<AuthPersonModel>> queryPerson(@RequestBody PersonAuthQueryForm form){
        return new RequestResult<>(personAuthConfigService.queryPerson(form));
    }

    @PostMapping("/savePersonAuth")
    public RequestResult savePersonAuth(@RequestBody PersonAuthSaveForm form){
        AuthTreeQueryForm param = makeParam(form);
        return new RequestResult<>(personAuthConfigService.savePersonAuth(param));
    }

    @PostMapping("/resetPersonAuth")
    public RequestResult resetPersonAuth(@RequestBody PersonAuthSaveForm form){
        AuthTreeQueryForm param = makeParam(form);
        return new RequestResult<>(personAuthConfigService.resetPersonAuth(param));
    }

    private AuthTreeQueryForm makeParam(PersonAuthSaveForm form) {
        AuthTreeQueryForm param = new AuthTreeQueryForm();
        param.setSystemKey(form.getSystemKey());
        param.setPersonId(form.getPersonId());
        param.setPositionLinkId(form.getPositionLinkId());
        param.setAuthIds(form.getAuthIds());
        return param;
    }

    @PostMapping("/queryAllPersonDataAuthority")
    public RequestResult<List<DataAuthModel>> queryAllPersonDataAuthority(@RequestBody DataAuthTreeQueryForm form){
        return new RequestResult<>(personAuthConfigService.queryAllPersonDataAuthority(form));
    }

    @PostMapping("/savePersonDataAuth")
    public RequestResult savePersonDataAuth(@RequestBody PersonDataAuthSaveForm form){
        return new RequestResult<>(personAuthConfigService.savePersonDataAuth(form));
    }

    @PostMapping("/resetPersonDataAuth")
    public RequestResult resetPersonDataAuth(@RequestBody PersonDataAuthSaveForm form){
        return new RequestResult<>(personAuthConfigService.resetPersonDataAuth(form));
    }

    @PostMapping("/checkPersonAuth")
    public RequestResult<List<String>> checkPersonAuth(@RequestBody PersonAuthCheckForm form){
        return new RequestResult<>(personAuthConfigService.checkPersonAuth(form));
    }

}
