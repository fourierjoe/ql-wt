package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.FinanceFundPlanForm;
import yhao.micro.service.surety.business.apilist.form.finance.FinancePickFundForm;
import yhao.micro.service.surety.business.apilist.form.finance.FundPlanQueryForm;
import yhao.micro.service.surety.business.apilist.form.finance.FundPlanQueryResultForm;
import yhao.micro.service.surety.business.apilist.model.finance.FundPlanModel;
import yhao.micro.service.surety.business.apilist.model.finance.FundPlanRecordModel;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/4 16:47
 * @Description:
 */
public interface FinanceFundPlanDao {
    /**新增用款计划*/
    Integer insertFundPlan(FundPlanModel planModel);
    /**查询用款计划列表*/
    void queryFundPlan(Pagination<FundPlanQueryResultForm> page, FundPlanQueryForm form);

    /**选择资方*/
    Integer fundPick(FinancePickFundForm form);
    /**查询用款计划操作记录*/
    void queryFundPlanRecord(Pagination<FundPlanRecordModel> page, IdForm form);
    /**用款计划更新进度*/
    Integer fundPlanUpdRate(FinanceFundPlanForm form);
    /**是否已确认到账*/
    Integer pickIsConfirmArrival(String guaranteeId);
    /**新增用款计划记录*/
    Integer insertFundPlanRecord(FundPlanRecordModel recordModel);
    /**查找用款计划*/
    FundPlanModel pickFundPlan(String guaranteeId);
}
