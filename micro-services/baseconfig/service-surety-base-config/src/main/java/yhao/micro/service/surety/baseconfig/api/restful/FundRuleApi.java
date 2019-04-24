package yhao.micro.service.surety.baseconfig.api.restful;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundRuleModel;
import yhao.micro.service.surety.baseconfig.service.FundRuleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-11
 * Time: 10:12
 */
@RestController
@RequestMapping(value = "/baseconfig/fundRule")
public class FundRuleApi extends RestfulBaseController {
    @Resource
    private FundRuleService fundRuleService;

    @RequestMapping(value = "/pageQuery", method = RequestMethod.POST)
    public RequestResult<Pagination<FundRuleModel>> pageQuery(@RequestBody FundRuleQueryForm form) {
        return new RequestResult<>(fundRuleService.pageQuery(form));
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public RequestResult<List<FundRuleModel>> query(@RequestBody FundRuleQueryForm form) {
        return new RequestResult<>(fundRuleService.query(form));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RequestResult save(@RequestBody FundRuleSaveForm form) {
        return new RequestResult<>(fundRuleService.save(form));
    }

    @RequestMapping(value = "/statusChange", method = RequestMethod.POST)
    public RequestResult statusChange(@RequestBody StatusChangeForm form) {
        return new RequestResult<>(fundRuleService.statusChange(form));
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public RequestResult deleteById(@RequestBody IdForm form){
        return new RequestResult<>(fundRuleService.deleteById(form));
    }
}
