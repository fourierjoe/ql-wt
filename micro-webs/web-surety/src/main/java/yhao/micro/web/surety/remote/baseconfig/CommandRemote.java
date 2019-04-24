package yhao.micro.web.surety.remote.baseconfig;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.CommandSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.CommandModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.CommandFeign;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-13
 * Time: 11:38
 */
@Service
public class CommandRemote {
    private Logger logger = LoggerFactory.getLogger(CommandRemote.class);
    @Resource
    private CommandFeign commandFeign;

    @HystrixCommand(fallbackMethod = "pageQuery")
    public Pagination<CommandModel> pageQuery(CommandQueryForm form) {
        return commandFeign.pageQuery(form).pickBody();
    }

    public void save(CommandSaveForm form) {
        commandFeign.save(form).pickBody();
    }

    public void statusChange(StatusChangeForm form) {
        commandFeign.statusChange(form).pickBody();
    }

    public void deleteById(IdForm form) {
        commandFeign.deleteById(form).pickBody();
    }


    public Pagination<CommandModel> pageQueryDown(CommandQueryForm form, Throwable e) {
        logger.error("Service Down:[CommandService.pageQueryDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }
}
