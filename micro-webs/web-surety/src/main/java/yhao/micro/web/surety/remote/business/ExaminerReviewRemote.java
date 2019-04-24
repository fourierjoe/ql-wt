package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.ExecutiveNoteListModel;
import yhao.micro.service.surety.business.apilist.model.FollowUpListQueryModel;
import yhao.micro.service.surety.business.apilist.model.ReveiceNameModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.surety.business.apilist.restful.BusinessFeign;

/**
 * @Description 审查员审查 Remote
 * @Author leice
 * @Date 2018/12/5 16:34
 * @Version 1.0
 */
@Service
public class ExaminerReviewRemote {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessFeign businessFeign;


    @HystrixCommand
    public FollowUpSaveForm warrantyFollowUpRecordingSave(FollowUpSaveForm form) {
        return businessFeign.warrantyFollowUpRecordingSave(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "pageQueryFollowUpRecordingByIdDown")
    public Pagination<FollowUpListQueryModel> pageQueryFollowUpRecordingById(FollowUpListForm form) {
        return  businessFeign.pageQueryFollowUpRecordingById(form).pickBody();
    }

    public Pagination<FollowUpListQueryModel> pageQueryFollowUpRecordingByIdDown(FollowUpListForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand
    public ReviewTransferForm reviewReceive(ReviewTransferForm form) {
        return businessFeign.reviewReceive(form).pickBody();
    }

    @HystrixCommand
    public ReviewTransferForm reviewTransfer(ReviewTransferForm form) {
        return businessFeign.reviewTransfer(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryReveiceNameByIdDown")
    public ReveiceNameModel queryReveiceNameById(QuerySingleGuaranteeInfoForm form) {
        return businessFeign.queryReveiceNameById(form).pickBody();
    }

    public ReveiceNameModel queryReveiceNameByIdDown(QuerySingleGuaranteeInfoForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand
    public ReviewInfoSaveForm warrantyReviewSave(ReviewInfoSaveForm form) {
        return businessFeign.warrantyReviewSave(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryWarrantyReviewInfoByIdDown")
    public ReviewInfoSaveForm queryWarrantyReviewInfoById(QuerySingleGuaranteeInfoForm form) {
        return businessFeign.queryWarrantyReviewInfoById(form).pickBody();
    }

    public ReviewInfoSaveForm queryWarrantyReviewInfoByIdDown(QuerySingleGuaranteeInfoForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand(fallbackMethod = "pageQueryWarrantyReviewDown")
    public Pagination<WindControllerGuaranteeModel> pageQueryWarrantyReview(WindControllerGuaranteeQueryForm form) {
        return businessFeign.pageQueryWarrantyReview(form).pickBody();
    }

    public Pagination<WindControllerGuaranteeModel> pageQueryWarrantyReviewDown(WindControllerGuaranteeQueryForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand
    public RefuseWarrantyReviewForm refuseWarrantyReview(RefuseWarrantyReviewForm form) {
        return businessFeign.refuseWarrantyReview(form).pickBody();
    }
}
