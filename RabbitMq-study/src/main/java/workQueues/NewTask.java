package workQueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.util.concurrent.TimeoutException;

/**
 * Created by gaochen on 2018/4/28.
 * Hello World Sending
 * 发布者将连接到RabbitMQ，发送一条消息，然后退出
 */
public class NewTask {
    private final static String QUEUE_NAME = "task_queue";

    public static void main(String[] argv)
            throws java.io.IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.142.130");
        factory.setUsername("gaochen");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);

        String message = getMessage(argv);
        /**
         * 关于消息持久性的说明
         * 尽管它告诉RabbitMQ将消息保存到磁盘，但RabbitMQ接收到消息并且尚未保存消息时仍有一段时间窗口。
         * 此外，RabbitMQ不会为每条消息执行fsync（2） - 它可能只是保存到缓存中，并没有真正写入磁盘。
         * 持久性保证不强，但对我们简单的任务队列来说已经足够了。
         */
        //将消息标记为持久 - 将MessageProperties（实现BasicProperties）设置为值PERSISTENT_TEXT_PLAIN。
        channel.basicPublish("", "hello", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        //公平派遣
        /**
         * 为了解决这个问题，我们可以使用basicQos方法和prefetchCount = 1设置。
         * 这告诉RabbitMQ一次不要向工作人员发送多个消息。
         * 或者换句话说，不要向工作人员发送新消息，直到它处理并确认了前一个消息。
         * 相反，它会将其分派给不是仍然忙碌的下一个工作人员。
         */
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        System.out.println(" [x] Sent '" + message + "'");
        //关闭频道和连接
        channel.close();
        connection.close();
    }

    private static String getMessage(String[] strings){
        if (strings.length < 1) {
            return "Hello World!";
        }
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) {
            return "";
        }
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
