package yhao.micro.service.surety.baseconfig.api.restful;

import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.PartnerModel;
import yhao.micro.service.surety.baseconfig.service.PartnerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-10
 * Time: 16:44
 */
@RestController
@RequestMapping(value = "/baseconfig/partner")
public class PartnerApi extends RestfulBaseController {
    @Resource
    private PartnerService partnerService;

    @PostMapping("/pageQuery")
    public RequestResult<Pagination<PartnerModel>> pageQuery(@RequestBody PartnerQueryForm form){
        return new RequestResult<>(partnerService.pageQuery(form));
    }

    @PostMapping("/query")
    public RequestResult<List<PartnerModel>> query(@RequestBody PartnerQueryForm form){
        return new RequestResult<>(partnerService.query(form));
    }

    @PostMapping("/save")
    public RequestResult savePartner(@RequestBody PartnerSaveForm form){
        return new RequestResult<>(partnerService.save(form));
    }

    @PostMapping("/statusChange")
    public RequestResult statusChange(@RequestBody StatusChangeForm form){
        return new RequestResult<>(partnerService.statusChange(form));
    }

    @RequestMapping(value = "/deleteById",method = RequestMethod.POST)
    public RequestResult deleteById(@RequestBody IdForm form){
        return new RequestResult<>(partnerService.deleteById(form));
    }
}
