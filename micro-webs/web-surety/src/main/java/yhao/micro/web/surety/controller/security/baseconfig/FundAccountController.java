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
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundAccountModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.FundAccountRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:资金账号管理 Controller
 * User: GUO.MAO.LIN
 * Date: 2018-11-30
 * Time: 14:00
 */
@Lazy
@RestController
@RequestMapping(value = "/security/baseconfig/fundAccount",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "FundAccountController", tags = "基础配置-资金账号管理")
public class FundAccountController extends WebBaseController {
    @Resource
    private FundAccountRemote fundAccountRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "资金账号管理分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundAccountModel.class, message = "资金账号管理信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_ACCOUNT_SELECT)
    public String pageQuery(FundAccountQueryForm queryForm) {
        Pagination<FundAccountModel> page = fundAccountRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page, FundAccountModel.class));
    }

    @PostMapping("/save")
    @ApiOperation(value = "资金账号管理新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_ACCOUNT_ADD)
    public String save(@RequestBody FundAccountSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        fundAccountRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/update")
    @ApiOperation(value = "资金账号管理更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_ACCOUNT_EDIT)
    public String update(@RequestBody FundAccountSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        fundAccountRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/statusChange")
    @ApiOperation(value = "资金账号管理启用/禁用")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_ACCOUNT_CHANGE_STATUS)
    public String statusChange(@RequestBody StatusChangeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        fundAccountRemote.statusChange(form);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "资金账号删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_ACCOUNT_DELETE)
    public String deleteById(@RequestBody IdForm idForm) {
        fundAccountRemote.deleteById(idForm);
        return returnSuccessInfo();
    }

}
