package source;

/**
 * @author gaochen
 * @date 2019/3/13
 */
public interface FactoryBean<T> {
    /**
     * 获取一个bean，如果配置了工厂bean，在getBean的时候，将会调用此方法，获取一个bean
     */
    T getObject() throws Exception;

    /**
     * 获取bean的类型
     */
    Class<?> getObjectType();

    /**
     * 是否是单例
     */
    boolean isSingleton();

}
