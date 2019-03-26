import base.*;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author gaochen
 * @date 2019/3/20
 */
public class BeanTest {
    @Test
    public void beanDefinitionTest() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1);
        builder.addPropertyValue("name", "xiaoming");
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();

        beanFactory.registerBeanDefinition("user", beanDefinition);
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }

    @Test
    public void genericApplicationContext_test() {
        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("config.xml");
        context.refresh();
        // 测试获取bean simple
        SimpleBean simpleBean = (SimpleBean) context.getBean("simple");
        simpleBean.send();

    }

    @Test
    public void innerBean_test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        SimpleBean.InnerBean innerBean = (SimpleBean.InnerBean) context.getBean("inner");
        innerBean.innerSend();
    }

    @Test
    public void defaultListableBeanFactory_test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1);
        builder.addPropertyValue("name", "xiaoming");
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        beanFactory.registerBeanDefinition("user", beanDefinition);

        User bean = (User) applicationContext.getBean("user");
        System.out.println(bean);
    }

    @Test
    public void lifeBean_test() throws InterruptedException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        SimpleBean simpleBean = (SimpleBean) context.getBean("simple");
        simpleBean.send();
    }

    @Test
    public void registerBeanFactoryPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions(new FileSystemResource("beans.xml"));

        PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
        cfg.setLocation(new FileSystemResource("jdbc.properties"));

        cfg.postProcessBeanFactory(beanFactory);
    }

    @Test
    public void registerBeanPostProcessor() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);
    }

    @Test
    public void resource_test() throws IOException {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        Resource template = ctx.getResource("some/resource/path/myTemplate.txt");
        Resource template1 = ctx.getResource("classpath:some/resource/path/myTemplate.txt");
        Resource template2 = ctx.getResource("file:///some/resource/path/myTemplate.txt");
        Resource template3 = ctx.getResource("http://myhost.com/resource/path/myTemplate.txt");
    }
}
