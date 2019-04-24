package yhao.micro.web.surety.controller.security.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.business.apilist.form.complex.ApplicationQueryForm;
import yhao.micro.service.surety.business.apilist.form.complex.DiscountApplicationSaveForm;
import yhao.micro.service.surety.business.apilist.form.complex.QuerySingleGuaranteeInfoForm;
import yhao.micro.service.surety.business.apilist.form.complex.RestartDiscountSaveForm;
import yhao.micro.service.surety.business.apilist.model.DiscountApplicationInfoModel;
import yhao.micro.service.surety.business.apilist.model.DiscountApplicationModel;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.DiscountApplicationRemote;

/**
 * @Description 打折申请有关
 *
 * @Author leice
 * @Date 2018/12/6 18:12
 * @Version 1.0
 */

@Lazy
@RestController
@RequestMapping(value = "/security/business/discountApplication",produces = {"application/json;charset=UTF-8"})
@Api(value = "DiscountApplicationController", tags = "担保业务-打折申请有关")
public class DiscountApplicationController extends WebBaseController {

    @Autowired
    private DiscountApplicationRemote discountApplicationRemote;

    /**
     * 功能描述: 打折申请信息分页查询
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @GetMapping("/pageQueryDiscountApplication")
    @ApiOperation(value = "打折申请信息分页查询")
    @AuthorityAnnotation(AuthorityAnnotationEnums.DISCOUNT_SELECT)
    @ApiResponses({@ApiResponse(code = 200, response = DiscountApplicationModel.class, message = "打折申请信息分页查询成功")})
    public String pageQueryDiscountApplication(ApplicationQueryForm applicationQueryForm) {
        applicationQueryForm.setErpDbName("SURETY");
        applicationQueryForm.setDataAuthRecord("gu");
        initDataAuth(applicationQueryForm);
        return returnSuccessInfo(discountApplicationRemote.pageQueryDiscountApplication(applicationQueryForm));
    }

    /**
     * 功能描述: 打折申请单条信息查看
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @GetMapping("/queryDiscountApplicationById")
    @ApiOperation(value = "打折申请单条信息查看")
    @AuthorityAnnotation(AuthorityAnnotationEnums.DISCOUNT_LOOK)
    @ApiResponses({@ApiResponse(code = 200, response = DiscountApplicationInfoModel.class, message = "打折申请单条信息查看成功")})
    public String queryDiscountApplicationById(QuerySingleGuaranteeInfoForm form) {
        return returnSuccessInfo(discountApplicationRemote.queryDiscountApplicationById(form));
    }

    /**
     * 功能描述: 重新发起打折申请/撤销打折申请
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @PostMapping("/restartDiscountApplication")
    @ApiOperation(value = "重新发起打折申请/撤销打折申请")
    @AuthorityAnnotation(AuthorityAnnotationEnums.DISCOUNT_RESTART)
    public String restartDiscountApplication(@RequestBody RestartDiscountSaveForm form) {
        return returnSuccessInfo(discountApplicationRemote.restartDiscountApplication(form));
    }

    /**
     * 功能描述: 驳回后修改打折申请并且重新启动流程
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @PostMapping("/updateDiscountApplication")
    @ApiOperation(value = "驳回后修改打折申请并且重新启动流程")
    @AuthorityAnnotation(AuthorityAnnotationEnums.DISCOUNT_UPDATE)
    public String updateDiscountApplication(@RequestBody RestartDiscountSaveForm form) {
        return returnSuccessInfo(discountApplicationRemote.updateDiscountApplication(form));
    }

    /**
     * 功能描述: 新增打折申请
     *
     * @auther: leice
     * @date: 2018/12/24 11:24
     */
    @PostMapping("/discountApplicationSave")
    @ApiOperation(value = "新增打折申请")
    public String discountApplicationSave(@RequestBody DiscountApplicationSaveForm form) {
        return returnSuccessInfo(discountApplicationRemote.discountApplicationSave(form));
    }

//    /**
//     * 功能描述: 重新发起打折申请
//     *
//     * @auther: leice
//     * @date: 2018/12/5 17:24
//     */
//    @GetMapping("/startDiscountApplication")
//    @ApiOperation(value = "重新发起打折申请")
//    @AuthorityAnnotation(AuthorityAnnotationEnums.DISCOUNT_LOOK)
//    @ApiResponses({@ApiResponse(code = 200, response = TaskStartForm.class, message = "打折申请单条信息查看成功")})
//    public String startDiscountApplication(IdForm form) {
//        TaskStartForm taskStartForm = new TaskStartForm();
//        taskStartForm.setTaskHead("打折申请子流程");
//        taskStartForm.setBizCodeStr("224");
//        taskStartForm.setBizEntityId(form.getId());
//        String s = returnSuccessInfo(discountApplicationRemote.startDiscountApplication(taskStartForm));
//
//        return s;
//    }
}
