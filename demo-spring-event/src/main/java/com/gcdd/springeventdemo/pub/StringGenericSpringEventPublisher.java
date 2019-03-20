package com.gcdd.springeventdemo.pub;

import com.gcdd.springeventdemo.domain.StringGenericSpringEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author gaochen
 * @date 2019/3/14
 */
@Component
public class StringGenericSpringEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void doStuffAndPublishAnEvent(final String message, final boolean success) {
        System.out.println("CustomSpringEventPublisher Publishing custom event. ");
        StringGenericSpringEvent springEvent = new StringGenericSpringEvent(message, success);
        applicationEventPublisher.publishEvent(springEvent);
    }
}
