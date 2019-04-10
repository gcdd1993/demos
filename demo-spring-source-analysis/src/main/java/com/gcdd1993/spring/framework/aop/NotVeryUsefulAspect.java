package com.gcdd1993.spring.framework.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author gaochen
 * @date 2019/4/1
 */
@Aspect
public class NotVeryUsefulAspect {
    @Pointcut("execution(* transfer(..))")
    private void anyOldTransfer() {
    }

    @Before("anyOldTransfer()")
    public void cut() {
        System.out.println("aspect...");
    }
}
