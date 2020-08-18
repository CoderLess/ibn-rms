package com.ibn.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

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
