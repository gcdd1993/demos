package com.gcdd.springeventdemo.domain;

/**
 * @author gaochen
 * @date 2019/3/14
 */
public class StringGenericSpringEvent extends GenericSpringEvent<String> {
    public StringGenericSpringEvent(String message, boolean success) {
        super(message, success);
    }
}
