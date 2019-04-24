package yhao.micro.web.surety;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import yhao.infra.feature.imgupload.ImageUploadConfig;
import yhao.infra.web.WebBaseConfig;
import yhao.infra.web.config.RedisSessionConfig;

/**
 * Created by yoara on 2017/2/10.
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication(exclude = SolrAutoConfiguration.class)
@EnableFeignClients("yhao.micro.service")
@Configuration
@Import({WebBaseConfig.class, RedisSessionConfig.class,ImageUploadConfig.class})
public class WebSuretyApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSuretyApplication.class, args);
    }
}
