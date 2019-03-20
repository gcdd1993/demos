package util;

import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by gaochen on 2018/4/28.
 */
public class ConnectionFactoryUtils {
    private static ConnectionFactory factory = new ConnectionFactory();

    static {
        factory.setHost("192.168.142.130");
        factory.setUsername("gaochen");
        factory.setPassword("123456");
    }

    public static ConnectionFactory getInstance() {
        return factory;
    }
}
