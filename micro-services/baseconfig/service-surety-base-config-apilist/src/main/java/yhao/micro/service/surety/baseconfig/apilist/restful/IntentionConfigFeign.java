package yhao.micro.service.surety.baseconfig.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.IntentionConfigModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:单据分配 Fegin
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 14:40
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface IntentionConfigFeign {
    @RequestMapping(value = "/baseconfig/intentionConfig/pageQuery", method = RequestMethod.POST)
    RequestResult<Pagination<IntentionConfigModel>> pageQuery(IntentionConfigQueryForm form);

    @RequestMapping(value = "/baseconfig/intentionConfig/query", method = RequestMethod.POST)
    RequestResult<List<IntentionConfigModel>> query(IntentionConfigQueryForm form);

    @RequestMapping(value = "/baseconfig/intentionConfig/pickFollowerByResponsibleOrgId", method = RequestMethod.POST)
    RequestResult<IntentionConfigModel> pickFollowerByResponsibleOrgId(IdForm idForm);

    @RequestMapping(value = "/baseconfig/intentionConfig/pickDeclarerByResponsibleOrgId", method = RequestMethod.POST)
    RequestResult<IntentionConfigModel> pickDeclarerByResponsibleOrgId(IdForm idForm);

    @RequestMapping(value = "/baseconfig/intentionConfig/save", method = RequestMethod.POST)
    RequestResult save(IntentionConfigSaveForm form);

    @RequestMapping(value = "/baseconfig/intentionConfig/statusChange", method = RequestMethod.POST)
    RequestResult statusChange(StatusChangeForm form);

    @RequestMapping(value = "/baseconfig/intentionConfig/deleteById", method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
