package yhao.micro.service.surety.erp.auth.apilist.restful;

import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkSaveForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthOrgModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import yhao.infra.apilist.RequestResult;

import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface BizSystemOrgLinkFeign {
    @RequestMapping(value = "/system/orgLink/querySystemOrgLink",method = RequestMethod.POST)
    RequestResult<List<AuthOrgModel>> querySystemOrgLink(SystemOrgLinkQueryForm form);

    @RequestMapping(value = "/system/orgLink/saveOrgLink",method = RequestMethod.POST)
    RequestResult saveOrgLink(SystemOrgLinkSaveForm form);

    @RequestMapping(value = "/system/orgLink/queryAllOrg",method = RequestMethod.POST)
    RequestResult<List<AuthOrgModel>> queryAllOrg();

    @RequestMapping(value = "/system/orgLink/queryOrgListBySystemKey",method = RequestMethod.POST)
    RequestResult<List<AuthOrgModel>> queryOrgListBySystemKey(@RequestParam("systemKey") String systemKey);
}
