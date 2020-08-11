package com.ibn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @version 1.0
 * @description:
 * @projectName：ibn-rms
 * @see: com.ibn.rms.config
 * @author： RenBin
 * @createTime：2020/8/10 11:16
 */
@Configuration
// mapper文件扫描
@MapperScan({"com.ibn.rms.dao"})
// 组件扫描
@ComponentScan(basePackages = {"com.ibn.rms"})
// dubbo接口
@ImportResource(locations = { "classpath:dubbo/*.xml" })
public class AutoConfig {
}
