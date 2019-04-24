package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.complex.BillingQueryFileRecordModel;
import yhao.micro.service.surety.business.apilist.model.complex.RedemptionEssentialsTakeModel;
import yhao.micro.service.surety.business.apilist.model.complex.RedemptionOrderModel;
import yhao.micro.service.surety.business.apilist.model.complex.RedemptionWithdrawalModel;
import yhao.micro.service.surety.business.apilist.restful.ComplexFeign;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yuanxy
 * @Date: 2018/12/6 11:10
 * @Description:
 */
@Service
public class ComplexRemote {
    private Logger logger = LoggerFactory.getLogger(ComplexRemote.class);
    @Resource
    private ComplexFeign complexFeign;

    @HystrixCommand(fallbackMethod = "queryRedemptionEnsureDown")
    public Pagination<EnsureQueryResultForm> queryRedemptionEnsure(EnsureQueryForm form) {
       return complexFeign.queryRedemptionEnsure(form).pickBody();
    }

    public Pagination<EnsureQueryResultForm> queryRedemptionEnsureDown(EnsureQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryRedemptionEnsureDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

   public RequestResult<Boolean> redemptionEnsureSave(EnsureSaveForm form) {
      return  complexFeign.redemptionEnsureSave(form);
    }

    @HystrixCommand(fallbackMethod = "queryEssentialsDown")
    public Pagination<EssentialsQueryResultForm> queryEssentials(EssentialsQueryForm form) {
        return complexFeign.queryEssentials(form).pickBody();
    }

    public Pagination<RedemptionEssentialsTakeModel> queryEssentialsDown(EssentialsQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryEssentialsDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public RequestResult<Boolean> bilingCheck(BilingCheckSaveForm checkForm) {
        return new RequestResult<Boolean>();
    }

    public RequestResult<BilingCheckDetailForm> bilingCheckDetail(IdForm form) {
        return new RequestResult<BilingCheckDetailForm>();

    }

    public RequestResult<Boolean> redemptionOrderSave(OrderSaveForm form) {
        return new RequestResult<Boolean>();
    }

    public RequestResult<RedemptionOrderModel> redemptionOrderDetail(IdForm form) {
        return new RequestResult<RedemptionOrderModel>();
    }

    public RequestResult<Boolean> withdrawalSave(WithdrawalSaveForm form) {
        return new RequestResult<Boolean>();
    }

    public RequestResult<RedemptionWithdrawalModel> withdrawalDetail(IdForm form) {
        return new RequestResult<RedemptionWithdrawalModel>();
    }

    public RequestResult<Boolean> materialArchiveSave(MaterialArchiveSaveForm form) {
        return new RequestResult<Boolean>();
    }

    public RequestResult<MeterialSecondmentForm> meterialSecondmentDetail(IdForm form) {
        return new RequestResult<MeterialSecondmentForm>();
    }

    public RequestResult<MeterialOperateDetailForm> meterialOperateDetail(IdForm form) {
        return new RequestResult<MeterialOperateDetailForm>();
    }

    @HystrixCommand(fallbackMethod = "queryBilingCheckDown")
    public Pagination<BilingCheckQueryResultForm> queryBilingCheck(BilingCheckQueryForm form) {
        return new Pagination<BilingCheckQueryResultForm>();
    }

    public Pagination<BilingCheckQueryResultForm> queryBilingCheckDown(BilingCheckQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryBilingCheckDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<BilingCheckQueryResultForm>();
    }
    @HystrixCommand(fallbackMethod = "queryRedemptionOrderDown")
    public Pagination<OrderQueryResultForm> queryRedemptionOrder(OrderQueryForm form) {
        return complexFeign.queryRedemptionOrder(form).pickBody();
    }
    public Pagination<OrderQueryResultForm> queryRedemptionOrderDown(OrderQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryRedemptionOrderDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<OrderQueryResultForm>();
    }
    @HystrixCommand(fallbackMethod = "queryRedemptionWithdrawalDown")
    public Pagination<WithdrawalQueryResultForm> queryRedemptionWithdrawal(WithdrawalQueryForm form) {
        return new Pagination<WithdrawalQueryResultForm>();
    }
    public Pagination<WithdrawalQueryResultForm> queryRedemptionWithdrawalDown(WithdrawalQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryRedemptionWithdrawalDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }
    @HystrixCommand(fallbackMethod = "queryMaterialArchiveDown")
    public Pagination<RedemptionBaseResultForm> queryMaterialArchive(ComplexRedemptionBaseQueryForm form) {
        return new Pagination<RedemptionBaseResultForm>();
    }
    public Pagination<RedemptionBaseResultForm> queryMaterialArchiveDown(ComplexRedemptionBaseQueryForm form, Throwable e) {
        logger.error("Service Down:[ComplexService.queryRedemptionWithdrawalDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public RequestResult<List<BillingQueryFileRecordModel>> queryFileRecord(IdForm form) {
        return complexFeign.queryFileRecord(form);
    }

    public Pagination<UnProtectedQueryResultForm> queryUnProtected(UnprotectedQueryForm form) {
        return complexFeign.queryUnProtected(form).pickBody();
    }

    public RequestResult<Boolean> unProtectedSave(UnProtectedSaveForm form) {
       return complexFeign.unProtectedSave(form);
    }

    public RequestResult<Boolean> redemptionOrderApply(OrderApplySaveForm form) {
        return complexFeign.redemptionOrderApply(form);
    }
}
