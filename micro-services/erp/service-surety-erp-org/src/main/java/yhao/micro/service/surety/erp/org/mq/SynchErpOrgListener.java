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
@Service("synchErpOrgListener")
@EnableJms
public class SynchErpOrgListener extends ActiveMqAbstractListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private ErpDataInputService erpDataInputService;

    @Override
    @JmsListener(containerFactory="queueContainerFactory",destination = "surety.erp_org_synchronize")
    protected void doTask(Message message) {
        logger.info("[SynchErpOrgListener] ERP组织，岗位，人员同步开始");
        try {
            erpDataInputService.synchErpOrgInfo();
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        logger.info("[SynchErpOrgListener] ERP组织，岗位，人员同步完成");
    }
}
