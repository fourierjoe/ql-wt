package yhao.micro.service.surety.erp.org.api.restful;

import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionCodeModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;
import yhao.micro.service.surety.erp.org.service.PositionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yoara on 2017/11/27.
 */
@RestController
@RequestMapping(value = "/position")
public class PositionApi extends RestfulBaseController {
    @Resource
    private PositionService positionService;

    @PostMapping("/queryPositionPage")
    public RequestResult<Pagination<PositionModel>> queryPositionPage(@RequestBody PositionQueryForm form){
        return new RequestResult<>(positionService.queryPositionPage(form));
    }

    @PostMapping("/savePosition")
    public RequestResult savePosition(@RequestBody PositionModel org){
        return new RequestResult<>(positionService.savePosition(org));
    }

    @PostMapping("/selectById")
    public RequestResult<PositionModel> selectById(@RequestBody IdForm form){
        return new RequestResult<>(positionService.selectById(form.getId()));
    }

    @PostMapping("/deleteById")
    public RequestResult deleteById(@RequestBody IdForm form){
        return new RequestResult<>(positionService.deleteById(form.getId()));
    }

    @PostMapping("/queryFollowerAndDeclarerCodeByCityOrg")
    public RequestResult<List<PositionCodeModel>> queryFollowerAndDeclarerCodeByCityOrg(@RequestBody IdForm idForm){
        return new RequestResult<>(positionService.queryFollowerAndDeclarerCodeByCityOrg(idForm));
    }

    @PostMapping("/queryObtainerAndForecloserCodeByCityOrg")
    public RequestResult<List<PositionCodeModel>> queryObtainerAndForecloserCodeByCityOrg(@RequestBody IdForm idForm){
        return new RequestResult<>(positionService.queryObtainerAndForecloserCodeByCityOrg(idForm));
    }

    @PostMapping("/queryManagerCodeByCityOrg")
    public RequestResult<PositionCodeModel> queryManagerCodeByCityOrg(@RequestBody IdForm idForm){
        return new RequestResult<>(positionService.queryManagerCodeByCityOrg(idForm));
    }

    @PostMapping("/queryResidentCodeByCityOrg")
    public RequestResult<PositionCodeModel> queryResidentCodeByCityOrg(@RequestBody IdForm idForm){
        return new RequestResult<>(positionService.queryResidentCodeByCityOrg(idForm));
    }

    @PostMapping("/queryExaminerCodeByCityOrg")
    public RequestResult<PositionCodeModel> queryExaminerCodeByCityOrg(@RequestBody IdForm idForm){
        return new RequestResult<>(positionService.queryExaminerCodeByCityOrg(idForm));
    }
}
