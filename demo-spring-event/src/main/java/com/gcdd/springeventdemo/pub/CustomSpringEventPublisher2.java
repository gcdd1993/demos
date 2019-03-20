package com.gcdd.springeventdemo.pub;

import com.gcdd.springeventdemo.domain.CustomSpringEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author gaochen
 * @date 2019/3/14
 */
@Component
public class CustomSpringEventPublisher2 {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishAnEvent(final String message) {
        System.out.println("CustomSpringEventPublisher2 Publishing custom event. ");
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
}
