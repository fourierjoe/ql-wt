package yhao.micro.service.surety.baseconfig.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundRuleModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资金方案管理 Feign
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:55
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface FundRuleFeign {
    @RequestMapping(value = "/baseconfig/fundRule/pageQuery",method = RequestMethod.POST)
    RequestResult<Pagination<FundRuleModel>> pageQuery(FundRuleQueryForm form);

    @RequestMapping(value = "/baseconfig/fundRule/query",method = RequestMethod.POST)
    RequestResult<List<FundRuleModel>> query(FundRuleQueryForm form);

    @RequestMapping(value = "/baseconfig/fundRule/save",method = RequestMethod.POST)
    RequestResult save(FundRuleSaveForm form);

    @RequestMapping(value = "/baseconfig/fundRule/statusChange",method = RequestMethod.POST)
    RequestResult statusChange(StatusChangeForm form);

    @RequestMapping(value = "/baseconfig/fundRule/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
