package yhao.micro.service.surety.baseconfig.api.restful;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.IntentionConfigModel;
import yhao.micro.service.surety.baseconfig.service.IntentionConfigService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-11
 * Time: 15:05
 */
@RestController
@RequestMapping(value = "/baseconfig/intentionConfig")
public class IntentionConfigApi extends RestfulBaseController {
    @Resource
    private IntentionConfigService intentionConfigService;

    @RequestMapping(value = "/pageQuery", method = RequestMethod.POST)
    public RequestResult<Pagination<IntentionConfigModel>> pageQuery(@RequestBody IntentionConfigQueryForm form) {
        return new RequestResult<>(intentionConfigService.pageQuery(form));
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public RequestResult<List<IntentionConfigModel>> query(@RequestBody IntentionConfigQueryForm form) {
        return new RequestResult<>(intentionConfigService.query(form));
    }

    @RequestMapping(value = "/pickFollowerByResponsibleOrgId", method = RequestMethod.POST)
    public RequestResult<IntentionConfigModel> pickFollowerByResponsibleOrgId(@RequestBody IdForm idForm) {
        return new RequestResult<>(intentionConfigService.pickFollowerByResponsibleOrgId(idForm));
    }

    @RequestMapping(value = "/pickDeclarerByResponsibleOrgId", method = RequestMethod.POST)
    public RequestResult<IntentionConfigModel> pickDeclarerByResponsibleOrgId(@RequestBody IdForm idForm) {
        return new RequestResult<>(intentionConfigService.pickDeclarerByResponsibleOrgId(idForm));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RequestResult save(@RequestBody IntentionConfigSaveForm form) {
        return new RequestResult<>(intentionConfigService.save(form));
    }

    @RequestMapping(value = "/statusChange", method = RequestMethod.POST)
    public RequestResult statusChange(@RequestBody StatusChangeForm form) {
        return new RequestResult<>(intentionConfigService.statusChange(form));
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public RequestResult deleteById(@RequestBody IdForm form) {
        return new RequestResult<>(intentionConfigService.deleteById(form));
    }
}
