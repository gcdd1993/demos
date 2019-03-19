package com.gcdd.springeventdemo.listener;

import com.gcdd.springeventdemo.domain.CustomSpringEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author gaochen
 * @date 2019/3/14
 */
@Component
public class AnnotationDrivenContextStartedListener {
    @Async
    @EventListener
    public void handleContextStart(CustomSpringEvent cse) {
        System.out.println("Handling Custom Spring Event.");
    }
}
