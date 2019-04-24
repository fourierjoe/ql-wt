package yhao.micro.service.surety.baseconfig.api.restful;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundAccountModel;
import yhao.micro.service.surety.baseconfig.service.FundAccountService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 19:42
 */
@RestController
@RequestMapping(value = "/baseconfig/fundAccount")
public class FundAccountApi extends RestfulBaseController {
    @Resource
    private FundAccountService fundAccountService;

    @RequestMapping(value = "/pageQuery",method = RequestMethod.POST)
    public RequestResult<Pagination<FundAccountModel>> pageQuery(@RequestBody FundAccountQueryForm form){
        return new RequestResult<>(fundAccountService.pageQuery(form));
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public RequestResult<List<FundAccountModel>> query(@RequestBody FundAccountQueryForm form){
        return new RequestResult<>(fundAccountService.query(form));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public RequestResult save(@RequestBody FundAccountSaveForm form){
        return new RequestResult<>(fundAccountService.save(form));
    }

    @RequestMapping(value = "/statusChange",method = RequestMethod.POST)
    public RequestResult statusChange(@RequestBody StatusChangeForm form){
        return new RequestResult<>(fundAccountService.statusChange(form));
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public RequestResult deleteById(@RequestBody IdForm form){
        return new RequestResult<>(fundAccountService.deleteById(form));
    }
}
