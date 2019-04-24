package yhao.micro.web.surety.remote.baseconfig;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundProviderSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundProviderModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.FundProviderFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资方管理 Remote
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 16:57
 */
@Service
public class FundProviderRemote {
    private Logger logger = LoggerFactory.getLogger(FundProviderRemote.class);
    @Resource
    private FundProviderFeign fundProviderFeign;

    @HystrixCommand(fallbackMethod = "pageQueryDown")
    public Pagination<FundProviderModel> pageQuery(FundProviderQueryForm form) {
        return fundProviderFeign.pageQuery(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryDown")
    public List<FundProviderModel> query(FundProviderQueryForm form) {
        return fundProviderFeign.query(form).pickBody();
    }

    public List<FundProviderModel> queryAllChildByParent(FundProviderQueryForm form) {
        return fundProviderFeign.queryAllChildByParent(form).pickBody();
    }

    public void save(FundProviderSaveForm form) {
        fundProviderFeign.save(form).pickBody();
    }

    public void statusChange(StatusChangeForm form) {
        fundProviderFeign.statusChange(form).pickBody();
    }

    public void deleteById(IdForm form) {
        fundProviderFeign.deleteById(form).pickBody();
    }

    public Pagination<FundProviderModel> pageQueryDown(FundProviderQueryForm form, Throwable e) {
        logger.error("Service Down:[FundProviderService.pageQueryDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }

    public List<FundProviderModel> queryDown(FundProviderQueryForm form, Throwable e) {
        logger.error("Service Down:[FundProviderService.queryDown]");
        logger.error(e.getMessage(), e.getCause());
        return new ArrayList<>();
    }
}
