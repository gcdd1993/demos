package com.gcdd1993.spring.framework.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 启用@AspectJ支持
 *
 * @author gaochen
 * @date 2019/4/1
 */
@EnableAspectJAutoProxy
@Configuration
public class AppConfig {
    @Bean
    public SimpleTransfer simpleBean() {
        return new SimpleTransfer();
    }
}
