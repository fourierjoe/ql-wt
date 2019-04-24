//package yhao.micro.web.surety.remote.erp.auth;
//
//
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//import yhao.infra.apilist.validate.IdForm;
//import yhao.infra.common.model.Pagination;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemPickForm;
//import yhao.micro.service.surety.erp.auth.apilist.form.system.BizSystemQueryForm;
//import yhao.micro.service.surety.erp.auth.apilist.model.BizSystemModel;
//import yhao.micro.service.surety.erp.auth.apilist.restful.BizSystemFeign;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by yoara on 2017/11/16.
// */
//@Service
//public class BizSystemRemote {
//    private Logger logger = LoggerFactory.getLogger(BizSystemRemote.class);
//    @Resource
//    private BizSystemFeign bizSystemFeign;
//
//    @HystrixCommand(fallbackMethod = "queryAllBizSystemDown")
//    public List<BizSystemModel> queryAllBizSystem() {
//        return bizSystemFeign.queryAllBizSystem().getBody();
//    }
//    public List<BizSystemModel> queryAllBizSystemDown() {
//        logger.error("Service Down:[BizSystemService.queryAllBizSystem]");
//        return new ArrayList<>();
//    }
//
//    @HystrixCommand(fallbackMethod = "queryBizSystemPageDown")
//    public Pagination<BizSystemModel> queryBizSystemPage(BizSystemQueryForm form) {
//        return bizSystemFeign.queryBizSystemPage(form).getBody();
//    }
//    public Pagination<BizSystemModel> queryBizSystemPageDown(BizSystemQueryForm form) {
//        logger.error("Service Down:[BizSystemService.queryBizSystemPage]");
//        return new Pagination<>();
//    }
//
//    @HystrixCommand(fallbackMethod = "selectByIdDown")
//    public BizSystemModel selectById(IdForm form) {
//        return bizSystemFeign.selectById(form).getBody();
//    }
//    public BizSystemModel selectByIdDown(IdForm form) {
//        logger.error("Service Down:[BizSystemService.selectById]");
//        return null;
//    }
//
//    @HystrixCommand(fallbackMethod = "selectByKeyDown")
//    public BizSystemModel selectByKey(BizSystemPickForm form) {
//        return bizSystemFeign.selectByKey(form).getBody();
//    }
//    public BizSystemModel selectByKeyDown(BizSystemPickForm form) {
//        logger.error("Service Down:[BizSystemService.selectByKey]");
//        return null;
//    }
//
//    @HystrixCommand
//    public void deleteBizSystem(IdForm form) {
//        bizSystemFeign.deleteBizSystem(form);
//    }
//
//    @HystrixCommand
//    public void saveBizSystem(BizSystemModel model) {
//        bizSystemFeign.saveBizSystem(model);
//    }
//}
