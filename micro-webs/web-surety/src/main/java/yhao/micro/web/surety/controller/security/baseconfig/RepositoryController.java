package yhao.micro.web.surety.controller.security.baseconfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositoryQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositorySaveForm;
import yhao.micro.service.surety.baseconfig.apilist.model.RepositoryModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.RepositoryRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 10:31
 */
@Lazy
@RestController
@RequestMapping(value = "/security/baseconfig/repository",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "RepositoryController", tags = "基础配置-仓库设置")
public class RepositoryController extends WebBaseController {
    @Resource
    private RepositoryRemote repositoryRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "仓库设置分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = RepositoryModel.class, message = "仓库设置信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.REPOSITORY_SELECT)
    public String pageQuery(RepositoryQueryForm queryForm) {
        Pagination<RepositoryModel> page = repositoryRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page, RepositoryModel.class));
    }

    @PostMapping("/save")
    @ApiOperation(value = "仓库设置新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.REPOSITORY_ADD)
    public String save(@RequestBody RepositorySaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        repositoryRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/update")
    @ApiOperation(value = "仓库设置更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.REPOSITORY_EDIT)
    public String update(@RequestBody RepositorySaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        repositoryRemote.save(saveForm);
        return returnSuccessInfo();
    }


    @PostMapping("/deleteById")
    @ApiOperation(value = "仓库设置删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.REPOSITORY_DELETE)
    public String deleteById(@RequestBody IdForm idForm) {
        repositoryRemote.deleteById(idForm);
        return returnSuccessInfo();
    }
}
