package yhao.micro.web.surety.controller.security.erp.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PositionAuthQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PositionAuthSaveForm;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PositionDataAuthSaveForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPositionLinkModel;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.auth.PositionAuthConfigRemote;

import javax.annotation.Resource;

/**
 * Created by yoara on 2017/09/07.
 */
@Lazy
@RestController
@RequestMapping(value = "/security/erp/auth/position",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "PositionAuthConfigController", tags = "系统设置-岗位管理")
public class PositionAuthConfigController extends WebBaseController {
    @Resource
    private PositionAuthConfigRemote positionAuthConfigRemote;

    @GetMapping("/pageQueryPositionLink")
    @ApiOperation(value = "岗位查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = AuthPositionLinkModel.class, message = "岗位信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_POSITION_DATA_SELECT)
    public String pageQueryPositionLink(PositionAuthQueryForm form) {
        Pagination<AuthPositionLinkModel> page = positionAuthConfigRemote.pageQueryPositionLink(form);
        return returnSuccessInfo(toPageListData(page, AuthPositionLinkModel.class));
    }

    @GetMapping("/pageQueryPosition")
    @ApiOperation(value = "查询分页岗位信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = PositionModel.class, message = "岗位数据")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_POSITION_SELECT)
    public String pageQueryPosition(PositionQueryForm form) {
        Pagination<PositionModel> page = positionAuthConfigRemote.pageQueryPosition(form);
        return returnSuccessInfo(toPageListData(page, PositionModel.class));
    }


    @PostMapping("/savePositionAuth")
    @ApiOperation(value = "保存岗位菜单功能权限")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_POSITION_AUTH_TYPE_CONFIG)
    public String savePositionAuth(@RequestBody PositionAuthSaveForm form) {
        positionAuthConfigRemote.savePositionBaseAuth(form);
        return returnSuccessInfo();
    }

    @PostMapping("/savePositionLinkDataAuth")
    @ApiOperation(value = "保存岗位数据权限")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_POSITION_DATA_CONFIG)
    public String savePositionLinkDataAuth(@RequestBody PositionDataAuthSaveForm form) {
        positionAuthConfigRemote.savePositionLinkDataAuth(form);
        return returnSuccessInfo();
    }
}
