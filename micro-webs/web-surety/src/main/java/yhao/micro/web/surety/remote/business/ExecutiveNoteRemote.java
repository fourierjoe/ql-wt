package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.PageForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.complex.ExecutivePostSaveForm;
import yhao.micro.service.surety.business.apilist.form.complex.QuerySingleGuaranteeInfoForm;
import yhao.micro.service.surety.business.apilist.form.complex.WindControllerGuaranteeQueryForm;
import yhao.micro.service.surety.business.apilist.model.ExecutiveNoteListModel;
import yhao.micro.service.surety.business.apilist.model.WindControllerGuaranteeModel;
import yhao.micro.service.surety.business.apilist.restful.BusinessFeign;

/**
 * @Description 执行岗备注 Remote
 *
 * @Author leice
 * @Date 2018/12/5 16:53
 * @Version 1.0
 */
@Service
public class ExecutiveNoteRemote {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BusinessFeign businessFeign;

    @HystrixCommand(fallbackMethod = "pageQueryExecutiveNoteDown")
    public Pagination<WindControllerGuaranteeModel> pageQueryExecutiveNote(WindControllerGuaranteeQueryForm form) {
        return  businessFeign.pageQueryExecutiveNote(form).pickBody();
    }

    public Pagination<WindControllerGuaranteeModel> pageQueryExecutiveNoteDown(WindControllerGuaranteeQueryForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }

    @HystrixCommand
    public ExecutivePostSaveForm executiveNoteSave(ExecutivePostSaveForm form) {
        return businessFeign.executiveNoteSave(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "pageQueryExecutiveNoteByIdDown")
    public Pagination<ExecutiveNoteListModel> pageQueryExecutiveNoteById(QuerySingleGuaranteeInfoForm form) {
        return  businessFeign.pageQueryExecutiveNoteById(form).pickBody();
    }

    public Pagination<ExecutiveNoteListModel> pageQueryExecutiveNoteByIdDown(QuerySingleGuaranteeInfoForm form, Throwable e) throws Throwable {
        logger.error(e.getMessage(),e);
        throw e;
    }
}
