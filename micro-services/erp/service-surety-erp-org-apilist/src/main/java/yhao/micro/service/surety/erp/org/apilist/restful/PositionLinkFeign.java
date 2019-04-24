package yhao.micro.service.surety.erp.org.apilist.restful;

import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;

import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface PositionLinkFeign {
    @RequestMapping(value = "/position/queryPositionLink",method = RequestMethod.POST)
    RequestResult<List<PositionLinkModel>> queryPositionLinkList(PositionLinkQueryForm form);

    @RequestMapping(value = "/position/savePositionLink",method = RequestMethod.POST)
    RequestResult savePositionLink(PositionLinkSaveForm form);

    @RequestMapping(value = "/position/deletePositionLink",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);
}
