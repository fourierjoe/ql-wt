package yhao.micro.web.surety.remote.baseconfig;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositoryQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.RepositorySaveForm;
import yhao.micro.service.surety.baseconfig.apilist.model.RepositoryModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.RepositoryFeign;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-01-14
 * Time: 10:34
 */
@Service
public class RepositoryRemote {
    private Logger logger = LoggerFactory.getLogger(PartnerRemote.class);
    @Resource
    private RepositoryFeign repositoryFeign;

    @HystrixCommand(fallbackMethod = "pageQueryDown")
    public Pagination<RepositoryModel> pageQuery(RepositoryQueryForm form) {
        return repositoryFeign.pageQuery(form).pickBody();
    }

    public void save(RepositorySaveForm form) {
        repositoryFeign.save(form).pickBody();
    }

    public void deleteById(IdForm form){
        repositoryFeign.deleteById(form).pickBody();
    }

    public Pagination<RepositoryModel> pageQueryDown(RepositoryQueryForm form, Throwable e) {
        logger.error("Service Down:[RepositoryService.pageQueryDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }
}
