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
import yhao.micro.service.surety.baseconfig.apilist.form.CommandQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.CommandModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.CommandRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 11:35
 */
@Lazy
@RestController
@RequestMapping(value = "/security/baseconfig/command",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "CommandController", tags = "基础配置-指令配置")
public class CommandController extends WebBaseController {
    @Resource
    private CommandRemote commandRemote;
     
    @GetMapping("/pageQuery")
    @ApiOperation(value = "指令配置分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = CommandModel.class, message = "指令配置信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.COMMAND_SELECT)
    public String pageQuery(CommandQueryForm queryForm) {
        Pagination<CommandModel> page = commandRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page, CommandModel.class));
    }

    @PostMapping("/save")
    @ApiOperation(value = "指令配置新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.COMMAND_ADD)
    public String save(@RequestBody CommandSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        commandRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/update")
    @ApiOperation(value = "指令配置更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.COMMAND_EDIT)
    public String update(@RequestBody CommandSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        commandRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/statusChange")
    @ApiOperation(value = "资金方案管理启用/禁用")
    @AuthorityAnnotation(AuthorityAnnotationEnums.COMMAND_CHANGE_STATUS)
    public String statusChange(@RequestBody StatusChangeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        commandRemote.statusChange(form);
        return returnSuccessInfo();
    }
    
    @PostMapping("/deleteById")
    @ApiOperation(value = "指令配置删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.COMMAND_DELETE)
    public String deleteById(@RequestBody IdForm idForm) {
        commandRemote.deleteById(idForm);
        return returnSuccessInfo();
    }
}
