package yhao.micro.service.surety.business.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.redemption.*;
import yhao.micro.service.surety.business.apilist.model.redemption.BillingApplyModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RedeemModel;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/2/14 17:28
 * @Description:赎楼相关接口
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface RedeemFeign {
    @RequestMapping(value = "/redemption/billingApply", method = RequestMethod.POST)
    RequestResult<Boolean> billingApply(BillingApplySaveForm form);

    @RequestMapping(value = "/redemption/pickBillingApplyDetail", method = RequestMethod.POST)
    RequestResult<BillingApplyModel> pickBillingApplyDetail(IdForm form);

    @RequestMapping(value = "/redemption/queryRedeemAfter", method = RequestMethod.POST)
    RequestResult<Pagination<RDTAfterFollowQueryResultForm>> queryRedeemAfter(RDTAfterFollowQueryForm form);

    @RequestMapping(value = "/redemption/redemptionAfterSave", method = RequestMethod.POST)
    RequestResult<Boolean> redemptionAfterSave(RedeemAfterSaveForm form);

    @RequestMapping(value = "/redemption/queryRedemptionManager", method = RequestMethod.POST)
    RequestResult<Pagination<RedemptionQueryResultForm>> queryRedemptionManager(RedemptionQueryForm form);

    @RequestMapping(value = "/redemption/billingApplyRefund", method = RequestMethod.POST)
    RequestResult<Boolean> billingApplyRefund(IdForm form);

    @RequestMapping(value = "/redemption/queryRedeemRecord", method = RequestMethod.POST)
    RequestResult<List<RedeemModel>> queryRedeemRecord(IdForm form);
}
