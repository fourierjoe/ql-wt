package yhao.micro.service.surety.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Import;
import yhao.infra.feature.oracle.OracleConfiguration;
import yhao.infra.service.ServiceBaseConfig;
import yhao.infra.service.config.DruidSqlStatConfig;
import yhao.infra.web.WebBaseConfig;
import yhao.micro.service.surety.baseconfig.apilist.restful.IntentionConfigFeign;
import yhao.micro.service.surety.business.apilist.restful.FinanceFeign;
import yhao.micro.service.surety.erp.org.apilist.restful.PersonFeign;
import yhao.micro.service.workflow.apilist.restful.ProcessFeign;
import yhao.micro.service.workflow.apilist.restful.TaskFeign;

/**
 * Created by yoara on 2017/2/10.
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(clients = {TaskFeign.class, ProcessFeign.class, IntentionConfigFeign.class, PersonFeign.class, FinanceFeign.class})
@SpringBootApplication(exclude = SolrAutoConfiguration.class)
@EnableHystrix
@Import({WebBaseConfig.class, ServiceBaseConfig.class, DruidSqlStatConfig.class, OracleConfiguration.class})
public class BusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
