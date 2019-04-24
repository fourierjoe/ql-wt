package yhao.micro.web.surety.controller.security.baseconfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundProviderModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.FundProviderRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资方管理 Controller
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:57
 */
@Lazy
@RestController
@RequestMapping(value = "/security/baseconfig/fundProvider",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "FundProviderController", tags = "基础配置-资方管理")
public class FundProviderController extends WebBaseController {
    @Resource
    private FundProviderRemote fundProviderRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "总行分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundProviderModel.class, message = "资方管理信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_HEAD_SELECT)
    public String pageQuery(FundProviderQueryForm queryForm) {
        Pagination<FundProviderModel> page= fundProviderRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page,FundProviderModel.class));
    }

    @PostMapping("/saveHead")
    @ApiOperation(value = "资方管理总行新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_HEAD_ADD)
    public String saveHead(@RequestBody FundProviderSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        fundProviderRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/updateHead")
    @ApiOperation(value = "资方管理总行更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_HEAD_EDIT)
    public String updateHead(@RequestBody FundProviderSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        fundProviderRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/headStatusChange")
    @ApiOperation(value = "资方管理总行启用/禁用")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_HEAD_CHANGE_STATUS)
    public String headStatusChange(@RequestBody StatusChangeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        fundProviderRemote.statusChange(form);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteHeadById")
    @ApiOperation(value = "资方管理总行删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_HEAD_DELETE)
    public String deleteHeadById(@RequestBody IdForm idForm) {
        fundProviderRemote.deleteById(idForm);
        return returnSuccessInfo();
    }

    @GetMapping("/queryAllChildByParent")
    @ApiOperation(value = "根据总行查询下属分行和支行")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundProviderModel.class, message = "资方管理信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_BRANCH_SELECT)
    public String queryAllChildByParent(FundProviderQueryForm queryForm) {
        List<FundProviderModel> fundProviderModelList = fundProviderRemote.queryAllChildByParent(queryForm);
        return returnSuccessInfo(fundProviderModelList);
    }

    @PostMapping("/saveBranch")
    @ApiOperation(value = "资方管理分行新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_BRANCH_ADD)
    public String saveBranch(@RequestBody FundProviderSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        fundProviderRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/updateBranch")
    @ApiOperation(value = "资方管理分行更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_BRANCH_EDIT)
    public String updateBranch(@RequestBody FundProviderSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        fundProviderRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/branchStatusChange")
    @ApiOperation(value = "资方管理分行启用/禁用")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_BRANCH_CHANGE_STATUS)
    public String branchStatusChange(@RequestBody StatusChangeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        fundProviderRemote.statusChange(form);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteBranchById")
    @ApiOperation(value = "资方管理分行删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_PROVIDER_BRANCH_DELETE)
    public String deleteBranchById(@RequestBody IdForm idForm) {
        fundProviderRemote.deleteById(idForm);
        return returnSuccessInfo();
    }
}
