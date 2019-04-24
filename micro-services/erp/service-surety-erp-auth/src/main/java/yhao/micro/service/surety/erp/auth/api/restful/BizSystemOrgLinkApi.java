package yhao.micro.service.surety.erp.auth.api.restful;

import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkSaveForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthOrgModel;
import yhao.micro.service.surety.erp.auth.service.BizSystemOrgLinkService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/system/orgLink")
public class BizSystemOrgLinkApi extends RestfulBaseController {
    @Resource
    private BizSystemOrgLinkService bizSystemOrgLinkService;

    @PostMapping("/querySystemOrgLink")
    public RequestResult<List<AuthOrgModel>> querySystemOrgLink(@RequestBody SystemOrgLinkQueryForm form){
        return new RequestResult<>(bizSystemOrgLinkService.querySystemOrgLink(form));
    }

    @PostMapping("/saveOrgLink")
    public RequestResult saveOrgLink(@RequestBody SystemOrgLinkSaveForm form){
        return new RequestResult<>(bizSystemOrgLinkService.saveOrgLink(form));
    }

    @PostMapping("/queryAllOrg")
    public RequestResult<List<AuthOrgModel>> queryAllOrg(){
        return new RequestResult<>(bizSystemOrgLinkService.queryAllOrg());
    }

    @PostMapping("/queryOrgListBySystemKey")
    public RequestResult<List<AuthOrgModel>> queryOrgListBySystemKey(String systemKey){
        return new RequestResult<>(bizSystemOrgLinkService.queryOrgListBySystemKey(systemKey));
    }
}
