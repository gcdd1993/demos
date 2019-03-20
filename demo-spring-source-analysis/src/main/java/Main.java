import base.SimpleBean;
import base.SimpleBeanFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;

import java.util.Arrays;

/**
 * @author gaochen
 * @date 2019/3/11
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        SimpleBean simpleBean = context.getBean(SimpleBean.class);
        simpleBean.send();
        SimpleBeanFactoryBean factoryBean = (SimpleBeanFactoryBean) context.getBean("&simple");
        simpleBean = factoryBean.getObject();
        simpleBean.send();
//        BeanFactory beanFactory = context.getAutowireCapableBeanFactory();
//        System.out.println("通过名称获取bean");
//        SimpleBean simpleBean = (SimpleBean) beanFactory.getBean("simpleBean");
//        simpleBean.send();
//        System.out.println("通过名称和类型获取bean");
//        simpleBean = beanFactory.getBean("simpleBean", SimpleBean.class);
//        simpleBean.send();
//        System.out.println("通过类型获取bean");
//        simpleBean = beanFactory.getBean(SimpleBean.class);
//        simpleBean.send();
//        boolean containsBean = beanFactory.containsBean("simpleBean");
//        System.out.println("是否包含 simpleBean ? " + containsBean);
//        boolean singleton = beanFactory.isSingleton("simpleBean");
//        System.out.println("是否是单例? " + singleton);
//        boolean match = beanFactory.isTypeMatch("simpleBean", ResolvableType.forClass(SimpleBean.class));
//        System.out.println("是否是SimpleBean类型 ? " + match);
//        match = beanFactory.isTypeMatch("simpleBean", SimpleBean.class);
//        System.out.println("是否是SimpleBean类型 ? " + match);
//        Class<?> aClass = beanFactory.getType("simpleBean");
//        System.out.println("simpleBean 的类型是 " + aClass.getName());
//        String[] aliases = beanFactory.getAliases("simpleBean");
//        System.out.println("simpleBean 的别名 : " + Arrays.toString(aliases));
    }
}
