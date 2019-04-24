package yhao.micro.web.surety.controller.security.open;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundAccountModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.FundAccountRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-25
 * Time: 17:43
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/fundAccount", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenFundAccountController", tags = "开放-资金账号查询")
public class OpenFundAccountController extends WebBaseController {
    @Resource
    private FundAccountRemote fundAccountRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "资金账号管理分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundAccountModel.class, message = "资金账号管理信息")
    })
    public String pageQuery(FundAccountQueryForm queryForm) {
        Pagination<FundAccountModel> page = fundAccountRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page, FundAccountModel.class));
    }
}
