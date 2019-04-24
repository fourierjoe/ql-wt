package yhao.micro.web.surety.controller.security.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.complex.*;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.ComplexRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/6 11:08
 * @Description:
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/complex", produces = {"application/json;charset=UTF-8"})
@Api(value = "ComplexManagerController", tags = "综合管理")
public class ComplexManagerController extends WebBaseController {

    @Resource
    ComplexRemote complexRemote;

    @GetMapping("/queryRedemptionEnsure")
    @ApiOperation(value = "保函单查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = EnsureQueryResultForm.class, message = "保函单信息")
    })
    public String queryRedemptionEnsure(EnsureQueryForm form) {
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<EnsureQueryResultForm> page = complexRemote.queryRedemptionEnsure(form);
        return returnSuccessInfo(page);
    }

    @PostMapping("/redemptionEnsureSave")
    @ApiOperation(value = "保函单保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "操作信息")
    })

    public String redemptionEnsureSave(@RequestBody EnsureSaveForm form) {
        LoginPersonModel currentPerson = getCurrentPerson();
        if(StringUtils.isNotEmpty(currentPerson.getId())){
            form.setCreateOperatorId(currentPerson.getId());
        }
        RequestResult<Boolean> result = complexRemote.redemptionEnsureSave(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/queryEssentials")
    @ApiOperation(value = "要件查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RedemptionEssentialsTakeModel.class, message = "要件信息")
    })
    public String queryEssentials(EssentialsQueryForm form) {
        Pagination<EssentialsQueryResultForm> page = complexRemote.queryEssentials(form);
        return returnSuccessInfo(page);
    }

    @GetMapping("/queryBillingCheck")
    @ApiOperation(value = "出账前核查查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RedemptionEssentialsTakeModel.class, message = "出账前核查信息")
    })
    public String queryBillingCheck(BilingCheckQueryForm form) {
        Pagination<BilingCheckQueryResultForm> page = complexRemote.queryBilingCheck(form);
        return returnSuccessInfo(page);
    }


    @PostMapping("/billingCheckSave")
    @ApiOperation(value = "出账前核查保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "操作信息")
    })
    public String billingCheckSave(@RequestBody BilingCheckSaveForm checkForm){
        RequestResult<Boolean> result =complexRemote.bilingCheck(checkForm);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/billingCheckDetail")
    @ApiOperation(value = "出账前核查查看详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = BilingCheckDetailForm.class, message = "出账前核查详情")
    })
    public String billingCheckDetail(IdForm form){
        RequestResult<BilingCheckDetailForm> result = complexRemote.bilingCheckDetail(form);
        return returnSuccessInfo(result.pickBody());

    }
    @GetMapping("/queryFileRecord")
    @ApiOperation(value = "出账前核查记录")
    @ApiResponses({
            @ApiResponse(code = 200, response = BillingQueryFileRecordModel.class, message = "出账前核查记录")
    })
    public String queryFileRecord(IdForm form){
        RequestResult<List<BillingQueryFileRecordModel>> result = complexRemote.queryFileRecord(form);
        return returnSuccessInfo(result.pickBody());

    }

    @GetMapping("/queryRedemptionOrder")
    @ApiOperation(value = "指令查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = OrderQueryResultForm.class, message = "指令信息")
    })
    public String queryRedemptionOrder(OrderQueryForm form) {
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<OrderQueryResultForm> page = complexRemote.queryRedemptionOrder(form);
        return returnSuccessInfo(page);
    }



    @PostMapping("/redemptionOrderApply")
    @ApiOperation(value = "发指令")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "发指令")
    })
    public String redemptionOrderApply(@RequestBody  OrderApplySaveForm form){
        RequestResult<Boolean> result =complexRemote.redemptionOrderApply(form);
        return returnSuccessInfo(result.pickBody());
    }


    @PostMapping("/redemptionOrderSave")
    @ApiOperation(value = "发指令")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "发指令")
    })
    public String redemptionOrderSave(@RequestBody  OrderSaveForm form){
        RequestResult<Boolean> result =complexRemote.redemptionOrderSave(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/redemptionOrderDetail")
    @ApiOperation(value = "指令详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = BilingCheckDetailForm.class, message = "指令详情")
    })
    public String redemptionOrderDetail(IdForm form){
        RequestResult<RedemptionOrderModel> result = complexRemote.redemptionOrderDetail(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/queryRedemptionWithdrawal")
    @ApiOperation(value = "退尾款查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RedemptionWithdrawalModel.class, message = "尾款信息")
    })
    public String queryRedemptionWithdrawal(WithdrawalQueryForm form) {
        Pagination<WithdrawalQueryResultForm> page = complexRemote.queryRedemptionWithdrawal(form);
        return returnSuccessInfo(page);
    }



    @PostMapping("/withdrawalSave")
    @ApiOperation(value = "退尾款")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "退尾款")
    })
    public String withdrawalSave(@RequestBody WithdrawalSaveForm form){
        RequestResult<Boolean> result =complexRemote.withdrawalSave(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/withdrawalDetail")
    @ApiOperation(value = "退尾款详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = RedemptionWithdrawalModel.class, message = "退尾款详情")
    })
    public String withdrawalDetail(IdForm form){
        RequestResult<RedemptionWithdrawalModel> result = complexRemote.withdrawalDetail(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/queryMaterialArchive")
    @ApiOperation(value = "材料归档查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RedemptionBaseResultForm.class, message = "材料归档信息")
    })
    public String queryMaterialArchive(ComplexRedemptionBaseQueryForm form) {
        Pagination<RedemptionBaseResultForm> page = complexRemote.queryMaterialArchive(form);
        return returnSuccessInfo(page);
    }


    @PostMapping("/materialArchiveSave")
    @ApiOperation(value = "材料归档")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "材料归档")
    })
    public String materialArchiveSave(@RequestBody MaterialArchiveSaveForm form){
        RequestResult<Boolean> result =complexRemote.materialArchiveSave(form);
        return returnSuccessInfo(result.pickBody());
    }

    @PostMapping("/meterialOperateDetail")
    @ApiOperation(value = "档案借出/归还详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = MeterialOperateDetailForm.class, message = "档案借出/归还详情")
    })
    public String meterialOperateDetail(@RequestBody IdForm form){
        RequestResult<MeterialOperateDetailForm> result =complexRemote.meterialOperateDetail(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/meterialSecondmentDetail")
    @ApiOperation(value = "借调详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = MeterialSecondmentForm.class, message = "借调详情")
    })
    public String meterialSecondmentDetail(IdForm form){
        RequestResult<MeterialSecondmentForm> result = complexRemote.meterialSecondmentDetail(form);
        return returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/queryUnprotected")
    @ApiOperation(value = "解保查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = UnProtectedQueryResultForm.class, message = "解保查询")
    })
    public String queryUnprotected(UnprotectedQueryForm form) {
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<UnProtectedQueryResultForm> page = complexRemote.queryUnProtected(form);
        return returnSuccessInfo(page);
    }


    @PostMapping("/unProtectedSave")
    @ApiOperation(value = "解保保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "解保保存")
    })
    public String unProtectedSave(@RequestBody UnProtectedSaveForm form){
        form.setCreaterId(getCurrentPerson().getCreateOperatorId());
        RequestResult<Boolean> result =complexRemote.unProtectedSave(form);
        return returnSuccessInfo(result.pickBody());
    }
}
