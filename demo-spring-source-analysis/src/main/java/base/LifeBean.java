package base;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author gaochen
 * @date 2019/3/21
 */
public class LifeBean implements InitializingBean, DisposableBean {

    public void init() {
        System.out.println("method init ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean afterPropertiesSet ...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("@PostConstruct ...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy ...");
    }

    public void myDestroy() {
        System.out.println("method myDestroy ...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy ...");
    }

}
