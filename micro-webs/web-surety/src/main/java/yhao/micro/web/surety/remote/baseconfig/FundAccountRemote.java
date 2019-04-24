package yhao.micro.web.surety.remote.baseconfig;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.FundAccountSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.FundAccountModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.FundAccountFeign;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:资金账号管理 Remote
 * User: GUO.MAO.LIN
 * Date: 2018-11-30
 * Time: 14:00
 */
@Service
public class FundAccountRemote {
    private Logger logger = LoggerFactory.getLogger(FundAccountRemote.class);
    @Resource
    private FundAccountFeign fundAccountFeign;

    @HystrixCommand(fallbackMethod = "pageQueryDown")
    public Pagination<FundAccountModel> pageQuery(FundAccountQueryForm form) {
        return fundAccountFeign.pageQuery(form).pickBody();
    }

    public void save(FundAccountSaveForm form) {
        fundAccountFeign.save(form).pickBody();
    }

    public void statusChange(StatusChangeForm form) {
        fundAccountFeign.statusChange(form).pickBody();
    }

    public void deleteById(IdForm form) {
        fundAccountFeign.deleteById(form).pickBody();
    }

    public Pagination<FundAccountModel> pageQueryDown(FundAccountQueryForm form, Throwable e) {
        logger.error("Service Down:[FundAccountService.pageQueryDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }
}
