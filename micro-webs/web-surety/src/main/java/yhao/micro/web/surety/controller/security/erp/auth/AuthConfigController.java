package yhao.micro.web.surety.controller.security.erp.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.constants.model.TreeModel;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthTypeModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.auth.AuthConfigRemote;
import yhao.micro.web.surety.util.TreeBuildUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoara on 2017/09/07.
 */
@Lazy
@RestController
@RequestMapping(value = "/security/erp/auth/auth",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "AuthConfigController", tags = "系统设置-菜单")
public class AuthConfigController extends WebBaseController {
    @Resource
    private AuthConfigRemote authConfigRemote;

    @GetMapping("/queryAuthTypeTree")
    @ApiOperation(value = "菜单树查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = TreeModel.class, message = "菜单信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_TYPE_SELECT)
    public String queryAuthTypeTree(AuthTypeQueryForm queryForm) {
        List<AuthTypeModel> authTypeModelList = authConfigRemote.queryAuthType(queryForm);
        return returnSuccessInfo(makeTreeModel(authTypeModelList));
    }

    @PostMapping("/saveAuthType")
    @ApiOperation(value = "菜单新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_TYPE_ADD)
    public String saveAuthType(@RequestBody AuthTypeSaveForm saveForm) {
        authConfigRemote.saveAuthType(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/updateAuthType")
    @ApiOperation(value = "菜单编辑")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_TYPE_EDIT)
    public String updateAuthType(@RequestBody AuthTypeSaveForm saveForm) {
        authConfigRemote.saveAuthType(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/batchUpdateAuthType")
    @ApiOperation(value = "批量菜单更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_TYPE_EDIT)
    public String batchUpdateAuthType(@RequestBody AuthTypeBatchSaveForm saveForm) {
        authConfigRemote.batchSaveAuthType(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteAuthType")
    @ApiOperation(value = "菜单删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_TYPE_DELETE)
    public String deleteAuthType(@RequestBody IdForm form) {
        authConfigRemote.deleteAuthType(form);
        return returnSuccessInfo();
    }

    @GetMapping("/pageQueryAuthLeaf")
    @ApiOperation(value = "功能分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = AuthLeafModel.class, message = "功能信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_SELECT)
    public String pageQueryAuthLeaf(AuthLeafQueryForm form) {
        Pagination<AuthLeafModel> page = authConfigRemote.pageQueryAuthLeaf(form);
        return returnSuccessInfo(toPageListData(page, AuthLeafModel.class));
    }

    @PostMapping("/saveAuthLeaf")
    @ApiOperation(value = "功能新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_ADD)
    public String saveAuthLeaf(@RequestBody AuthLeafSaveForm saveForm) {
        authConfigRemote.saveAuthLeaf(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/updateAuthLeaf")
    @ApiOperation(value = "功能编辑")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_EDIT)
    public String updateAuthLeaf(@RequestBody AuthLeafSaveForm saveForm) {
        authConfigRemote.saveAuthLeaf(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteAuthLeaf")
    @ApiOperation(value = "功能删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.AUTH_DELETE)
    public String deleteAuthLeaf(@RequestBody IdForm form) {
        authConfigRemote.deleteAuthLeaf(form);
        return returnSuccessInfo();
    }

    private List<TreeModel> makeTreeModel(List<AuthTypeModel> list) {
        List<TreeModel> treeModelList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(list)) {
            for (AuthTypeModel authType : list) {
                TreeModel item = new TreeModel();
                item.setId(authType.getId());
                item.setName(authType.getName());
                item.setPid(authType.getParentId());
                item.setpName(authType.getParentName());
                item.setOrder(authType.getOrder());
                item.setChecked(false);
                item.setExpand(false);
                if (StringUtils.isNotBlank(authType.getParentId())) {//目前只存在二级菜单，所以没有父亲就表示是叶子结点
                    item.setLeaf(true);
                }
                treeModelList.add(item);
            }
        }
        return TreeBuildUtil.buildTree(treeModelList);
    }
}
