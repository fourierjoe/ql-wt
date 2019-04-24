package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.twiceRepay.*;
import yhao.micro.service.surety.business.apilist.model.twiceRepay.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2019/2/20 09:33
 * @Version: v1.0
 */
public interface TwiceRepayDao {
	void queryTwiceRepayStartPage(Pagination<TwiceRepayStartPageModel> page, TwiceRepayPageQueryForm form);
	void queryTwiceRepayConfirmPage(Pagination<TwiceRepayConfirmPageModel> page, TwiceRepayPageQueryForm form);
	void queryTwiceRepayArrivalPage(Pagination<TwiceRepayArrivalPageModel> page, TwiceRepayPageQueryForm form);
	void queryTwiceRepayApplyPage(Pagination<TwiceRepayApplyPageModel> page, TwiceRepayPageQueryForm form);
	void queryTwiceRepayBillingPage(Pagination<TwiceRepayBillingPageModel> page, TwiceRepayPageQueryForm form);
	void queryTwiceRepayRedeemPage(Pagination<TwiceRepayRedeemPageModel> page, TwiceRepayPageQueryForm form);

	int updateTwiceRepayState(TwiceRepayStateForm form);

	int updateRequisitesConfirm(RequisitesConfirmForm form);

	void saveTwiceArrival(TwiceArrivalSaveForm form);

	int updateTwiceArrival(TwiceArrivalSaveForm form);

	void deleteTwiceArrival(String id);

	void TwiceArrivalIdPageForm(Pagination<TwiceArrivalModel> page, TwiceArrivalIdPageForm form);

	TwiceArrivalModel pickTwiceArrival(String id);

	int insertApplicationBilling(ApplicationBillingSaveForm form);

	void queryApplicationBilling(Pagination<TwiceApplicationModel> page, GuaranteeIdPageForm form);

	TwiceApplicationModel selectApplicationBilling(String id);

	TwiceBillingModel pickTwiceBilling(String id);

	void saveTwiceBilling(TwiceBillingSaveForm form);
	void twiceBilling(TwiceBillingSaveForm form);

	int insertTwiceRedeem(TwiceRedeemSaveForm form);

	int updateTwiceRedeem(TwiceRedeemSaveForm form);

	TwiceRepayHistoryModel selectTwiceRepayHistory(String id);

	/**
	 * 添加历史表操作记录
	 */
	int insertTwiceRepayHistory(TwiceRepayHistorySaveForm form);

	List<BigDecimal> selectTwiceArrivalMoney(String id);

	int updateRedeemState(BalanceConfirmForm form);

	String selectRedeemState(String id);

	/**
	 * 查询到账,出账,申请总金额
	 * @param guaranteeId
	 * @return
	 */
	List<TwiceApplicationRecordModel> selectArrivalAmount(String guaranteeId);

	TwiceRedeemModel pickTwiceRedeem(String id);

	void insertBilling(BillingSaveForm form);

	List<TwiceRepayRedeemInnerPageModel> queryTwiceRepayRedeem(String id);

	/**
	 * 申请撤单修改状态
	 * @param id
	 * @return
	 */
	int updateCancelState(String id);
}
