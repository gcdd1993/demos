package com.gaochen.java8NewFeature.interfaceDefaultMethod;

/**
 * @author: gaochen
 * Date: 2019/1/13
 */
public class Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.show();
        myClass.showA();
        //通过类名.方法名调用接口静态方法
        MyInterface.showB();
    }
}
