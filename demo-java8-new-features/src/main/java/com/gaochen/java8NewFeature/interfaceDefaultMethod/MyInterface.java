package com.gaochen.java8NewFeature.interfaceDefaultMethod;

/**
 * @author: gaochen
 * Date: 2019/1/13
 */
public interface MyInterface {

    void show();

    default void showA() {
        System.out.println("我是接口默认方法");
    }

    static void showB() {
        System.out.println("我是接口静态方法");
    }
}
