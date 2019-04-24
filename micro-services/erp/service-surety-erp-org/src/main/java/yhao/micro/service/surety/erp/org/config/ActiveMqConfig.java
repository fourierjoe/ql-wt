package yhao.micro.service.surety.erp.org.config;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import yhao.component.schedulefeedback.SchedulerFeedbackConfig;
import yhao.infra.feature.activemq.ActiveMqConfiguration;

import javax.jms.Session;

/**
 * Created by yoara on 2017/12/25.
 */
@Configuration
@Import({ActiveMqConfiguration.class, SchedulerFeedbackConfig.class})
public class ActiveMqConfig {
    @Autowired
    private Environment environment;

    @Bean("queueContainerFactory")
    public DefaultJmsListenerContainerFactory queueContainerFactory(
            CachingConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return containerFactory;
    }

    @Bean("amqErpFactoryTopic")
    public ActiveMQConnectionFactory amqErpFactoryTopic(){
        ActiveMQConnectionFactory amqConnectionFactory = new ActiveMQConnectionFactory();
        amqConnectionFactory.setBrokerURL(environment.getProperty("basic.activemq.url"));
        amqConnectionFactory.setConnectResponseTimeout(5000);
        amqConnectionFactory.setSendTimeout(10000);
        amqConnectionFactory.setTrustAllPackages(true);
        return amqConnectionFactory;
    }

    @Bean("connectionErpFactoryTopic")
    public CachingConnectionFactory connectionErpFactoryTopic(
            ActiveMQConnectionFactory amqErpFactoryTopic){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(amqErpFactoryTopic);
        connectionFactory.setSessionCacheSize(
                environment.getProperty("basic.activemq.topicSessionSize",Integer.class));
        return connectionFactory;
    }

    @Bean("erpTopicContainerFactory")
    public DefaultJmsListenerContainerFactory erpTopicContainerFactory(
            CachingConnectionFactory connectionErpFactoryTopic){
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionErpFactoryTopic);
        containerFactory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        containerFactory.setPubSubDomain(true);
        return containerFactory;
    }
}
