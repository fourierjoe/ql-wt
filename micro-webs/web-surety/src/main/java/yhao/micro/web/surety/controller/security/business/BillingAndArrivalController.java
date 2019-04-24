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
import yhao.micro.service.surety.business.apilist.model.finance.FinanceArrivalDetailModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.FinanceRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/4 15:17
 * @Description:到账出账菜单
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/finance", produces = {"application/json;charset=UTF-8"})
@Api(value = "BillingAndArrivalController", tags = "担保财务-到账出账")
public class BillingAndArrivalController extends WebBaseController {
    @Resource
    private FinanceRemote financeRemote;

    @GetMapping("/queryFundArrivalBilling")
    @ApiOperation(value = "到账出账查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FinanceArrivalBillingQueryResultForm.class, message = "到账出账查询")
    })
    public String queryFundArrivalBilling(FinanceArrivalBillingQueryForm form){
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<FinanceArrivalBillingQueryResultForm> page = financeRemote.queryFundArrivalBilling(form);
        return  returnSuccessInfo(page);
    }
    @GetMapping("/queryFundArrival")
    @ApiOperation(value = "到账查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FinanceArrivalQueryResultForm.class, message = "到账查询")
    })
    public String queryFundArrival(IdForm form){
        RequestResult<List<FinanceArrivalQueryResultForm>> result = financeRemote.queryFundArrival(form);
        return  returnSuccessInfo(result);
    }
    @GetMapping("/queryFundBilling")
    @ApiOperation(value = "转回出账查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FinanceBillingQueryResultForm.class, message = "转回出账查询")
    })
    public String queryFundBilling(IdForm form){
        RequestResult<List<FinanceBillingQueryResultBizForm>> result = financeRemote.queryFundBilling(form);
        return  returnSuccessInfo(result);
    }
    @PostMapping("/fundBillingConfirm")
    @ApiOperation(value = "确认出账")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "确认出账")
    })
    public String fundBillingConfirm(@RequestBody IdForm form){
        RequestResult<Boolean> result =   financeRemote.FundBillingConfirm(form);
        return  returnSuccessInfo(result.pickBody());
    }
    @GetMapping("/fundArrivalConfirm")
    @ApiOperation(value = "确认到账")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "确认到账")
    })
    public String fundArrivalConfirm(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result =   financeRemote.fundArrivalConfirm(form);
        return  returnSuccessInfo(result.pickBody());
    }
    @PostMapping("/fundArrivalSave")
    @ApiOperation(value = "新增/编辑到账")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "新增/编辑到账")
    })
    public String fundArrivalSave(@RequestBody FinanceArrivalSaveForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result =   financeRemote.fundArrivalSave(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/pickFundArrival")
    @ApiOperation(value = "到账详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = FinanceArrivalDetailModel.class, message = "到账详情")
    })
    public String pickFundArrival(IdForm form){
        return  returnSuccessInfo(financeRemote.pickFundArrival(form).pickBody());
    }




    @GetMapping("/fundArrivalDel")
    @ApiOperation(value = "删除到账")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "删除到账")
    })
    public String fundArrivalDel(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        return  returnSuccessInfo(financeRemote.fundArrivalDel(form).pickBody());
    }



    @PostMapping("/fundBillingSave")
    @ApiOperation(value = "出账保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "出账保存")
    })
    public String fundBillingSave(@RequestBody FinanceBillingSaveForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result =   financeRemote.fundBillingSave(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @PostMapping("/rewind")
    @ApiOperation(value = "出账转回")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "出账转回")
    })
    public String rewind(@RequestBody RewindSaveForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<Boolean> result =   financeRemote.rewind(form);
        return  returnSuccessInfo(result.pickBody());
    }


    @PostMapping("/firstBillingGeneral")
    @ApiOperation(value = "第一次出账合计概况")
    @ApiResponses({
            @ApiResponse(code = 200, response = FirstBillingGeneralForm.class, message = "第一次出账合计概况")
    })
    public String firstBillingGeneral(IdForm form){
        RequestResult<FirstBillingGeneralForm> result =   financeRemote.firstBillingGeneral(form);
        return  returnSuccessInfo(result.pickBody());

    }


}
