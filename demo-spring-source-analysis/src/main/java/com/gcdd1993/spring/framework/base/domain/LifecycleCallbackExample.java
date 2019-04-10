package com.gcdd1993.spring.framework.base.domain;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class LifecycleCallbackExample implements InitializingBean, DisposableBean, Lifecycle {
    public void init() {
        System.out.println("init...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }

    @PostConstruct
    public void post() {
        System.out.println("@PostConstruct...");
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy...");
    }

    @Override
    public void start() {
        System.out.println("Lifecycle start...");
    }

    @Override
    public void stop() {
        System.out.println("Lifecycle stop...");
    }

    @Override
    public boolean isRunning() {
        return false;
    }
}
