package yhao.micro.service.surety.business.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.intention.*;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayModel;
import yhao.micro.service.surety.business.apilist.model.intention.credit.CreditModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayPageModel;
import yhao.micro.service.surety.business.service.IntentionService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2019/1/7 20:42
 * @Version: v1.0
 */
@RestController
@RequestMapping(value = "/business/intention")
public class IntentionApi extends RestfulBaseController {
	@Resource
	private IntentionService intentionService;

	@PostMapping("/saveIntention")
	public RequestResult<IntentionForm> saveIntention(@RequestBody IntentionForm form) {
		return new RequestResult(intentionService.saveIntention(form));
	}

	@PostMapping("/updateIntention")
	public RequestResult<IntentionForm> updateIntention(@RequestBody IntentionForm form) {
		return new RequestResult(intentionService.updateIntention(form));
	}

	@PostMapping("/deleteIntention")
	public RequestResult<Boolean> deleteIntention(@RequestBody IdForm form) {
		return new RequestResult(intentionService.deleteIntention(form));
	}

	@PostMapping("/intentionPage")
	public RequestResult<Pagination<IntentionPageModel>> intentionPage(@RequestBody IntentionQueryForm form) {
		return new RequestResult(intentionService.intentionPage(form));
	}

	@PostMapping("/intentionPick")
	public RequestResult<IntentionModel> intentionPick(@RequestBody IdForm form) {
		return new RequestResult(intentionService.intentionPick(form));
	}

	/*****************************************跟单员*****************************************************/
	/**
	 * 跟单员table分页
	 * @param form
	 * @return
	 */
	@PostMapping("/followPage")
	public RequestResult<Pagination<FollowerPageModel>> followPage(@RequestBody IntentionQueryForm form) {
		return new RequestResult(intentionService.followPage(form));
	}

	/**
	 * 跟单员跟进
	 * @param form
	 * @return
	 */
	@PostMapping("/followIntention")
	public RequestResult<Boolean> followIntention(@RequestBody FollowerUpdateForm form) {
		return new RequestResult(intentionService.followIntention(form));
	}

	/**
	 * 转交保单, 使用followIntention接口
	 * @param form
	 * @return
	 */
	@Deprecated
	@PostMapping("/transferIntention")
	public RequestResult<Boolean> followIntention(@RequestBody FollowerTransferForm form) {
		return new RequestResult(intentionService.followTransfer(form));
	}

	/**
	 * 跟单员查看按钮
	 * @param form
	 * @return
	 */
	@PostMapping("/followerPick")
	public RequestResult<FollowerModel> followerPick(@RequestBody IdForm form) {
		return new RequestResult(intentionService.followerPick(form));
	}

	/*****************************************征信*****************************************************/
	/**
	 * 征信办理按钮
	 * @param form
	 * @return
	 */
	@PostMapping("/creditDeal")
	public RequestResult<Boolean> creditDeal(@RequestBody CreditClerkSaveForm form) {
		return new RequestResult(intentionService.creditDeal(form));
	}

	/**
	 * 征信查看
	 * @param form
	 * @return
	 */
	@PostMapping("/creditPick")
	public RequestResult<CreditModel> creditPick(@RequestBody IdForm form) {
		return new RequestResult(intentionService.creditPick(form));
	}

	@PostMapping("/creditPage")
	public RequestResult<Pagination<CreditModel>> creditPage(@RequestBody IntentionQueryForm form) {
		return new RequestResult(intentionService.creditPage(form));
	}

	/*****************************************还款申请*****************************************************/
	@PostMapping("/repayDeal")
	public RequestResult<Boolean> repayDeal(@RequestBody IntentionRepaySaveForm form) {
		return new RequestResult(intentionService.repayDeal(form));
	}

	@PostMapping("/repayPick")
	public RequestResult<RepayModel> repayPick(@RequestBody IdForm form) {
		return new RequestResult(intentionService.repayPick(form));
	}

	@PostMapping("/repayPage")
	public RequestResult<Pagination<RepayPageModel>> repayPage(@RequestBody IntentionQueryForm form) {
		return new RequestResult(intentionService.repayPage(form));
	}
}
