package yhao.micro.service.surety.baseconfig.config;

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
import yhao.infra.feature.activemq.ConfigFactory;

import javax.annotation.Resource;
import javax.jms.Session;

/**
 * Created by yoara on 2017/12/25.
 */
@Configuration
@Import({ActiveMqConfiguration.class, SchedulerFeedbackConfig.class})
public class ActiveMqConfig {
    @Autowired
    private Environment environment;

    @Bean("amqBaseConfigTopicConnectionFactory")
    public ActiveMQConnectionFactory amqBaseConfigTopicConnectionFactory(){
        ActiveMQConnectionFactory amqConnectionFactory = new ActiveMQConnectionFactory();
        amqConnectionFactory.setBrokerURL(environment.getProperty("basic.activemq.url"));
        amqConnectionFactory.setConnectResponseTimeout(5000);
        amqConnectionFactory.setSendTimeout(10000);
        amqConnectionFactory.setTrustAllPackages(true);
        return amqConnectionFactory;
    }

    @Bean("baseConfigTopicConnectionFactory")
    public CachingConnectionFactory baseConfigTopicConnectionFactory(
            ActiveMQConnectionFactory amqBaseConfigTopicConnectionFactory){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(amqBaseConfigTopicConnectionFactory);
        connectionFactory.setSessionCacheSize(
                environment.getProperty("basic.activemq.sessionSize",Integer.class));
        return connectionFactory;
    }

    @Bean("baseConfigQueueContainerFactory")
    public DefaultJmsListenerContainerFactory baseConfigQueueContainerFactory(
            CachingConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        return containerFactory;
    }

    @Bean("baseConfigTopicContainerFactory")
    public DefaultJmsListenerContainerFactory baseConfigTopicContainerFactory(
            CachingConnectionFactory baseConfigTopicConnectionFactory){
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        containerFactory.setConnectionFactory(baseConfigTopicConnectionFactory);
        containerFactory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        containerFactory.setPubSubDomain(true);
        return containerFactory;
    }
}
