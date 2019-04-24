package yhao.micro.service.surety.erp.auth.apilist.restful;

import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPositionLinkModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;

import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface PositionAuthConfigFeign {
    @RequestMapping(value = "/auth/positionAuth/queryAllPositionAuthority",method = RequestMethod.POST)
    RequestResult<List<AuthLeafModel>> queryAllPositionAuthority(AuthTreeQueryForm form);

    @RequestMapping(value = "/auth/positionAuth/queryPosition",method = RequestMethod.POST)
    RequestResult<Pagination<AuthPositionLinkModel>> queryPosition(PositionAuthQueryForm form);

    @RequestMapping(value = "/auth/positionAuth/savePositionAuth",method = RequestMethod.POST)
    RequestResult savePositionAuth(PositionAuthSaveForm form);

    @RequestMapping(value = "/auth/positionAuth/savePositionBaseAuth",method = RequestMethod.POST)
    RequestResult savePositionBaseAuth(PositionAuthSaveForm form);

    @RequestMapping(value = "/auth/positionAuth/queryAllPositionDataAuthority",method = RequestMethod.POST)
    RequestResult<List<DataAuthModel>> queryAllPositionDataAuthority(DataAuthTreeQueryForm form);

    @RequestMapping(value = "/auth/positionAuth/savePositionDataAuth",method = RequestMethod.POST)
    RequestResult savePositionDataAuth(PositionDataAuthSaveForm form);

    @RequestMapping(value = "/auth/positionAuth/resetPositionLinkAuth",method = RequestMethod.POST)
    RequestResult resetPositionLinkAuth(PositionAuthSaveForm form);
}
