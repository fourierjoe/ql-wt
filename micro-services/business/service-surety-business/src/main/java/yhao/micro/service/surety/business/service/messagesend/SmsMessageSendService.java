package yhao.micro.service.surety.business.service.messagesend;

import com.qfang.sms.facade.smssend.SmsSendFacade;
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
public class SmsMessageSendService {
    @Resource
    private SmsSendFacade smsSendFacade;
}
