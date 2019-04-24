package yhao.micro.service.surety.business.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.twiceRepay.*;
import yhao.micro.service.surety.business.apilist.model.twiceRepay.*;
import yhao.micro.service.surety.business.service.TwiceRepayService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2019/2/20 09:31
 * @Version: v1.0
 */
@RestController
@RequestMapping(value = "/business/twice")
public class TwiceRepayApi extends RestfulBaseController {
	@Resource
	private TwiceRepayService twiceRepayService;

	/************************************客户经理发起**********************************************************************/
	/**
	 * 客户经理分页
	 * @param form
	 * @return
	 */
	@PostMapping("/twiceRepayStartPage")
	public RequestResult<Pagination<TwiceRepayStartPageModel>> twiceRepayStartPage(@RequestBody TwiceRepayPageQueryForm form) {
		return new RequestResult(twiceRepayService.twiceRepayStartPage(form));
	}


	@PostMapping("/twiceRepayStart")
	public RequestResult<Boolean> twiceRepayStart(@RequestBody GuaranteeIdForm form) {
		return new RequestResult(twiceRepayService.twiceRepayStart(form));
	}

	/************************************要件员**********************************************************************/
	/**
	 * 要件员分页
	 * @param form
	 * @return
	 */
	@PostMapping("/twiceRepayConfirmPage")
	public RequestResult<Pagination<TwiceRepayConfirmPageModel>> twiceRepayConfirmPage(@RequestBody TwiceRepayPageQueryForm form) {
		return new RequestResult(twiceRepayService.twiceRepayConfirmPage(form));
	}

	/**
	 * 要件员确认
	 * @param form
	 * @return
	 */
	@PostMapping("/requisitesConfirm")
	public RequestResult<Boolean> requisitesConfirm(@RequestBody RequisitesConfirmForm form) {
		return new RequestResult(twiceRepayService.requisitesConfirm(form));
	}

	/************************************二次到账**********************************************************************/
	/**
	 * 二次到账分页
	 * @param form
	 * @return
	 */
	@PostMapping("/twiceRepayArrivalPage")
	public RequestResult<Pagination<TwiceRepayArrivalPageModel>> twiceRepayArrivalPage(@RequestBody TwiceRepayPageQueryForm form) {
		return new RequestResult(twiceRepayService.twiceRepayArrivalPage(form));
	}
	/**
	 * 新增到账/编辑到账
	 * @param form
	 * @return
	 */
	@PostMapping("/twiceArrival")
	public RequestResult<TwiceArrivalSaveForm> twiceArrival(@RequestBody TwiceArrivalSaveForm form) {
		return new RequestResult(twiceRepayService.twiceArrival(form));
	}

	/**
	 * 删除二次到账
	 * @param form
	 * @return
	 */
	@PostMapping("/deleteTwiceArrival")
	public RequestResult<Boolean> deleteTwiceArrival(@RequestBody IdForm form) {
		return new RequestResult(twiceRepayService.deleteTwiceArrival(form));
	}

	/**
	 * 到账按钮分页
	 * @param form 担保单id
	 * @return
	 */
	@PostMapping("/queryTwiceArrivalPage")
	public RequestResult<Pagination<TwiceArrivalModel>> queryTwiceArrivalPage(@RequestBody TwiceArrivalIdPageForm form) {
		return new RequestResult(twiceRepayService.queryTwiceArrivalPage(form));
	}

	/**
	 * 到账按钮查看(失效,直接使用queryTwiceArrivalPage方法)
	 * @param form detail表id
	 * @return
	 */
	@Deprecated
	@PostMapping("/pickTwiceArrival")
	public RequestResult<TwiceArrivalModel> pickTwiceArrival(@RequestBody IdForm form) {
		return new RequestResult(twiceRepayService.pickTwiceArrival(form));
	}

	/**
	 * 到账确认
	 * @param form
	 * @return
	 */
	@PostMapping("/confirmTwiceArrival")
	public RequestResult<Boolean> confirmTwiceArrival(@RequestBody GuaranteeIdForm form) {
		return new RequestResult(twiceRepayService.confirmTwiceArrival(form));
	}

	/************************************出账申请**********************************************************************/

	/**
	 * 出账申请分页
	 * @param form
	 * @return
	 */
	@PostMapping("/twiceRepayApplyPage")
	public RequestResult<Pagination<TwiceRepayApplyPageModel>> twiceRepayApplyPage(@RequestBody TwiceRepayPageQueryForm form) {
		return new RequestResult(twiceRepayService.twiceRepayApplyPage(form));
	}

	/**
	 * 申请出账
	 * @param form
	 * @return
	 */
	@PostMapping("/applicationBilling")
	public RequestResult<Boolean> applicationBilling(@RequestBody ApplicationBillingSaveForm form) {
		return new RequestResult(twiceRepayService.applicationBilling(form));
	}

	/**
	 * 撤销申请出账
	 * @param form
	 * @return
	 */
	@PostMapping("/cancelApplicationBilling")
	public RequestResult<Boolean> cancelApplicationBilling(@RequestBody IdForm form) {
		return new RequestResult(twiceRepayService.cancelApplicationBilling(form));
	}

	/**
	 * 查看申请记录
	 * @param form 担保单id
	 * @return
	 */
	@PostMapping("/queryApplicationBilling")
	public RequestResult<TwiceApplicationRecordModel> queryApplicationBilling(@RequestBody GuaranteeIdPageForm form) {
		return new RequestResult(twiceRepayService.queryApplicationBilling(form));
	}

	/**
	 * 申请记录单个查看
	 * @param form
	 * @return
	 */
	@PostMapping("/pickApplicationBilling")
	public RequestResult<TwiceApplicationModel> pickApplicationBilling(@RequestBody IdForm form) {
		return new RequestResult(twiceRepayService.pickApplicationBilling(form));
	}

	/************************************二次出账**********************************************************************/

	/**
	 * 出账申请分页
	 * @param form
	 * @return
	 */
	@PostMapping("/twiceRepayBillingPage")
	public RequestResult<Pagination<TwiceRepayBillingPageModel>> twiceRepayBillingPage(@RequestBody TwiceRepayPageQueryForm form) {
		return new RequestResult(twiceRepayService.twiceRepayBillingPage(form));
	}

	/**
	 * 出账查看
	 * @param form
	 * @return
	 */
	@PostMapping("/pickTwiceBilling")
	public RequestResult<TwiceBillingModel> pickTwiceBilling(@RequestBody IdForm form) {
		return new RequestResult(twiceRepayService.pickTwiceBilling(form));
	}

	/**
	 * 二次出账
	 * @param form
	 * @return
	 */
	@PostMapping("/saveTwiceBilling")
	public RequestResult<TwiceBillingSaveForm> saveTwiceBilling(@RequestBody TwiceBillingSaveForm form) {
		return new RequestResult(twiceRepayService.saveTwiceBilling(form));
	}

	/**
	 * 出账确认
	 * @param form
	 * @return
	 */
	@PostMapping("/confirmTwiceBilling")
	public RequestResult<Boolean> confirmTwiceBilling(@RequestBody GuaranteeIdOperaForm form) {
		return new RequestResult(twiceRepayService.confirmTwiceBilling(form));
	}

	/************************************二次赎楼/还款**********************************************************************/
	/**
	 * 二次赎楼/还款分页
	 * @param form
	 * @return
	 */
	@PostMapping("/twiceRepayRedeemPage")
	public RequestResult<Pagination<TwiceRepayRedeemPageModel>> twiceRepayRedeemPage(@RequestBody TwiceRepayPageQueryForm form) {
		return new RequestResult(twiceRepayService.twiceRepayRedeemPage(form));
	}

	/**
	 * 还款查看 出账表id FFINANCE_BILLING_ID, twiceRepayRedeemInnerPageModelList分页出来的id
	 * @param form
	 * @return
	 */
	@PostMapping("/pickTwiceRedeem")
	public RequestResult<TwiceRedeemModel> pickTwiceRedeem(@RequestBody IdForm form) {
		return new RequestResult(twiceRepayService.pickTwiceRedeem(form));
	}

	/**
	 * 还款新增或编辑(只有余款确认状态为NO时才能编辑)
	 * @param form
	 * @return
	 */
	@PostMapping("/confirmTwiceRedeem")
	public RequestResult<Boolean> confirmTwiceRedeem(@RequestBody TwiceRedeemSaveForm form) {
		return new RequestResult(twiceRepayService.confirmTwiceRedeem(form));
	}

	/**
	 * 余款确认
	 * @param form id传还款分页中twiceRepayRedeemInnerPageModelList 查出来的id,也就是FFINANCE_BILLING_ID
	 * @return
	 */
	@PostMapping("/confirmBalance")
	public RequestResult<Boolean> confirmBalance(@RequestBody BalanceConfirmForm  form) {
		return new RequestResult(twiceRepayService.confirmBalance(form));
	}

	/************************************日志查看**********************************************************************/
	/**
	 * @return
	 */
	@PostMapping("/pickTwiceRepayHistory")
	public RequestResult<TwiceRepayHistoryModel> pickTwiceRepayHistory(@RequestBody GuaranteeUnIdForm form) {
		return new RequestResult(twiceRepayService.pickTwiceRepayHistory(form));
	}

}
