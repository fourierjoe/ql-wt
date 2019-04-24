package yhao.micro.service.surety.erp.auth.config;

import yhao.micro.service.surety.erp.auth.interceptor.ContextInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yoara on 2017/6/8.
 *
 * xml
 *  <mvc:interceptors></mvc:interceptors>
 *  <mvc:view-controller
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ContextInterceptor()).addPathPatterns("/**");
    }
}
