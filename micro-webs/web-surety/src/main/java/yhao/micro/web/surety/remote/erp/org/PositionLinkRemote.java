package yhao.micro.web.surety.remote.erp.org;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import yhao.infra.apilist.validate.IdForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkQueryForm;
import yhao.micro.service.surety.erp.org.apilist.form.position.PositionLinkSaveForm;
import yhao.micro.service.surety.erp.org.apilist.model.PositionLinkModel;
import yhao.micro.service.surety.erp.org.apilist.restful.PositionLinkFeign;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yoara on 2017/11/28.
 */
@Service
public class PositionLinkRemote {
    private Logger logger = LoggerFactory.getLogger(PositionLinkRemote.class);
    @Resource
    private PositionLinkFeign positionLinkFeign;

    @HystrixCommand(fallbackMethod = "queryPositionLinkListDown")
    public List<PositionLinkModel> queryPositionLinkList(PositionLinkQueryForm form) {
        return positionLinkFeign.queryPositionLinkList(form).getBody();
    }
    public List<PositionLinkModel> queryPositionLinkListDown(PositionLinkQueryForm form) {
        logger.error("Service Down:[PositionLinkService.queryPositionLinkListDown]");
        return new ArrayList<>();
    }

    @HystrixCommand
    public void savePositionLink(PositionLinkSaveForm form) {
        positionLinkFeign.savePositionLink(form);
    }

    @HystrixCommand
    public void deleteById(IdForm form) {
        positionLinkFeign.deleteById(form);
    }
}
