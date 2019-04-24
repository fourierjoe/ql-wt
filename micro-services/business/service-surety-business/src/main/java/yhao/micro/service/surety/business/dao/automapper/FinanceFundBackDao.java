package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.*;
import yhao.micro.service.surety.business.apilist.model.finance.FundPayBackGeneralModel;
import yhao.micro.service.surety.business.apilist.model.finance.FundPayBackDetailModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/25 15:34
 * @Description:
 */
public interface FinanceFundBackDao {

    void queryFundPayBack(Pagination<FundPayBackQueryResultForm> page, FundPaybackQueryForm form);

    List<FundPayBackDetailModel> queryFundPayBackRecord(FundPayBackRecordQueryForm form);

    Integer insertFundPayBackDetail(FundPayBackDetailModel form);

    Integer fundPayBackConfirm(String id);

    FundPayBackGeneralModel pickPayBackGeneral(String guaranteeId);

    Integer insertFundPayBackGeneral(FundPayBackGeneralModel payBackGeneral);

    FundPayBackConfirmResultForm fundPayBackConfirmQuery(IdForm form);
    /**
     * 查询借款每日费率和逾期费率
     * @return:
     * @auther: yuanxy
     * @date: 2019/2/18 11:20
     */
    FinanceFeeRateResultForm pickFeeRate(String loanId);

    Integer deletePayBack(IdForm form);

    FundPayBackDetailModel pickPayBackDetail(String id);

    Integer updatePayBackGeneral(FundPayBackGeneralModel payBackGeneral);

    void updateFundPayBackDetail(FundPayBackDetailModel detailModel);

    List<LoanPayBackTotalQueryForm> queryFundPayBackLoanTotal(List<String> guaranteeIds);

    BigDecimal pickTotalFee(String guaranteeId);
    /**产生逾期费回款记录*/
    List<OverdueRecordResultForm> queryOverdueRecord(IdForm form);
    /**担保单财务台账*/
    AccountGeneralForm pickAccountGeneral(IdForm form);
}
