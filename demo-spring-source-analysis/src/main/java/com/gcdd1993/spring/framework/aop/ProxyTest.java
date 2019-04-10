
package com.gcdd1993.spring.framework.aop;

import com.gcdd1993.spring.framework.aop.domain.Pojo;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaochen
 * @date 2019/3/28
 */
public class ProxyTest {
    @Test
    public void test_proxy() {
        ProxyFactory factory = new ProxyFactory();
        factory.addInterface(Pojo.class);
//        factory.addAdvice(new RetryAdvice());
        Pojo pojo = (Pojo) factory.getProxy();
        pojo.bar();
    }

    @Test
    public void test_aop() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        SimpleTransfer bean = (SimpleTransfer) ctx.getBean("simpleTransfer");
        bean.transfer();
    }

    @Test
    public void test_annotation_driven_aop() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.register(NotVeryUsefulAspect.class);
        ctx.register(SimpleTransfer.class);
        ctx.refresh();
        SimpleTransfer bean = (SimpleTransfer) ctx.getBean("simpleTransfer");
        bean.transfer();
    }

}
