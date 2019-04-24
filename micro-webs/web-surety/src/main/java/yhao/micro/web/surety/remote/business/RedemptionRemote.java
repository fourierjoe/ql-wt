package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.redemption.*;
import yhao.micro.service.surety.business.apilist.model.redemption.BillingApplyModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RDTAfterFollowModel;
import yhao.micro.service.surety.business.apilist.model.redemption.RedeemModel;
import yhao.micro.service.surety.business.apilist.restful.RedeemFeign;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/11 11:50
 * @Description:
 */
@Service
public class RedemptionRemote {
    private Logger logger = LoggerFactory.getLogger(RedemptionRemote.class);

    @Resource
    private RedeemFeign redeemFeign;

    @HystrixCommand(fallbackMethod = "queryRedeemAfterDown")
    public Pagination<RDTAfterFollowQueryResultForm> queryRedeemAfter(RDTAfterFollowQueryForm form) {
        return redeemFeign.queryRedeemAfter(form).pickBody();
    }
    public Pagination<RDTAfterFollowQueryResultForm> queryRedeemAfterDown(RDTAfterFollowQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryRedemptionAfterDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }


    @HystrixCommand(fallbackMethod = "queryRedemptionManagerDown")
    public Pagination<RedemptionQueryResultForm> queryRedemptionManager(RedemptionQueryForm form) {
        return redeemFeign.queryRedemptionManager(form).pickBody();
    }

    public Pagination<RedemptionQueryResultForm> queryRedemptionManagerDown(RedemptionQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryRedemptionManagerDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public RequestResult<Boolean> redemptionAfterSave(RedeemAfterSaveForm form) {
       return redeemFeign.redemptionAfterSave(form);
    }

    public RequestResult<Boolean> redemptionSave(RedeemSaveForm form) {
        return  new RequestResult<Boolean>();
    }

    public RequestResult<Boolean> redeemSupplementSave(RedeemSupplementSaveForm form) {
        return  new RequestResult<Boolean>();
    }

    public RequestResult<RedemptionDetailForm> pickRedemptionDetail(IdForm form) {
        return  new RequestResult<RedemptionDetailForm>();
    }

    public RequestResult<Boolean> billingReject(IdForm form) {
        return  new RequestResult<Boolean>();
    }

    public RequestResult<Boolean> billingApply(BillingApplySaveForm form) {
        return redeemFeign.billingApply(form);
    }

    public RequestResult<BillingApplyModel> pickBillingApplyDetail(IdForm form) {
        return redeemFeign.pickBillingApplyDetail(form);
    }

    public RequestResult<Boolean> billingApplyRefund(IdForm form) {
        return redeemFeign.billingApplyRefund(form);
    }

    public RequestResult<List<RedeemModel>> queryRedeemRecord(IdForm form) {
        return redeemFeign.queryRedeemRecord(form);
    }
}
