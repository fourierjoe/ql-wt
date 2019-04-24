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
import yhao.micro.service.surety.business.apilist.model.finance.FundPlanRecordModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.TransactionTypeReceivePaymentPlanModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.FinanceRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:05
 * @Description:用款计划、资金回款菜单
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/finance", produces = {"application/json;charset=UTF-8"})
@Api(value = "FinanceController", tags = "担保财务-用款计划/资金回款")
public class FinanceController extends WebBaseController {

    @Resource
    private FinanceRemote financeRemote;


    @GetMapping("/queryFundPlan")
    @ApiOperation(value = "用款计划查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundPlanQueryResultForm.class, message = "用款计划信息")
    })
    public String queryFundPlan(FundPlanQueryForm form){
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<FundPlanQueryResultForm> page = financeRemote.queryFundPlan(form);
        return  returnSuccessInfo(page);
    }

    @PostMapping("/fundPlanSave")
    @ApiOperation(value = "用款计划保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "用款计划选择资方")
    })
    public String fundPlanSave(@RequestBody FinanceFundPlanSaveForm form){
        RequestResult<Boolean> result =   financeRemote.fundPlanSave(form);
        return  returnSuccessInfo(result.pickBody());
    }


    @PostMapping("/fundPick")
    @ApiOperation(value = "用款计划选择资方")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "用款计划选择资方")
    })
    public String fundPick(@RequestBody FinancePickFundForm form){
        form.setCreateOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result =   financeRemote.fundPick(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @PostMapping("/fundPlanUpdRate")
    @ApiOperation(value = "用款计划更新进度")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "用款计划更新进度")
    })
    public String fundPlanUpdRate(@RequestBody FinanceFundPlanForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result =   financeRemote.fundPlanUpdRate(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/queryFundPlanRecord")
    @ApiOperation(value = "用款计划记录查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundPlanRecordModel.class, message = "用款计划记录查询")
    })
    public String queryFundPlanRecord(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        Pagination<FundPlanRecordModel> page = financeRemote.queryFundPlanRecord(form);
        return  returnSuccessInfo(toPageListData(page,FundPlanRecordModel.class));
    }


    @GetMapping("/queryFundPayBack")
    @ApiOperation(value = "资金回款列表查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundPayBackQueryResultForm.class, message = "资金回款列表查询")
    })
    public String queryFundPayBack(FundPaybackQueryForm form){
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<FundPayBackQueryResultForm> page = financeRemote.queryFundPayBack(form);
        return  returnSuccessInfo(page);
    }

    @GetMapping("/fundPayBackPick")
    @ApiOperation(value = "回款查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FinancePaybackPickResultForm.class, message = "回款查询")
    })
    public String fundPayBackPick(FundPayBackRecordQueryForm form){
        return  returnSuccessInfo(financeRemote.fundPayBackPick(form));
    }
    @PostMapping("/fundPayBackSave")
    @ApiOperation(value = "新增回款")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "新增回款")
    })
    public String fundPayBackSave(@RequestBody FundPayBackSaveForm form){
        form.setOperatorId(getCurrentPerson().getCreateOperatorId());
        RequestResult<Boolean> result =   financeRemote.fundPayBackSave(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @PostMapping("/fundPayBackConfirmQuery")
    @ApiOperation(value = "确认回款信息查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundPayBackConfirmResultForm.class, message = "确认回款信息查询")
    })
    public String fundPayBackConfirmQuery(@RequestBody IdForm form){
        RequestResult<FundPayBackConfirmResultForm> result =   financeRemote.fundPayBackConfirmQuery(form);
        return  returnSuccessInfo(result.pickBody());
    }


    @GetMapping("/fundPayBackConfirm")
    @ApiOperation(value = "确认回款")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "确认回款")
    })
    public String fundPayBackConfirm(IdForm form){
        RequestResult<Boolean> result =   financeRemote.fundPayBackConfirm(form);
        return  returnSuccessInfo(result.pickBody());
    }


    @GetMapping("/queryOverdue")
    @ApiOperation(value = "产生逾期费回款记录")
    @ApiResponses({
            @ApiResponse(code = 200, response = OverdueRecordResultForm.class, message = "产生逾期费回款记录")
    })
    public String queryOverdueRecord(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<List<OverdueRecordResultForm>> result =   financeRemote.queryOverdueRecord(form);
        return  returnSuccessInfo(result.pickBody());
    }



    @GetMapping("/pickAccountGeneral")
    @ApiOperation(value = "担保单财务台账")
    @ApiResponses({
            @ApiResponse(code = 200, response = OverdueRecordResultForm.class, message = "担保单财务台账")
    })
    public String pickAccountGeneral(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<AccountGeneralForm> result =   financeRemote.pickAccountGeneral(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/queryRepayAccount")
    @ApiOperation(value = "新增回款账户查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = TransactionTypeReceivePaymentPlanModel.class, message = "新增回款账户查询")
    })
    public String queryRepayAccount(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<List<TransactionTypeReceivePaymentPlanModel>> result =   financeRemote.queryRepayAccount(form);
        return  returnSuccessInfo(result.pickBody());

    }




}

