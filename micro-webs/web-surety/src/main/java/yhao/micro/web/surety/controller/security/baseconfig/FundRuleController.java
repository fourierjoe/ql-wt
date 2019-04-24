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
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundRuleModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.FundRuleRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:资金方案管理 Controller
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 20:46
 */
@Lazy
@RestController
@RequestMapping(value = "/security/baseconfig/fundRule",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "FundRuleController", tags = "基础配置-资金方案管理")
public class FundRuleController extends WebBaseController {
    @Resource
    private FundRuleRemote fundRuleRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "资金方案管理分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundRuleModel.class, message = "资金方案管理信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_RULE_SELECT)
    public String pageQuery(FundRuleQueryForm queryForm) {
        Pagination<FundRuleModel> page = fundRuleRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page, FundRuleModel.class));
    }


    @PostMapping("/saveFundRule")
    @ApiOperation(value = "资金方案管理新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_RULE_ADD)
    public String save(@RequestBody FundRuleSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        fundRuleRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/updateFundRule")
    @ApiOperation(value = "资金方案管理更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_RULE_EDIT)
    public String update(@RequestBody FundRuleSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        fundRuleRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/statusChange")
    @ApiOperation(value = "资金方案管理启用/禁用")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_RULE_CHANGE_STATUS)
    public String statusChange(@RequestBody StatusChangeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        fundRuleRemote.statusChange(form);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "资金方案删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.FUND_RULE_DELETE)
    public String deleteById(@RequestBody IdForm idForm) {
        fundRuleRemote.deleteById(idForm);
        return returnSuccessInfo();
    }
}
