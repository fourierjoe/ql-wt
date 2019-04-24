package yhao.micro.web.surety.controller.security.erp.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PersonAuthQueryForm;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PersonAuthSaveForm;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.PersonDataAuthSaveForm;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPersonModel;
import yhao.micro.service.surety.erp.org.apilist.form.StatusUpdateForm;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.auth.PersonAuthConfigRemote;
import yhao.micro.web.surety.remote.erp.org.PersonRemote;

import javax.annotation.Resource;

/**
 * Created by yoara on 2017/09/07.
 */
@Lazy
@RestController
@RequestMapping(value = "/security/erp/auth/person",
        produces = { "application/json;charset=UTF-8"})
@Api(value = "PersonAuthConfigController", tags = "系统设置-账号管理管理")
public class PersonAuthConfigController extends WebBaseController {
    @Resource
    private PersonAuthConfigRemote personAuthConfigRemote;

    @GetMapping("/queryPersonLink")
    @ApiOperation(value = "账号查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = AuthPersonModel.class, message = "账号信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_PERSON_SELECT)
    public String queryPersonLink(PersonAuthQueryForm form) {
        Pagination<AuthPersonModel> page = personAuthConfigRemote.queryPerson(form);
        return returnSuccessInfo(toPageListData(page, AuthPersonModel.class));
    }

    @PostMapping("/savePersonAuth")
    @ApiOperation(value = "保存账号菜单功能权限")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_PERSON_AUTH_TYPE_CONFIG)
    public String savePersonAuth(@RequestBody PersonAuthSaveForm form) {
        personAuthConfigRemote.savePersonAuth(form);
        return returnSuccessInfo();
    }

    @PostMapping("/savePersonDataAuth")
    @ApiOperation(value = "保存账号数据权限")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_PERSON_DATA_CONFIG)
    public String savePersonDataAuth(@RequestBody PersonDataAuthSaveForm form) {
        personAuthConfigRemote.savePersonDataAuth(form);
        return returnSuccessInfo();
    }

    @PostMapping("/suretyStatusChange")
    @ApiOperation(value = "更改人员在万通担保系统的状态")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_PERSON_CHANGE_STATUS)
    public String suretyStatusChange(@RequestBody StatusUpdateForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        personAuthConfigRemote.suretyPersonStatusChange(form);
        return returnSuccessInfo();
    }
}
