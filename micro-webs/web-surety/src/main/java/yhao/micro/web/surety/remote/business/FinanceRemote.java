package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceArrivalDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceTollDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FundPlanRecordModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.TransactionTypeReceivePaymentPlanModel;
import yhao.micro.service.surety.business.apilist.restful.FinanceFeign;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 20:06
 * @Description:担保财务相关
 */
@Service
public class FinanceRemote {
    private Logger logger = LoggerFactory.getLogger(FinanceRemote.class);

    @Resource
    private FinanceFeign financeFeign;

    @HystrixCommand(fallbackMethod = "queryFundPlanDown")
    public Pagination<FundPlanQueryResultForm> queryFundPlan(FundPlanQueryForm form) {
        return financeFeign.queryFundPlan(form).pickBody();
    }

    public Pagination<FundPlanQueryResultForm> queryFundPlanDown(FundPlanQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryFundPlanDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public RequestResult<Boolean> fundPick(FinancePickFundForm form) {
        return financeFeign.fundPick(form);
    }

    public RequestResult<Boolean> fundPlanUpdRate(FinanceFundPlanForm form) {
        return financeFeign.fundPlanUpdRate(form);
    }

    @HystrixCommand(fallbackMethod = "queryFundPlanRecordDown")
    public Pagination<FundPlanRecordModel> queryFundPlanRecord(IdForm form) {
        return financeFeign.queryFundPlanRecord(form).pickBody();
    }

    public Pagination<FundPlanRecordModel> queryFundPlanRecordDown(IdForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryFundPlanRecordDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public Pagination<FundPayBackQueryResultForm> queryFundPayBack(FundPaybackQueryForm form) {
        return financeFeign.queryFundPayBack(form).pickBody();
    }

    public Pagination<FundPayBackQueryResultForm> queryFundPayBackDown(FundPaybackQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryFundPayBackDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public FinancePaybackPickResultForm fundPayBackPick(FundPayBackRecordQueryForm form) {
        return new FinancePaybackPickResultForm();
    }

    public Pagination<FinancePaybackPickResultForm> fundPayBackPickDown(IdForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.fundPayBackPickDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public RequestResult<Boolean> fundPayBackSave(FundPayBackSaveForm form) {
        return financeFeign.fundPayBackSave(form);
    }

    public RequestResult<Boolean> fundPayBackConfirm(IdForm form) {
       return financeFeign.fundPayBackConfirm(form);
    }

    public Pagination<FinanceArrivalBillingQueryResultForm> queryFundArrivalBilling(FinanceArrivalBillingQueryForm form) {
        return financeFeign.queryFundArrivalBilling(form).pickBody();
    }


    public RequestResult<List<FinanceArrivalQueryResultForm>> queryFundArrival(IdForm form) {
        return financeFeign.queryFundArrival(form);
    }

    public RequestResult<List<FinanceBillingQueryResultBizForm>> queryFundBilling(IdForm form) {
        return financeFeign.queryFundBilling(form);
    }

    public RequestResult<Boolean> FundBillingConfirm(IdForm form) {
        return new RequestResult<>();
    }

    public RequestResult<Boolean> fundArrivalConfirm(IdForm form) {
        return financeFeign.confirmArrival(form);
    }

    public RequestResult<Boolean> fundArrivalSave(FinanceArrivalSaveForm form) {
        return financeFeign.fundArrivalSave(form);
    }

    public RequestResult<Boolean> fundBillingSave(FinanceBillingSaveForm form) {
        return new RequestResult<>();
    }

    @HystrixCommand(fallbackMethod = "queryChargeDown")
    public Pagination<FinanceTollQueryResultForm> queryCharge(FinanceTollQueryForm form) {
        return financeFeign.queryCharge(form).pickBody();
    }

    public Pagination<FinanceTollQueryResultForm> queryChargeDown(FinanceTollQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryFundPayBackDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public RequestResult<Boolean> tollSave(FinanceTollSaveForm form) {
        return financeFeign.tollSave(form);
    }

    public RequestResult<Boolean> fundPlanSave(FinanceFundPlanSaveForm form) {
        return financeFeign.fundPlanSave(form);
    }

    public RequestResult<FinanceArrivalDetailModel> pickFundArrival(IdForm form) {
        return financeFeign.pickFundArrival(form);
    }

    public RequestResult<Boolean> fundArrivalDel(IdForm form) {
        return financeFeign.fundArrivalDel(form);
    }

    public RequestResult<List<FinanceTollDetailModel>> queryTollRecord(IdForm form) {
        return financeFeign.queryTollRecord(form);
    }

    public RequestResult<GeneralLoanDetailQueryResultForm> queryLoanDetail(IdForm form) {
        return financeFeign.queryLoanDetail(form);
    }

    public RequestResult<Boolean> confirmToll(FinanceTollConfirmSaveForm form) {
        return financeFeign.confirmToll(form);
    }

    public RequestResult<Boolean> tollDel(FinanceTollDelForm form) {
        return financeFeign.tollDel(form);
    }

    public RequestResult<FinanceTollDetailModel> pickTollDetail(IdForm form) {
        return financeFeign.pickTollDetail(form);
    }

    public RequestResult<FinanceBillingGeneralResultForm> loanGeneral(IdForm form) {
        return new RequestResult<FinanceBillingGeneralResultForm>();
    }

    public RequestResult<List<ConsumeRecordResultForm>> queryConsumeRecord(IdForm form) {
        return financeFeign.queryConsumeRecord(form);
    }

    public RequestResult<CostGeneralResultForm> costGeneral(IdForm form) {
        return financeFeign.costGeneral(form);
    }

    public RequestResult<Boolean> rewind(RewindSaveForm form) {
       return financeFeign.rewind(form);
    }

    public RequestResult<FundPayBackConfirmResultForm> fundPayBackConfirmQuery(IdForm form) {
        return financeFeign.fundPayBackConfirmQuery(form);
    }

    public RequestResult<FirstBillingGeneralForm> firstBillingGeneral(IdForm form) {
        return financeFeign.firstBillingGeneral(form);
    }

    public RequestResult<List<OverdueRecordResultForm>> queryOverdueRecord(IdForm form) {
        return financeFeign.queryOverdueRecord(form);
    }

    public RequestResult<AccountGeneralForm> pickAccountGeneral(IdForm form) {
        return financeFeign.pickAccountGeneral(form);
    }

    public RequestResult<List<TransactionTypeReceivePaymentPlanModel>> queryRepayAccount(IdForm form) {
        return financeFeign.queryRepayAccount(form);
    }
}
