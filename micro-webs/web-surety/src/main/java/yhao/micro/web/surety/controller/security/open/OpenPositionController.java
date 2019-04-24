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
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.erp.org.PositionLinkRemote;
import yhao.micro.web.surety.remote.erp.org.PositionRemote;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-11
 * Time: 10:56
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/position", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenPersonController", tags = "开放-岗位查询")
public class OpenPositionController extends WebBaseController {
    @Resource
    private PositionRemote positionRemote;
    @Resource
    private PositionLinkRemote positionLinkRemote;

    @GetMapping("/pageQueryPosition")
    @ApiOperation(value = "查询分页岗位信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = PositionModel.class, message = "岗位数据")
    })
    public String queryPersonPage(PositionQueryForm form) {
        Pagination<PositionModel> page = positionRemote.queryPositionPage(form);
        return returnSuccessInfo(toPageListData(page, PositionModel.class));
    }

    @GetMapping("/queryPositionLink")
    @ApiOperation(value = "查询挂职岗位信息")
    @ApiResponses({
            @ApiResponse(code = 200, response = PositionModel.class, message = "挂职岗位数据")
    })
    public String queryPositionLink(PositionLinkQueryForm form) {
        List<PositionLinkModel> positionLinkModelList = positionLinkRemote.queryPositionLinkList(form);
        return returnSuccessInfo(positionLinkModelList);
    }
}
