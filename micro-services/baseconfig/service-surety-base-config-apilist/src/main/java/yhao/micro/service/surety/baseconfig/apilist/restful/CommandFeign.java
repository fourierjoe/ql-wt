package yhao.micro.service.surety.baseconfig.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.CommandModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 11:19
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface CommandFeign {
    @RequestMapping(value = "/baseconfig/command/pageQuery",method = RequestMethod.POST)
    RequestResult<Pagination<CommandModel>> pageQuery(CommandQueryForm form);

    @RequestMapping(value = "/baseconfig/command/query",method = RequestMethod.POST)
    RequestResult<List<CommandModel>> query(CommandQueryForm form);

    @RequestMapping(value = "/baseconfig/command/save",method = RequestMethod.POST)
    RequestResult save(CommandSaveForm form);

    @RequestMapping(value = "/baseconfig/command/statusChange",method = RequestMethod.POST)
    RequestResult statusChange(StatusChangeForm form);

    @RequestMapping(value = "/baseconfig/command/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
