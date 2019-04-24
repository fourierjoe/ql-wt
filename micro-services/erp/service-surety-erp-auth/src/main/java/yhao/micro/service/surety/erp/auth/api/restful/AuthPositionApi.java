package yhao.micro.service.surety.erp.auth.api.restful;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPositionLinkModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import yhao.micro.service.surety.erp.auth.service.PositionAuthConfigService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/auth/positionAuth")
public class AuthPositionApi extends RestfulBaseController {
    @Resource
    private PositionAuthConfigService positionAuthConfigService;

    @PostMapping("/queryAllPositionAuthority")
    public RequestResult<List<AuthLeafModel>> queryAllPositionAuthority(@RequestBody AuthTreeQueryForm form){
        return new RequestResult<>(positionAuthConfigService.queryAllPositionAuthority(form));
    }

    @PostMapping("/queryPosition")
    public RequestResult<Pagination<AuthPositionLinkModel>> queryPosition(@RequestBody PositionAuthQueryForm form){
        return new RequestResult<>(positionAuthConfigService.queryPosition(form));
    }

    @PostMapping("/savePositionAuth")
    public RequestResult savePositionAuth(@RequestBody PositionAuthSaveForm form){
        return new RequestResult<>(positionAuthConfigService.savePositionAuth(form));
    }

    @PostMapping("/savePositionBaseAuth")
    public RequestResult savePositionBaseAuth(@RequestBody PositionAuthSaveForm form){
        return new RequestResult<>(positionAuthConfigService.savePositionBaseAuth(form));
    }

    @PostMapping("/resetPositionLinkAuth")
    public RequestResult resetPositionLinkAuth(@RequestBody PositionAuthSaveForm form){
        return new RequestResult<>(positionAuthConfigService.resetPositionLinkAuth(form));
    }

    @PostMapping("/queryAllPositionDataAuthority")
    public RequestResult<List<DataAuthModel>> queryAllPositionDataAuthority(@RequestBody DataAuthTreeQueryForm form){
        return new RequestResult<>(positionAuthConfigService.queryAllPositionDataAuthority(form));
    }

    @PostMapping("/savePositionDataAuth")
    public RequestResult savePositionDataAuth(@RequestBody PositionDataAuthSaveForm form){
        return new RequestResult<>(positionAuthConfigService.savePositionDataAuth(form));
    }
}
