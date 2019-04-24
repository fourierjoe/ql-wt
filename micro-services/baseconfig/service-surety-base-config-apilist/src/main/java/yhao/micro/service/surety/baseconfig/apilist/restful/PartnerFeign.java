package yhao.micro.service.surety.baseconfig.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.PartnerModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:合作方管理 Feign
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:30
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface PartnerFeign {
    @RequestMapping(value = "/baseconfig/partner/pageQuery",method = RequestMethod.POST)
    RequestResult<Pagination<PartnerModel>> pageQuery(PartnerQueryForm form);

    @RequestMapping(value = "/baseconfig/partner/query",method = RequestMethod.POST)
    RequestResult<List<PartnerModel>> query(PartnerQueryForm form);

    @RequestMapping(value = "/baseconfig/partner/save",method = RequestMethod.POST)
    RequestResult save(PartnerSaveForm form);

    @RequestMapping(value = "/baseconfig/partner/statusChange",method = RequestMethod.POST)
    RequestResult statusChange(StatusChangeForm form);

    @RequestMapping(value = "/baseconfig/partner/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
