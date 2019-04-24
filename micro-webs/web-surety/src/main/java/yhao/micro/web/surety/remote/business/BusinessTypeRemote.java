package yhao.micro.web.surety.remote.business;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeQueryForm;
import yhao.micro.service.surety.business.apilist.form.businessType.BusinessTypeSaveForm;
import yhao.micro.service.surety.business.apilist.form.businessType.OrgIdForm;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeModel;
import yhao.micro.service.surety.business.apilist.model.businessType.BusinessTypeNameModel;
import yhao.micro.service.surety.business.apilist.restful.BusinessTypeFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Created by ql on 2018/12/8 19:35
 * @Version: v1.0
 */
@Service
public class BusinessTypeRemote {
    private Logger logger = LoggerFactory.getLogger(BusinessTypeRemote.class);
    @Resource
    private BusinessTypeFeign businessTypeFeign;

    @HystrixCommand
    public BusinessTypeSaveForm saveBusinessType(BusinessTypeSaveForm form) {
        return businessTypeFeign.saveBusinessType(form).pickBody();
    }


    @HystrixCommand(fallbackMethod = "queryBusinessTypePageDown")
    public Pagination<BusinessTypeModel> queryBusinessTypePage(BusinessTypeQueryForm form) {
        return businessTypeFeign.queryBusinessTypePage(form).pickBody();
    }
    public Pagination<BusinessTypeModel> queryBusinessTypePageDown(BusinessTypeQueryForm form, Throwable e) {
        logger.error("Service Down:[BusinessTypeService.queryBusinessTypePage]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    @HystrixCommand(fallbackMethod = "pickBusinessTypeByIdDown")
    public BusinessTypeModel pickBusinessTypeById(IdForm form) {
        return businessTypeFeign.pickBusinessTypeById(form).pickBody();
    }
    public BusinessTypeModel pickBusinessTypeByIdDown(IdForm form, Throwable e) {
        logger.error("Service Down:[BusinessTypeService.pickBusinessTypeById]");
        logger.error(e.getMessage(), e.getCause());
        return new BusinessTypeModel();
    }

    @HystrixCommand(fallbackMethod = "queryBusinessTypeAllNameDown")
    public List<BusinessTypeNameModel> queryBusinessTypeAllName(OrgIdForm form) {
        return businessTypeFeign.queryBusinessTypeAllName(form).pickBody();
    }
    public List<BusinessTypeNameModel> queryBusinessTypeAllNameDown(OrgIdForm form, Throwable e) {
        logger.error("Service Down:[BusinessTypeService.queryBusinessTypeAllName]");
        logger.error(e.getMessage(), e.getCause());
        return new ArrayList<>();
    }

}
