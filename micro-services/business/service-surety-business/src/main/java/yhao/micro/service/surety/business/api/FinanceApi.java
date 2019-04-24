package yhao.micro.service.surety.business.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceArrivalDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceTollDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FundPlanRecordModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.TransactionTypeReceivePaymentPlanModel;
import yhao.micro.service.surety.business.service.BillingArrivalService;
import yhao.micro.service.surety.business.service.FinancePayBackService;
import yhao.micro.service.surety.business.service.FinanceFundPlanService;
import yhao.micro.service.surety.business.service.FinanceTollManagerService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/7 20:01
 * @Description:
 */
@RestController
@RequestMapping(value = "/finance")
public class FinanceApi {
    @Resource
    private FinanceFundPlanService fundPlanService;
    @Resource
    private FinanceTollManagerService tollManagerService;

    @Resource
    private BillingArrivalService billingArrivalService;

    @Resource
    private FinancePayBackService financeFundBackService;


    @PostMapping(value = "/fundPlanSave")
    public RequestResult<Boolean> fundPlanSave(@RequestBody FinanceFundPlanSaveForm form) {
        return new RequestResult<>(fundPlanService.fundPlanSave(form));
    }

    @PostMapping(value = "/queryFundPlan")
    public RequestResult<Pagination<FundPlanQueryResultForm>> queryFundPlan(@RequestBody FundPlanQueryForm form) {
        return new RequestResult<>(fundPlanService.queryFundPlan(form));
    }

    @PostMapping(value = "/queryFundPlanRecord")
    public RequestResult<Pagination<FundPlanRecordModel>> queryFundPlanRecord(@RequestBody IdForm form) {
        return new RequestResult<>(fundPlanService.queryFundPlanRecord(form));
    }

    @PostMapping(value = "/fundPick")
    public RequestResult<Boolean> fundPick(@RequestBody FinancePickFundForm form) {
        return new RequestResult<>(fundPlanService.fundPick(form));
    }

    @PostMapping(value = "/fundPlanUpdRate")
    public RequestResult<Boolean> fundPlanUpdRate(@RequestBody FinanceFundPlanForm form) {
        return new RequestResult<>(fundPlanService.fundPlanUpdRate(form));
    }


    @PostMapping(value = "/tollSave")
    public RequestResult<Boolean> tollSave(@RequestBody FinanceTollSaveForm form) {
        return new RequestResult<>(tollManagerService.tollSave(form));
    }

    @PostMapping(value = "/queryTollRecord")
    public RequestResult<List<FinanceTollDetailModel>> queryTollRecord(@RequestBody IdForm form) {
        return new RequestResult<>(tollManagerService.queryTollRecord(form));
    }

    @PostMapping(value = "/queryLoanDetail")
    public RequestResult<GeneralLoanDetailQueryResultForm> queryLoanDetail(@RequestBody IdForm form) {
        return new RequestResult<>(tollManagerService.queryLoanDetail(form));
    }

    @PostMapping(value = "/confirmToll")
    public RequestResult<Boolean> confirmToll(@RequestBody FinanceTollConfirmSaveForm form) {
        return new RequestResult<>(tollManagerService.confirmToll(form));
    }

    @PostMapping(value = "/tollDel")
    public RequestResult<Boolean> tollDel(@RequestBody FinanceTollDelForm form) {
        return new RequestResult<>(tollManagerService.tollDel(form));
    }

    @PostMapping(value = "/pickTollDetail")
    public RequestResult<FinanceTollDetailModel> pickTollDetail(@RequestBody IdForm form) {
        return new RequestResult<>(tollManagerService.pickTollDetail(form));
    }

    @PostMapping(value = "/queryFundArrivalBilling")
    public RequestResult<Pagination<FinanceArrivalBillingQueryResultForm>> queryFundArrivalBilling(@RequestBody FinanceArrivalBillingQueryForm form) {
        return new RequestResult<>(billingArrivalService.queryFundArrivalBilling(form));
    }

    @PostMapping(value = "/fundArrivalSave")
    public RequestResult<Boolean> fundArrivalSave(@RequestBody FinanceArrivalSaveForm form) {
        return new RequestResult<>(billingArrivalService.fundArrivalSave(form));
    }

    @PostMapping(value = "/pickFundArrival")
    public RequestResult<FinanceArrivalDetailModel> pickFundArrival(@RequestBody IdForm form) {
        return new RequestResult<>(billingArrivalService.pickFundArrival(form));
    }

    @PostMapping(value = "/fundArrivalDel")
    public RequestResult<Boolean> fundArrivalDel(@RequestBody IdForm form) {
        return new RequestResult<>(billingArrivalService.fundArrivalDel(form));
    }

    @PostMapping(value = "/confirmArrival")
    public RequestResult<Boolean> confirmArrival(@RequestBody IdForm form) {
        return new RequestResult<>(billingArrivalService.confirmArrival(form));
    }

    @PostMapping(value = "/queryFundPayBack")
    public RequestResult<Pagination<FundPayBackQueryResultForm>> queryFundPayBack(@RequestBody FundPaybackQueryForm form) {
        return new RequestResult<>(financeFundBackService.queryFundPayBack(form));
    }

    @PostMapping(value = "/fundPayBackPick")
    public RequestResult<FinancePaybackPickResultForm> fundPayBackPick(@RequestBody FundPayBackRecordQueryForm form) {
        return new RequestResult<>(financeFundBackService.fundPayBackPick(form));
    }

    @PostMapping(value = "/fundPayBackSave")
    public RequestResult<Boolean> fundPayBackSave(@RequestBody FundPayBackSaveForm form) {
        return new RequestResult<>(financeFundBackService.fundPayBackSave(form));
    }

    @PostMapping(value = "/fundPayBackConfirmQuery")
    public RequestResult<FundPayBackConfirmResultForm> fundPayBackConfirmQuery(@RequestBody IdForm form) {
        return new RequestResult<>(financeFundBackService.fundPayBackConfirmQuery(form));
    }

    @PostMapping(value = "/fundPayBackConfirm")
    public RequestResult<Boolean> fundPayBackConfirm(@RequestBody IdForm form) {
        return new RequestResult<>(financeFundBackService.fundPayBackConfirm(form));
    }

    @PostMapping(value = "/deletePayBack")
    public RequestResult<Boolean> deletePayBack(@RequestBody IdForm form) {
        return new RequestResult<>(financeFundBackService.deletePayBack(form));
    }


    @PostMapping(value = "/queryCharge")
    public RequestResult<Pagination<FinanceTollQueryResultForm>> queryCharge(@RequestBody FinanceTollQueryForm form) {
        return new RequestResult<>(tollManagerService.queryCharge(form));
    }

    @PostMapping(value = "/queryConsumeRecord")
    public RequestResult<List<ConsumeRecordResultForm>> queryConsumeRecord(@RequestBody IdForm form) {
        return new RequestResult<>(tollManagerService.queryConsumeRecord(form));
    }

    @PostMapping(value = "/costGeneral")
    RequestResult<CostGeneralResultForm> costGeneral(@RequestBody IdForm form) {
        return new RequestResult<>(tollManagerService.costGeneral(form));
    }
    @PostMapping(value = "/queryOverdueRecord")
    RequestResult<List<OverdueRecordResultForm>> queryOverdueRecord(@RequestBody IdForm form){
        return new RequestResult<>(financeFundBackService.queryOverdueRecord(form));
    }

    @PostMapping(value = "/pickAccountGeneral")
    RequestResult<AccountGeneralForm> pickAccountGeneral(@RequestBody IdForm form){
        return new RequestResult<>(financeFundBackService.pickAccountGeneral(form));
    }
    @PostMapping(value = "/queryFundBilling")
    RequestResult<List<FinanceBillingQueryResultBizForm>> queryFundBilling(@RequestBody IdForm form){
        return new RequestResult<>(billingArrivalService.queryFundBilling(form));
    }
    @PostMapping(value = "/queryFundArrival")
    RequestResult<List<FinanceArrivalQueryResultForm>> queryFundArrival(@RequestBody IdForm form){
        return new RequestResult<>(billingArrivalService.queryFundArrival(form));
    }

    @PostMapping(value = "/rewind")
    RequestResult<Boolean> rewind(@RequestBody RewindSaveForm form){
        return new RequestResult<>(billingArrivalService.rewind(form));
    }

    @PostMapping(value = "/queryRepayAccount")
    RequestResult<List<TransactionTypeReceivePaymentPlanModel>> queryRepayAccount(@RequestBody IdForm form){
        return new RequestResult<>(financeFundBackService.queryRepayAccount(form));
    }

}
