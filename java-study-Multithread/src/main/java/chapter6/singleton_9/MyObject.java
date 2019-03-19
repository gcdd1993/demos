package chapter6.singleton_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/8/17
 *使用静态内置类实现单例模式
 */
public enum MyObject {
    connectionFactory;
    private Connection connection;
    MyObject() {
        try {
            System.out.println("run myobject constructor");
            DriverManager.getConnection("");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
