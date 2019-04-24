package yhao.micro.service.surety.baseconfig.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundProviderModel;

import java.net.CacheRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资方管理 Feign
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:55
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface FundProviderFeign {
    @RequestMapping(value = "/baseconfig/fundProvider/pageQuery",method = RequestMethod.POST)
    RequestResult<Pagination<FundProviderModel>> pageQuery(FundProviderQueryForm form);

    @RequestMapping(value = "/baseconfig/fundProvider/query",method = RequestMethod.POST)
    RequestResult<List<FundProviderModel>> query(FundProviderQueryForm form);

    @RequestMapping(value = "/baseconfig/fundProvider/queryAllChildByParent",method = RequestMethod.POST)
    RequestResult<List<FundProviderModel>> queryAllChildByParent(FundProviderQueryForm form);

    @RequestMapping(value = "/baseconfig/fundProvider/save",method = RequestMethod.POST)
    RequestResult save(FundProviderSaveForm form);

    @RequestMapping(value = "/baseconfig/fundProvider/statusChange",method = RequestMethod.POST)
    RequestResult statusChange(StatusChangeForm form);

    @RequestMapping(value = "/baseconfig/fundProvider/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
