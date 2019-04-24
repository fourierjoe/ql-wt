package yhao.micro.service.surety.baseconfig.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundAccountModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资金账号管理 Feign
 * User: GUO.MAO.LIN
 * Date: 2018-11-30
 * Time: 13:58
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface FundAccountFeign {
    @RequestMapping(value = "/baseconfig/fundAccount/pageQuery",method = RequestMethod.POST)
    RequestResult<Pagination<FundAccountModel>> pageQuery(FundAccountQueryForm form);

    @RequestMapping(value = "/baseconfig/fundAccount/query",method = RequestMethod.POST)
    RequestResult<List<FundAccountModel>> query(FundAccountQueryForm form);

    @RequestMapping(value = "/baseconfig/fundAccount/save",method = RequestMethod.POST)
    RequestResult save(FundAccountSaveForm form);

    @RequestMapping(value = "/baseconfig/fundAccount/statusChange",method = RequestMethod.POST)
    RequestResult statusChange(StatusChangeForm form);

    @RequestMapping(value = "/baseconfig/fundAccount/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
