package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceTollDetailModel;
import yhao.micro.service.surety.business.apilist.model.finance.FinanceTollGeneralModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.output.LoanDetailsModel;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/8 20:35
 * @Description:
 */
public interface FinanceTollManagerDao {
    /***新增收费概况*/
    Integer insertTollGeneral(FinanceTollGeneralModel model);

    /***新增收费详情*/
    Integer insertTollDetail(FinanceTollSaveForm form);

    /***收费详情记录*/
    List<FinanceTollDetailModel> queryTollDetail(String id);

    /***担保费借款明细*/
    GeneralLoanDetailQueryResultForm pickLoanGeneral(String id);

    /***确认收费*/
    Integer confirmToll(FinanceTollConfirmSaveForm form);

    /***收费详情*/
    FinanceTollDetailModel pickTollDetail(String id);

    /***更新收费概况*/
    Integer updateTollGeneral(FinanceTollGeneralModel generalModel);

    /***更新收费详情*/
    Integer updateTollDetail(FinanceTollDetailModel detailModel);

    /***删除收费*/
    Integer delTollDetail(String id);

    /***收费概况*/
    FinanceTollGeneralModel pickTollGeneral(String guaranteeId);

    /***查询担保单打折申请状态*/
    String pickDiscountApplication(String guaranteeId);
    /***担保费查询*/
    void queryWarranty(Pagination<FinanceTollQueryResultForm> page, FinanceTollQueryForm form);
    /***展期费查询*/
    void queryDelay(Pagination<FinanceTollQueryResultForm> page, FinanceTollQueryForm form);
    /***逾期费查询*/
    void queryOverdue(Pagination<FinanceTollQueryResultForm> page, FinanceTollQueryForm form);
    /***展期申请消费记录*/
    List<ConsumeRecordResultForm> queryConsumeRecord(IdForm form);
    /***展期申请交费概况*/
    CostGeneralResultForm costGeneral(IdForm form);
}
