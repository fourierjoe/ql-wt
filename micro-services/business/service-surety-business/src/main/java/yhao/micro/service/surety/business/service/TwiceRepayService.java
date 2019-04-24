package yhao.micro.service.surety.business.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.infra.common.util.CommonListUtil;
import yhao.micro.service.constants.CommonConstants;
import yhao.micro.service.constants.util.WrapDozerUtil;
import yhao.micro.service.surety.business.apilist.form.finance.FirstBillingGeneralForm;
import yhao.micro.service.surety.business.apilist.form.twiceRepay.*;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.OperateNameEnum;
import yhao.micro.service.surety.business.apilist.model.enums.twiceRepay.OperateStateContentEnum;
import yhao.micro.service.surety.business.apilist.model.twiceRepay.*;
import yhao.micro.service.surety.business.apilist.restful.FinanceFeign;
import yhao.micro.service.surety.business.dao.automapper.TwiceRepayDao;
import yhao.micro.service.workflow.apilist.enums.flow.ConditionNameType;
import yhao.micro.service.workflow.apilist.enums.task.TaskStatus;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.form.task.TaskVariableSaveForm;
import yhao.micro.service.workflow.apilist.model.task.TaskModel;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Description:
 * @Created by ql on 2019/2/20 09:32
 * @Version: v1.0
 */
@Service
public class TwiceRepayService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private TwiceRepayDao twiceRepayDao;
	@Resource
	private FinanceFeign financeFeign;
	@Resource
	private TaskFeign taskFeign;

	/************************************客户经理发起**********************************************************************/
	public Pagination<TwiceRepayStartPageModel> twiceRepayStartPage(TwiceRepayPageQueryForm form) {
		var page = new Pagination<TwiceRepayStartPageModel>(form.getPageSize(), form.getCurrentPage());

		form.setStateInt(1);
		twiceRepayDao.queryTwiceRepayStartPage(page, form);

		return page;
	}

	@Transactional
	public boolean twiceRepayStart(GuaranteeIdForm form) {
		TwiceRepayHistorySaveForm twiceRepayHistorySaveForm = WrapDozerUtil.map(form, TwiceRepayHistorySaveForm.class);
		twiceRepayHistorySaveForm.setOperateName(OperateNameEnum.MANAGER_START.getDesc());
		twiceRepayHistorySaveForm.setOperateContent(OperateStateContentEnum.MANAGER_START_CONTENT.getContent());
		twiceRepayHistorySaveForm.setOperateState(OperateStateContentEnum.MANAGER_START_CONTENT.getState());
		twiceRepayHistorySaveForm.setGuaranteeId(form.getGuaranteeId());
		insertTwiceRepayHistory(twiceRepayHistorySaveForm);

		TwiceRepayStateForm twiceRepayStateForm = TwiceRepayStateForm.newTwiceRepayStateForm();
		twiceRepayStateForm.setId(form.getGuaranteeId());
		twiceRepayStateForm.setTwiceRepayState(1);
		return twiceRepayDao.updateTwiceRepayState(twiceRepayStateForm) > 0;
	}

	/************************************要件员确认**********************************************************************/
	/**
	 * 分页
	 * @param form
	 * @return
	 */
	public Pagination<TwiceRepayConfirmPageModel> twiceRepayConfirmPage(TwiceRepayPageQueryForm form) {
		var page = new Pagination<TwiceRepayConfirmPageModel>(form.getPageSize(), form.getCurrentPage());

		form.setStateInt(2);
		twiceRepayDao.queryTwiceRepayConfirmPage(page, form);

		return page;
	}

	@Transactional
	public boolean requisitesConfirm(RequisitesConfirmForm form) {
		TwiceRepayHistorySaveForm twiceRepayHistorySaveForm = WrapDozerUtil.map(form, TwiceRepayHistorySaveForm.class);
		twiceRepayHistorySaveForm.setOperateName(OperateNameEnum.REQUISITES_CONFIRM.getDesc());
		twiceRepayHistorySaveForm.setOperateContent(OperateStateContentEnum.REQUISITES_CONFIRM_CONTENT.getContent());
		twiceRepayHistorySaveForm.setOperateState(OperateStateContentEnum.REQUISITES_CONFIRM_CONTENT.getState());
		twiceRepayHistorySaveForm.setGuaranteeId(form.getGuaranteeId());
		insertTwiceRepayHistory(twiceRepayHistorySaveForm);

		// 要件员确认

		form.setTwiceRepayState(2);
		return twiceRepayDao.updateRequisitesConfirm(form) > 0;
	}

	/************************************二次到账**********************************************************************/
	/**
	 * 分页
	 * @param form
	 * @return
	 */
	public Pagination<TwiceRepayArrivalPageModel> twiceRepayArrivalPage(TwiceRepayPageQueryForm form) {
		var page = new Pagination<TwiceRepayArrivalPageModel>(form.getPageSize(), form.getCurrentPage());

		form.setStateInt(3);
		twiceRepayDao.queryTwiceRepayArrivalPage(page, form);

		return page;
	}

	@Transactional
	public TwiceArrivalSaveForm twiceArrival(TwiceArrivalSaveForm form) {
		if (StringUtils.isNotEmpty(form.getId())) {
			int rownum = twiceRepayDao.updateTwiceArrival(form);
			if (rownum < 1) {
				throw new RuntimeException("没有与传入参数相符的数据可供修改...");
			}
		} else {
			form.setId(UUID.randomUUID().toString());
			twiceRepayDao.saveTwiceArrival(form);
		}

		return form;
	}

	@Transactional
	public boolean deleteTwiceArrival(IdForm form) {
		twiceRepayDao.deleteTwiceArrival(form.getId());
		return true;
	}

	public Pagination<TwiceArrivalModel> queryTwiceArrivalPage(TwiceArrivalIdPageForm form) {
		var page = new Pagination<TwiceArrivalModel>(form.getPageSize(), form.getCurrentPage());

		twiceRepayDao.TwiceArrivalIdPageForm(page, form);
		return page;
	}

	public TwiceArrivalModel pickTwiceArrival(IdForm form) {
		return twiceRepayDao.pickTwiceArrival(form.getId());
	}

	/**
	 * 二次到账确认
	 * @param form
	 * @return
	 */
	@Transactional
	public boolean confirmTwiceArrival(GuaranteeIdForm form) {

		// 计算二次到账合计金额
		List<BigDecimal> twiceArrivals = twiceRepayDao.selectTwiceArrivalMoney(form.getGuaranteeId());
		if (CommonListUtil.isEmpty(twiceArrivals)) {
			throw new RuntimeException("请先到账再进行到账确认...");
		}
		BigDecimal twiceArrivalTotal = twiceArrivals.stream().reduce(BigDecimal::add).get();

		TwiceRepayHistorySaveForm twiceRepayHistorySaveForm = WrapDozerUtil.map(form, TwiceRepayHistorySaveForm.class);
		twiceRepayHistorySaveForm.setOperateName(OperateNameEnum.TWICE_ARRIVAL.getDesc());
		twiceRepayHistorySaveForm.setOperateContent(messageFormat(OperateStateContentEnum.TWICE_ARRIVAL_CONTENT.getContent(), twiceArrivalTotal));
		twiceRepayHistorySaveForm.setOperateState(OperateStateContentEnum.TWICE_ARRIVAL_CONTENT.getState());
		twiceRepayHistorySaveForm.setGuaranteeId(form.getGuaranteeId());
		insertTwiceRepayHistory(twiceRepayHistorySaveForm);

		TwiceRepayStateForm twiceRepayStateForm = TwiceRepayStateForm.newTwiceRepayStateForm();
		twiceRepayStateForm.setId(form.getGuaranteeId());
		twiceRepayStateForm.setTwiceRepayState(3);
		twiceRepayStateForm.setTwiceArrivalTotal(twiceArrivalTotal);
		return twiceRepayDao.updateTwiceRepayState(twiceRepayStateForm) > 0;
	}

	/************************************申请出账**********************************************************************/
	/**
	 * 分页
	 * @param form
	 * @return
	 */
	public Pagination<TwiceRepayApplyPageModel> twiceRepayApplyPage(TwiceRepayPageQueryForm form) {
		var page = new Pagination<TwiceRepayApplyPageModel>(form.getPageSize(), form.getCurrentPage());

		form.setStateInt(4);
		twiceRepayDao.queryTwiceRepayApplyPage(page, form);

		return page;
	}

	@Transactional
	public boolean applicationBilling(ApplicationBillingSaveForm form) {
		TwiceRepayHistorySaveForm twiceRepayHistorySaveForm = WrapDozerUtil.map(form, TwiceRepayHistorySaveForm.class);
		twiceRepayHistorySaveForm.setOperateName(OperateNameEnum.TWICE_APPLICATION.getDesc());
		twiceRepayHistorySaveForm.setOperateContent(messageFormat(OperateStateContentEnum.TWICE_APPLICATION_CONTENT.getContent(), form.getApplicationAmount()));
		twiceRepayHistorySaveForm.setOperateState(OperateStateContentEnum.TWICE_APPLICATION_CONTENT.getState());
		twiceRepayHistorySaveForm.setGuaranteeId(form.getGuaranteeId());
		insertTwiceRepayHistory(twiceRepayHistorySaveForm);

		// 出账申请表主键id
		String applicationBillingId = UUID.randomUUID().toString();
		form.setApplicationBillingId(applicationBillingId);
		twiceRepayDao.insertApplicationBilling(form);

		// 修改主表状态
		TwiceRepayStateForm twiceRepayStateForm = TwiceRepayStateForm.newTwiceRepayStateForm();
		twiceRepayStateForm.setId(form.getGuaranteeId());
		twiceRepayStateForm.setTwiceRepayState(4);
		twiceRepayDao.updateTwiceRepayState(twiceRepayStateForm);

		// 开启出账申请任务
		TaskStartForm taskStartForm = new TaskStartForm();
		taskStartForm.setBizCodeStr("45");
		taskStartForm.setBizEntityId(applicationBillingId);
		TaskVariableSaveForm taskVariableSaveForm = new TaskVariableSaveForm();
		taskVariableSaveForm.setBizEntityId(form.getGuaranteeId());
		taskVariableSaveForm.setVariableText(form.getApplicationAmount().toString());
		taskVariableSaveForm.setVariableName(ConditionNameType.BILLING_AMOUNT);
		taskStartForm.setTaskVariableSaveForm(taskVariableSaveForm);

		RequestResult<TaskStartForm> taskStartFormRequestResult = taskFeign.startNewTask(taskStartForm);
		if (!taskStartFormRequestResult.isSuccess()) {
			logger.error("出账申请失败,开启任务失败担保单id:" + form.getGuaranteeId());
			throw new RuntimeException("出账申请任务开启失败,请重试...");
		}

		return true;
	}

	@Transactional
	public boolean cancelApplicationBilling(IdForm form) {
		TaskModel taskModel = taskFeign.pickTaskState(form).pickBody();
		if (taskModel.getStatus() == TaskStatus.END) {
			throw new RuntimeException("该流程已审批通过，不能撤销”");
		}
		RequestResult<Boolean> booleanRequestResult = taskFeign.cancelTask(form);
		if (!booleanRequestResult.isSuccess()) {
			logger.error("任务撤回执行失败...申请表id为" + form.getId());
			throw new RuntimeException("任务撤回执行失败,请稍后再试");
		}

		return twiceRepayDao.updateCancelState(form.getId()) > 0;
	}

	public TwiceApplicationRecordModel queryApplicationBilling(GuaranteeIdPageForm form) {
		TwiceApplicationRecordModel twiceBillingRecordModel = TwiceApplicationRecordModel.newTwiceApplicationRecordModel();
		var page = new Pagination<TwiceApplicationModel>(form.getPageSize(), form.getCurrentPage());
		// 分页查询
		twiceRepayDao.queryApplicationBilling(page, form);
		twiceBillingRecordModel.setModel(page);

		//获取到账金额
		List<TwiceApplicationRecordModel> twiceBillingRecordModels = twiceRepayDao.selectArrivalAmount(form.getGuaranteeId());

//		twiceBillingRecordModels.forEach(amount -> {
//			totalArrivalAmount.add(amount.getArrivalAmount());
//			totalApplicationAmount.add(amount.getApplicationAmount());
//		});
		BigDecimal totalArrivalAmount = twiceBillingRecordModels.stream().map(TwiceApplicationRecordModel::getArrivalAmount)
				.reduce(BigDecimal::add).get();
		BigDecimal totalApplicationAmount = twiceBillingRecordModels.stream().map(TwiceApplicationRecordModel::getApplicationAmount)
				.reduce(BigDecimal::add).get();

		BigDecimal surplusApplicationAmount = totalArrivalAmount.subtract(totalApplicationAmount);
		twiceBillingRecordModel.setTotalArrivalAmount(totalArrivalAmount);
		twiceBillingRecordModel.setTotalApplicationAmount(totalApplicationAmount);
		twiceBillingRecordModel.setSurplusApplicationAmount(surplusApplicationAmount);
		return twiceBillingRecordModel;
	}

	public TwiceApplicationModel pickApplicationBilling(IdForm form) {
		return twiceRepayDao.selectApplicationBilling(form.getId());
	}

	/************************************二次出账**********************************************************************/

	/**
	 * 分页
	 * @param form
	 * @return
	 */
	public Pagination<TwiceRepayBillingPageModel> twiceRepayBillingPage(TwiceRepayPageQueryForm form) {
		var page = new Pagination<TwiceRepayBillingPageModel>(form.getPageSize(), form.getCurrentPage());

		form.setStateInt(5);
		twiceRepayDao.queryTwiceRepayBillingPage(page, form);

		return page;
	}

	/**
	 * 出账查看
	 * @param form
	 */
	public TwiceBillingModel pickTwiceBilling(IdForm form) {
		TwiceBillingModel twiceBillingModel = twiceRepayDao.pickTwiceBilling(form.getId());

		List<TwiceApplicationRecordModel> twiceApplicationRecordModels = twiceRepayDao.selectArrivalAmount(twiceBillingModel.getGuaranteeId());
//		twiceApplicationRecordModels.forEach(twiceApplicationRecordModel -> {
//			// 总申请金额
//			totalApplicationAmount.add(twiceApplicationRecordModel.getApplicationAmount());
//			// 总到账
//			totalArrivalAmount.add(twiceApplicationRecordModel.getArrivalAmount());
//			// 总出账
//			totalBillingAmount.add(twiceApplicationRecordModel.getTwiceBillingAmount());
//		});
		// 总申请金额
		BigDecimal totalApplicationAmount = twiceApplicationRecordModels.stream().map(TwiceApplicationRecordModel::getApplicationAmount)
				.reduce(BigDecimal::add).get();
		// 总到账
		BigDecimal totalArrivalAmount = twiceApplicationRecordModels.stream().map(TwiceApplicationRecordModel::getArrivalAmount)
				.reduce(BigDecimal::add).get();
		// 总出账
		BigDecimal totalBillingAmount = twiceApplicationRecordModels.stream().map(TwiceApplicationRecordModel::getTwiceBillingAmount)
				.reduce(BigDecimal::add).get();

		// 申请金额
		twiceBillingModel.setApplicationAmount(totalApplicationAmount);
		// 总到账
		twiceBillingModel.setTotalArrivalAmount(totalArrivalAmount);
		// 总出账
		twiceBillingModel.setTotalBillingAmount(totalBillingAmount);
		// 剩余可出账
		twiceBillingModel.setSurplusBillingAmount(totalArrivalAmount.subtract(totalBillingAmount));

		return twiceBillingModel;
	}

	@Transactional
	public TwiceBillingSaveForm saveTwiceBilling(TwiceBillingSaveForm form) {
		// 查出账申请的记录
		form.setId(UUID.randomUUID().toString());
		twiceRepayDao.saveTwiceBilling(form);
		return form;
	}

	/**
	 * 出账确认
	 * @param form
	 * @return
	 */
	@Transactional
	public boolean confirmTwiceBilling(GuaranteeIdOperaForm form) {
		// 计算二次出账合计金额
		List<BigDecimal> twiceBillings = twiceRepayDao.selectTwiceArrivalMoney(form.getGuaranteeId());
		BigDecimal twiceBillingTotal = new BigDecimal(0);
		twiceBillings.forEach(twiceBilling -> twiceBillingTotal.add(twiceBilling));

		TwiceRepayHistorySaveForm twiceRepayHistorySaveForm = WrapDozerUtil.map(form, TwiceRepayHistorySaveForm.class);
		twiceRepayHistorySaveForm.setOperateName(OperateNameEnum.TWICE_BILLING.getDesc());
		twiceRepayHistorySaveForm.setOperateContent(messageFormat(OperateStateContentEnum.TWICE_BILLING_CONTENT.getContent(), twiceBillingTotal));
		twiceRepayHistorySaveForm.setOperateState(OperateStateContentEnum.TWICE_BILLING_CONTENT.getState());
		twiceRepayHistorySaveForm.setGuaranteeId(form.getGuaranteeId());
		insertTwiceRepayHistory(twiceRepayHistorySaveForm);

		TwiceRepayStateForm twiceRepayStateForm = TwiceRepayStateForm.newTwiceRepayStateForm();
		twiceRepayStateForm.setId(form.getGuaranteeId());
		twiceRepayStateForm.setTwiceRepayState(5);
		twiceRepayStateForm.setTwiceBillingTotal(twiceBillingTotal);
		twiceRepayStateForm.setTwiceBillingDate(new Date());
		return twiceRepayDao.updateTwiceRepayState(twiceRepayStateForm) > 0;
	}

	/************************************二次赎楼- 还款**********************************************************************/
	/**
	 * 分页
	 * @param form
	 * @return
	 */
	public Pagination<TwiceRepayRedeemPageModel> twiceRepayRedeemPage(TwiceRepayPageQueryForm form) {
		var page = new Pagination<TwiceRepayRedeemPageModel>(form.getPageSize(), form.getCurrentPage());

		form.setStateInt(6);
		twiceRepayDao.queryTwiceRepayRedeemPage(page, form);

		return page;
	}

	/**
	 * 还款查看
	 * @param form
	 * @return
	 */
	public TwiceRedeemModel pickTwiceRedeem(IdForm form) {
		TwiceRedeemModel twiceRedeemModel = twiceRepayDao.pickTwiceRedeem(form.getId());
		// 还款合计 = 实际还贷本金+利息+罚息
		BigDecimal totalRedeem = new BigDecimal(0);
		totalRedeem = totalRedeem.add(twiceRedeemModel.getTwiceRealRepaymentFund()).add(twiceRedeemModel.getTwiceInterest()).add(twiceRedeemModel.getTwicePenaltyInterest());
		twiceRedeemModel.setTotalRedeem(totalRedeem);
		// 还款余额 = 出账金额+客户补差额-还款合计
		BigDecimal redeemBalance = new BigDecimal(0);
		redeemBalance = redeemBalance.add(twiceRedeemModel.getTwiceBillingAmount()).add(twiceRedeemModel.getTwiceCustomerReplenishment()).subtract(totalRedeem);
		twiceRedeemModel.setRedeemBalance(redeemBalance);
		return twiceRedeemModel;
	}

	/**
	 * 还款
	 * @param form
	 * @return
	 */
	@Transactional
	public boolean confirmTwiceRedeem(TwiceRedeemSaveForm form) {
		//赎楼合计 = 实际还贷本金+利息+罚息
		BigDecimal $0 = new BigDecimal(0);
		$0 = $0.add(form.getTwiceRealRepaymentFund()).add(form.getTwiceInterest()).add(form.getTwicePenaltyInterest());

		// 计算二次出账合计金额
		List<BigDecimal> twiceBillings = twiceRepayDao.selectTwiceArrivalMoney(form.getGuaranteeId());
		BigDecimal twiceBillingTotal = twiceBillings.stream().reduce(BigDecimal :: add).get();

		//赎楼余额 = 出账金额+客户补差额-赎楼合计
		BigDecimal $1 = new BigDecimal(0);
		$1 = $1.add(twiceBillingTotal).add(form.getTwiceCustomerReplenishment()).subtract($0);

		if (StringUtils.isNotEmpty(form.getId())) { //修改

			String balanceConfirmState = twiceRepayDao.selectRedeemState(form.getId());
			if (!balanceConfirmState.equals(CommonConstants.NO)) {
				throw new RuntimeException("余款处于已确认状态, 不可编辑,请刷新...");
			}

			TwiceRepayHistorySaveForm twiceRepayHistorySaveForm = WrapDozerUtil.map(form, TwiceRepayHistorySaveForm.class);
			twiceRepayHistorySaveForm.setOperateName(OperateNameEnum.TWICE_REDEEM_EDIT.getDesc());
			twiceRepayHistorySaveForm.setOperateContent(messageFormat(OperateStateContentEnum.TWICE_EDIT_REDEEM_CONTENT.getContent(), $0, $1));
			twiceRepayHistorySaveForm.setOperateState(OperateStateContentEnum.TWICE_EDIT_REDEEM_CONTENT.getState());
			twiceRepayHistorySaveForm.setGuaranteeId(form.getGuaranteeId());
			insertTwiceRepayHistory(twiceRepayHistorySaveForm);

			return twiceRepayDao.updateTwiceRedeem(form) > 0;
		} else { //新增
			boolean noAllRepay = true;
			List<TwiceRepayRedeemInnerPageModel> twiceRepayRedeemInnerPageModelList = twiceRepayDao.queryTwiceRepayRedeem(form.getGuaranteeId());
			for (TwiceRepayRedeemInnerPageModel twiceRepayRedeemInnerPageModel : twiceRepayRedeemInnerPageModelList) {
				if (!Optional.ofNullable(twiceRepayRedeemInnerPageModel.getPerRedeemState()).orElse("").equals(CommonConstants.YES)) {
					noAllRepay = false;
					break;
				}
			}
			if (noAllRepay) { //全部每笔还款后修改状态为 -> 全部还款
				TwiceRepayStateForm twiceRepayStateForm = TwiceRepayStateForm.newTwiceRepayStateForm();
				twiceRepayStateForm.setId(form.getGuaranteeId());
				twiceRepayStateForm.setTwiceRepayState(6);
				int row = twiceRepayDao.updateTwiceRepayState(twiceRepayStateForm);
				if (row <= 0) {
					throw new RuntimeException("二次赎楼修改失败,请重试...");
				}
			}

			TwiceRepayHistorySaveForm twiceRepayHistorySaveForm = WrapDozerUtil.map(form, TwiceRepayHistorySaveForm.class);
			twiceRepayHistorySaveForm.setOperateName(OperateNameEnum.TWICE_REDEEM.getDesc());
			twiceRepayHistorySaveForm.setOperateContent(messageFormat(OperateStateContentEnum.TWICE_REDEEM_CONTENT.getContent(), $0, $1));
			twiceRepayHistorySaveForm.setOperateState(OperateStateContentEnum.TWICE_REDEEM_CONTENT.getState());
			insertTwiceRepayHistory(twiceRepayHistorySaveForm);

			form.setId(UUID.randomUUID().toString());
			return twiceRepayDao.insertTwiceRedeem(form) > 0;
		}
	}

	/**
	 * 余款确认
	 * @param form
	 * @return
	 */
	@Transactional
	public boolean confirmBalance(BalanceConfirmForm form) {
		TwiceRepayHistorySaveForm twiceRepayHistorySaveForm = WrapDozerUtil.map(form, TwiceRepayHistorySaveForm.class);
		twiceRepayHistorySaveForm.setOperateName(OperateNameEnum.TWICE_REDEEM_CONFIRM_BALANCE.getDesc());
		twiceRepayHistorySaveForm.setOperateContent(messageFormat(OperateStateContentEnum.TWICE_CONFIRM_BALANCE_CONTENT.getContent()));
		twiceRepayHistorySaveForm.setOperateState(OperateStateContentEnum.TWICE_CONFIRM_BALANCE_CONTENT.getState());
		twiceRepayHistorySaveForm.setGuaranteeId(form.getGuaranteeId());
		insertTwiceRepayHistory(twiceRepayHistorySaveForm);

		return twiceRepayDao.updateRedeemState(form) > 0;
	}
	/************************************日志查看**********************************************************************/
	public TwiceRepayHistoryModel pickTwiceRepayHistory(GuaranteeUnIdForm form) {
		// 操作日志 + 第二次赎楼
		TwiceRepayHistoryModel twiceRepayHistoryModel = twiceRepayDao.selectTwiceRepayHistory(form.getGuaranteeId());

		// 第一次赎楼
		IdForm idForm = new IdForm();
		idForm.setId(form.getGuaranteeId());
		FirstBillingGeneralForm firstBillingGeneralForm = financeFeign.firstBillingGeneral(idForm).pickBody();
		twiceRepayHistoryModel.setFirstArrival(firstBillingGeneralForm.getTotalArrivalAmount());
		twiceRepayHistoryModel.setFirstBalance(firstBillingGeneralForm.getRefundTailAmount());
		twiceRepayHistoryModel.setFirstRedeem(firstBillingGeneralForm.getTotalRedeemAmount());

		return twiceRepayHistoryModel;
	}

	private void insertTwiceRepayHistory(TwiceRepayHistorySaveForm form) {
		form.setId(UUID.randomUUID().toString());
		int row = twiceRepayDao.insertTwiceRepayHistory(form);
		if (row <= 0) {
			throw new RuntimeException("二次还款历史记录添加失败");
		}
	}

	private String messageFormat(String pattern, Object... arguments) {
		return MessageFormat.format(pattern, arguments);
	}
}
