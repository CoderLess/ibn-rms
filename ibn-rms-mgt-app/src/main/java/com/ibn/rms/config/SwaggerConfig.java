package com.ibn.rms.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.config
 * @author： RenBin
 * @createTime：2020/8/13 13:38
 */
// 开启swagger3的支持
@EnableOpenApi
@Configuration
public class SwaggerConfig {
    /**
     * @description: swagger3
     * @author：RenBin
     * @createTime：2020/8/11 13:44
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("Swagger3接口文档")
                        .description("ibn-rms-mgt-app接口文档")
                        .contact(new Contact("Ray。", "http://www.ruiyeclub.cn", "ruiyeclub@foxmail.com"))
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
}


