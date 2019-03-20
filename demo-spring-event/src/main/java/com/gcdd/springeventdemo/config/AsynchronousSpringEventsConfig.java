//package com.gcdd.springeventdemo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ApplicationEventMulticaster;
//import org.springframework.context.event.SimpleApplicationEventMulticaster;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//
///**
// * @author gaochen
// * @date 2019/3/14
// */
//@Configuration
//public class AsynchronousSpringEventsConfig {
//    @Bean(name = "applicationEventMulticaster")
//    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
//        SimpleApplicationEventMulticaster eventMulticaster
//                = new SimpleApplicationEventMulticaster();
//
//        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
//        return eventMulticaster;
//    }
//}
