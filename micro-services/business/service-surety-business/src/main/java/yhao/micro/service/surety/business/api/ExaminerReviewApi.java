package yhao.micro.service.surety.business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.RequestResultException;
import yhao.infra.apilist.RestfulBaseController;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.FollowUpListQueryModel;
import yhao.micro.service.surety.business.apilist.model.ReveiceNameModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.surety.business.service.ExaminerReviewService;

import javax.validation.Valid;

/**
 * @Description 审查员审查api
 *
 * @Author leice
 * @Date 2018/12/18 11:45
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/examinerreview")
public class ExaminerReviewApi extends RestfulBaseController {

    @Autowired
    private ExaminerReviewService examinerReviewService;

    /**
     * 功能描述: 担保单是否审查分页查询
     */
    @PostMapping("/pageQueryWarrantyReview")
    public RequestResult<Pagination<WindControllerGuaranteeModel>> pageQueryWarrantyReview(@RequestBody WindControllerGuaranteeQueryForm form) throws Exception {
        return new RequestResult<>(examinerReviewService.pageQueryWarrantyReview(form));
    }

    /**
     * 功能描述: 新增跟进记录
     */
    @PostMapping("/warrantyFollowUpRecordingSave")
    public RequestResult<FollowUpSaveForm> warrantyFollowUpRecordingSave(@RequestBody FollowUpSaveForm form) throws Exception {
            return new RequestResult<>(examinerReviewService.warrantyFollowUpRecordingSave(form));
    }

    /**
     * 功能描述: 审查担保单
     */
    @PostMapping("/warrantyReviewSave")
    public RequestResult<ReviewInfoSaveForm> warrantyReviewSave(@Valid @RequestBody ReviewInfoSaveForm form) throws Exception{
            return new RequestResult<>(examinerReviewService.warrantyReviewSave(form));
    }

    /**
     * 功能描述: 审查驳回
     */
    @PostMapping("/refuseWarrantyReview")
    public RequestResult<RefuseWarrantyReviewForm> refuseWarrantyReview(@Valid @RequestBody RefuseWarrantyReviewForm form) throws Exception{
        return new RequestResult<>(examinerReviewService.refuseWarrantyReview(form));
    }

    /**
     * 功能描述: 担保单审查信息查看
     */
    @PostMapping("/queryWarrantyReviewInfoById")
    public RequestResult<ReviewInfoSaveForm> queryWarrantyReviewInfoById(@RequestBody QuerySingleGuaranteeInfoForm form) throws Exception{
        return new RequestResult<>(examinerReviewService.queryWarrantyReviewInfoById(form));
    }


    /**
     * 功能描述: 根据事项id查询跟进记录历史
     */
    @PostMapping("/pageQueryFollowUpRecordingById")
    public RequestResult<Pagination<FollowUpListQueryModel>> pageQueryFollowUpRecordingById(@Valid @RequestBody FollowUpListForm form) throws Exception{
            return new RequestResult<>(examinerReviewService.pageQueryFollowUpRecordingById(form));
    }

    /**
     * 功能描述: 审查接收
     */
    @PostMapping("/reviewReceive")
    public RequestResult<ReviewTransferForm> reviewReceive(@RequestBody ReviewTransferForm form) throws Exception {
        if ( null == form.getGuaranteeId() || null == form.getReceiveId()){
            throw new Exception("接收人id/担保单id不能为空");
        }
            return new RequestResult<>(examinerReviewService.reviewReceive(form));
    }

    /**
     * 功能描述: 转交页 查询当前处理人
     */
    @PostMapping("/queryReveiceNameById")
    public RequestResult<ReveiceNameModel> queryReveiceNameById(@RequestBody QuerySingleGuaranteeInfoForm form) throws Exception {
        if ( null == form.getGuaranteeId()){
            throw new Exception("担保单id不能为空");
        }
        return new RequestResult<>(examinerReviewService.queryReveiceNameById(form));
    }

    /**
     * 功能描述: 审查转交
     */
    @PostMapping("/reviewTransfer")
    public RequestResult<ReviewTransferForm> reviewTransfer(@RequestBody ReviewTransferForm form) throws Exception {
        if ( null == form.getId() || null == form.getReceiveId()){
            throw new Exception("接收记录id/转交人id不能为空");
        }
            return new RequestResult<>(examinerReviewService.reviewTransfer(form));
    }
}
