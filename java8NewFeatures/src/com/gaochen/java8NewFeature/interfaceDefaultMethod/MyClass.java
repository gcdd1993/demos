package com.gaochen.java8NewFeature.interfaceDefaultMethod;

/**
 * Created by gaochen on 2018/8/2.
 */
public class MyClass implements MyInterface {
    @Override
    public void show() {
        System.out.println("我是实现方法");
    }

    //默认方法支持重写,不覆盖则执行接口的默认方法
    @Override
    public void showA() {
        System.out.println("我覆盖了接口的默认方法");
    }

    //静态方法不可以重写
}
