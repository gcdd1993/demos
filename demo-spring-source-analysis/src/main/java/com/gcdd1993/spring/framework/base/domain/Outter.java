package com.gcdd1993.spring.framework.base.domain;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class Outter {

    public void print() {
        System.out.println("outter class...");
    }

    public static class Inner {
        public void print() {
            System.out.println("inner class...");
        }
    }
}
