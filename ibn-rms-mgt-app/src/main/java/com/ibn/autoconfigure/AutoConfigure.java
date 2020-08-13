package com.ibn.autoconfigure;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
 * @see: com.ibn.config
 * @author： RenBin
 * @createTime：2020/8/11 10:42
 */
@Configuration
// 包扫描
@ComponentScan(basePackages = {"com.ibn.rms"})
// dubbo配置文件
@ImportResource(locations = {"classpath:dubbo/*.xml"})
public class AutoConfigure {
}
