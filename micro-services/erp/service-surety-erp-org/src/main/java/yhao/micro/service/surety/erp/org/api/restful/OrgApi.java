package yhao.micro.service.surety.erp.org.api.restful;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgPropertyChangeForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.OrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.org.PositionOrgQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.person.ErpPersonResetForm;
import yhao.micro.service.surety.erp.org.apilist.model.OrgModel;
import yhao.micro.service.surety.erp.org.service.ErpDataInputService;
import yhao.micro.service.surety.erp.org.service.OrgService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/org")
public class OrgApi extends RestfulBaseController {
    @Resource
    private OrgService orgService;
    @Resource
    private ErpDataInputService erpDataInputService;

    @PostMapping("/queryOrgList")
    public RequestResult<List<OrgModel>> queryOrgList(@RequestBody OrgQueryForm form){
        return new RequestResult<>(orgService.queryOrgList(form));
    }

    @PostMapping("/queryOrgPage")
    public RequestResult<Pagination<OrgModel>> queryOrgPage(@RequestBody OrgQueryForm form){
        return new RequestResult<>(orgService.queryOrgPage(form));
    }

    @PostMapping("/saveOrg")
    public RequestResult saveOrg(@RequestBody OrgModel org){
        return new RequestResult(orgService.saveOrg(org));
    }

    @PostMapping("/orgStatusChange")
    public RequestResult orgStatusChange(@RequestBody StatusUpdateForm form){
        return new RequestResult<>(orgService.orgStatusChange(form));
    }

    @PostMapping("/cityOrgChange")
    public RequestResult<Boolean> cityOrgChange(@RequestBody OrgPropertyChangeForm form){
        return new RequestResult<>(orgService.cityOrgChange(form));
    }

    @PostMapping("/selectById")
    public RequestResult<OrgModel> selectById(@RequestBody IdForm form){
        return new RequestResult<>(orgService.selectById(form.getId()));
    }

    @PostMapping("/resetErpOrg")
    public RequestResult<Boolean> resetErpOrg(){
        return new RequestResult(erpDataInputService.synchErpOrgInfo());
    }

    @PostMapping("/resetErpPerson")
    public RequestResult<Boolean> resetErpPerson(@RequestBody ErpPersonResetForm form){
        return new RequestResult<>(erpDataInputService.resetErpPerson(form));
    }

    @PostMapping("/deleteOrg")
    public RequestResult deleteOrg(@RequestBody IdForm form) {
        orgService.deleteOrg(form);
        return new RequestResult();
    }

    @PostMapping("/checkHasPerson")
    public RequestResult<Boolean> checkHasPerson(@RequestBody ErpPersonResetForm form){
        return new RequestResult<>(erpDataInputService.checkHasPerson(form));
    }

    @PostMapping("/queryOrgListByPosition")
    public RequestResult<List<OrgModel>> queryOrgListByPosition(@RequestBody PositionOrgQueryForm form){
        return new RequestResult<>(orgService.queryOrgListByPosition(form));
    }

    @PostMapping("/queryCityOrgByChildOrgId")
    public RequestResult<OrgModel> queryCityOrgByChildOrgId(@RequestBody IdForm form){
        return new RequestResult<>(orgService.queryCityOrgByChildOrgId(form));
    }

}
