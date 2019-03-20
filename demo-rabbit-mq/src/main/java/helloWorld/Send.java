package helloWorld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

/**
 * Created by gaochen on 2018/4/28.
 * Hello World Sending
 * 发布者将连接到RabbitMQ，发送一条消息，然后退出
 */
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv)
            throws java.io.IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.142.130");
        factory.setUsername("gaochen");
        factory.setPassword("123456");
        //创建一个到服务器的连接
        //连接抽象出套接字连接，并为我们处理协议版本协商和身份验证等。
        //在这里，我们连接到本地机器上的代理 - 因此是本地主机。
        //如果我们想连接到另一台机器上的代理，我们只需在此指定其名称或IP地址。
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //创建一个频道，这是大部分用于完成任务的API驻留的地方
        //声明一个队列是幂等的 - 只有当它不存在时才会被创建。
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String message = "Hello World";
        //消息内容是一个字节数组，所以你可以编码任何你喜欢的地方。
        channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");
        //关闭频道和连接
        channel.close();
        connection.close();
    }
}
