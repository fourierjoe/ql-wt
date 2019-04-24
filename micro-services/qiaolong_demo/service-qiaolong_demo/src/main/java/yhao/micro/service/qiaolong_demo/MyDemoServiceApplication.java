package yhao.micro.service.qiaolong_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import yhao.infra.feature.mysql.MysqlConfiguration;
import yhao.infra.service.ServiceBaseConfig;
import yhao.infra.web.WebBaseConfig;

/**
 * Created by yoara on 2017/2/10.
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication(exclude = SolrAutoConfiguration.class)
@EnableFeignClients("yhao.micro.service")
@EnableHystrix
@Import({WebBaseConfig.class, ServiceBaseConfig.class,MysqlConfiguration.class})
public class MyDemoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyDemoServiceApplication.class, args);
    }
}
