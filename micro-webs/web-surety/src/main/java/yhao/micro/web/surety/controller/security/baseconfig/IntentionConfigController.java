package yhao.micro.web.surety.controller.security.baseconfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.IntentionConfigSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.IntentionConfigModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.IntentionConfigRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:单据分配设置 Controller
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 14:45
 */
@Lazy
@RestController
@RequestMapping(value = "/security/baseconfig/intentionConfig",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "IntentionConfigController", tags = "基础配置-单据分配设置")
public class IntentionConfigController extends WebBaseController {
    @Resource
    private IntentionConfigRemote intentionConfigRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "单据分配设置分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = IntentionConfigModel.class, message = "单据分配设置信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.INTENTION_ASSIGN_SELECT)
    public String pageQuery(IntentionConfigQueryForm queryForm) {
        Pagination<IntentionConfigModel> page = intentionConfigRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page, IntentionConfigModel.class));
    }

    @PostMapping("/save")
    @ApiOperation(value = "单据分配设置新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.INTENTION_ASSIGN_ADD)
    public String save(@RequestBody IntentionConfigSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        intentionConfigRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/update")
    @ApiOperation(value = "单据分配设置更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.INTENTION_ASSIGN_EDIT)
    public String update(@RequestBody IntentionConfigSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        intentionConfigRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/statusChange")
    @ApiOperation(value = "单据分配设置启用/禁用")
    @AuthorityAnnotation(AuthorityAnnotationEnums.INTENTION_ASSIGN_CHANGE_STATUS)
    public String statusChange(@RequestBody StatusChangeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        intentionConfigRemote.statusChange(form);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "单据分配设置删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.INTENTION_ASSIGN_DELETE)
    public String deleteById(@RequestBody IdForm idForm) {
        intentionConfigRemote.deleteById(idForm);
        return returnSuccessInfo();
    }


}
