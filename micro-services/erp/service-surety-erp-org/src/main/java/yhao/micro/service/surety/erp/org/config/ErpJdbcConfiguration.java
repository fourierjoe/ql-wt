package yhao.micro.service.surety.erp.org.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by yoara on 2017/2/17.
 */
@Configuration
public class ErpJdbcConfiguration {
    @Resource
    private Environment env;

    @Bean(name="erpDataSource",initMethod = "init",destroyMethod = "close")
    public DruidDataSource erpDataSource(){
        DruidDataSource source = new DruidDataSource();
        source.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        source.setUrl(env.getProperty("basic.erp.url"));
        source.setUsername(env.getProperty("basic.erp.username"));
        source.setPassword(env.getProperty("basic.erp.password"));
        source.setInitialSize(5);
        source.setMinIdle(5);
        source.setMaxActive(1000);
        source.setMaxWait(30000);
        source.setTimeBetweenEvictionRunsMillis(300000);
        source.setMinEvictableIdleTimeMillis(30000);
        source.setPoolPreparedStatements(false);
        Properties properties = new Properties();
        properties.setProperty("druid.stat.sql.MaxSize","3000");
        source.setConnectProperties(properties);
        return source;
    }

    @Bean(name="erpJdbcTemplate")
    public JdbcTemplate erpJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(erpDataSource());
        return jdbcTemplate;
    }
}
