package yhao.micro.service.surety.business.dao.automapper;

import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.redemption.RDTAfterFollowQueryForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RDTAfterFollowQueryResultForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RedemptionQueryForm;
import yhao.micro.service.surety.business.apilist.form.redemption.RedemptionQueryResultForm;
import yhao.micro.service.surety.business.apilist.model.redemption.BillingApplyModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RDTAfterFollowModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RedeemModel;

import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2019/1/2 15:04
 * @Description:赎楼管理dao
 */
public interface RedeemDao {
    /**未出账查询*/
    Pagination<RedemptionQueryResultForm> queryNoBilling(Pagination<RedemptionQueryResultForm> page,RedemptionQueryForm form);
    /**未赎楼查询*/
    Pagination<RedemptionQueryResultForm> queryNoRedeem(Pagination<RedemptionQueryResultForm> page, RedemptionQueryForm form);
    /**赎楼查询*/
    Pagination<RedemptionQueryResultForm> queryRedeem(Pagination<RedemptionQueryResultForm> page, RedemptionQueryForm form);
    /**出账申请查询*/
    List<BillingApplyModel> queryApplyRecord(IdForm form);
    /**新增出账申请*/
    Integer inertInsertApply(BillingApplyModel applyModel);
    /**赎楼*/
    Integer inertInsertRedeem(RedeemModel redeemModel);
    /**赎楼详情*/
    RedeemModel pickRedeem(IdForm form);
    /**赎楼记录*/
    List<RedeemModel> queryRedeemRecord(IdForm form);
    /**出账申请详情*/
    BillingApplyModel pickBillingApplyDetail(IdForm form);
    /**赎楼后跟进查询*/
    void queryRedeemAfter(Pagination<RDTAfterFollowQueryResultForm> page, RDTAfterFollowQueryForm form);

    Integer insertRedeemAfterFollow(RDTAfterFollowModel model);
    /**赎楼后跟进查询*/
    RDTAfterFollowModel pickRedeemAfter(String guaranteeId);
    /**更新赎楼后跟进*/
    void updateRedeemAfter(RDTAfterFollowModel model);
}
