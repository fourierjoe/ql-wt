package yhao.micro.web.surety.controller.security.business;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import yhao.micro.service.constants.annotations.AuthorityAnnotation;
import yhao.micro.service.constants.enums.AuthorityAnnotationEnums;
import yhao.micro.service.surety.business.apilist.form.complex.ExecutivePostSaveForm;
import yhao.micro.service.surety.business.apilist.form.complex.QuerySingleGuaranteeInfoForm;
import yhao.micro.service.surety.business.apilist.form.complex.WindControllerGuaranteeQueryForm;
import yhao.micro.service.surety.business.apilist.model.ExecutiveNoteListModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.ExecutiveNoteRemote;

/**
 * @Description 执行岗备注有关
 *
 * @Author leice
 * @Date 2018/12/5 16:52
 * @Version 1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/executiveNote",produces = {"application/json;charset=UTF-8"})
@Api(value = "ExecutiveNoteController", tags = "风险管控-执行岗备注管理")
public class ExecutiveNoteController extends WebBaseController {

    @Autowired
    private ExecutiveNoteRemote executiveNoteRemote;

    /**
     * 功能描述: 担保单是否备注分页查询
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @GetMapping("/pageQueryReviewSetting")
    @ApiOperation(value = "担保单是否备注分页查询")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXECUTIVENOTE_SELECT)
    @ApiResponses({
            @ApiResponse(code = 200, response = WindControllerGuaranteeModel.class, message = "担保单备注分页查询成功")
    })
    public String pageQueryExecutiveNote(WindControllerGuaranteeQueryForm form) {
        form.setErpDbName("SURETY");
        form.setDataAuthRecord("gu");
        initDataAuth(form);
        return returnSuccessInfo(executiveNoteRemote.pageQueryExecutiveNote(form));
    }

    /**
     * 功能描述: 担保单新增备注
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @PostMapping("/executiveNoteSave")
    @ApiOperation(value = "担保单新增备注")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXECUTIVENOTE_ADD)
    public String executiveNoteSave(@RequestBody ExecutivePostSaveForm form) {
        return returnSuccessInfo(executiveNoteRemote.executiveNoteSave(form));
    }

//    /**
//     * 功能描述: 担保单备注修改
//     *
//     * @auther: leice
//     * @date: 2018/12/5 17:24
//     */
//    @PostMapping("/executiveNoteUpdate")
//    @ApiOperation(value = "担保单备注修改")
//    @ApiResponses({
//            @ApiResponse(code = 200,  message = "担保单备注修改成功")
//    })
//    public String executiveNoteUpdate() {
//        return returnSuccessInfo();
//    }

    /**
     * 功能描述: 根据担保单id查询担保单备注历史
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @GetMapping("/pageQueryExecutiveNoteById")
    @ApiOperation(value = "根据担保单id查询担保单备注历史")
    @AuthorityAnnotation(AuthorityAnnotationEnums.EXECUTIVENOTE_SELECT_HISTORY)
    @ApiResponses({
            @ApiResponse(code = 200, response = ExecutiveNoteListModel.class, message = "担保单id查询担保单备注历史成功")
    })
    public String pageQueryExecutiveNoteById(QuerySingleGuaranteeInfoForm form) {
        return returnSuccessInfo(executiveNoteRemote.pageQueryExecutiveNoteById(form));
    }
}
