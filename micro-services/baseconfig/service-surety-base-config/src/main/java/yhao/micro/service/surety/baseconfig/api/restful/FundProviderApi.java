package yhao.micro.service.surety.baseconfig.api.restful;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundProviderModel;
import yhao.micro.service.surety.baseconfig.service.FundProviderService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-11
 * Time: 14:00
 */
@RestController
@RequestMapping(value = "/baseconfig/fundProvider")
public class FundProviderApi extends RestfulBaseController {
    @Resource
    private FundProviderService fundProviderService;

    @RequestMapping(value = "/pageQuery", method = RequestMethod.POST)
    RequestResult<Pagination<FundProviderModel>> pageQuery(@RequestBody FundProviderQueryForm form) {
        return new RequestResult<>(fundProviderService.pageQuery(form));
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    RequestResult<List<FundProviderModel>> query(@RequestBody FundProviderQueryForm form) {
        return new RequestResult<>(fundProviderService.query(form));
    }

    @RequestMapping(value = "/queryAllChildByParent", method = RequestMethod.POST)
    RequestResult<List<FundProviderModel>> queryAllChildByParent(@RequestBody FundProviderQueryForm form) {
        return new RequestResult<>(fundProviderService.queryAllChildByParent(form));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    RequestResult save(@RequestBody FundProviderSaveForm form) {
        return new RequestResult<>(fundProviderService.save(form));
    }

    @RequestMapping(value = "/statusChange", method = RequestMethod.POST)
    RequestResult statusChange(@RequestBody StatusChangeForm form) {
        return new RequestResult<>(fundProviderService.statusChange(form));
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public RequestResult deleteById(@RequestBody IdForm form) {
        return new RequestResult<>(fundProviderService.deleteById(form));
    }
}
