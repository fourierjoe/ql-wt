package yhao.micro.service.surety.baseconfig.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositoryQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositorySaveForm;
import yhao.micro.service.surety.baseconfig.apilist.model.RepositoryModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 9:48
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface RepositoryFeign {
    @RequestMapping(value = "/baseconfig/repository/pageQuery",method = RequestMethod.POST)
    RequestResult<Pagination<RepositoryModel>> pageQuery(RepositoryQueryForm form);

    @RequestMapping(value = "/baseconfig/repository/query",method = RequestMethod.POST)
    RequestResult<List<RepositoryModel>> query(RepositoryQueryForm form);

    @RequestMapping(value = "/baseconfig/repository/save",method = RequestMethod.POST)
    RequestResult save(RepositorySaveForm form);

    @RequestMapping(value = "/baseconfig/repository/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
