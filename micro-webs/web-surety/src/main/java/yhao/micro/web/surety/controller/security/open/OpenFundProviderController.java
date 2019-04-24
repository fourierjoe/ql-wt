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
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundProviderModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.FundProviderRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资方管理开放
 * User: GUO.MAO.LIN
 * Date: 2018-12-06
 * Time: 11:26
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/fundProvider", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenFundProviderController", tags = "开放-资方查询")
public class OpenFundProviderController extends WebBaseController {
    @Resource
    private FundProviderRemote fundProviderRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "资方查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundProviderModel.class, message = "资方管理信息")
    })
    public String pageQuery(FundProviderQueryForm queryForm) {
        Pagination<FundProviderModel> page= fundProviderRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page,FundProviderModel.class));
    }

    @GetMapping("/query")
    @ApiOperation(value = "资方查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundProviderModel.class, message = "资方管理信息")
    })
    public String query(FundProviderQueryForm queryForm) {
        List<FundProviderModel> list= fundProviderRemote.query(queryForm);
        return returnSuccessInfo(list);
    }


    @GetMapping("/queryAllChildByParent")
    @ApiOperation(value = "根据总行查询下属分行和支行")
    @ApiResponses({
            @ApiResponse(code = 200, response = FundProviderModel.class, message = "资方管理信息")
    })
    public String queryAllChildByParent(FundProviderQueryForm queryForm) {
        List<FundProviderModel> fundProviderModelList = fundProviderRemote.queryAllChildByParent(queryForm);
        return returnSuccessInfo(fundProviderModelList);
    }
}
