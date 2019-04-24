package yhao.micro.service.surety.erp.org.apilist.restful;

import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionCodeModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;

import java.net.CacheRequest;
import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface PositionFeign {
    @RequestMapping(value = "/position/queryPositionPage",method = RequestMethod.POST)
    RequestResult<Pagination<PositionModel>> queryPositionPage(PositionQueryForm form);

    @RequestMapping(value = "/position/savePosition",method = RequestMethod.POST)
    RequestResult savePosition(PositionModel org);

    @RequestMapping(value = "/position/selectById",method = RequestMethod.POST)
    RequestResult<PositionModel> selectById(IdForm form);

    @RequestMapping(value = "/position/deleteById",method = RequestMethod.POST)
    RequestResult deleteById(IdForm form);

    @RequestMapping(value = "/position/queryFollowerAndDeclarerCodeByCityOrg",method = RequestMethod.POST)
    RequestResult<List<PositionCodeModel>> queryFollowerAndDeclarerCodeByCityOrg(IdForm idForm);

    @RequestMapping(value = "/position/queryObtainerAndForecloserCodeByCityOrg",method = RequestMethod.POST)
    RequestResult<List<PositionCodeModel>> queryObtainerAndForecloserCodeByCityOrg(IdForm idForm);

    @RequestMapping(value = "/position/queryManagerCodeByCityOrg",method = RequestMethod.POST)
    RequestResult<PositionCodeModel> queryManagerCodeByCityOrg(IdForm idForm);

    @RequestMapping(value = "/position/queryResidentCodeByCityOrg",method = RequestMethod.POST)
    RequestResult<PositionCodeModel> queryResidentCodeByCityOrg(IdForm idForm);

    @RequestMapping(value = "/position/queryExaminerCodeByCityOrg",method = RequestMethod.POST)
    RequestResult<PositionCodeModel> queryExaminerCodeByCityOrg(IdForm idForm);
}
