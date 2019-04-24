package yhao.micro.service.workflow.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2019-03-09
 * Time: 14:01
 */
@Service
public class MqMessageSendService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final ExecutorService executorService = Executors.newFixedThreadPool(20);
    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送MQ消息对象
     *
     * @param destination   消息目的
     * @param messageObject 消息对象
     */
    public void send(String destination, Serializable messageObject) {
        executorService.execute(() -> {
            try {
                jmsTemplate.send(destination, session -> session.createObjectMessage(messageObject));
            } catch (Exception e) {
                logger.error("发送MQ消息失败：destination=" + destination + "  message=" + messageObject.toString(), e);
            }
        });
    }

    /**
     * 发送MQ字符串消息
     * @param destination 消息目的
     * @param messageString 消息内容字符串
     */
    public void send(String destination, String messageString) {
        executorService.execute(() -> {
            try {
                jmsTemplate.send(destination, session -> session.createTextMessage(messageString));
            } catch (Exception e) {
                logger.error("发送MQ消息失败：destination=" + destination + "  message=" + messageString, e);
            }
        });
    }
}