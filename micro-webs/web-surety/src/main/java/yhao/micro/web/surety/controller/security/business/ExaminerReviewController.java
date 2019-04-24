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
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.DiscountApplicationModel;
import yhao.micro.service.surety.business.apilist.model.FollowUpListQueryModel;
import yhao.micro.service.surety.business.apilist.model.OperatingRecordListModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.surety.erp.auth.login.apilist.model.LoginPersonModel;
import yhao.micro.web.surety.controller.WebBaseController;
import yhao.micro.web.surety.remote.business.ExaminerReviewRemote;

import javax.validation.Valid;
import javax.ws.rs.POST;

/**
 * @Description 审查员审查有关
 *
 * @Author leice
 * @Date 2018/12/5 16:27
 * @Version 1.0
 */
@Lazy
@RestController
@RequestMapping(value = "/security/business/examinerReview",produces = {"application/json;charset=UTF-8"})
@Api(value = "ExaminerReviewController", tags = "风险管控-审查员审查管理")
public class ExaminerReviewController extends WebBaseController {

    @Autowired
    private ExaminerReviewRemote examinerReviewRemote;

    /**
     * 功能描述: 担保单审查信息分页查询
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @GetMapping("/pageQueryWarrantyReview")
    @ApiOperation(value = "担保单审查信息分页查询")
    @AuthorityAnnotation(AuthorityAnnotationEnums.REVIEW_SELECT)
    @ApiResponses({
            @ApiResponse(code = 200,response = WindControllerGuaranteeModel.class,  message = "担保单审查信息分页查询成功")
    })
    public String pageQueryWarrantyReview(WindControllerGuaranteeQueryForm form) {
        form.setErpDbName("SURETY");
        form.setDataAuthRecord("gu");
        initDataAuth(form);
        return returnSuccessInfo(examinerReviewRemote.pageQueryWarrantyReview(form));
    }

//    /**
//     * 功能描述: 单据详情信息查询
//     *
//     * @auther: leice
//     * @date: 2018/12/5 17:24
//     */
//    @PostMapping("/queryWarrantyInfo")
//    @ApiOperation(value = "单据详情信息查询")
//    @ApiResponses({
//            @ApiResponse(code = 200,  message = "单据详情信息查询查询成功")
//    })
//    public String queryWarrantyInfo() {
//        return returnSuccessInfo();
//    }

    /**
     * 功能描述: 审查担保单
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @PostMapping("/warrantyReviewSave")
    @ApiOperation(value = "审查担保单")
    @AuthorityAnnotation(AuthorityAnnotationEnums.REVIEW_ADD)
    public String warrantyReviewSave(@RequestBody ReviewInfoSaveForm form) {
        return returnSuccessInfo(examinerReviewRemote.warrantyReviewSave(form));
    }

    /**
     * 功能描述: 审查驳回
     *
     * @auther: leice
     * @date: 2019/3/7 20:24
     */
    @PostMapping("/refuseWarrantyReview")
    @ApiOperation(value = "审查驳回")
    @AuthorityAnnotation(AuthorityAnnotationEnums.REFUSE_REVIEW_ADD)
    public String refuseWarrantyReview(@RequestBody RefuseWarrantyReviewForm form) {
        return returnSuccessInfo(examinerReviewRemote.refuseWarrantyReview(form));
    }

    /**
     * 功能描述: 担保单审查信息查看
     *
     * @auther: leice
     * @date: 2018/12/19 17:24
     */
    @GetMapping("/queryWarrantyReviewInfoById")
    @ApiOperation(value = "担保单审查信息查看")
    public String queryWarrantyReviewInfoById(QuerySingleGuaranteeInfoForm form) {
        return returnSuccessInfo(examinerReviewRemote.queryWarrantyReviewInfoById(form));
    }


    /**
     * 功能描述: 审查员接收
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @PostMapping("/reviewReceive")
    @ApiOperation(value = "审查员接收")
    @AuthorityAnnotation(AuthorityAnnotationEnums.REVIEW_RECEIVE)
    public String reviewReceive(@RequestBody ReviewTransferForm form) {
        LoginPersonModel currentPerson = this.getCurrentPerson();
        form.setReceiveId(currentPerson.getNumber());
        return returnSuccessInfo(examinerReviewRemote.reviewReceive(form));
    }

    /**
     * 功能描述: 查询当前处理人
     *
     * @auther: leice
     * @date: 2018/12/18 19:45
     */
    @GetMapping("/queryReveiceNameById")
    @ApiOperation(value = "查询当前处理人")
    public String queryReveiceNameById(QuerySingleGuaranteeInfoForm form) {
        return returnSuccessInfo(examinerReviewRemote.queryReveiceNameById(form));
    }

    /**
     * 功能描述: 审查员转交
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @PostMapping("/reviewTransfer")
    @ApiOperation(value = "审查员转交")
    @AuthorityAnnotation(AuthorityAnnotationEnums.REVIEW_TRANSFER)
    public String reviewTransfer(@RequestBody ReviewTransferForm form) {
        return returnSuccessInfo(examinerReviewRemote.reviewTransfer(form));
    }

    /**
     * 功能描述: 担保单操作记录信息查询
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @GetMapping("/queryWarrantyOperationRecording")
    @ApiOperation(value = "担保单操作记录信息查询")
    @ApiResponses({
            @ApiResponse(code = 200, response = OperatingRecordListModel.class, message = "担保单操作记录信息查询成功")
    })
    public String queryWarrantyOperationRecording(QuerySingleGuaranteeInfoForm form) {
        return returnSuccessInfo();
    }

    /**
     * 功能描述: 担保单跟进记录信息查询
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @GetMapping("/queryWarrantyFollowUpRecording")
    @ApiOperation(value = "担保单跟进记录信息查询")
    @ApiResponses({
            @ApiResponse(code = 200,  response = FollowUpListQueryModel.class, message = "担保单跟进记录信息查询成功")
    })
    public String queryWarrantyFollowUpRecording(FollowUpListForm form) {

        return returnSuccessInfo(examinerReviewRemote.pageQueryFollowUpRecordingById(form));
    }

    /**
     * 功能描述: 新增担保单跟进记录
     *
     * @auther: leice
     * @date: 2018/12/5 17:24
     */
    @PostMapping("/warrantyFollowUpRecordingSave")
    @ApiOperation(value = "新增担保单跟进记录")
    public String warrantyFollowUpRecordingSave(@RequestBody FollowUpSaveForm form) {
        return returnSuccessInfo(examinerReviewRemote.warrantyFollowUpRecordingSave(form));
    }
}
