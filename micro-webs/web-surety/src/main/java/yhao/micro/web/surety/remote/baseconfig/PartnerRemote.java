package yhao.micro.web.surety.remote.baseconfig;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.PartnerSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.PartnerModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.PartnerFeign;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:合作方管理 Remote
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:38
 */
@Service
public class PartnerRemote {
    private Logger logger = LoggerFactory.getLogger(PartnerRemote.class);
    @Resource
    private PartnerFeign partnerFeign;

    @HystrixCommand(fallbackMethod = "pageQueryDown")
    public Pagination<PartnerModel> pageQuery(PartnerQueryForm form) {
        return partnerFeign.pageQuery(form).pickBody();
    }

    public void save(PartnerSaveForm form) {
        partnerFeign.save(form).pickBody();
    }

    public void statusChange(StatusChangeForm form){
        partnerFeign.statusChange(form).pickBody();
    }

    public void deleteById(IdForm form){
        partnerFeign.deleteById(form).pickBody();
    }

    public Pagination<PartnerModel> pageQueryDown(PartnerQueryForm form, Throwable e) {
        logger.error("Service Down:[PartnerService.pageQueryDown]");
        logger.error(e.getMessage(), e.getCause());
        return new Pagination<>();
    }
}
