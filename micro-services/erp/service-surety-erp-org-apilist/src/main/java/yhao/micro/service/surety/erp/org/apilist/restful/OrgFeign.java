package yhao.micro.service.surety.erp.org.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgPropertyChangeForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.PositionOrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.ErpPersonResetForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;

import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface OrgFeign {
    @RequestMapping(value = "/org/queryOrgList",method = RequestMethod.POST)
    RequestResult<List<OrgModel>> queryOrgList(OrgQueryForm formQuery);

    @RequestMapping(value = "/org/queryOrgPage",method = RequestMethod.POST)
    RequestResult<Pagination<OrgModel>> queryOrgPage(OrgQueryForm form);

    @RequestMapping(value = "/org/saveOrg",method = RequestMethod.POST)
    RequestResult saveOrg(OrgModel org);

    @RequestMapping(value = "/org/orgStatusChange",method = RequestMethod.POST)
    RequestResult orgStatusChange(StatusUpdateForm form);

    @RequestMapping(value = "/org/selectById",method = RequestMethod.POST)
    RequestResult<OrgModel> selectById(IdForm form);

    @RequestMapping(value = "/org/resetErpOrg",method = RequestMethod.POST)
    RequestResult<Boolean> resetErpOrg();

    @RequestMapping(value = "/org/resetErpPerson",method = RequestMethod.POST)
    RequestResult<Boolean> resetErpPerson(ErpPersonResetForm form);

    @RequestMapping(value = "/org/deleteOrg",method = RequestMethod.POST)
    RequestResult<Boolean> deleteOrg(IdForm form);

    @RequestMapping(value = "/org/checkHasPerson",method = RequestMethod.POST)
    RequestResult<Boolean> checkHasPerson(ErpPersonResetForm form);

    @RequestMapping(value = "/org/cityOrgChange",method = RequestMethod.POST)
    RequestResult<Boolean> cityOrgChange(OrgPropertyChangeForm form);

    @RequestMapping(value = "/org/queryOrgListByPosition",method = RequestMethod.POST)
    RequestResult<List<OrgModel>> queryOrgListByPosition(PositionOrgQueryForm form);

    @RequestMapping(value = "/org/queryCityOrgByChildOrgId",method = RequestMethod.POST)
    RequestResult<OrgModel> queryCityOrgByChildOrgId(IdForm form);
}
