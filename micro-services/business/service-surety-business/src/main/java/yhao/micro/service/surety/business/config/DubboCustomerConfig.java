package yhao.micro.service.surety.business.config;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.qfang.wechatgateway.common.service.facade.TemplateMessageSendFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import yhao.infra.feature.dubbo.ConfigFactory;
import yhao.infra.feature.dubbo.DubboConfig;

/**
 * Created by yoara on 2017/11/20.
 */
@Configuration
@Import(DubboConfig.class)
public class DubboCustomerConfig {
    @Bean(name = "templateMessageSendFacade")
    public ReferenceBean templateMessageSendFacade() {
        return ConfigFactory.makeQuickReferenceBean("templateMessageSendFacade",
                com.qfang.wechatgateway.common.service.facade.TemplateMessageSendFacade.class);
    }

    @Bean(name = "smsSendFacade")
    public ReferenceBean smsSendFacade() {
        return ConfigFactory.makeQuickReferenceBean("smsSendFacade",
                com.qfang.sms.facade.smssend.SmsSendFacade.class);
    }
}