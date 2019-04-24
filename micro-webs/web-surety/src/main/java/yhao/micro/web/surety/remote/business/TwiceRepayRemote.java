package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.twiceRepay.*;
import yhao.micro.service.surety.business.apilist.model.twiceRepay.*;
import yhao.micro.service.surety.business.apilist.restful.TwiceRepayFeign;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2019/2/25 20:38
 * @Version: v1.0
 */
@Service
public class TwiceRepayRemote {
	private Logger logger = LoggerFactory.getLogger(TwiceRepayRemote.class);
	@Resource
	private TwiceRepayFeign twiceRepayFeign;


	/************************************客户经理发起**********************************************************************/
	@HystrixCommand(fallbackMethod = "twiceRepayStartPageDown")
	public Pagination<TwiceRepayStartPageModel> twiceRepayStartPage( TwiceRepayPageQueryForm form) {
		return twiceRepayFeign.twiceRepayStartPage(form).pickBody();
	}
	public Pagination<TwiceRepayStartPageModel> twiceRepayStartPageDown( TwiceRepayPageQueryForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.twiceRepayStartPage]");
		logger.error(e.getMessage(), e.getCause());
		return new Pagination<>();
	}

	@HystrixCommand
	public Boolean twiceRepayStart( GuaranteeIdForm form) {
		return twiceRepayFeign.twiceRepayStart(form).pickBody();
	}

	/************************************要件员**********************************************************************/
	@HystrixCommand(fallbackMethod = "twiceRepayConfirmPageDown")
	public Pagination<TwiceRepayConfirmPageModel> twiceRepayConfirmPage( TwiceRepayPageQueryForm form) {
		return twiceRepayFeign.twiceRepayConfirmPage(form).pickBody();
	}
	public Pagination<TwiceRepayConfirmPageModel> twiceRepayConfirmPageDown( TwiceRepayPageQueryForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.twiceRepayConfirmPage]");
		logger.error(e.getMessage(), e.getCause());
		return new Pagination<>();
	}

	/**
	 * 要件员确认
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public Boolean requisitesConfirm( RequisitesConfirmForm form) {
		return twiceRepayFeign.requisitesConfirm(form).pickBody();
	}

	/************************************二次到账**********************************************************************/
	@HystrixCommand(fallbackMethod = "twiceRepayArrivalPageDown")
	public Pagination<TwiceRepayArrivalPageModel> twiceRepayArrivalPage( TwiceRepayPageQueryForm form) {
		return twiceRepayFeign.twiceRepayArrivalPage(form).pickBody();
	}
	public Pagination<TwiceRepayArrivalPageModel> twiceRepayArrivalPageDown( TwiceRepayPageQueryForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.twiceRepayArrivalPage]");
		logger.error(e.getMessage(), e.getCause());
		return new Pagination<>();
	}

	/**
	 * 新增到账/编辑到账
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public TwiceArrivalSaveForm twiceArrival( TwiceArrivalSaveForm form) {
		return twiceRepayFeign.twiceArrival(form).pickBody();
	}

	/**
	 * 删除二次还款
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public Boolean deleteTwiceArrival( IdForm form) {
		return twiceRepayFeign.deleteTwiceArrival(form).pickBody();
	}

	/**
	 * 查看到账按钮分页
	 * @param form 担保单id
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "queryTwiceArrivalPageDown")
	public Pagination<TwiceArrivalModel> queryTwiceArrivalPage( TwiceArrivalIdPageForm form) {
		return twiceRepayFeign.queryTwiceArrivalPage(form).pickBody();
	}
	public Pagination<TwiceArrivalModel> queryTwiceArrivalPageDown( TwiceArrivalIdPageForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.queryTwiceArrivalPage]");
		logger.error(e.getMessage(), e.getCause());
		return new Pagination<>();
	}

	/**
	 * 查看到账
	 * @param form details表id, 非担保单id
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "pickTwiceArrivalDown")
	public TwiceArrivalModel pickTwiceArrival( IdForm form) {
		return twiceRepayFeign.pickTwiceArrival(form).pickBody();
	}
	public TwiceArrivalModel pickTwiceArrivalDown( IdForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.pickTwiceArrival]");
		logger.error(e.getMessage(), e.getCause());
		return new TwiceArrivalModel();
	}

	/**
	 * 到账确认
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public Boolean confirmTwiceArrival( GuaranteeIdForm form) {
		return twiceRepayFeign.confirmTwiceArrival(form).pickBody();
	}

	/************************************出账申请**********************************************************************/
	@HystrixCommand(fallbackMethod = "twiceRepayApplyPageDown")
	public Pagination<TwiceRepayApplyPageModel> twiceRepayApplyPage( TwiceRepayPageQueryForm form) {
		return twiceRepayFeign.twiceRepayApplyPage(form).pickBody();
	}
	public Pagination<TwiceRepayApplyPageModel> twiceRepayApplyPageDown( TwiceRepayPageQueryForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.twiceRepayApplyPage]");
		logger.error(e.getMessage(), e.getCause());
		return new Pagination<>();
	}

	/**
	 * 申请出账
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public Boolean applicationBilling( ApplicationBillingSaveForm form) {
		return twiceRepayFeign.applicationBilling(form).pickBody();
	}

	/**
	 * 撤销申请出账
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public Boolean cancelApplicationBilling( IdForm form) {
		return twiceRepayFeign.cancelApplicationBilling(form).pickBody();
	}

	/**
	 * 查看申请记录
	 * @param form 担保单id
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "queryApplicationBillingDown")
	public TwiceApplicationRecordModel queryApplicationBilling( GuaranteeIdPageForm form) {
		return twiceRepayFeign.queryApplicationBilling(form).pickBody();
	}
	public TwiceApplicationRecordModel queryApplicationBillingDown( GuaranteeIdPageForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.queryApplicationBilling]");
		logger.error(e.getMessage(), e.getCause());
		return new TwiceApplicationRecordModel();
	}

	/**
	 * 申请记录单个查看
	 * @param form
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "pickApplicationBillingDown")
	public TwiceApplicationModel pickApplicationBilling( IdForm form) {
		return twiceRepayFeign.pickApplicationBilling(form).pickBody();
	}
	public TwiceApplicationModel pickApplicationBillingDown( IdForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.pickApplicationBilling]");
		logger.error(e.getMessage(), e.getCause());
		return new TwiceApplicationModel();
	}

	/************************************二次出账**********************************************************************/
	@HystrixCommand(fallbackMethod = "twiceRepayBillingPageDown")
	public Pagination<TwiceRepayBillingPageModel> twiceRepayBillingPage( TwiceRepayPageQueryForm form) {
		return twiceRepayFeign.twiceRepayBillingPage(form).pickBody();
	}
	public Pagination<TwiceRepayBillingPageModel> twiceRepayBillingPageDown( TwiceRepayPageQueryForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.twiceRepayBillingPage]");
		logger.error(e.getMessage(), e.getCause());
		return new Pagination<>();
	}

	@HystrixCommand(fallbackMethod = "queryTwiceBillingPageDown")
	public TwiceBillingModel queryTwiceBillingPage(TwiceBillingPageQueryForm form) {
		return twiceRepayFeign.queryTwiceBillingPage(form).pickBody();
	}
	public TwiceBillingModel queryTwiceBillingPageDown( TwiceBillingPageQueryForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.queryTwiceBillingPage]");
		logger.error(e.getMessage(), e.getCause());
		return new TwiceBillingModel();
	}

	/**
	 * 出账查看
	 * @param form
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "pickTwiceBillingDown")
	public TwiceBillingModel pickTwiceBilling( IdForm form) {
		return twiceRepayFeign.pickTwiceBilling(form).pickBody();
	}
	public TwiceBillingModel pickTwiceBillingDown( IdForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.pickTwiceBilling]");
		logger.error(e.getMessage(), e.getCause());
		return new TwiceBillingModel();
	}

	/**
	 * 二次出账
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public TwiceBillingSaveForm saveTwiceBilling( TwiceBillingSaveForm form) {
		return twiceRepayFeign.saveTwiceBilling(form).pickBody();
	}

	/**
	 * 出账确认
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public Boolean confirmTwiceBilling( GuaranteeIdOperaForm form) {
		return twiceRepayFeign.confirmTwiceBilling(form).pickBody();
	}

	/************************************二次赎楼**********************************************************************/
	@HystrixCommand(fallbackMethod = "twiceRepayRedeemPageDown")
	public Pagination<TwiceRepayRedeemPageModel> twiceRepayRedeemPage( TwiceRepayPageQueryForm form) {
		return twiceRepayFeign.twiceRepayRedeemPage(form).pickBody();
	}
	public Pagination<TwiceRepayRedeemPageModel> twiceRepayRedeemPageDown( TwiceRepayPageQueryForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.twiceRepayBillingPage]");
		logger.error(e.getMessage(), e.getCause());
		return new Pagination<>();
	}

	/**
	 * 还款查看
	 * @param form
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "pickTwiceRedeemDown")
	public TwiceRedeemModel pickTwiceRedeem( IdForm form) {
		return twiceRepayFeign.pickTwiceRedeem(form).pickBody();
	}
	public TwiceRedeemModel pickTwiceRedeemDown( IdForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.pickTwiceRedeem]");
		logger.error(e.getMessage(), e.getCause());
		return new TwiceRedeemModel();
	}

	/**
	 * 新增或编辑(只有余款确认状态为NO时才能编辑)
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public Boolean confirmTwiceRedeem( TwiceRedeemSaveForm form) {
		return twiceRepayFeign.confirmTwiceRedeem(form).pickBody();
	}

	/**
	 * 余款确认
	 * @param form
	 * @return
	 */
	@HystrixCommand
	public Boolean confirmBalance( BalanceConfirmForm form) {
		return twiceRepayFeign.confirmBalance(form).pickBody();
	}

	/************************************日志查看**********************************************************************/
	/**
	 * @return
	 */
	@HystrixCommand(fallbackMethod = "pickTwiceRepayHistoryDown")
	public TwiceRepayHistoryModel pickTwiceRepayHistory( GuaranteeUnIdForm form) {
		return twiceRepayFeign.pickTwiceRepayHistory(form).pickBody();
	}
	public TwiceRepayHistoryModel pickTwiceRepayHistoryDown( GuaranteeUnIdForm form, Throwable e) {
		logger.error("Service Down:[TwiceRepayService.pickTwiceRepayHistory]");
		logger.error(e.getMessage(), e.getCause());
		return new TwiceRepayHistoryModel();
	}
}
