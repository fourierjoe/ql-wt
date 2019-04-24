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
import yhao.micro.service.surety.business.apilist.form.finance.OverdueRecordResultForm;
import yhao.micro.service.surety.business.apilist.model.*;
import yhao.micro.service.surety.business.apilist.restful.BusinessFeign;
import yhao.micro.service.surety.business.apilist.restful.FinanceFeign;

import java.util.List;

/**
 * @Description 展期申请Remote
 *
 * @Author leice
 * @Date 2018/12/6 17:56
 * @Version 1.0
 */
@Service
public class ExtensionApplicationRemote {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessFeign businessFeign;

    @Autowired
    private FinanceFeign financeFeign;


    @HystrixCommand
    public ExtensionApplicationSaveForm extensionApplicationSave(ExtensionApplicationSaveForm form) {
        return  businessFeign.extensionApplicationSave(form).pickBody();
    }

    @HystrixCommand
    public ExtensionApplicationSaveForm extensionApplicationUpdate(ExtensionApplicationSaveForm form) {
        return  businessFeign.extensionApplicationUpdate(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryExtensionApplicationByIdDown")
    public ExtensionApplicationModel queryExtensionApplicationById(QueryExtensionByIdForm form) {
        return  businessFeign.queryExtensionApplicationById(form).pickBody();
    }

    public ExtensionApplicationModel queryExtensionApplicationByIdDown(QueryExtensionByIdForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand(fallbackMethod = "queryExtensionListByIdDown")
    public Pagination<ExtensionApplicationModel> queryExtensionListById(QueryExtensionByIdForm form) {
        return businessFeign.queryExtensionListById(form).pickBody();
    }

    public Pagination<ExtensionApplicationModel> queryExtensionListByIdDown(QueryExtensionByIdForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand(fallbackMethod = "extensionApplicationListDown")
    public Pagination<ExtensionApplicationListModel> extensionApplicationList(ApplicationQueryForm form) {
        return businessFeign.extensionApplicationList(form).pickBody();
    }

    public Pagination<ExtensionApplicationListModel> extensionApplicationListDown(ApplicationQueryForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand(fallbackMethod = "createExtensionApplicationListDown")
    public Pagination<CreateExtensionListModel> createExtensionApplicationList(CreateExtensionListForm form) {
        return businessFeign.createExtensionApplicationList(form).pickBody();
    }

    public Pagination<CreateExtensionListModel> createExtensionApplicationListDown(CreateExtensionListForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand
    public ExtensionApplicationModel cancelExtension(CancleExtensionForm form) {
        return businessFeign.cancelExtension(form).pickBody();
    }

    @HystrixCommand
    public OverdueToExtensionListForm overdueToExtensionSave(OverdueToExtensionListForm form) {
        return businessFeign.overdueToExtensionSave(form).pickBody();
    }

    @HystrixCommand
    public OverdueToExtCancelForm OverdueToExtCancel(OverdueToExtCancelForm form) {
        return businessFeign.OverdueToExtCancel(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "overDueListDown")
    public Pagination<OverDueListModel> overDueList(OverDueQueryForm form) {
        return businessFeign.overDueList(form).pickBody();
    }

    public Pagination<OverDueListModel> overDueListDown(OverDueQueryForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand(fallbackMethod = "querySomeFieldDown")
    public ExtensionSomeFiledModel querySomeField(ExtensionSomeFiledForm form) {
        return businessFeign.querySomeField(form).pickBody();
    }

    public ExtensionSomeFiledModel querySomeFieldDown(ExtensionSomeFiledForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    public RequestResult<List<OverdueRecordResultForm>> queryLookOverdueRecord(IdForm form) {
        return businessFeign.queryLookOverdueRecord(form);
    }

    public RequestResult<List<OverdueRecordResultForm>> queryOverdueRecord(IdForm form) {
        return financeFeign.queryOverdueRecord(form);
    }

    public OverdueToExtensionListForm OverdueToExtUpdate(OverdueToExtensionListForm form) {
        return businessFeign.OverdueToExtUpdate(form).pickBody();
    }
}
