package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.intention.*;
import yhao.micro.service.surety.business.apilist.model.intention.credit.CreditModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerModel;
import yhao.micro.service.surety.business.apilist.model.intention.follower.FollowerPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionModel;
import yhao.micro.service.surety.business.apilist.model.intention.intention.IntentionPageModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayModel;
import yhao.micro.service.surety.business.apilist.model.intention.repay.RepayPageModel;
import yhao.micro.service.surety.business.apilist.restful.IntentionFeign;

import javax.annotation.Resource;

/**
 * @Description:
 * @Created by ql on 2018/12/9 15:40
 * @Version: v1.0
 */
@Service
public class IntentionRemote {
    private Logger logger = LoggerFactory.getLogger(IntentionRemote.class);
    @Resource
    private IntentionFeign intentionFeign;

    @HystrixCommand
    public IntentionForm saveIntention(IntentionForm form) {
        return intentionFeign.saveIntention(form).pickBody();
    }
    @HystrixCommand
    public IntentionForm updateIntention(IntentionForm form) {
        return intentionFeign.updateIntention(form).pickBody();
    }

    @HystrixCommand
    public Boolean deleteIntention(IdForm form) {
        return intentionFeign.deleteIntention(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "intentionPageDown")
    public Pagination<IntentionPageModel> intentionPage(IntentionQueryForm form) {
        return intentionFeign.intentionPage(form).pickBody();
    }
    public Pagination<IntentionPageModel> intentionPageDown(IntentionQueryForm form, Throwable e) {
        logger.error("Service Down:[IntentionService.intentionPage]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<IntentionPageModel>();
    }

    @HystrixCommand(fallbackMethod = "intentionPickDown")
    public IntentionModel intentionPick(IdForm form) {
        return intentionFeign.intentionPick(form).pickBody();
    }
    public IntentionModel intentionPickDown(IdForm form, Throwable e) {
        logger.error("Service Down:[IntentionService.intentionPick]");
        logger.error(e.getMessage(), e.getCause());
        return new IntentionModel();
    }

    /*****************************************跟单*****************************************************/
    @HystrixCommand
    public Boolean followIntention(FollowerUpdateForm form) {
        return intentionFeign.followIntention(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "followPageDown")
    public Pagination<FollowerPageModel> followPage(IntentionQueryForm form) {
        return intentionFeign.followPage(form).pickBody();
    }
    public Pagination<FollowerPageModel> followPageDown(IntentionQueryForm form, Throwable e) {
        logger.error("Service Down:[IntentionService.followPage]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<FollowerPageModel>();
    }

    @HystrixCommand(fallbackMethod = "followPageDown")
    public FollowerModel followerPick(IdForm form) {
        return intentionFeign.followerPick(form).pickBody();
    }
    public FollowerModel followPageDown(IdForm form, Throwable e) {
        logger.error("Service Down:[IntentionService.followerPick]");
        logger.error(e.getMessage(), e.getCause());
        return new FollowerModel();
    }
    /*****************************************征信*****************************************************/
    @HystrixCommand
    public boolean creditDeal(CreditClerkSaveForm form) {
        return intentionFeign.creditDeal(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "creditPickDown")
    public CreditModel creditPick(IdForm form) {
        return intentionFeign.creditPick(form).pickBody();
    }
    public CreditModel creditPickDown(IdForm form, Throwable e) {
        logger.error("Service Down:[IntentionService.creditPick]");
        logger.error(e.getMessage(), e.getCause());
        return new CreditModel();
    }

    @HystrixCommand(fallbackMethod = "creditPageDown")
    public Pagination<CreditModel> creditPage(IntentionQueryForm form) {
        return intentionFeign.creditPage(form).pickBody();
    }
    public Pagination<CreditModel> creditPageDown(IntentionQueryForm form, Throwable e) {
        logger.error("Service Down:[IntentionService.creditPage]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<CreditModel>();
    }

    @HystrixCommand
    public Boolean repayDeal(IntentionRepaySaveForm form) {
        return intentionFeign.repayDeal(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "repayPickDown")
    public RepayModel repayPick(IdForm form) {
        return intentionFeign.repayPick(form).pickBody();
    }
    public RepayModel repayPickDown(IdForm form, Throwable e) {
        logger.error("Service Down:[IntentionService.repayPick]");
        logger.error(e.getMessage(), e.getCause());
        return new RepayModel();
    }


    @HystrixCommand(fallbackMethod = "repayPageDown")
    public Pagination<RepayPageModel> repayPage(IntentionQueryForm form) {
        return intentionFeign.repayPage(form).pickBody();
    }
    public Pagination<RepayPageModel> repayPageDown(IntentionQueryForm form, Throwable e) {
        logger.error("Service Down:[IntentionService.repayPage]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<RepayPageModel>();
    }
}
