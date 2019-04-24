package yhao.micro.web.surety.remote.baseconfig;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.infra.common.model.Pagination;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialQueryForm;
import yhao.micro.service.surety.baseconfig.apilist.form.MaterialSaveForm;
import yhao.micro.service.surety.baseconfig.apilist.form.StatusChangeForm;
import yhao.micro.service.surety.baseconfig.apilist.model.MaterialModel;
import yhao.micro.service.surety.baseconfig.apilist.restful.MaterialFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:资料设置 Remote
 * User: GUO.MAO.LIN
 * Date: 2018-12-04
 * Time: 9:38
 */
@Service
public class MaterialRemote {
    private Logger logger = LoggerFactory.getLogger(MaterialRemote.class);
    @Resource
    private MaterialFeign materialFeign;

    @HystrixCommand(fallbackMethod = "pageQueryDown")
    public Pagination<MaterialModel> pageQuery(MaterialQueryForm form){
        return materialFeign.pageQuery(form).pickBody();
    }

    @HystrixCommand(fallbackMethod = "queryDown")
    public List<MaterialModel> query(MaterialQueryForm form) {
        return materialFeign.query(form).pickBody();
    }

    public void save(MaterialSaveForm saveForm){
        materialFeign.save(saveForm).pickBody();
    }

    public void statusChange(StatusChangeForm form) {
        materialFeign.statusChange(form).pickBody();
    }

    public void deleteById(IdForm form){
        materialFeign.deleteById(form).pickBody();
    }

    public Pagination<MaterialModel> pageQueryDown(MaterialQueryForm form,Throwable e) {
        logger.error("Service Down:[MaterialService.pageQueryDown]");
        logger.error(e.getMessage(),e.getCause());
        return new Pagination<>();
    }

    public List<MaterialModel> queryDown(MaterialQueryForm form,Throwable e) {
        logger.error("Service Down:[MaterialService.queryDown]");
        logger.error(e.getMessage(),e.getCause());
        return new ArrayList<>();
    }


}
