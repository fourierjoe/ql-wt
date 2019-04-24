package yhao.micro.service.surety.baseconfig.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.MaterialModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资料设置 Feign
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:36
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface MaterialFeign {
    @RequestMapping(value = "/baseconfig/material/pageQuery",method = RequestMethod.POST)
    RequestResult<Pagination<MaterialModel>> pageQuery(MaterialQueryForm form);

    @RequestMapping(value = "/baseconfig/material/query",method = RequestMethod.POST)
    RequestResult<List<MaterialModel>> query(MaterialQueryForm form);

    @RequestMapping(value = "/baseconfig/material/save",method = RequestMethod.POST)
    RequestResult save(MaterialSaveForm saveForm);

    @RequestMapping(value = "/baseconfig/material/statusChange",method = RequestMethod.POST)
    RequestResult statusChange(StatusChangeForm form);

    @RequestMapping(value = "/baseconfig/material/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
