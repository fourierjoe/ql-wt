package yhao.micro.service.surety.business.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.complex.*;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/5 16:52
 * @Description:
 */
@FeignClient(ZoneConstants.FEIGN_URL)
public interface ComplexFeign {
    @RequestMapping(value = "/complex/queryRedemptionEnsure", method = RequestMethod.POST)
    RequestResult<Pagination<EnsureQueryResultForm>> queryRedemptionEnsure(EnsureQueryForm form);

    @RequestMapping(value = "/complex/redemptionEnsureSave", method = RequestMethod.POST)
    RequestResult<Boolean> redemptionEnsureSave(EnsureSaveForm form);

    @RequestMapping(value = "/complex/queryEssentials", method = RequestMethod.POST)
    RequestResult<Pagination<EssentialsQueryResultForm>> queryEssentials(EssentialsQueryForm form);

    @RequestMapping(value = "/complex/essentialsLendApply", method = RequestMethod.POST)
    RequestResult<Boolean> essentialsLendApply(EssentialsLendApplySaveForm form);

    @RequestMapping(value = "/complex/essentialsRemandApply", method = RequestMethod.POST)
    RequestResult<Boolean> essentialsRemandApply(EssentialsRemandApplySaveForm form);

    @RequestMapping(value = "/complex/confirmLendOrRemand", method = RequestMethod.POST)
    RequestResult<Boolean> confirmLendOrRemand(EssentialsLendSaveForm form);

    @RequestMapping(value = "/complex/essentialsLendDetail", method = RequestMethod.POST)
    RequestResult<MaterialLendModel> essentialsLendDetail(@RequestBody IdForm form);

    @RequestMapping(value = "/complex/essentialsRemandDetail", method = RequestMethod.POST)
    RequestResult<MaterialRemandModel> essentialsRemandDetail(@RequestBody IdForm form);

    @RequestMapping(value = "/complex/redeemOrderSave", method = RequestMethod.POST)
    RequestResult<Boolean> redeemOrderSave(@RequestBody IdForm form);

    @RequestMapping(value = "/complex/redeemOrderUpdate", method = RequestMethod.POST)
    RequestResult<Boolean> redeemOrderUpdate(@RequestBody OrderSaveForm form);

    @RequestMapping(value = "/complex/billingCheckSave", method = RequestMethod.POST)
    RequestResult<Boolean> billingCheckSave(@RequestBody BilingCheckSaveForm form);

    @RequestMapping(value = "/complex/billingCheckQueryResultSave", method = RequestMethod.POST)
    RequestResult<Boolean> billingCheckQueryResultSave(@RequestBody BillingQueryFileSaveForm form);

    @RequestMapping(value = "/complex/billingCheckDetail")
    RequestResult<BillingCheckDetailForm> billingCheckDetail(@RequestBody IdForm form);

    @RequestMapping(value = "/complex/queryFileRecord")
    RequestResult<List<BillingQueryFileRecordModel>> queryFileRecord(@RequestBody IdForm form);

    @RequestMapping(value = "/complex/unProtectedSave")
    RequestResult<Boolean> unProtectedSave(@RequestBody UnProtectedSaveForm form);

    @RequestMapping(value = "/complex/queryUnprotected")
    RequestResult<Pagination<UnProtectedQueryResultForm>> queryUnProtected(UnprotectedQueryForm form);
    @RequestMapping(value = "/complex/redemptionOrderApply")
    RequestResult<Boolean> redemptionOrderApply(@RequestBody OrderApplySaveForm form);

    @RequestMapping(value = "/complex/queryRedemptionOrder")
    RequestResult<Pagination<OrderQueryResultForm>> queryRedemptionOrder(OrderQueryForm form);
}
