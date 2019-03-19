package com.gcdd.springeventdemo.listener;

import com.gcdd.springeventdemo.domain.GenericSpringEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author gaochen
 * @date 2019/3/14
 */
@Component
public class AnnotationDrivenEventListener {
    @EventListener(condition = "#event.success")
    public void handleSuccessful(GenericSpringEvent<String> event) {
        System.out.println("Handling generic event (conditional) " + event.getMessage());
    }
}
