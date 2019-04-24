package yhao.micro.web.surety.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

/**
 * Created by yoara on 2017/6/8.
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
    @Resource
    private Environment env;

    @Bean
    public Docket createRestApi() {
        String basePackage = "yhao.micro.web";
        if ("pro".equalsIgnoreCase(env.getProperty("deploy.env"))) {
            basePackage = basePackage + ".xxx";
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("万通担保系统")
                .description("本文档为万通担保系统前端接口文档")
                .version("1.0.0")
                .build();
    }
}
