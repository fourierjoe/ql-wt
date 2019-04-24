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
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.MaterialModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.MaterialRemote;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:资料设置 Controller
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:39
 */
@Lazy
@RestController
@RequestMapping(value = "/security/baseconfig/material",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "MaterialController", tags = "基础配置-资料设置")
public class MaterialController extends WebBaseController {

    @Resource
    private MaterialRemote materialRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "资料设置分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = MaterialModel.class, message = "资料设置信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.MATERIAL_SELECT)
    public String pageQuery(MaterialQueryForm queryForm) {
        Pagination<MaterialModel> page = materialRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page, MaterialModel.class));
    }

    @PostMapping("/save")
    @ApiOperation(value = "资料设置新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.MATERIAL_ADD)
    public String save(@RequestBody MaterialSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        materialRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/update")
    @ApiOperation(value = "资料设置更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.MATERIAL_EDIT)
    public String update(@RequestBody MaterialSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        materialRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/statusChange")
    @ApiOperation(value = "资料设置启用/禁用")
    @AuthorityAnnotation(AuthorityAnnotationEnums.MATERIAL_CHANGE_STATUS)
    public String statusChange(@RequestBody StatusChangeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        materialRemote.statusChange(form);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "资料设置删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.MATERIAL_DELETE)
    public String deleteById(@RequestBody IdForm idForm) {
        materialRemote.deleteById(idForm);
        return returnSuccessInfo();
    }
}
