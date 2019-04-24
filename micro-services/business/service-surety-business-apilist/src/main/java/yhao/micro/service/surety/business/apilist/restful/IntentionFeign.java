package yhao.micro.service.surety.business.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.intention.*;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionModel;
import yhao.micro.service.surety.business.apilist.model.intention.credit.CreditModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayPageModel;

/**
 * @author ql
 * @date 2018-12-7 17:07:56
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface IntentionFeign {

    @RequestMapping(value = "/business/intention/saveIntention",method = RequestMethod.POST)
    RequestResult<IntentionForm> saveIntention(IntentionForm form);

    @PostMapping("/business/intention/updateIntention")
    RequestResult<IntentionForm> updateIntention(IntentionForm form);

    @PostMapping("/business/intention/deleteIntention")
    RequestResult<Boolean> deleteIntention(IdForm form);

    @RequestMapping(value = "/business/intention/intentionPick",method = RequestMethod.POST)
    RequestResult<IntentionModel> intentionPick(IdForm form);

    @PostMapping("/business/intention/intentionPage")
    RequestResult<Pagination<IntentionPageModel>> intentionPage(IntentionQueryForm form);

    /**
     * 转交保单,更改单据状态
     * @param form
     * @return
     */
    @RequestMapping(value = "/business/intention/updateIntentionState",method = RequestMethod.POST)
    RequestResult updateIntentionState(IntentionStateUpdateForm form);

    /*****************************************跟单*****************************************************/
    @RequestMapping(value = "/business/intention/followPage",method = RequestMethod.POST)
    RequestResult<Pagination<FollowerPageModel>> followPage(IntentionQueryForm form);

    @PostMapping("/business/intention/followIntention")
    RequestResult<Boolean> followIntention(FollowerUpdateForm form);

    @PostMapping("/business/intention/followerPick")
    RequestResult<FollowerModel> followerPick(IdForm form);

    /*****************************************征信*****************************************************/
    @RequestMapping(value = "/business/intention/creditDeal",method = RequestMethod.POST)
    RequestResult<Boolean> creditDeal(CreditClerkSaveForm form);

    @RequestMapping(value = "/business/intention/creditPick",method = RequestMethod.POST)
    RequestResult<CreditModel> creditPick(IdForm form);

    @RequestMapping(value = "/business/intention/creditPage",method = RequestMethod.POST)
    RequestResult<Pagination<CreditModel>> creditPage(IntentionQueryForm form);

    /*****************************************还款申请*****************************************************/
    @PostMapping("/business/intention/repayDeal")
    RequestResult<Boolean> repayDeal(IntentionRepaySaveForm form);

    @PostMapping("/business/intention/repayPick")
    RequestResult<RepayModel> repayPick(IdForm form);

    @PostMapping("/business/intention/repayPage")
    RequestResult<Pagination<RepayPageModel>> repayPage(IntentionQueryForm form);
}
