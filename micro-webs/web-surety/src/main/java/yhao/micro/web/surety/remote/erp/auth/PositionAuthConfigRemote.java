package yhao.micro.web.surety.remote.erp.auth;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.erp.auth.apilist.form.auth.*;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthLeafModel;
import yhao.micro.service.surety.erp.auth.apilist.model.AuthPositionLinkModel;
import yhao.micro.service.surety.erp.auth.apilist.model.DataAuthModel;
import yhao.micro.service.surety.erp.auth.apilist.restful.PositionAuthConfigFeign;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionQueryForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionModel;
import yhao.micro.service.surety.erp.org.apilist.restful.PositionFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoara on 2017/11/16.
 */
@Service
public class PositionAuthConfigRemote {
    private Logger logger = LoggerFactory.getLogger(PositionAuthConfigRemote.class);
    @Resource
    private PositionAuthConfigFeign positionAuthConfigFeign;
    @Resource
    private PositionFeign positionFeign;

    @HystrixCommand(fallbackMethod = "queryAllPositionAuthorityDown")
    public List<AuthLeafModel> queryAllPositionAuthority(AuthTreeQueryForm form) {
        return positionAuthConfigFeign.queryAllPositionAuthority(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "pageQueryPositionLinkDown")
    public Pagination<AuthPositionLinkModel> pageQueryPositionLink(PositionAuthQueryForm form) {
        return positionAuthConfigFeign.queryPosition(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "pageQueryPositionDown")
    public Pagination<PositionModel> pageQueryPosition(PositionQueryForm form) {
        return positionFeign.queryPositionPage(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryAllPositionDataAuthorityDown")
    public List<DataAuthModel> queryAllPositionDataAuthority(DataAuthTreeQueryForm form) {
        return positionAuthConfigFeign.queryAllPositionDataAuthority(form).pickBody();
    }

    public void savePositionLinkDataAuth(PositionDataAuthSaveForm form) {
        positionAuthConfigFeign.savePositionDataAuth(form).pickBody();
    }

    public void savePositionBaseAuth(PositionAuthSaveForm form) {
        positionAuthConfigFeign.savePositionBaseAuth(form).pickBody();
    }


    public List<AuthLeafModel> queryAllPositionAuthorityDown(AuthTreeQueryForm form) {
        logger.error("Service Down:[PositionAuthConfigService.queryAllPositionAuthority]");
        return new ArrayList<>();
    }

    public Pagination<AuthPositionLinkModel> pageQueryPositionLinkDown(PositionAuthQueryForm form) {
        logger.error("Service Down:[PositionAuthConfigService.pageQueryPositionLink]");
        return new Pagination<>();
    }
    
    public Pagination<PositionModel> pageQueryPositionDown(PositionQueryForm form) {
        logger.error("Service Down:[PositionService.pageQueryPosition]");
        return new Pagination<>();
    }

    public List<DataAuthModel> queryAllPositionDataAuthorityDown(DataAuthTreeQueryForm form) {
        logger.error("Service Down:[PositionAuthConfigService.queryAllPositionDataAuthority]");
        return new ArrayList<>();
    }
}
