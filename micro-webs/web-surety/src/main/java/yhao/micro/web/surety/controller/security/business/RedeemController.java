package yhao.micro.web.surety.controller.security.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.redemption.*;
import yhao.micro.service.surety.business.apilist.model.redemption.BillingApplyModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RDTAfterFollowModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RedeemModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.RedemptionRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 11:47
 * @Description:
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/redemption",produces = {"application/json;charset=UTF-8"})
@Api(value = "RedeemController", tags = "赎楼管理-赎楼管理")
public class RedeemController extends WebBaseController {

    @Resource
    private RedemptionRemote redemptionRemote;

    @GetMapping("/queryRedemptionManager")
    @ApiOperation(value = "赎楼管理查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RedemptionQueryResultForm.class, message = "赎楼管理查询")
    })
    public String queryRedemptionManager(RedemptionQueryForm form){
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<RedemptionQueryResultForm> page = redemptionRemote.queryRedemptionManager(form);
        return returnSuccessInfo(page);
    }

    @PostMapping("/redemptionSave")
    @ApiOperation(value = "赎楼保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "赎楼保存")
    })
    public String redemptionSave(@RequestBody RedeemSaveForm form){
        RequestResult<Boolean> result =redemptionRemote.redemptionSave(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @PostMapping("/redeemSupplementSave")
    @ApiOperation(value = "赎楼补录保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "赎楼保存")
    })
    public String redeemSupplementSave(@RequestBody RedeemSupplementSaveForm form){
        RequestResult<Boolean> result =redemptionRemote.redeemSupplementSave(form);
        return  returnSuccessInfo(result.pickBody());
    }


    @GetMapping("/pickRedemptionDetail")
    @ApiOperation(value = "已赎楼查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RedemptionDetailForm.class, message = "已赎楼查询")
    })
    public String pickRedemptionDetail(IdForm form){
        RequestResult<RedemptionDetailForm> page = redemptionRemote.pickRedemptionDetail(form);
        return  returnSuccessInfo(page);
    }

    @PostMapping("/billingReject")
    @ApiOperation(value = "出账申请驳回")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "出账申请驳回")
    })
    public String billingReject(@RequestBody IdForm form){
        RequestResult<Boolean> result =redemptionRemote.billingReject(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @PostMapping("/billingApply")
    @ApiOperation(value = "出账申请保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "出账申请保存")
    })
    public String billingApply(@RequestBody BillingApplySaveForm form){
        form.setCreaterId(getCurrentPerson().getId());
        RequestResult<Boolean> result =redemptionRemote.billingApply(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/pickBillingApplyDetail")
    @ApiOperation(value = "出账申请详情")
    @ApiResponses({
            @ApiResponse(code = 200, response = BillingApplyModel.class, message = "出账申请详情")
    })
    public String pickBillingApplyDetail(IdForm form){
        RequestResult<BillingApplyModel> result = redemptionRemote.pickBillingApplyDetail(form);
        return  returnSuccessInfo(result);
    }

    @GetMapping("/billingApplyRefund")
    @ApiOperation(value = "出账申请撤销")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "出账申请撤销 id为申请单id")
    })
    public String billingApplyRefund(IdForm form){
        RequestResult<Boolean> result = redemptionRemote.billingApplyRefund(form);
        return  returnSuccessInfo(result);
    }

    @GetMapping("/queryRedeemRecord")
    @ApiOperation(value = "赎楼记录")
    @ApiResponses({
            @ApiResponse(code = 200, response = RedeemModel.class, message = "赎楼记录 id为担保单id")
    })
    public String queryRedeemRecord(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<List<RedeemModel>> result = redemptionRemote.queryRedeemRecord(form);
        return  returnSuccessInfo(result);
    }





}
