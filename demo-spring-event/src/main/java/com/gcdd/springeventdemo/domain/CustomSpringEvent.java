package com.gcdd.springeventdemo.domain;

import org.springframework.context.ApplicationEvent;

/**
 * @author gaochen
 * @date 2019/3/14
 */
public class CustomSpringEvent extends ApplicationEvent {
    private String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
