package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionCodeModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.org.PositionRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-29
 * Time: 10:07
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/constant", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenConstantController", tags = "开放-系统常量查询")
public class OpenConstantController extends WebBaseController {
    @Resource
    private PositionRemote positionRemote;

    @GetMapping("/queryFollowerAndDeclarerCodeByCityOrg")
    @ApiOperation(value = "根据指定城市组织ID查询跟单员和报单员岗位编码")
    @ApiResponses({
            @ApiResponse(code = 200, response = PositionCodeModel.class, message = "岗位编码数据")
    })
    public String queryFollowerAndDeclarerCodeByCityOrg(IdForm idForm) {
        return returnSuccessInfo(positionRemote.queryFollowerAndDeclarerCodeByCityOrg(idForm));
    }

    @GetMapping("/queryManagerCodeByCityOrg")
    @ApiOperation(value = "根据指定城市组织ID查询客户经理岗位编码")
    @ApiResponses({
            @ApiResponse(code = 200, response = PositionCodeModel.class, message = "岗位编码数据")
    })
    public String queryManagerCodeByCityOrg(IdForm idForm) {
        return returnSuccessInfo(positionRemote.queryManagerCodeByCityOrg(idForm));
    }

    @GetMapping("/queryResidentCodeByCityOrg")
    @ApiOperation(value = "根据指定城市组织ID查询驻点专员岗位编码")
    @ApiResponses({
            @ApiResponse(code = 200, response = PositionCodeModel.class, message = "岗位编码数据")
    })
    public String queryResidentCodeByCityOrg(IdForm idForm) {
        return returnSuccessInfo(positionRemote.queryResidentCodeByCityOrg(idForm));
    }

    @GetMapping("/queryExaminerCodeByCityOrg")
    @ApiOperation(value = "根据指定城市组织ID查询审查员岗位编码")
    @ApiResponses({
            @ApiResponse(code = 200, response = PositionCodeModel.class, message = "岗位编码数据")
    })
    public String queryExaminerCodeByCityOrg(IdForm idForm) {
        return returnSuccessInfo(positionRemote.queryExaminerCodeByCityOrg(idForm));
    }

    @GetMapping("/queryObtainerAndForecloserCodeByCityOrg")
    @ApiOperation(value = "根据指定城市组织ID查询取证专员和赎楼员岗位编码")
    @ApiResponses({
            @ApiResponse(code = 200, response = PositionCodeModel.class, message = "岗位编码数据")
    })
    public String queryObtainerAndForecloserCodeByCityOrg(IdForm idForm) {
        return returnSuccessInfo(positionRemote.queryObtainerAndForecloserCodeByCityOrg(idForm));
    }

}
