package yhao.micro.service.surety.baseconfig.api.restful;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.CommandModel;
import yhao.micro.service.surety.baseconfig.service.CommandService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 11:20
 */
@RestController
@RequestMapping(value = "/baseconfig/command")
public class CommandApi extends RestfulBaseController {
    @Resource
    private CommandService commandService;

    @RequestMapping(value = "/pageQuery",method = RequestMethod.POST)
    RequestResult<Pagination<CommandModel>> pageQuery(@RequestBody CommandQueryForm form){
        return new RequestResult<>(commandService.pageQuery(form));
    }

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    RequestResult<List<CommandModel>> query(@RequestBody CommandQueryForm form){
        return new RequestResult<>(commandService.query(form));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    RequestResult save(@RequestBody CommandSaveForm form){
        return new RequestResult<>(commandService.save(form));
    }

    @RequestMapping(value = "/statusChange",method = RequestMethod.POST)
    RequestResult statusChange(@RequestBody StatusChangeForm form){
        return new RequestResult<>(commandService.statusChange(form));
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(@RequestBody IdForm form){
        return new RequestResult<>(commandService.deleteById(form));
    }
}
