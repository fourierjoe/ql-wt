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
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.PartnerModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.baseconfig.PartnerRemote;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:合作方管理 Controller
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:39
 */
@Lazy
@RestController
@RequestMapping(value = "/security/baseconfig/partner",
        produces = {"application/json;charset=UTF-8"})
@Api(value = "PartnerController", tags = "基础配置-合作方管理")
public class PartnerController extends WebBaseController {
    @Resource
    private PartnerRemote partnerRemote;

    @GetMapping("/pageQuery")
    @ApiOperation(value = "合作方管理分页查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = PartnerModel.class, message = "合作方管理信息")
    })
    @AuthorityAnnotation(AuthorityAnnotationEnums.PARTNERS_SELECT)
    public String pageQuery(PartnerQueryForm queryForm) {
        Pagination<PartnerModel> page = partnerRemote.pageQuery(queryForm);
        return returnSuccessInfo(toPageListData(page, PartnerModel.class));
    }

    @PostMapping("/save")
    @ApiOperation(value = "合作方管理新增")
    @AuthorityAnnotation(AuthorityAnnotationEnums.PARTNERS_ADD)
    public String save(@RequestBody PartnerSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        partnerRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/update")
    @ApiOperation(value = "合作方管理更新")
    @AuthorityAnnotation(AuthorityAnnotationEnums.PARTNERS_EDIT)
    public String update(@RequestBody PartnerSaveForm saveForm) {
        saveForm.setOperatorId(getCurrentPerson().getId());
        partnerRemote.save(saveForm);
        return returnSuccessInfo();
    }

    @PostMapping("/statusChange")
    @ApiOperation(value = "合作方管理启用/禁用")
    @AuthorityAnnotation(AuthorityAnnotationEnums.PARTNERS_CHANGE_STATUS)
    public String statusChange(@RequestBody StatusChangeForm form) {
        form.setOperatorId(getCurrentPerson().getId());
        partnerRemote.statusChange(form);
        return returnSuccessInfo();
    }

    @PostMapping("/deleteById")
    @ApiOperation(value = "合作方管理删除")
    @AuthorityAnnotation(AuthorityAnnotationEnums.PARTNERS_DELETE)
    public String deleteById(@RequestBody IdForm idForm) {
        partnerRemote.deleteById(idForm);
        return returnSuccessInfo();
    }

}
