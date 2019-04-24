package yhao.micro.service.surety.business.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceArrivalDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceTollDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FundPlanRecordModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.TransactionTypeReceivePaymentPlanModel;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/7 19:12
 * @Description:财务相关接口
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface FinanceFeign {
    @RequestMapping(value = "/finance/fundPlanSave", method = RequestMethod.POST)
    RequestResult<Boolean> fundPlanSave(@RequestBody FinanceFundPlanSaveForm form);

    @RequestMapping(value = "/finance/queryFundPlan", method = RequestMethod.POST)
    RequestResult<Pagination<FundPlanQueryResultForm>> queryFundPlan(@RequestBody FundPlanQueryForm form);

    @RequestMapping(value = "/finance/queryFundPlanRecord", method = RequestMethod.POST)
    RequestResult<Pagination<FundPlanRecordModel>> queryFundPlanRecord(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/fundPick", method = RequestMethod.POST)
    RequestResult<Boolean> fundPick(@RequestBody FinancePickFundForm form);

    @RequestMapping(value = "/finance/fundPlanUpdRate", method = RequestMethod.POST)
    RequestResult<Boolean> fundPlanUpdRate(@RequestBody FinanceFundPlanForm form);

    @RequestMapping(value = "/finance/pickFundArrival", method = RequestMethod.POST)
    RequestResult<FinanceArrivalDetailModel> pickFundArrival(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/fundArrivalDel", method = RequestMethod.POST)
    RequestResult<Boolean> fundArrivalDel(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/tollSave", method = RequestMethod.POST)
    RequestResult<Boolean> tollSave(@RequestBody FinanceTollSaveForm form);

    @RequestMapping(value = "/finance/queryTollRecord", method = RequestMethod.POST)
    RequestResult<List<FinanceTollDetailModel>> queryTollRecord(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/queryLoanDetail", method = RequestMethod.POST)
    RequestResult<GeneralLoanDetailQueryResultForm> queryLoanDetail(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/confirmToll", method = RequestMethod.POST)
    RequestResult<Boolean> confirmToll(@RequestBody FinanceTollConfirmSaveForm form);

    @RequestMapping(value = "/finance/tollDel", method = RequestMethod.POST)
    RequestResult<Boolean> tollDel(@RequestBody FinanceTollDelForm form);

    @RequestMapping(value = "/finance/pickTollDetail", method = RequestMethod.POST)
    RequestResult<FinanceTollDetailModel> pickTollDetail(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/fundArrivalSave", method = RequestMethod.POST)
    RequestResult<Boolean> fundArrivalSave(@RequestBody FinanceArrivalSaveForm form);

    @RequestMapping(value = "/finance/confirmArrival", method = RequestMethod.POST)
    RequestResult<Boolean> confirmArrival(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/rewind", method = RequestMethod.POST)
    RequestResult<Boolean> rewind(@RequestBody RewindSaveForm form);

    @RequestMapping(value = "/finance/queryFundPayBack", method = RequestMethod.POST)
    RequestResult<Pagination<FundPayBackQueryResultForm>> queryFundPayBack(@RequestBody FundPaybackQueryForm form);


    @RequestMapping(value = "/finance/fundPayBackConfirm", method = RequestMethod.POST)
    RequestResult<Boolean> fundPayBackConfirm(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/fundPayBackConfirmQuery", method = RequestMethod.POST)
    RequestResult<FundPayBackConfirmResultForm> fundPayBackConfirmQuery(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/fundPayBackSave", method = RequestMethod.POST)
    RequestResult<Boolean> fundPayBackSave(@RequestBody FundPayBackSaveForm form);

    @RequestMapping(value = "/finance/firstBillingGeneral", method = RequestMethod.POST)
    RequestResult<FirstBillingGeneralForm> firstBillingGeneral(@RequestBody IdForm form);

    @RequestMapping(value = "/finance/queryFundArrivalBilling", method = RequestMethod.POST)
    RequestResult<Pagination<FinanceArrivalBillingQueryResultForm>> queryFundArrivalBilling(@RequestBody FinanceArrivalBillingQueryForm form);

    @RequestMapping(value = "/finance/queryCharge", method = RequestMethod.POST)
    RequestResult<Pagination<FinanceTollQueryResultForm>> queryCharge(FinanceTollQueryForm form);

    @RequestMapping(value = "/finance/queryConsumeRecord", method = RequestMethod.POST)
    RequestResult<List<ConsumeRecordResultForm>> queryConsumeRecord(IdForm form);

    @RequestMapping(value = "/finance/costGeneral", method = RequestMethod.POST)
    RequestResult<CostGeneralResultForm> costGeneral(IdForm form);

    @RequestMapping(value = "/finance/queryOverdueRecord", method = RequestMethod.POST)
    RequestResult<List<OverdueRecordResultForm>> queryOverdueRecord(IdForm form);

    @RequestMapping(value = "/finance/pickAccountGeneral", method = RequestMethod.POST)
    RequestResult<AccountGeneralForm> pickAccountGeneral(IdForm form);

    @RequestMapping(value = "/finance/queryFundBilling", method = RequestMethod.POST)
    RequestResult<List<FinanceBillingQueryResultBizForm>> queryFundBilling(IdForm form);

    @RequestMapping(value = "/finance/queryFundArrival", method = RequestMethod.POST)
    RequestResult<List<FinanceArrivalQueryResultForm>> queryFundArrival(IdForm form);

    @RequestMapping(value = "/finance/queryRepayAccount", method = RequestMethod.POST)
    RequestResult<List<TransactionTypeReceivePaymentPlanModel>> queryRepayAccount(IdForm form);
}
