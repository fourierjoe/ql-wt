package yhao.micro.service.surety.erp.org.config;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import yhao.infra.feature.dubbo.DubboConfig;

/**
 * Created by yoara on 2017/11/20.
 */
@Configuration
@Import(DubboConfig.class)
public class DubboCustomerConfig {
    @Bean(name="schedulerLoggerFacade")
    public ReferenceBean schedulerLoggerFacade(){
        ReferenceBean bean =  new ReferenceBean();
        bean.setLazy(true);
        bean.setId("schedulerLoggerFacade");
        bean.setInterface(com.qfang.operation.scheduler.facade.SchedulerLoggerFacade.class);
        bean.setProtocol("dubbo");
        return bean;
    }
}