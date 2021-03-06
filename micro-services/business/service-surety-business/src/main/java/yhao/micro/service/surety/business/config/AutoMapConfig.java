package yhao.micro.service.surety.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yhao.infra.service.datasource.mybatis.mapper.scanner.MapperScannerConfigurer;

/**
 * Created by yoara on 2017/8/23.
 */
@Configuration
public class AutoMapConfig {
    @Bean(name="autoMapperScanner")
    public MapperScannerConfigurer autoMapperScanner(){
        MapperScannerConfigurer orgMapperScanner = new MapperScannerConfigurer();
        orgMapperScanner.setBasePackage("yhao.micro.service.surety.business.dao.automapper");
        return orgMapperScanner;
    }
}
