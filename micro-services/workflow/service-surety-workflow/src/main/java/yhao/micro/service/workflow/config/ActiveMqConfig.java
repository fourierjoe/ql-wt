package yhao.micro.service.workflow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import yhao.component.schedulefeedback.SchedulerFeedbackConfig;
import yhao.infra.feature.activemq.ActiveMqConfiguration;

/**
 * Created by yoara on 2017/12/25.
 */
@Configuration
@Import({ActiveMqConfiguration.class, SchedulerFeedbackConfig.class})
public class ActiveMqConfig {

}
