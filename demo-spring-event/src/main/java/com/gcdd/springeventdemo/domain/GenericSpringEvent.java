package com.gcdd.springeventdemo.domain;

import lombok.Data;

/**
 * @author gaochen
 * @date 2019/3/14
 */
@Data
public class GenericSpringEvent<T> {
    private T message;
    protected boolean success;

    public GenericSpringEvent(T message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
