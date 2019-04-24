package yhao.micro.service.surety.business.apilist.restful;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.intention.IntentionSaveForm;
import yhao.micro.service.surety.business.apilist.form.twiceRepay.*;
import yhao.micro.service.surety.business.apilist.model.twiceRepay.*;

/**
 * @Description:
 * @Auther: ql
 * @Date: 2018/12/8 17:51
 */

@FeignClient(ZoneConstants.FEIGN_URL)
public interface TwiceRepayFeign {

    /************************************客户经理发起**********************************************************************/
    @PostMapping("/business/twice/twiceRepayStartPage")
    RequestResult<Pagination<TwiceRepayStartPageModel>> twiceRepayStartPage( TwiceRepayPageQueryForm form);

    @PostMapping("/business/twice/twiceRepayStart")
    RequestResult<Boolean> twiceRepayStart( GuaranteeIdForm form);

    /************************************要件员**********************************************************************/
    @PostMapping("/business/twice/twiceRepayConfirmPage")
    RequestResult<Pagination<TwiceRepayConfirmPageModel>> twiceRepayConfirmPage( TwiceRepayPageQueryForm form);

    /**
     * 要件员确认
     * @param form
     * @return
     */
    @PostMapping("/business/twice/requisitesConfirm")
    RequestResult<Boolean> requisitesConfirm( RequisitesConfirmForm form);

    /************************************二次到账**********************************************************************/
    @PostMapping("/business/twice/twiceRepayArrivalPage")
    RequestResult<Pagination<TwiceRepayArrivalPageModel>> twiceRepayArrivalPage( TwiceRepayPageQueryForm form);
    /**
     * 新增到账/编辑到账
     * @param form
     * @return
     */
    @PostMapping("/business/twice/twiceArrival")
    RequestResult<TwiceArrivalSaveForm> twiceArrival( TwiceArrivalSaveForm form);

    /**
     * 删除二次还款
     * @param form
     * @return
     */
    @PostMapping("/business/twice/deleteTwiceArrival")
    RequestResult<Boolean> deleteTwiceArrival( IdForm form);

    /**
     * 查看到账按钮分页
     * @param form 担保单id
     * @return
     */
    @PostMapping("/business/twice/queryTwiceArrivalPage")
    RequestResult<Pagination<TwiceArrivalModel>> queryTwiceArrivalPage( TwiceArrivalIdPageForm form);

    /**
     * 查看到账
     * @param form details表id, 非担保单id
     * @return
     */
    @PostMapping("/business/twice/pickTwiceArrival")
    RequestResult<TwiceArrivalModel> pickTwiceArrival( IdForm form);

    /**
     * 到账确认
     * @param form
     * @return
     */
    @PostMapping("/business/twice/confirmTwiceArrival")
    RequestResult<Boolean> confirmTwiceArrival( GuaranteeIdForm form);

    /************************************出账申请**********************************************************************/
    @PostMapping("/business/twice/twiceRepayApplyPage")
    RequestResult<Pagination<TwiceRepayApplyPageModel>> twiceRepayApplyPage( TwiceRepayPageQueryForm form);
    /**
     * 申请出账
     * @param form
     * @return
     */
    @PostMapping("/business/twice/applicationBilling")
    RequestResult<Boolean> applicationBilling( ApplicationBillingSaveForm form);

    /**
     * 撤销申请出账
     * @param form
     * @return
     */
    @PostMapping("/business/twice/cancelApplicationBilling")
    RequestResult<Boolean> cancelApplicationBilling(IdForm form);

    /**
     * 查看申请记录
     * @param form 担保单id
     * @return
     */
    @PostMapping("/business/twice/queryApplicationBilling")
    RequestResult<TwiceApplicationRecordModel> queryApplicationBilling( GuaranteeIdPageForm form);

    /**
     * 申请记录单个查看
     * @param form
     * @return
     */
    @PostMapping("/business/twice/pickApplicationBilling")
    RequestResult<TwiceApplicationModel> pickApplicationBilling( IdForm form);

    /************************************二次出账**********************************************************************/
    @PostMapping("/business/twice/twiceRepayBillingPage")
    RequestResult<Pagination<TwiceRepayBillingPageModel>> twiceRepayBillingPage( TwiceRepayPageQueryForm form);

    @PostMapping("/business/twice/queryTwiceBillingPage")
    RequestResult<TwiceBillingModel> queryTwiceBillingPage(TwiceBillingPageQueryForm form);

    /**
     * 出账查看
     * @param form
     * @return
     */
    @PostMapping("/business/twice/pickTwiceBilling")
    RequestResult<TwiceBillingModel> pickTwiceBilling( IdForm form);


    /**
     * 二次出账
     * @param form
     * @return
     */
    @PostMapping("/business/twice/saveTwiceBilling")
    RequestResult<TwiceBillingSaveForm> saveTwiceBilling( TwiceBillingSaveForm form);

    /**
     * 出账确认
     * @param form
     * @return
     */
    @PostMapping("/business/twice/confirmTwiceBilling")
    RequestResult<Boolean> confirmTwiceBilling( GuaranteeIdOperaForm form);

    /************************************二次赎楼**********************************************************************/
    @PostMapping("/business/twice/twiceRepayRedeemPage")
    RequestResult<Pagination<TwiceRepayRedeemPageModel>> twiceRepayRedeemPage( TwiceRepayPageQueryForm form);
    /**
     * 还款查看
     * @param form
     * @return
     */
    @PostMapping("/business/twice/pickTwiceRedeem")
    RequestResult<TwiceRedeemModel> pickTwiceRedeem( IdForm form);

    /**
     * 新增或编辑(只有余款确认状态为NO时才能编辑)
     * @param form
     * @return
     */
    @PostMapping("/business/twice/confirmTwiceRedeem")
    RequestResult<Boolean> confirmTwiceRedeem( TwiceRedeemSaveForm form);

    /**
     * 余款确认
     * @param form
     * @return
     */
    @PostMapping("/business/twice/confirmBalance")
    RequestResult<Boolean> confirmBalance( BalanceConfirmForm form);

    /************************************日志查看**********************************************************************/
    /**
     * @return
     */
    @PostMapping("/business/twice/pickTwiceRepayHistory")
    RequestResult<TwiceRepayHistoryModel> pickTwiceRepayHistory(GuaranteeUnIdForm form);
}