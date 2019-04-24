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
import yhao.micro.service.surety.baseconfig.apilist.form.RepositoryQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.model.RepositoryModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.RepositoryRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 12:32
 */
@Lazy
@RestController
@RequestMapping(value = "/security/open/repository", produces = {"application/json;charset=UTF-8"})
@Api(value = "OpenRepositoryController", tags = "开放-仓库查询")
public class OpenRepositoryController extends WebBaseController {
    @Resource
    private RepositoryRemote repositoryRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "仓库查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RepositoryModel.class, message = "仓库信息")
    })
    public String pageQuery(RepositoryQueryForm queryForm) {
        Pagination<RepositoryModel> page= repositoryRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page,RepositoryModel.class));
    }

}
