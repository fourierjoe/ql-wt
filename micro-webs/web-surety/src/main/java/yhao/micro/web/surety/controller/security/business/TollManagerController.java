package yhao.micro.web.surety.controller.security.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceTollDetailModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.FinanceRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/4 15:13
 * @Description:收费管理菜单
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/finance", produces = {"application/json;charset=UTF-8"})
@Api(value = "TollManagerController", tags = "担保财务-收费管理")
public class TollManagerController extends WebBaseController {
    @Resource
    private FinanceRemote financeRemote;

    @GetMapping("/queryCharge")
    @ApiOperation(value = "收费管理查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FinanceTollQueryResultForm.class, message = "收费管理查询")
    })
    public String queryCharge(FinanceTollQueryForm form) {
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<FinanceTollQueryResultForm> page = financeRemote.queryCharge(form);
        return returnSuccessInfo(page);
    }

    @PostMapping("/tollSave")
    @ApiOperation(value = "收费保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "收费保存")
    })
    public String tollSave(@RequestBody FinanceTollSaveForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result = financeRemote.tollSave(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping(value = "/queryTollRecord")
    @ApiOperation(value = "收费历史")
    @ApiResponses({
            @ApiResponse(code = 200, response = FinanceTollDetailModel.class, message = "收费历史")
    })
    public String queryTollRecord(IdForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<List<FinanceTollDetailModel>> result = financeRemote.queryTollRecord(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping(value = "/queryLoanDetail")
    @ApiOperation(value = "借款明细")
    @ApiResponses({
            @ApiResponse(code = 200, response = GeneralLoanDetailQueryResultForm.class, message = "借款明细")
    })
    public String queryLoanDetail(IdForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<GeneralLoanDetailQueryResultForm> result = financeRemote.queryLoanDetail(form);
        return returnSuccessInfo(result.pickBody());
    }

    @PostMapping(value = "/confirmToll")
    @ApiOperation(value = "确认收费")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "确认收费")
    })
    public String confirmToll(@RequestBody FinanceTollConfirmSaveForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result = financeRemote.confirmToll(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping(value = "/tollDel")
    @ApiOperation(value = "删除收费")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "删除收费")
    })
    public String tollDel(FinanceTollDelForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result = financeRemote.tollDel(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping(value = "/pickTollDetail")
    @ApiOperation(value = "收费详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = FinanceTollDetailModel.class, message = "收费详情")
    })
    public String pickTollDetail(IdForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<FinanceTollDetailModel> result = financeRemote.pickTollDetail(form);
        return returnSuccessInfo(result.pickBody());
    }


    @GetMapping(value = "/consumeRecord")
    @ApiOperation(value = "展期申请消费记录")
    @ApiResponses({
            @ApiResponse(code = 200, response = ConsumeRecordResultForm.class, message = "收费详情")
    })
    public String queryConsumeRecord(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<List<ConsumeRecordResultForm>> result =financeRemote.queryConsumeRecord(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping(value = "/costGeneral")
    @ApiOperation(value = "展期申请交费概况")
    @ApiResponses({
            @ApiResponse(code = 200, response = CostGeneralResultForm.class, message = "展期申请交费概况")
    })
    public String costGeneral(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<CostGeneralResultForm> result =financeRemote.costGeneral(form);
        return returnSuccessInfo(result.pickBody());
    }





}
