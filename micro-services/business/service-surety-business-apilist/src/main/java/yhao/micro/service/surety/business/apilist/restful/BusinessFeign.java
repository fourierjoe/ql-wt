package yhao.micro.service.surety.business.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.form.finance.OverdueRecordResultForm;
import yhao.micro.service.surety.business.apilist.model.*;

import java.util.List;

/**
 * @Description
 * @Author leice
 * @Date 2018/12/11 10:54
 * @Version 1.0
 */
@FeignClient(value = ZoneConstants.FEIGN_URL)
public interface BusinessFeign {


    @RequestMapping(value = "/executivenote/pageQueryExecutiveNote",method = RequestMethod.POST)
    RequestResult<Pagination<WindControllerGuaranteeModel>> pageQueryExecutiveNote(WindControllerGuaranteeQueryForm form);

    @RequestMapping(value = "/executivenote/executiveNoteSave",method = RequestMethod.POST)
    RequestResult<ExecutivePostSaveForm> executiveNoteSave(ExecutivePostSaveForm form);

    @RequestMapping(value = "/executivenote/pageQueryExecutiveNoteById",method = RequestMethod.POST)
    RequestResult<Pagination<ExecutiveNoteListModel>> pageQueryExecutiveNoteById(QuerySingleGuaranteeInfoForm form);

    @RequestMapping(value = "/examinerreview/warrantyFollowUpRecordingSave",method = RequestMethod.POST)
    RequestResult<FollowUpSaveForm> warrantyFollowUpRecordingSave(FollowUpSaveForm form);

    @RequestMapping(value = "/examinerreview/pageQueryFollowUpRecordingById",method = RequestMethod.POST)
    RequestResult<Pagination<FollowUpListQueryModel>> pageQueryFollowUpRecordingById(FollowUpListForm form);

    @RequestMapping(value = "/examinerreview/reviewReceive",method = RequestMethod.POST)
    RequestResult<ReviewTransferForm> reviewReceive(ReviewTransferForm form);

    @RequestMapping(value = "/examinerreview/reviewTransfer",method = RequestMethod.POST)
    RequestResult<ReviewTransferForm> reviewTransfer(ReviewTransferForm form);

    @RequestMapping(value = "/examinerreview/queryReveiceNameById",method = RequestMethod.POST)
    RequestResult<ReveiceNameModel> queryReveiceNameById(QuerySingleGuaranteeInfoForm form);

    @RequestMapping(value = "/examinerreview/warrantyReviewSave",method = RequestMethod.POST)
    RequestResult<ReviewInfoSaveForm> warrantyReviewSave(ReviewInfoSaveForm form);

    @RequestMapping(value = "/examinerreview/queryWarrantyReviewInfoById",method = RequestMethod.POST)
    RequestResult<ReviewInfoSaveForm> queryWarrantyReviewInfoById(QuerySingleGuaranteeInfoForm form);

    @RequestMapping(value = "/discountapplication/queryDiscountApplicationById",method = RequestMethod.POST)
    RequestResult<DiscountApplicationInfoModel> queryDiscountApplicationById(QuerySingleGuaranteeInfoForm form);

    @RequestMapping(value = "/discountapplication/restartDiscountApplication",method = RequestMethod.POST)
    RequestResult<RestartDiscountSaveForm> restartDiscountApplication(RestartDiscountSaveForm form);

    @RequestMapping(value = "/discountapplication/discountApplicationSave",method = RequestMethod.POST)
    RequestResult<DiscountApplicationSaveForm> discountApplicationSave(DiscountApplicationSaveForm form);

    @RequestMapping(value = "/examinerreview/pageQueryWarrantyReview",method = RequestMethod.POST)
    RequestResult<Pagination<WindControllerGuaranteeModel>> pageQueryWarrantyReview(WindControllerGuaranteeQueryForm form);

    @RequestMapping(value = "/discountapplication/pageQueryDiscountApplication",method = RequestMethod.POST)
    RequestResult<Pagination<DiscountApplicationModel>> pageQueryDiscountApplication(ApplicationQueryForm applicationQueryForm);

    @RequestMapping(value = "/extensionApplication/extensionApplicationSave",method = RequestMethod.POST)
    RequestResult<ExtensionApplicationSaveForm> extensionApplicationSave(ExtensionApplicationSaveForm form);

    @RequestMapping(value = "/extensionApplication/extensionApplicationUpdate",method = RequestMethod.POST)
    RequestResult<ExtensionApplicationSaveForm> extensionApplicationUpdate(ExtensionApplicationSaveForm form);

    @RequestMapping(value = "/extensionApplication/queryExtensionApplicationById",method = RequestMethod.POST)
    RequestResult<ExtensionApplicationModel> queryExtensionApplicationById(QueryExtensionByIdForm form);

    @RequestMapping(value = "/extensionApplication/queryExtensionListById",method = RequestMethod.POST)
    RequestResult<Pagination<ExtensionApplicationModel>> queryExtensionListById(QueryExtensionByIdForm form);

    @RequestMapping(value = "/extensionApplication/extensionApplicationList",method = RequestMethod.POST)
    RequestResult<Pagination<ExtensionApplicationListModel>> extensionApplicationList(ApplicationQueryForm form);

    @RequestMapping(value = "/extensionApplication/createExtensionApplicationList",method = RequestMethod.POST)
    RequestResult<Pagination<CreateExtensionListModel>> createExtensionApplicationList(CreateExtensionListForm form);

    @RequestMapping(value = "/extensionApplication/cancelExtension",method = RequestMethod.POST)
    RequestResult<ExtensionApplicationModel> cancelExtension(CancleExtensionForm form);

    @RequestMapping(value = "/extensionApplication/overdueToExtensionSave",method = RequestMethod.POST)
    RequestResult<OverdueToExtensionListForm> overdueToExtensionSave(OverdueToExtensionListForm form);

    @RequestMapping(value = "/extensionApplication/OverdueToExtCancel",method = RequestMethod.POST)
    RequestResult<OverdueToExtCancelForm> OverdueToExtCancel(OverdueToExtCancelForm form);

    @RequestMapping(value = "/extensionApplication/overDueList",method = RequestMethod.POST)
    RequestResult<Pagination<OverDueListModel>> overDueList(OverDueQueryForm form);

    @RequestMapping(value = "/extensionApplication/querySomeField",method = RequestMethod.POST)
    RequestResult<ExtensionSomeFiledModel> querySomeField(ExtensionSomeFiledForm form);

    @RequestMapping(value = "/extensionApplication/queryLookOverdueRecord",method = RequestMethod.POST)
    RequestResult<List<OverdueRecordResultForm>> queryLookOverdueRecord(IdForm form);

    @RequestMapping(value = "/examinerreview/refuseWarrantyReview",method = RequestMethod.POST)
    RequestResult<RefuseWarrantyReviewForm> refuseWarrantyReview(RefuseWarrantyReviewForm form);

    @RequestMapping(value = "/extensionApplication/OverdueToExtUpdate",method = RequestMethod.POST)
    RequestResult<OverdueToExtensionListForm> OverdueToExtUpdate(OverdueToExtensionListForm form);

    @RequestMapping(value = "/discountapplication/updateDiscountApplication",method = RequestMethod.POST)
    RequestResult<RestartDiscountSaveForm> updateDiscountApplication(RestartDiscountSaveForm form);
}
