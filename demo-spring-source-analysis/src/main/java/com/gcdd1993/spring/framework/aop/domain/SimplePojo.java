package com.gcdd1993.spring.framework.aop.domain;

/**
 * @author gaochen
 * @date 2019/3/28
 */
public class SimplePojo implements Pojo {
    public void foo() {
        this.bar();
    }

    @Override
    public void bar() {
        System.out.println("bar...");
    }
}
