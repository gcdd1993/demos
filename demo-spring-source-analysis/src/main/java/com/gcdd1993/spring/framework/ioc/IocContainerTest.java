package com.gcdd1993.spring.framework.ioc;

import com.gcdd1993.spring.framework.base.domain.Account;
import com.gcdd1993.spring.framework.base.domain.Item;
import com.gcdd1993.spring.framework.base.domain.Outter;
import com.gcdd1993.spring.framework.base.domain.Person;
import com.gcdd1993.spring.framework.base.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.math.BigInteger;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class IocContainerTest {

    private AbstractApplicationContext applicationContext;

    /**
     * prepare application context {@link ClassPathXmlApplicationContext}
     */
    @Before
    public void prepareTest() {
        applicationContext = new ClassPathXmlApplicationContext("config.xml");
        // add a shutdown hook for the above context...
        applicationContext.registerShutdownHook();
    }

    /**
     * get bean with {@code ApplicationContext.#getBean(String)}
     */
    @Test
    public void test_getBeanFromApplicationContext() {
        ItemService itemService = (ItemService) applicationContext.getBean("itemService");
        Item item = itemService.findOne();
        System.out.println(item);
    }

    /**
     * get inner bean
     * <p><bean id="inner" class="com.gcdd1993.spring.framework.base.domain.Outter$Inner"/></p>
     */
    @Test
    public void test_InnerClass() {
        Outter.Inner inner = (Outter.Inner) applicationContext.getBean("inner");
        inner.print();
    }

    /**
     * Instantiation with a static factory method
     */
    @Test
    public void test_staticFactoryMethod() {
        Item item = (Item) applicationContext.getBean("item");
        System.out.println(item);
    }

    /**
     * Instantiation using an instance factory method
     */
    @Test
    public void test_instanceFactoryMethod() {
        Account account = (Account) applicationContext.getBean("account");
        System.out.println(account);
    }

    /**
     * life cycle callbacks of bean
     */
    @Test
    public void test_LifecycleCallbacks() {
        applicationContext.getBean("lifecycleCallbackExample");
    }

    /**
     * bean post processors will run when every bean init or destroy
     */
    @Test
    public void test_beanPostProcessor() {
        System.out.println("beanPostProcessor...");
    }

    @Test
    public void test_lookup() throws NamingException {
        Context ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
        System.out.println(dataSource);
    }

    @Test
    public void test_simple() {
        Person person = (Person) applicationContext.getBean("person");
    }
}
