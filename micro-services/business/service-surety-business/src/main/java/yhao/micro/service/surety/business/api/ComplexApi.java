package yhao.micro.service.surety.business.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.complex.BillingQueryFileRecordModel;
import yhao.micro.service.surety.business.apilist.model.complex.MaterialLendModel;
import yhao.micro.service.surety.business.apilist.model.complex.MaterialRemandModel;
import yhao.micro.service.surety.business.service.ComplexService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/18 19:36
 * @Description:
 */
@RestController
@RequestMapping(value = "/complex")
public class ComplexApi extends RestfulBaseController {
    @Resource
    private ComplexService complexService;

    @PostMapping("/queryRedemptionEnsure")
    public RequestResult<Pagination<EnsureQueryResultForm>> queryPersonPage(@RequestBody EnsureQueryForm form) {
        return new RequestResult<>(complexService.queryRedemptionEnsure(form));
    }
    @PostMapping("/redemptionEnsureSave")
    public RequestResult<Boolean> redemptionEnsureSave(@RequestBody  EnsureSaveForm form) {
        return  new RequestResult<>(complexService.redemptionEnsureSave(form));
    }
    @PostMapping("/essentialsSave")
    public RequestResult<Boolean> essentialsSave(@RequestBody EssentialsSaveForm form) {
        return  new RequestResult<>(complexService.essentialsSave(form));
    }
    @PostMapping("/essentialsLendApply")
    public RequestResult<Boolean> essentialsLendApply(@RequestBody EssentialsLendApplySaveForm form) {
        return  new RequestResult<>(complexService.essentialsLendApply(form));
    }
    @PostMapping("/essentialsRemandApply")
    public RequestResult<Boolean> essentialsRemandApply(@RequestBody EssentialsRemandApplySaveForm form) {
        return  new RequestResult<>(complexService.essentialsRemandApply(form));
    }

    @PostMapping("/confirmLendOrRemand")
    public RequestResult<Boolean> confirmLendOrRemand(@RequestBody EssentialsLendSaveForm form) {
        return  new RequestResult<>(complexService.confirmLendOrRemand(form));
    }
    @PostMapping("/essentialsLendDetail")
    public RequestResult<MaterialLendModel> essentialsLendDetail(@RequestBody IdForm form) {
        return  new RequestResult<MaterialLendModel>(complexService.essentialsLendDetail(form));
    }
    @PostMapping("/essentialsRemandDetail")
    public RequestResult<MaterialRemandModel> essentialsRemandDetail(@RequestBody IdForm form) {
        return  new RequestResult<MaterialRemandModel>(complexService.essentialsRemandDetail(form));
    }
    @PostMapping("/redeemOrderSave")
    public RequestResult<Boolean> redeemOrderSave(@RequestBody IdForm form) {
        return  new RequestResult<>(complexService.redeemOrderSave(form));
    }
    @PostMapping("/redeemOrderUpdate")
    public RequestResult<Boolean> redeemOrderUpdate(@RequestBody OrderSaveForm form) {
        return  new RequestResult<>(complexService.redeemOrderUpdate(form));
    }
    @PostMapping("/billingCheckSave")
    public RequestResult<Boolean> billingCheckSave(@RequestBody BilingCheckSaveForm form) {
        return  new RequestResult<>(complexService.billingCheckSave(form));
    }
    @PostMapping("/billingCheckQueryResultSave")
    public RequestResult<Boolean> billingCheckQueryResultSave(@RequestBody BillingQueryFileSaveForm form) {
        return  new RequestResult<>(complexService.billingCheckQueryResultSave(form));
    }
    @PostMapping("/billingCheckDetail")
    public RequestResult<BillingCheckDetailForm> billingCheckDetail(@RequestBody IdForm form) {
        return  new RequestResult<>(complexService.billingCheckDetail(form));
    }
    @PostMapping("/queryFileRecord")
    public RequestResult<List<BillingQueryFileRecordModel>> queryFileRecord(@RequestBody IdForm form) {
        return  new RequestResult<>(complexService.queryFileRecord(form));
    }
    @PostMapping("/queryMaterialArchive")
    public RequestResult<Pagination<RedemptionBaseResultForm>> queryMaterialArchive(@RequestBody ComplexRedemptionBaseQueryForm form) {
        return  new RequestResult<>(complexService.queryMaterialArchive(form));
    }
    @PostMapping("/materialArchiveSave")
    public RequestResult<Boolean> materialArchiveSave(@RequestBody MaterialArchiveSaveForm form) {
        return  new RequestResult<>(complexService.materialArchiveSave(form));
    }
    @PostMapping("/unProtectedSave")
    public RequestResult<Boolean> unProtectedSave(@RequestBody UnProtectedSaveForm form) {
        return  new RequestResult<>(complexService.unProtectedSave(form));
    }

    @PostMapping("/queryUnprotected")
    public RequestResult<Pagination<UnProtectedQueryResultForm>> queryUnProtected(@RequestBody UnprotectedQueryForm form) {
        return new RequestResult<>(complexService.queryUnProtected(form));

    }
    @PostMapping("/queryRedemptionOrder")
    public RequestResult<Pagination<OrderQueryResultForm>> queryRedemptionOrder(@RequestBody OrderQueryForm form) {
        return new RequestResult<>(complexService.queryRedemptionOrder(form));

    }


}
