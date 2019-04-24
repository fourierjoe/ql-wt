package yhao.micro.service.surety.erp.org.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import yhao.infra.feature.activemq.ActiveMqAbstractListener;
import yhao.micro.service.surety.erp.org.service.ErpDataInputService;

import javax.annotation.Resource;
import javax.jms.Message;

/**
 * Created by yoara on 2017/12/25.
 */
@Service("erpPersonTransferListener")
@EnableJms
public class ErpPersonTransferListener extends ActiveMqAbstractListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private ErpDataInputService erpDataInputService;

    @Override
    @JmsListener(containerFactory="erpTopicContainerFactory",destination = "erp.data.oa.personTransferTopic")
    protected void doTask(Message message) {
        String msg = decodeMessage(message);
        try {
            logger.info("[ErpPersonTransferListener]人员异动同步 开始");
            erpDataInputService.erpPersonTransfer(msg);
            logger.info("[ErpPersonTransferListener]人员异动同步 结束");
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }
}
