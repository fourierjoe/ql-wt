package yhao.micro.service.workflow.message;

import com.qfang.wechatgateway.common.service.facade.TemplateMessageSendFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-20
 * Time: 16:58
 */
@Service
public class WxMessageSendService {
    @Resource
    private TemplateMessageSendFacade templateMessageSendFacade;
}
