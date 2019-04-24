package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.guarantee.*;
import yhao.micro.service.surety.business.apilist.model.guarantee.AssociateGuaranteeModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.EstateFileModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.GuaranteeModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.MainContractNumModel;
import yhao.micro.service.surety.business.apilist.model.guarantee.page.GuaranteePageModel;
import yhao.micro.service.surety.business.apilist.restful.GuaranteeFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/9 15:30
 * @Version: v1.0
 */
@Service
public class GuaranteeRemote {
    private Logger logger = LoggerFactory.getLogger(BusinessTypeRemote.class);
    @Resource
    private GuaranteeFeign guaranteeFeign;

    @HystrixCommand
    public void saveGuarantee(GuaranteeForm form) {
        guaranteeFeign.saveGuarantee(form);
    }

    @HystrixCommand
    public void updateGuarantee(GuaranteeForm form) {
        guaranteeFeign.updateGuarantee(form);
    }

    @HystrixCommand(fallbackMethod = "pickGuaranteeDown")
    public GuaranteeModel pickGuarantee(IdForm form) {
        return guaranteeFeign.pickGuarantee(form).pickBody();
    }
    public GuaranteeModel pickGuaranteeDown(IdForm form, Throwable e) {
        logger.error("Service Down:[GuaranteeService.pickGuarantee]");
        logger.error(e.getMessage(), e.getCause());
        return new GuaranteeModel();
    }

    @HystrixCommand
    public MainContractNumSaveForm saveMainContractNum(MainContractNumSaveForm form) {
        return guaranteeFeign.saveMainContractNum(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "pickMainContractNumDown")
    public MainContractNumModel pickMainContractNum(IdForm form) {
        return guaranteeFeign.pickMainContractNum(form).pickBody();
    }
    public MainContractNumModel pickMainContractNumDown(IdForm form, Throwable e) {
        logger.error("Service Down:[GuaranteeService.pickMainContractNum]");
        logger.error(e.getMessage(), e.getCause());
        return new MainContractNumModel();
    }

    @HystrixCommand(fallbackMethod = "queryGuaranteePageDown")
    public Pagination<GuaranteePageModel> queryGuaranteePage(GuaranteeQueryPageForm form) {
        return guaranteeFeign.queryGuaranteePage(form).pickBody();
    }
    public Pagination<GuaranteePageModel> queryGuaranteePageDown(GuaranteeQueryPageForm form, Throwable e) {
        logger.error("Service Down:[GuaranteeService.queryGuaranteePage]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    @HystrixCommand
    public Boolean cancelThisGuarantee(IdForm form) {
        return guaranteeFeign.cancelThisGuarantee(form).pickBody();
    }

    @HystrixCommand
    public Boolean rejectGuarantee(IdForm form) {
        return guaranteeFeign.rejectGuarantee(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "associateGuaranteeDown")
    public Pagination<AssociateGuaranteeModel> associateGuarantee(AssociateGuaranteeForm form) {
        return guaranteeFeign.associateGuarantee(form).pickBody();
    }
    public Pagination<AssociateGuaranteeModel> associateGuaranteeDown(AssociateGuaranteeForm form, Throwable e) {
        logger.error("Service Down:[GuaranteeService.associateGuarantee]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    @HystrixCommand
    public EstateFileSaveForm saveEstateFile(EstateFileSaveForm form) {
        return guaranteeFeign.saveEstateFile(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryEstateFileDown")
    public List<EstateFileModel> queryEstateFile(IdForm form) {
        return guaranteeFeign.queryEstateFile(form).pickBody();
    }
    public List<EstateFileModel> queryEstateFileDown(IdForm form, Throwable e) {
        logger.error("Service Down:[GuaranteeService.queryEstateFile]");
        logger.error(e.getMessage(), e.getCause());
        return new ArrayList<>();
    }

}
