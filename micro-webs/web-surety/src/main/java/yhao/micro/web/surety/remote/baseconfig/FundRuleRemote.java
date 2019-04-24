package yhao.micro.web.surety.remote.baseconfig;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundRuleSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundRuleModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.FundRuleFeign;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:资金方案管理 Remote
 * User: GUO.MAO.LIN
 * Date: 2018-11-29
 * Time: 20:48
 */
@Service
public class FundRuleRemote {
    private Logger logger = LoggerFactory.getLogger(FundRuleRemote.class);
    @Resource
    private FundRuleFeign fundRuleFeign;

    @HystrixCommand(fallbackMethod = "pageQueryDown")
    public Pagination<FundRuleModel> pageQuery(FundRuleQueryForm form) {
        return fundRuleFeign.pageQuery(form).pickBody();
    }

    public void save(FundRuleSaveForm form) {
        fundRuleFeign.save(form).pickBody();
    }

    public void deleteById(IdForm form) {
        fundRuleFeign.deleteById(form).pickBody();
    }

    public void statusChange(StatusChangeForm form) {
        fundRuleFeign.statusChange(form).pickBody();
    }

    public Pagination<FundRuleModel> pageQueryDown(FundRuleQueryForm form,Throwable e) {
        logger.error("Service Down:[FundRuleService.pageQueryDown]");
        logger.error(e.getMessage(),e.getCause());
        return new Pagination<>();
    }
}
