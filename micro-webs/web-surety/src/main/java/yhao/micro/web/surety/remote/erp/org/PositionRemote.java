package yhao.micro.web.surety.remote.erp.org;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.org.apilist.model.PositionCodeModel;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;
import yhao.micro.service.surety.erp.org.apilist.restful.PositionFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoara on 2017/11/28.
 */
@Service
public class PositionRemote {
    private Logger logger = LoggerFactory.getLogger(PositionRemote.class);
    @Resource
    private PositionFeign positionFeign;

    @HystrixCommand(fallbackMethod = "queryPositionPageDown")
    public Pagination<PositionModel> queryPositionPage(PositionQueryForm form) {
        return positionFeign.queryPositionPage(form).getBody();
    }
    public Pagination<PositionModel> queryPositionPageDown(PositionQueryForm form) {
        logger.error("Service Down:[PositionService.queryPositionPageDown]");
        return new Pagination<>();
    }

    @HystrixCommand(fallbackMethod = "queryFollowerAndDeclarerCodeByCityOrgDown")
    public List<PositionCodeModel> queryFollowerAndDeclarerCodeByCityOrg(IdForm idForm){
        return positionFeign.queryFollowerAndDeclarerCodeByCityOrg(idForm).getBody();
    }

    public List<PositionCodeModel> queryFollowerAndDeclarerCodeByCityOrgDown(IdForm idForm) {
        logger.error("Service Down:[PositionService.queryFollowerAndDeclarerCodeByCityOrgDown]");
        return new ArrayList<>();
    }

    @HystrixCommand(fallbackMethod = "queryObtainerAndForecloserCodeByCityOrgDown")
    public Object queryObtainerAndForecloserCodeByCityOrg(IdForm idForm) {
        return positionFeign.queryObtainerAndForecloserCodeByCityOrg(idForm).getBody();
    }

    public List<PositionCodeModel> queryObtainerAndForecloserCodeByCityOrgDown(IdForm idForm) {
        logger.error("Service Down:[PositionService.queryObtainerAndForecloserCodeByCityOrgDown]");
        return new ArrayList<>();
    }

    public PositionCodeModel queryManagerCodeByCityOrg(IdForm idForm) {
        return positionFeign.queryManagerCodeByCityOrg(idForm).getBody();
    }

    public PositionCodeModel queryResidentCodeByCityOrg(IdForm idForm) {
        return positionFeign.queryResidentCodeByCityOrg(idForm).getBody();
    }

    public PositionCodeModel queryExaminerCodeByCityOrg(IdForm idForm) {
        return positionFeign.queryExaminerCodeByCityOrg(idForm).getBody();
    }

    @HystrixCommand
    public void savePosition(PositionModel org) {
        positionFeign.savePosition(org);
    }

    @HystrixCommand(fallbackMethod = "selectByIdDown")
    public PositionModel selectById(IdForm form) {
        return positionFeign.selectById(form).getBody();
    }
    public PositionModel selectByIdDown(IdForm form) {
        logger.error("Service Down:[PositionService.selectByIdDown]");
        return null;
    }

    @HystrixCommand
    public void deleteById(IdForm form) {
        positionFeign.deleteById(form);
    }



}
