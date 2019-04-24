package yhao.micro.web.surety.controller.security.business;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.intention.*;
import yhao.micro.service.surety.business.apilist.model.intention.credit.CreditModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayPageModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.IntentionRemote;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2018/12/9 15:41
 * @Version: v1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/intention", produces = {"application/json;charset=UTF-8"})
@Api(value = "IntentionController", tags = "担保业务-意向单管理")
public class IntentionController extends WebBaseController {

    @Resource
    private IntentionRemote intentionRemote;

    @PostMapping(value = "/intention")
    @ApiOperation(value = "意向单保存")
    public String saveIntention(@RequestBody IntentionForm form) {
        return returnSuccessInfo(intentionRemote.saveIntention(form));
    }

    @PostMapping(value = "/updateIntention")
    @ApiOperation(value = "意向单修改")
    public String updateIntention(@RequestBody IntentionForm form) {
        return returnSuccessInfo(intentionRemote.updateIntention(form));
    }

    @GetMapping(value = "/intention")
    @ApiOperation(value = "意向单分页查询")
    @ApiResponses(
            @ApiResponse(code = 200, response = IntentionPageModel.class, message = "意向单分页信息")
    )
    public String intentionPage(IntentionQueryForm form) {
        var page = intentionRemote.intentionPage(form);
        Object object = JSON.toJSON(page);
        return returnSuccessInfo(object);
    }

    /**
     * 传入担保单ID
     * @param form
     * @return
     */
    @PostMapping(value = "/deleteIntention")
    @ApiOperation(value = "意向单根据担保单ID删除")
    public String deleteIntention(@RequestBody IdForm form) {
        return returnSuccessInfo(intentionRemote.deleteIntention(form));
    }

    /**
     * 通过id查询
     * @param form
     * @return
     */
    @GetMapping(value = "/intentionPick")
    @ApiOperation(value = "意向单根据意向单号查询(单个查询)")
    @ApiResponses(
            @ApiResponse(code = 200, response = IntentionModel.class, message = "意向单编辑页面信息")
    )
    public String intentionPick(IdForm form) {
        return returnSuccessInfo(intentionRemote.intentionPick(form));
    }

    /**
     * 接受/转交保单,更改单据状态  废除
     * @param form
     * @return
     */
    @Deprecated
    @PostMapping(value = "/followerUpdateIntentionState")
    @ApiOperation(value = "意向单修改单据状态")
    public String followerUpdateIntentionState(@RequestBody IntentionStateUpdateForm form) {
        return returnSuccessInfo();
    }

    /**
     * 跟单员table分页
     * @param form
     * @return
     */
    @GetMapping("/followPage")
    @ApiOperation(value = "跟单员table分页")
    @ApiResponses(
            @ApiResponse(code = 200, response = FollowerPageModel.class, message = "跟单员table分页信息")
    )
    public String followPage(IntentionQueryForm form) {
        var page = intentionRemote.followPage(form);
        Object object = JSON.toJSON(page);
        return returnSuccessInfo(object);
    }

    /**
     * 跟单员跟进
     * @param form
     * @return
     */
    @PostMapping(value = "/followIntention")
    @ApiOperation(value = "跟单员跟进")
    public String followIntention(@RequestBody FollowerUpdateForm form) {
        return returnSuccessInfo(intentionRemote.followIntention(form));
    }

    /**
     * 跟单员查看
     * @param form
     * @return
     */
    @GetMapping(value = "/followerPick")
    @ApiOperation(value = "跟单员查看")
    @ApiResponses(
            @ApiResponse(code = 200, response = FollowerModel.class, message = "跟单查看按钮页面信息")
    )
    public String followerPick(IdForm form) {
        return returnSuccessInfo(intentionRemote.followerPick(form));
    }


    /**
     * 征信table办理
     * @param form
     * @return
     */
    @PostMapping(value = "/credit")
    @ApiOperation(value = "征信办理")
    public String credit(@RequestBody CreditClerkSaveForm form) {
        intentionRemote.creditDeal(form);
        return returnSuccessInfo();
    }

    @GetMapping("/creditPick")
    @ApiOperation(value = "征信查看")
    @ApiResponses(
            @ApiResponse(code = 200, response = CreditModel.class, message = "征信查看页信息")
    )
    public String creditPick(IdForm form) {
        return returnSuccessInfo(intentionRemote.creditPick(form));
    }

    /**
     * 征信分页
     * @param form
     * @return
     */
    @GetMapping("/creditPage")
    @ApiOperation(value = "征信分页")
    @ApiResponses(
            @ApiResponse(code = 200, response = CreditModel.class, message = "征信分页信息")
    )
    public String creditPage(IntentionQueryForm form) {
        Pagination<CreditModel> page = intentionRemote.creditPage(form);
        Object object = JSON.toJSON(page);
        return returnSuccessInfo(object);
    }

    /**
     * 还款申请table办理
     * @param form
     * @return
     */
    @PostMapping(value = "/repayDeal")
    @ApiOperation(value = "还款申请办理")
    public String repayDeal(@RequestBody IntentionRepaySaveForm form) {
        return returnSuccessInfo(intentionRemote.repayDeal(form));
    }

    @GetMapping(value = "/repayPick")
    @ApiOperation(value = "还款申请查看")
    @ApiResponses(
            @ApiResponse(code = 200, response = RepayModel.class, message = "还款申请查看内容")
    )
    public String repayPick(IdForm form) {
        RepayModel repayModel = intentionRemote.repayPick(form);
        return returnSuccessInfo(repayModel);
    }

    @GetMapping(value = "/repayPage")
    @ApiOperation(value = "还款申请分页")
    @ApiResponses(
            @ApiResponse(code = 200, response = RepayPageModel.class, message = "还款申请分页内容")
    )
    public String repayPage(IntentionQueryForm form) { // hot
        Pagination<RepayPageModel> page = intentionRemote.repayPage(form);
        Object object = JSON.toJSON(page);
        return returnSuccessInfo(object);
    }
}
