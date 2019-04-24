package yhao.micro.web.surety.controller.security.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.form.finance.OverdueRecordResultForm;
import yhao.micro.service.surety.business.apilist.model.*;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.ExtensionApplicationRemote;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description 展期逾期申请
 *
 * @Author leice
 * @Date 2018/12/6 17:53
 * @Version 1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/extensionApplication",produces = {"application/json;charset=UTF-8"})
@Api(value = "ExtensionApplicationController", tags = "担保业务-展期申请")
public class ExtensionApplicationController extends WebBaseController {

    @Autowired
    private ExtensionApplicationRemote extensionApplicationRemote;

    /**
     * 功能描述: 查询展期申请列表
     *
     * @auther: leice
     * @date: 2018/1/4 15:24
     */
    @GetMapping("/extensionApplicationList")
    @ApiOperation(value = "查询展期申请列表")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXTENSION_SELECT)
    @ApiResponses({@ApiResponse(code = 200, response = ExtensionApplicationListModel.class, message = "查询展期申请列表成功")})
    public String extensionApplicationList(ApplicationQueryForm form) {
        form.setErpDbName("SURETY");
        form.setDataAuthRecord("gu");
        initDataAuth(form);
        return returnSuccessInfo(extensionApplicationRemote.extensionApplicationList(form));
    }

    /**
     * 功能描述: 创建展期申请时的列表查询
     *
     * @auther: leice
     * @date: 2018/1/4 15:24
     */
    @GetMapping("/createExtensionApplicationList")
    @ApiOperation(value = "创建展期申请时的列表查询")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXTENSION_SELECT_CREATE)
    @ApiResponses({@ApiResponse(code = 200, response = CreateExtensionListModel.class, message = "创建展期申请时的列表查询成功")})
    public String createExtensionApplicationList(CreateExtensionListForm form) {
        LoginPersonModel currentPerson = getCurrentPerson();
        form.setLoginId(currentPerson.getId());
//        form.setLoginId("65aba9b1-506d-4f93-a0ed-01f4d8d3e43d");
        return returnSuccessInfo(extensionApplicationRemote.createExtensionApplicationList(form));
    }

    /**
     * 功能描述: 新增展期申请
     *
     * @auther: leice
     * @date: 2018/1/3 15:24
     */
    @PostMapping("/extensionApplicationSave")
    @ApiOperation(value = "新增展期申请")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXTENSION_ADD)
    public String extensionApplicationSave(@RequestBody ExtensionApplicationSaveForm form) {
        return returnSuccessInfo(extensionApplicationRemote.extensionApplicationSave(form));
    }

    /**
     * 功能描述: 修改展期申请
     *
     * @auther: leice
     * @date: 2018/1/3 15:24
     */
    @PostMapping("/extensionApplicationUpdate")
    @ApiOperation(value = "修改展期申请")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXTENSION_UPDATE)
    public String extensionApplicationUpdate(@RequestBody ExtensionApplicationSaveForm form) {
        return returnSuccessInfo(extensionApplicationRemote.extensionApplicationUpdate(form));
    }

    /**
     * 功能描述: 撤销展期申请
     *
     * @auther: leice
     * @date: 2018/1/8 15:24
     */
    @PostMapping("/cancelExtension")
    @ApiOperation(value = "撤销展期申请")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXTENSION_OVER)
    public String cancelExtension(@RequestBody CancleExtensionForm form) {
        return returnSuccessInfo(extensionApplicationRemote.cancelExtension(form));
    }

    /**
     * 功能描述: 根据展期id查询展期申请
     *
     * @auther: leice
     * @date: 2018/1/3 15:24
     */
    @GetMapping("/queryExtensionApplicationById")
    @ApiOperation(value = "根据展期id查询展期申请")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXTENSION_LOOK)
    @ApiResponses({@ApiResponse(code = 200, response = ExtensionApplicationModel.class, message = "根据展期id查询展期申请成功")})
    public String queryExtensionApplicationById(QueryExtensionByIdForm form) {
        return returnSuccessInfo(extensionApplicationRemote.queryExtensionApplicationById(form));
    }

    /**
     * 功能描述: 根据借款id查询展期申请记录
     *
     * @auther: leice
     * @date: 2018/1/4 15:24
     */
    @GetMapping("/queryExtensionListById")
    @ApiOperation(value = "根据借款id查询展期申请记录")
    @ApiResponses({@ApiResponse(code = 200, response = ExtensionApplicationModel.class, message = "根据借款id查询展期申请记录成功")})
    public String queryExtensionListById(QueryExtensionByIdForm form) {
        return returnSuccessInfo(extensionApplicationRemote.queryExtensionListById(form));
    }


    /**
     * 功能描述: 新增逾期申请
     *
     * @auther: leice
     * @date: 2018/1/3 15:24
     */
    @PostMapping("/overdueToExtensionSave")
    @ApiOperation(value = "逾转展保存")
    @AuthorityAnnotation(AuthorityAnnotationEnums.OVER_DUE_ADD)
    public String overdueToExtensionSave(@RequestBody OverdueToExtensionListForm form) {
        return returnSuccessInfo(extensionApplicationRemote.overdueToExtensionSave(form));
    }

    /**
     * 功能描述: 撤销逾期申请
     *
     * @auther: leice
     * @date: 2018/1/8 15:24
     */
    @PostMapping("/OverdueToExtCancel")
    @ApiOperation(value = "撤销逾转展申请")
    @AuthorityAnnotation(AuthorityAnnotationEnums.OVER_DUE_OVER)
    public String OverdueToExtCancel(@RequestBody OverdueToExtCancelForm form) {
        return returnSuccessInfo(extensionApplicationRemote.OverdueToExtCancel(form));
    }

    /**
     * 功能描述: 逾期列表
     *
     * @auther: leice
     * @date: 2018/1/4 15:24
     */
    @GetMapping("/overDueList")
    @ApiOperation(value = "查询逾期列表")
    @AuthorityAnnotation(AuthorityAnnotationEnums.OVER_DUE_SELECT)
    @ApiResponses({@ApiResponse(code = 200, response = OverDueListModel.class, message = "查询逾期列表成功")})
    public String overDueList(OverDueQueryForm form) {
        form.setErpDbName("SURETY");
        form.setDataAuthRecord("gu");
        initDataAuth(form);
        return returnSuccessInfo(extensionApplicationRemote.overDueList(form));
    }

    /**
     * 功能描述: 查询修改展期是的首行表单字段
     *
     * @auther: leice
     * @date: 2018/2/28 15:24
     */
    @GetMapping("/querySomeField")
    @ApiOperation(value = "查询修改展期是的首行表单字段--查询额度通过担保单id，查询现金通过借款id ")
    @ApiResponses({@ApiResponse(code = 200, response = ExtensionSomeFiledModel.class, message = "查询修改展期是的首行表单字段成功")})
    public String querySomeField(ExtensionSomeFiledForm form) {
        return returnSuccessInfo(extensionApplicationRemote.querySomeField(form));
    }

    /**
     * 功能描述: 逾期查看
     *
     * @auther: leice
     * @date: 2018/3/5 15:24
     */
    @GetMapping("/queryLookOverdueRecord")
    @ApiOperation(value = "逾期查看/重新发起--通过担保单id ")
    @AuthorityAnnotation(AuthorityAnnotationEnums.LOOK_OVER_DUE_OVER)
    @ApiResponses({@ApiResponse(code = 200, response = OverdueRecordResultForm.class, message = "逾期查看成功")})
    public String queryLookOverdueRecord(IdForm form) {
        RequestResult<List<OverdueRecordResultForm>> result =   extensionApplicationRemote.queryLookOverdueRecord(form);
        return  returnSuccessInfo(result.pickBody());
    }

    @GetMapping("/queryOverdue")
    @ApiOperation(value = "逾期减免费用申请/撤销申请")
    @AuthorityAnnotation(AuthorityAnnotationEnums.LOOK_OVER_DUE_RECORD)
    @ApiResponses({
            @ApiResponse(code = 200, response = OverdueRecordResultForm.class, message = "减免费用申请查看")
    })
    public String queryOverdueRecord(IdForm form){
        form.setOperatorId(getCurrentPerson().getId());
        RequestResult<List<OverdueRecordResultForm>> result =   extensionApplicationRemote.queryOverdueRecord(form);
        return  returnSuccessInfo(result.pickBody());
    }


    @PostMapping("/OverdueToExtUpdate")
    @ApiOperation(value = "减免费用申请修改")
    @AuthorityAnnotation(AuthorityAnnotationEnums.UPUDATE_OVER_DUE_RECORD)
    @ApiResponses({
            @ApiResponse(code = 200, response = OverdueToExtensionListForm.class, message = "减免费用申请修改")
    })
    public String OverdueToExtUpdate(@RequestBody OverdueToExtensionListForm form){
        return returnSuccessInfo(extensionApplicationRemote.OverdueToExtUpdate(form));
    }

}
