package yhao.micro.web.surety.controller.security.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.redemption.RDTAfterFollowQueryForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RDTAfterFollowQueryResultForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RedeemAfterSaveForm;
import yhao.micro.service.surety.business.apilist.model.redemption.RDTAfterFollowModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.RedemptionRemote;

import javax.annotation.Resource;

/**
 * @Auther: yuanxy
 * @Date: 2019/3/2 11:12
 * @Description:
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/redemption",produces = {"application/json;charset=UTF-8"})
@Api(value = "RedeemAfterController", tags = "赎楼管理-赎楼后跟进")
public class RedeemAfterController  extends WebBaseController {
    @Resource
    private RedemptionRemote redemptionRemote;

    @GetMapping("/queryRedeemAfter")
    @ApiOperation(value = "赎楼后跟进查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RDTAfterFollowQueryResultForm.class, message = "赎楼后跟进查询信息")
    })
    public String queryRedeemAfter(RDTAfterFollowQueryForm form){
        form.setDataAuthRecord("GUARANTEE");
        initDataAuth(form);
        Pagination<RDTAfterFollowQueryResultForm> page = redemptionRemote.queryRedeemAfter(form);
        return  returnSuccessInfo(page);
    }
    @PostMapping("/redeemAfterSave")
    @ApiOperation(value = "赎楼后跟进信息保存")
    @ApiResponses({
            @ApiResponse(code = 200, response = Boolean.class, message = "赎楼后跟进信息保存")
    })
    public String redemptionAfterSave(@RequestBody RedeemAfterSaveForm form){
        RequestResult<Boolean> result =redemptionRemote.redemptionAfterSave(form);
        return  returnSuccessInfo(result.pickBody());
    }




}
