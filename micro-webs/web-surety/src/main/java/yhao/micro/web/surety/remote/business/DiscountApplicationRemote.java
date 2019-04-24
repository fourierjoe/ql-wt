package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.RequestResult;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.*;
import yhao.micro.service.surety.business.apilist.model.DiscountApplicationInfoModel;
import yhao.micro.service.surety.business.apilist.model.DiscountApplicationModel;
import yhao.micro.service.surety.business.apilist.model.FollowUpListQueryModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.surety.business.apilist.restful.BusinessFeign;
import yhao.micro.service.workflow.apilist.form.task.TaskStartForm;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

import javax.annotation.Resource;

/**
 * @Description 打折申请Remote
 *
 * @Author leice
 * @Date 2018/12/6 18:14
 * @Version 1.0
 */
@Service
public class DiscountApplicationRemote {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessFeign businessFeign;

    @Resource
    private TaskFeign taskFeign;


    @HystrixCommand(fallbackMethod = "queryDiscountApplicationByIdDown")
    public DiscountApplicationInfoModel queryDiscountApplicationById(QuerySingleGuaranteeInfoForm form) {
        return  businessFeign.queryDiscountApplicationById(form).pickBody();
    }

    public DiscountApplicationInfoModel queryDiscountApplicationByIdDown(QuerySingleGuaranteeInfoForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand
    public RestartDiscountSaveForm restartDiscountApplication(RestartDiscountSaveForm form) {
        return  businessFeign.restartDiscountApplication(form).pickBody();
    }

    public DiscountApplicationSaveForm discountApplicationSave(DiscountApplicationSaveForm form) {
        return  businessFeign.discountApplicationSave(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "pageQueryDiscountApplicationDown")
    public Pagination<DiscountApplicationModel> pageQueryDiscountApplication(ApplicationQueryForm applicationQueryForm) {
        return businessFeign.pageQueryDiscountApplication(applicationQueryForm).pickBody();
    }

    public Pagination<DiscountApplicationModel> pageQueryDiscountApplicationDown(ApplicationQueryForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand
    public RequestResult<TaskStartForm> startDiscountApplication(TaskStartForm form) {
        return taskFeign.startNewTask(form);
    }

    @HystrixCommand
    public RequestResult<Boolean> cancelTask(IdForm form) {
        return taskFeign.cancelTask(form);
    }

    @HystrixCommand
    public RestartDiscountSaveForm updateDiscountApplication(RestartDiscountSaveForm form) {
        return  businessFeign.updateDiscountApplication(form).pickBody();
    }
}
