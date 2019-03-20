package base;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author gaochen
 * @date 2019/3/12
 */
public class SimpleBeanFactoryBean implements FactoryBean<SimpleBean> {
    @Override
    public SimpleBean getObject() throws Exception {
        System.out.println("MyFactoryBean getObject");
        return new SimpleBean();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("MyFactoryBean getObjectType");
        return SimpleBean.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
