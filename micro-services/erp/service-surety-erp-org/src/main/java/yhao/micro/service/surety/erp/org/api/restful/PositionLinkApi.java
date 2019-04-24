package yhao.micro.service.surety.erp.org.api.restful;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
import yhao.micro.service.surety.erp.org.service.PositionLinkService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/position")
public class PositionLinkApi extends RestfulBaseController {
    @Resource
    private PositionLinkService positionLinkService;

    @PostMapping("/queryPositionLink")
    public RequestResult<List<PositionLinkModel>> queryPositionLinkList(@RequestBody PositionLinkQueryForm form){
        return new RequestResult<>(positionLinkService.queryPositionLinkList(form));
    }

    @PostMapping("/savePositionLink")
    public RequestResult savePositionLink(@RequestBody PositionLinkSaveForm form){
        return new RequestResult<>(positionLinkService.savePositionLink(form));
    }

    @PostMapping("/deletePositionLink")
    public RequestResult deletePositionLink(@RequestBody IdForm form){
        return new RequestResult<>(positionLinkService.deleteById(form.getId()));
    }
}
