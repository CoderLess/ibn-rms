package com.ibn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.config
 * @author： RenBin
 * @createTime：2020/8/10 11:16
 */
@Configuration
@MapperScan({"com.ibn.rms.dao"})
@ComponentScan(basePackages = {"com.ibn.rms"})
//@ImportResource(locations = { "classpath:META-INF/spring/*.xml" })//dubbo发布的接口
//@PropertySource({""})
public class AutoConfig {

}
