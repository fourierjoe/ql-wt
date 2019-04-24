package yhao.micro.service.surety.business.dao.automapper;

import org.springframework.stereotype.Repository;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.FollowUpListQueryModel;
import yhao.micro.service.surety.business.apilist.model.RefuseWarrantyReviewModel;
import yhao.micro.service.surety.business.apilist.model.ReveiceNameModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.workflow.apilist.model.task.TaskNodeItemModel;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/18 11:48
 * @Version 1.0
 */
@Repository
public interface ExaminerReviewDao {

    void warrantyFollowUpRecordingSave(FollowUpSaveForm form);

    Pagination<FollowUpListQueryModel> pageQueryFollowUpRecordingById(Pagination<FollowUpListQueryModel> page, FollowUpListForm form);

    void reviewReceive(ReviewTransferForm form);

    void updateReviewStatus(String id);

    void reviewTransfer(ReviewTransferForm form);

    ReviewTransferForm selectReviewById(String id);

    ReviewTransferForm selectReviewByGuaranteeId(String id);

    ReviewInfoSaveForm selectReviewInfoByGuaranteeId(String id);

    void updateReviewInfoByGuaranteeId(ReviewInfoSaveForm form);

    ReveiceNameModel queryReveiceNameById(String id);

    String queryManageName(String id);

    Pagination<WindControllerGuaranteeModel> pageQueryWarrantyReview(Pagination page, WindControllerGuaranteeQueryForm form);

    RefuseWarrantyReviewModel refuseWarrantyReview(RefuseWarrantyReviewForm form);
}
