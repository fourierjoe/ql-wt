package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.model.MaterialModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.MaterialRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-02-25
 * Time: 19:44
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/material", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenMaterialController", tags = "开放-资料查询")
public class OpenMaterialController extends WebBaseController {
    @Resource
    private MaterialRemote materialRemote;

    @GetMapping("/query")
    @ApiOperation(value = "资料设置分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = MaterialModel.class, message = "资料设置信息")
    })
    public String query(MaterialQueryForm queryForm) {
        List<MaterialModel> materialModelList = materialRemote.query(queryForm);
        return returnSuccessInfo(materialModelList);
    }
}
