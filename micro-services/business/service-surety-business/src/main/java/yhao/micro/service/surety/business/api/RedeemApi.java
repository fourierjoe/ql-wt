package yhao.micro.service.surety.business.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.finance.FinanceArrivalBillingQueryForm;
import yhao.micro.service.surety.business.apilist.form.finance.FinanceArrivalBillingQueryResultForm;
import yhao.micro.service.surety.business.apilist.form.redemption.*;
import yhao.micro.service.surety.business.apilist.model.redemption.BillingApplyModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RedeemModel;
import yhao.micro.service.surety.business.service.RedeemAfterService;
import yhao.micro.service.surety.business.service.RedeemService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/14 17:38
 * @Description:赎楼相关接口
 */
@RestController
@RequestMapping(value = "/redemption")
public class RedeemApi {

    @Resource
    private RedeemService redeemService;
    @Resource
    private RedeemAfterService redeemAfterService;

    @PostMapping(value = "/billingApply")
    RequestResult<Boolean> billingApply(@RequestBody BillingApplySaveForm form){
        return new RequestResult<>(redeemService.billingApply(form));
    }

    @PostMapping(value = "/pickBillingApplyDetail")
    RequestResult<BillingApplyModel> pickBillingApplyDetail(@RequestBody IdForm form){
        return new RequestResult<>(redeemService.pickBillingApplyDetail(form));
    }


    @PostMapping(value = "/queryRedeemAfter")
    RequestResult<Pagination<RDTAfterFollowQueryResultForm>> queryRedeemAfter(@RequestBody RDTAfterFollowQueryForm form){
        return new RequestResult<>(redeemAfterService.queryRedeemAfter(form));
    }

    @PostMapping(value = "/redemptionAfterSave")
    RequestResult<Boolean> redemptionAfterSave(@RequestBody  RedeemAfterSaveForm form){
        return new RequestResult<>(redeemAfterService.redemptionAfterSave(form));
    }


    @PostMapping(value = "/queryRedemptionManager")
    RequestResult<Pagination<RedemptionQueryResultForm>> queryRedemptionManager(@RequestBody RedemptionQueryForm form){
        return new RequestResult<>(redeemService.queryRedemptionManager(form));
    }

    @PostMapping(value = "/billingApplyRefund")
    RequestResult<Boolean> billingApplyRefund(@RequestBody  IdForm form){
        return new RequestResult<>(redeemService.billingApplyRefund(form));
    }

    @PostMapping(value = "/queryRedeemRecord")
    RequestResult<List<RedeemModel>> queryRedeemRecord(@RequestBody  IdForm form){
        return new RequestResult<>(redeemService.queryRedeemRecord(form));
    }

}
