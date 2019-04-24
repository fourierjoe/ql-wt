package yhao.micro.service.surety.baseconfig.api.restful;

import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositoryQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositorySaveForm;
import yhao.micro.service.surety.baseconfig.apilist.model.RepositoryModel;
import yhao.micro.service.surety.baseconfig.service.RepositoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 9:52
 */
@RestController
@RequestMapping(value = "/baseconfig/repository")
public class RepositoryApi extends RestfulBaseController {
    @Resource
    private RepositoryService repositoryService;

    @PostMapping("/pageQuery")
    public RequestResult<Pagination<RepositoryModel>> pageQuery(@RequestBody RepositoryQueryForm form) {
        return new RequestResult<>(repositoryService.pageQuery(form));
    }

    @PostMapping("/query")
    public RequestResult<List<RepositoryModel>> query(@RequestBody RepositoryQueryForm form) {
        return new RequestResult<>(repositoryService.query(form));
    }

    @PostMapping("/save")
    public RequestResult savePartner(@RequestBody RepositorySaveForm form) {
        return new RequestResult<>(repositoryService.save(form));
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public RequestResult deleteById(@RequestBody IdForm form) {
        return new RequestResult<>(repositoryService.deleteById(form));
    }
}
