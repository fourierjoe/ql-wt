//package yhao.micro.web.surety.remote.erp.auth;
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkQueryForm;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.SystemOrgLinkSaveForm;
//import yhao.micro.service.surety.erp.auth.apilist.model.AuthOrgModel;
//import yhao.micro.service.surety.erp.auth.apilist.restful.BizSystemOrgLinkFeign;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by yoara on 2017/11/16.
// */
//@Service
//public class BizSystemOrgLinkRemote {
//    private Logger logger = LoggerFactory.getLogger(BizSystemOrgLinkRemote.class);
//    @Resource
//    private BizSystemOrgLinkFeign bizSystemOrgLinkFeign;
//
//    @HystrixCommand(fallbackMethod = "queryAllBizSystemDown")
//    public List<AuthOrgModel> querySystemOrgLink(SystemOrgLinkQueryForm form) {
//        return bizSystemOrgLinkFeign.querySystemOrgLink(form).getBody();
//    }
//
//    @HystrixCommand
//    public void saveOrgLink(SystemOrgLinkSaveForm form) {
//        bizSystemOrgLinkFeign.saveOrgLink(form);
//    }
//
//    @HystrixCommand(fallbackMethod = "queryAllOrgDown")
//    public List<AuthOrgModel> queryAllOrg() {
//        return bizSystemOrgLinkFeign.queryAllOrg().getBody();
//    }
//
//
//    @HystrixCommand(fallbackMethod = "queryOrgListBySystemKeyDown")
//    public List<AuthOrgModel> queryOrgListBySystemKey(String systemKey) {
//        return bizSystemOrgLinkFeign.queryOrgListBySystemKey(systemKey).getBody();
//    }
//
//    public List<AuthOrgModel> queryOrgListBySystemKeyDown(String systemKey) {
//        logger.error("Service Down:[AuthConfigService.queryOrgListBySystemKey]");
//        return new ArrayList<>();
//    }
//
//    public List<AuthOrgModel> queryAllBizSystemDown(SystemOrgLinkQueryForm form) {
//        logger.error("Service Down:[BizSystemOrgLinkService.querySystemOrgLink]");
//        return new ArrayList<>();
//    }
//
//    public List<AuthOrgModel> queryAllOrgDown() {
//        logger.error("Service Down:[BizSystemOrgLinkService.queryAllOrg]");
//        return new ArrayList<>();
//    }
//}
