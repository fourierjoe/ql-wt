package yhao.micro.service.surety.business.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import yhao.infra.feature.activemq.ActiveMqAbstractListener;
import yhao.micro.service.surety.business.constant.AmqDestination;

import javax.jms.Message;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-03-08
 * Time: 17:21
 */
@Service("workFlowListener")
@EnableJms
public class WorkFlowListener extends ActiveMqAbstractListener {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @JmsListener(containerFactory = "businessTopicContainerFactory", destination = AmqDestination.T_WORKFLOW_FINISH)
    protected void doTask(Message message) {

    }
}
