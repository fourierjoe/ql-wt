package yhao.micro.service.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import yhao.infra.feature.oracle.OracleConfiguration;
import yhao.infra.service.ServiceBaseConfig;
import yhao.infra.service.config.DruidSqlStatConfig;
import yhao.infra.web.WebBaseConfig;

/**
 * Created by yoara on 2017/2/10.
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication(exclude = SolrAutoConfiguration.class)
@EnableHystrix
@Import({WebBaseConfig.class, ServiceBaseConfig.class, DruidSqlStatConfig.class, OracleConfiguration.class})
public class WorkFlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkFlowApplication.class, args);
    }
}
