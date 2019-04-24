package yhao.micro.web.surety.controller.security.business;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.twiceRepay.*;
import yhao.micro.service.surety.business.apilist.model.twiceRepay.*;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.TwiceRepayRemote;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2019/2/20 14:49
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/guarantee", produces = {"application/json;charset=UTF-8"})
@Api(value = "TwiceRepayController", tags = "担保业务-二次还款")
public class TwiceRepayController extends WebBaseController {
	@Resource
	private TwiceRepayRemote twiceRepayRemote;

	/************************************客户经理发起**********************************************************************/
	@GetMapping("/twiceRepayStartPage")
	@ApiOperation(value = "客户经理分页查询")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceRepayStartPageModel.class, message = "客户经理分页查询")
	})
	public String twiceRepayStartPage(TwiceRepayPageQueryForm form) {
		Pagination<TwiceRepayStartPageModel> page = twiceRepayRemote.twiceRepayStartPage(form);
		Object object = JSON.toJSON(page);
		return returnSuccessInfo(object);
	}

	@PostMapping("/twiceRepayStart")
	@ApiOperation(value = "客户经理发起")
	public String twiceRepayStart(@RequestBody GuaranteeIdForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		form.setOperatorName(getCurrentPerson().getName());
		return returnSuccessInfo(twiceRepayRemote.twiceRepayStart(form));
	}

	/************************************要件员**********************************************************************/
	@GetMapping("/twiceRepayConfirmPage")
	@ApiOperation(value = "要件员分页查询")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceRepayConfirmPageModel.class, message = "要件员分页查询")
	})
	public String twiceRepayConfirmPage(TwiceRepayPageQueryForm form) {
		Pagination<TwiceRepayConfirmPageModel> page = twiceRepayRemote.twiceRepayConfirmPage(form);
		Object object = JSON.toJSON(page);
		return returnSuccessInfo(object);
	}

	/**
	 * 要件员确认
	 * @param form
	 * @return
	 */
	@PostMapping("/requisitesConfirm")
	@ApiOperation(value = "要件员确认")
	public String requisitesConfirm(@RequestBody RequisitesConfirmForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		form.setOperatorName(getCurrentPerson().getName());
		return returnSuccessInfo(twiceRepayRemote.requisitesConfirm(form));
	}

	/************************************二次到账**********************************************************************/
	@GetMapping("/twiceRepayArrivalPage")
	@ApiOperation(value = "二次到账分页查询")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceRepayArrivalPageModel.class, message = "二次到账分页查询")
	})
	public String twiceRepayArrivalPage(TwiceRepayPageQueryForm form) {
		Pagination<TwiceRepayArrivalPageModel> page = twiceRepayRemote.twiceRepayArrivalPage(form);
		Object object = JSON.toJSON(page);
		return returnSuccessInfo(object);
	}

	/**
	 * 新增到账/编辑到账
	 * @param form
	 * @return
	 */
	@PostMapping("/twiceArrival")
	@ApiOperation(value = "二次到账新增/编辑")
	public String twiceArrival(@RequestBody TwiceArrivalSaveForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		return returnSuccessInfo(twiceRepayRemote.twiceArrival(form));
	}

	/**
	 * 删除二次到账
	 * @param form
	 * @return
	 */
	@PostMapping("/deleteTwiceArrival")
	@ApiOperation(value = "删除二次到账")
	public String deleteTwiceArrival(@RequestBody IdForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		return returnSuccessInfo(twiceRepayRemote.deleteTwiceArrival(form));
	}

	/**
	 * 查看到账按钮分页
	 * @param form details表id, 非担保单id
	 * @return
	 */
	@GetMapping("/queryTwiceArrivalPage")
	@ApiOperation(value = "查看到账按钮分页")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceArrivalModel.class, message = "查看到账按钮分页")
	})
	public String queryTwiceArrivalPage(TwiceArrivalIdPageForm form) {
		return returnSuccessInfo(twiceRepayRemote.queryTwiceArrivalPage(form));
	}

	/**
	 * 到账确认
	 * @param form
	 * @return
	 */
	@PostMapping("/confirmTwiceArrival")
	@ApiOperation(value = "到账确认")
	public String confirmTwiceArrival(@RequestBody GuaranteeIdForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		form.setOperatorName(getCurrentPerson().getName());
		return returnSuccessInfo(twiceRepayRemote.confirmTwiceArrival(form));
	}

	/************************************出账申请**********************************************************************/
	@GetMapping("/twiceRepayApplyPage")
	@ApiOperation(value = "出账申请分页查询")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceRepayApplyPageModel.class, message = "出账申请分页查询")
	})
	public String twiceRepayApplyPage(TwiceRepayPageQueryForm form) {
		Pagination<TwiceRepayApplyPageModel> page = twiceRepayRemote.twiceRepayApplyPage(form);
		Object object = JSON.toJSON(page);
		return returnSuccessInfo(object);
	}

	/**
	 * 申请出账
	 * @param form
	 * @return
	 */
	@PostMapping("/applicationBilling")
	@ApiOperation(value = "申请出账")
	public String applicationBilling(@RequestBody ApplicationBillingSaveForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		form.setOperatorName(getCurrentPerson().getName());
		return returnSuccessInfo(twiceRepayRemote.applicationBilling(form));
	}

	/**
	 * 撤销申请出账
	 * @param form
	 * @return
	 */
	@PostMapping("/cancelApplicationBilling")
	@ApiOperation(value = "撤销申请出账")
	public String cancelApplicationBilling(@RequestBody IdForm form) {
		return returnSuccessInfo(twiceRepayRemote.cancelApplicationBilling(form));
	}

	/**
	 * 查看申请记录
	 *
	 * @param form 担保单id
	 * @return
	 */
	@GetMapping("/queryApplicationBilling")
	@ApiOperation(value = "查看申请记录")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceApplicationRecordModel.class, message = "查看申请记录")
	})
	public String queryApplicationBilling(GuaranteeIdPageForm form) {
		TwiceApplicationRecordModel page = twiceRepayRemote.queryApplicationBilling(form);
		Object object = JSON.toJSON(page);
		return returnSuccessInfo(object);
	}

	/**
	 * 申请记录单个查看
	 * @param form
	 * @return
	 */
	@GetMapping("/pickApplicationBilling")
	@ApiOperation(value = "申请记录单个查看")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceApplicationModel.class, message = "申请记录单个查看")
	})
	public String pickApplicationBilling(IdForm form) {
		return returnSuccessInfo(twiceRepayRemote.pickApplicationBilling(form));
	}

	/************************************二次出账**********************************************************************/
	@GetMapping("/twiceRepayBillingPage")
	@ApiOperation(value = "二次出账分页查询")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceRepayBillingPageModel.class, message = "二次出账分页查询")
	})
	public String twiceRepayBillingPage(TwiceRepayPageQueryForm form) {
		Pagination<TwiceRepayBillingPageModel> page = twiceRepayRemote.twiceRepayBillingPage(form);
		Object object = JSON.toJSON(page);
		return returnSuccessInfo(object);
	}

	/**
	 * 二次出账分页查询
	 * @param form
	 * @return
	 */
	@Deprecated
	@GetMapping("/queryTwiceBillingPage")
	@ApiOperation(value = "出账分页")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceBillingModel.class, message = "出账分页信息")
	})
	public String queryTwiceBillingPage(TwiceBillingPageQueryForm form) {
		return returnSuccessInfo(twiceRepayRemote.queryTwiceBillingPage(form));
	}

	/**
	 * 出账查看
	 * @param form
	 * @return
	 */
	@GetMapping("/pickTwiceBilling")
	@ApiOperation(value = "出账查看")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceBillingModel.class, message = "出账查看")
	})
	public String pickTwiceBilling(IdForm form) {
		return returnSuccessInfo(twiceRepayRemote.pickTwiceBilling(form));
	}


	/**
	 * 二次出账
	 * @param form
	 * @return
	 */
	@PostMapping("/saveTwiceBilling")
	@ApiOperation(value = "二次出账")
	public String saveTwiceBilling(@RequestBody TwiceBillingSaveForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		return returnSuccessInfo(twiceRepayRemote.saveTwiceBilling(form));
	}

	/**
	 * 出账确认
	 * @param form
	 * @return
	 */
	@PostMapping("/confirmTwiceBilling")
	@ApiOperation(value = "出账确认")
	public String confirmTwiceBilling(@RequestBody GuaranteeIdOperaForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		form.setOperatorName(getCurrentPerson().getName());
		return returnSuccessInfo(twiceRepayRemote.confirmTwiceBilling(form));
	}

	/************************************二次赎楼**********************************************************************/
	@GetMapping("/twiceRepayRedeemPage")
	@ApiOperation(value = "二次赎楼分页查询")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceRepayRedeemPageModel.class, message = "二次赎楼分页查询")
	})
	public String twiceRepayRedeemPage(TwiceRepayPageQueryForm form) {
		Pagination<TwiceRepayRedeemPageModel> page = twiceRepayRemote.twiceRepayRedeemPage(form);
		Object object = JSON.toJSON(page);
		return returnSuccessInfo(object);
	}


	/**
	 * 还款查看
	 * @param form
	 * @return
	 */
	@GetMapping("/pickTwiceRedeem")
	@ApiOperation(value = "还款查看")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceRedeemModel.class, message = "还款查看")
	})
	public String pickTwiceRedeem(IdForm form) {
		return returnSuccessInfo(twiceRepayRemote.pickTwiceRedeem(form));
	}

	/**
	 * 还款新增或编辑(只有余款确认状态为NO时才能编辑) id传还款分页中twiceRepayRedeemInnerPageModelList 查出来的id,也就是FFINANCE_BILLING_ID
	 * @param form
	 * @return
	 */
	@PostMapping("/confirmTwiceRedeem")
	@ApiOperation(value = "还款新增或编辑")
	public String confirmTwiceRedeem(@RequestBody TwiceRedeemSaveForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		form.setOperatorName(getCurrentPerson().getName());
		return returnSuccessInfo(twiceRepayRemote.confirmTwiceRedeem(form));
	}

	/**
	 * 余款确认
	 * @param form
	 * @return
	 */
	@PostMapping("/confirmBalance")
	@ApiOperation(value = "余款确认")
	public String confirmBalance(@RequestBody BalanceConfirmForm form) {
		form.setOperatorId(getCurrentPerson().getId());
		form.setOperatorName(getCurrentPerson().getName());
		return returnSuccessInfo(twiceRepayRemote.confirmBalance(form));
	}

	/************************************日志查看**********************************************************************/
	/**
	 * @return
	 */
	@GetMapping("/pickTwiceRepayHistory")
	@ApiOperation(value = "日志查看")
	@ApiResponses({
			@ApiResponse(code = 200, response = TwiceRepayHistoryModel.class, message = "日志查看")
	})
	public String pickTwiceRepayHistory(GuaranteeUnIdForm form) {
		return returnSuccessInfo(twiceRepayRemote.pickTwiceRepayHistory(form));
	}
}
